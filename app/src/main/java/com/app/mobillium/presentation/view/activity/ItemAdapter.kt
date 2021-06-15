package com.app.mobillium.presentation.view.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.mobillium.R
import com.app.mobillium.databinding.*
import com.app.mobillium.presentation.model.CommonModel

class ItemAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var resultModelItemList: List<CommonModel> = listOf()

    class NewProductsViewHolder(val binding: ItemChildNewProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CommonModel) {
            binding.model = item
            binding.executePendingBindings()
        }
    }

    class FeaturedViewHolder(val binding: ItemChildFeaturedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CommonModel) {
            binding.model = item
            binding.executePendingBindings()
        }
    }

    class CategoryViewHolder(val binding: ItemChildCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CommonModel) {
            binding.model = item
            binding.executePendingBindings()
        }
    }

    class CollentionsViewHolder(val binding: ItemChildCollectionsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CommonModel) {
            binding.model = item
            binding.executePendingBindings()
        }
    }

    class ShopViewHolder(val binding: ItemChildShopBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CommonModel) {
            binding.model = item
            binding.executePendingBindings()
        }
    }

    fun updateList(resultModelItemList: ArrayList<CommonModel>) {
        this.resultModelItemList = resultModelItemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1) {
            val binding: ItemChildFeaturedBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_child_featured, parent, false
            )
            return FeaturedViewHolder(binding)
        } else if (viewType == 2) {
            val binding: ItemChildNewProductsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_child_new_products, parent, false
            )
            return NewProductsViewHolder(binding)
        } else if (viewType == 3) {
            val binding: ItemChildCategoryBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_child_category, parent, false
            )
            return CategoryViewHolder(binding)
        } else if (viewType == 4) {
            val binding: ItemChildCollectionsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_child_collections, parent, false
            )
            return CollentionsViewHolder(binding)
        } else {
            val binding: ItemChildShopBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_child_shop, parent, false
            )
            return ShopViewHolder(binding)
        }

    }

    override fun getItemCount(): Int = resultModelItemList.size

    override fun getItemViewType(position: Int): Int {
        return resultModelItemList[position].viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val commonModel: CommonModel = resultModelItemList[position]

        if (commonModel.viewHolder == 1) {
            holder as FeaturedViewHolder
            holder.bind(resultModelItemList[position])
        } else if (commonModel.viewHolder == 2) {
            holder as NewProductsViewHolder
            holder.bind(resultModelItemList[position])
        } else if (commonModel.viewHolder == 3) {
            holder as CategoryViewHolder
            holder.bind(resultModelItemList[position])
        } else if (commonModel.viewHolder == 4) {
            holder as CollentionsViewHolder
            holder.bind(resultModelItemList[position])
        } else {
            holder as ShopViewHolder
            holder.bind(resultModelItemList[position])
        }
    }
}