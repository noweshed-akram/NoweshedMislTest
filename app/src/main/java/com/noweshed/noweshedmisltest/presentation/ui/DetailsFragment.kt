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

        productViewModel.getProductById(Constants.SECRET_CODE, 1)

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