package kz.sdk.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kz.sdk.myapplication.base.BaseProductViewHolder
import kz.sdk.myapplication.base.BaseViewHolder
import kz.sdk.myapplication.databinding.ItemProductBinding

class Adapter:ListAdapter<Product, BaseProductViewHolder<*>>(ProductDiffUtils()){

    var click: ((Product)-> Unit)?= null

    class ProductDiffUtils:DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseProductViewHolder<*> {
        return ProductViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseProductViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }

    inner class ProductViewHolder(binding: ItemProductBinding):BaseProductViewHolder<ItemProductBinding>(binding) {
        override fun bindView(item: Product) {
            with(binding){
                image.setImageResource(item.img)
                name.text = item.name
                price.text =  "${item.price} ₸"
            }
            itemView.setOnClickListener {
                click?.invoke(item)
            }
        }
    }
}