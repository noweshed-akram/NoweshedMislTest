package com.noweshed.noweshedmisltest.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.noweshed.noweshedmisltest.R
import com.noweshed.noweshedmisltest.data.util.Constants
import com.noweshed.noweshedmisltest.data.util.Resource
import com.noweshed.noweshedmisltest.databinding.FragmentProductsBinding
import com.noweshed.noweshedmisltest.presentation.adapter.ProductAdapter
import com.noweshed.noweshedmisltest.presentation.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private lateinit var fragmentProductsBinding: FragmentProductsBinding

    @Inject
    lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentProductsBinding = FragmentProductsBinding.inflate(layoutInflater)
        return fragmentProductsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentProductsBinding = FragmentProductsBinding.bind(view)

        productViewModel.getAllProducts(Constants.SECRET_CODE)

        productViewModel.productList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    productAdapter.differ.submitList(response.data)
                    fragmentProductsBinding.productRecyclerView.visibility = View.VISIBLE
                    Log.i("ProductsFragment", "${response.data}")
                    fragmentProductsBinding.loadingProgress.loadingProgress.visibility = View.GONE
                }
                is Resource.Loading -> {
                    fragmentProductsBinding.productRecyclerView.visibility = View.INVISIBLE
                    fragmentProductsBinding.loadingProgress.loadingProgress.visibility =
                        View.VISIBLE
                    Log.i("ProductsFragment", "Loading...")
                }
                is Resource.Error -> {
                    Log.i("ProductsFragment", "${response.message}")
                    fragmentProductsBinding.loadingProgress.loadingProgress.visibility = View.GONE
                }
            }
        }

        fragmentProductsBinding.swipeRefresh.setOnRefreshListener {
            fragmentProductsBinding.swipeRefresh.isRefreshing = false
            productViewModel.getAllProducts(Constants.SECRET_CODE)
        }

        fragmentProductsBinding.productRecyclerView.adapter = productAdapter
        productAdapter.setOnItemClickListener { response ->
            val bundle = Bundle()
            bundle.putInt("productId", response.id)
            findNavController().navigate(R.id.action_productFragment_to_detailsFragment, bundle)
        }
    }
}