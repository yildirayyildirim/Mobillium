package com.app.mobillium.presentation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mobillium.R
import com.app.mobillium.core.enum.EnumType
import com.app.mobillium.databinding.ItemParentReyclerviewBinding
import com.app.mobillium.presentation.model.CommonModel
import com.app.mobillium.presentation.model.ResultModel
import com.app.mobillium.presentation.model.ResultModelItem
import com.app.mobillium.presentation.view.activity.ItemAdapter


class MainAdapter(
    private val context: Context
) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var resultModelItemList: ResultModel = ResultModel()

    class MainViewHolder(val binding: ItemParentReyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResultModelItem) {
            binding.model = item
            binding.executePendingBindings()
        }
    }

    fun updateList(resultModelItemList: ResultModel) {
        this.resultModelItemList = resultModelItemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding: ItemParentReyclerviewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_parent_reyclerview, parent, false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(resultModelItemList[position])

        val response =
            resultModelItemList.filter { it.type == resultModelItemList[position].type }

        setChildItem(context, holder.binding.itemRecycler, response)
    }

    override fun getItemCount(): Int = resultModelItemList.size

    private fun setChildItem(
        context: Context,
        recyclerView: RecyclerView,
        categoryItemList: List<ResultModelItem>
    ) {
        val itemRecyclerAdapter = ItemAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerAdapter

        val list: ArrayList<CommonModel> = ArrayList()

        categoryItemList.forEach {
            if (EnumType.FEATURED.value == it.type) {
                it.featured.forEach {
                    list.add(CommonModel(it.title, it.cover.url, 1, it.sub_title))
                }

            } else if (EnumType.NEW_PRODUCTS.value == it.type) {
                it.products.forEach { it ->
                    list.add(CommonModel(it.title, it.images[0].url, 2, it.definition))
                }

            } else if (EnumType.CATEGORIES.value == it.type) {
                it.categories.forEach { it ->
                    list.add(CommonModel(it.name, it.cover.url, 3, null))
                }

            } else if (EnumType.COLLECTIONS.value == it.type) {
                it.collections.forEach { it ->
                    list.add(CommonModel(it.title, it.cover.url, 4, null))
                }

            } else if (EnumType.EDITOR_SHOPS.value == it.type) {
                it.shops.forEach { it ->
                    list.add(CommonModel(it.name, it.cover?.url.toString(), 5, null))
                }

            }
            itemRecyclerAdapter.updateList(
                list
            )
        }
    }
}