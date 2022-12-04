package com.noweshed.noweshedmisltest.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.noweshed.noweshedmisltest.R
import com.noweshed.noweshedmisltest.data.model.response.ProductResponse
import com.noweshed.noweshedmisltest.databinding.ProductItemviewBinding

/**
 * Created by noweshedakram on 3/12/22.
 */
class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(private val binding: ProductItemviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(productResponse: ProductResponse) {

            Glide.with(binding.root)
                .load(productResponse.imageUrl)
                .placeholder(R.drawable.thumbnail)
                .into(binding.productImage)

            binding.productName.text = productResponse.name
            binding.productModel.text = "Model: ${productResponse.model}"
            binding.productSize.text = "Size: ${productResponse.size}"
            binding.productDescription.text = productResponse.description
            binding.productPrice.text = "BDT. ${productResponse.price}"

            binding.itemView.setOnClickListener {
                onItemClickListener(productResponse)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ProductItemviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.bindData(product)
    }

    override fun getItemCount() = differ.currentList.size

    private val callback = object : DiffUtil.ItemCallback<ProductResponse>() {
        override fun areItemsTheSame(oldItem: ProductResponse, newItem: ProductResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductResponse,
            newItem: ProductResponse
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    private var onItemClickListener: ((ProductResponse) -> Unit) = {}

    fun setOnItemClickListener(listener: (ProductResponse) -> Unit) {
        onItemClickListener = listener
    }
}