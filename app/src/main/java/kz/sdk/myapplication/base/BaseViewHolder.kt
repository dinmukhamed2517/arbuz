package kz.sdk.myapplication.base

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import kz.sdk.myapplication.Product

abstract class BaseViewHolder<VB : ViewBinding, T>(protected open val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}

abstract class BaseProductViewHolder<VB:ViewBinding>(override val binding: VB):BaseViewHolder<VB, Product>(binding)