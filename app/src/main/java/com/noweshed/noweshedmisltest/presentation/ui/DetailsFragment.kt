package com.noweshed.noweshedmisltest.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.noweshed.noweshedmisltest.R
import com.noweshed.noweshedmisltest.data.util.Constants
import com.noweshed.noweshedmisltest.data.util.Resource
import com.noweshed.noweshedmisltest.databinding.FragmentDetailsBinding
import com.noweshed.noweshedmisltest.presentation.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var fragmentDetailsBinding: FragmentDetailsBinding

    @Inject
    lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentDetailsBinding = FragmentDetailsBinding.inflate(layoutInflater)
        return fragmentDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentDetailsBinding = FragmentDetailsBinding.bind(view)

        val prodId = arguments?.getInt("productId", 1)

        if (prodId != null) {
            productViewModel.getProductById(Constants.SECRET_CODE, prodId)
        }

        productViewModel.product.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    fragmentDetailsBinding.loadingProgress.loadingProgress.visibility =
                        View.GONE

                    Log.i("DetailsFragment", "${response.data?.imageUrl}")
                    Glide.with(fragmentDetailsBinding.root)
                        .load(response.data?.imageUrl)
                        .placeholder(R.drawable.thumbnail)
                        .into(fragmentDetailsBinding.productImage)

                    fragmentDetailsBinding.productName.text = response.data?.name
                    fragmentDetailsBinding.productPrice.text =
                        "BDT. ${response.data?.price.toString()}"
                    fragmentDetailsBinding.productTitle.text = response.data?.title
                    fragmentDetailsBinding.productDescription.text = response.data?.description

                    fragmentDetailsBinding.nameInfo.text = response.data?.name
                    fragmentDetailsBinding.modelInfo.text = response.data?.model?.trim()

                    fragmentDetailsBinding.displayInfo.text =
                        "Aspect Ratio: ${response.data?.specification?.display?.aspectRatio}\n" +
                                "Resolution: ${response.data?.specification?.display?.resolution}\n" +
                                "Screen Size: ${response.data?.specification?.display?.resolution}"

                    fragmentDetailsBinding.processorInfo.text =
                        response.data?.specification?.processor?.processor

                    fragmentDetailsBinding.osInfo.text =
                        response.data?.specification?.os?.operatingSystem

                    fragmentDetailsBinding.prodTypeInfo.text =
                        response.data?.specification?.productType?.productType

                    fragmentDetailsBinding.dimensionsInfo.text =
                        "Set Size with Stand (WxHxD):\n" +
                                "${response.data?.specification?.dimensionsMm?.setSizeWithStandWxHxD}\n" +
                                "Set Size without Stand (WxHxD):\n" +
                                "${response.data?.specification?.dimensionsMm?.setSizeWithoutStandWxHxD}"

                    fragmentDetailsBinding.videoInfo.text =
                        "PQI (Picture Quality Index): " +
                                "${response.data?.specification?.video?.pQIPictureQualityIndex}\n" +
                                "One Billion Color: " +
                                "${response.data?.specification?.video?.oneBillionColor}\n" +
                                "HDR (High Dynamic Range): " +
                                "${response.data?.specification?.video?.hDRHighDynamicRange}\n" +
                                "HDR 10+: " +
                                "${response.data?.specification?.video?.hDRHighDynamicRange}\n" +
                                "Contrast: " +
                                "${response.data?.specification?.video?.hDRHighDynamicRange}\n" +
                                "Contrast Enhancer: " +
                                "${response.data?.specification?.video?.hDRHighDynamicRange}\n" +
                                "Auto Motion Plus: " +
                                "${response.data?.specification?.video?.hDRHighDynamicRange}\n" +
                                "Picture Engine: " +
                                "${response.data?.specification?.video?.hDRHighDynamicRange}\n" +
                                "Refresh Rate: " +
                                "${response.data?.specification?.video?.hDRHighDynamicRange}\n" +
                                "Color: " +
                                "${response.data?.specification?.video?.hDRHighDynamicRange}"

                    fragmentDetailsBinding.audioInfo.text =
                        "Speaker Type: " +
                                "${response.data?.specification?.audio?.speakerType}\n" +
                                "Sound Output (RMS): " +
                                "${response.data?.specification?.audio?.soundOutputRMS}\n" +
                                "Dolby Digital Plus: " +
                                "${response.data?.specification?.audio?.dolbyDigitalPlus}"

                    fragmentDetailsBinding.connectivityInfo.text =
                        "HDMI: " +
                                "${response.data?.specification?.connectivity?.hdmi}\n" +
                                "USB: " +
                                "${response.data?.specification?.connectivity?.usb}\n" +
                                "WiFi Direct: " +
                                "${response.data?.specification?.connectivity?.wiFiDirect}\n" +
                                "Wi-Fi: " +
                                "${response.data?.specification?.connectivity?.wiFi}"

                    fragmentDetailsBinding.powerInfo.text =
                        "Power Consumption (Max): " +
                                "${response.data?.specification?.power?.powerConsumptionMax}\n" +
                                "Power Supply: " +
                                "${response.data?.specification?.power?.powerConsumptionMax}"

                    fragmentDetailsBinding.smartFetInfo.text =
                        "Mobile to TV - Mirroring, DLNA: " +
                                "${response.data?.specification?.smartFeature?.mobileToTVMirroringDLNA}\n" +
                                "TV Sound to Mobile: " +
                                "${response.data?.specification?.smartFeature?.tvSoundToMobile}\n" +
                                "Sound Mirroring: " +
                                "${response.data?.specification?.smartFeature?.soundMirroring}"

                    fragmentDetailsBinding.otherInfo.text =
                        "Series: " +
                                "${response.data?.specification?.others?.series}\n" +
                                "Picture Engine: " +
                                "${response.data?.specification?.others?.series}\n" +
                                "Micro Dimming: " +
                                "${response.data?.specification?.others?.series}\n" +
                                "Q-Symphony: " +
                                "${response.data?.specification?.others?.series}\n" +
                                "Web Browser: " +
                                "${response.data?.specification?.others?.series}\n" +
                                "TV to Mobile - Mirroring: " +
                                "${response.data?.specification?.others?.series}\n" +
                                "Design: " +
                                "${response.data?.specification?.others?.series}\n" +
                                "Bezel Type: " +
                                "${response.data?.specification?.others?.series}\n" +
                                "Power Supply: " +
                                "${response.data?.specification?.others?.series}"

                }
                is Resource.Loading -> {
                    fragmentDetailsBinding.loadingProgress.loadingProgress.visibility =
                        View.VISIBLE
                    Log.i("ProductsFragment", "Loading...")
                }
                is Resource.Error -> {
                    fragmentDetailsBinding.loadingProgress.loadingProgress.visibility =
                        View.GONE
                }
            }
        }

        fragmentDetailsBinding.prodDetailsToolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_productFragment)
        }

        fragmentDetailsBinding.addToCart.setOnClickListener {
            Toast.makeText(context, "Product Added Successful!", Toast.LENGTH_LONG).show()
        }

    }


}