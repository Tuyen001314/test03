package com.example.task03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task03.databinding.ItemCategoriesBinding
import com.example.task03.databinding.ItemCollectionsBinding
import com.example.task03.databinding.ItemColorsBinding
import com.example.task03.databinding.ItemPopularBinding


import com.example.task03.databinding.ItemSearchesBinding

class BaseHomeAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var context: Context
    private lateinit var listData: MutableList<Data>
    private lateinit var mList: MutableList<String>

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
        const val VIEW_TYPE_THREE = 3
    }

    constructor(
        context: Context,
        listData: MutableList<Data>,
        mList: MutableList<String>
    ) : this() {
        this.context = context
        this.listData = listData
        this.mList = mList
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return when (p1) {
            VIEW_TYPE_ONE -> {
                val binding: ItemSearchesBinding = ItemSearchesBinding.inflate(inflater, p0, false)
                FeatureViewHolder(binding)
            }
            VIEW_TYPE_TWO -> {
                val binding: ItemCollectionsBinding = ItemCollectionsBinding.inflate(inflater, p0, false)
                CollectionsViewHolder(binding)
            }
            else -> {
                val binding: ItemPopularBinding =
                    ItemPopularBinding.inflate(inflater, p0, false)
                PopularViewHolder(binding)
            }

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data: Data = listData[position]
        if (holder.javaClass == FeatureViewHolder::class.java) {
            holder as FeatureViewHolder
            with(holder) {
                val featureAdapter = FeatureAdapter(context, mList)
                recyclerView.layoutManager = LinearLayoutManager(
                    recyclerView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = featureAdapter

                title.text = data.name

            }
        } else if (holder.javaClass == CollectionsViewHolder::class.java) {
            holder as CollectionsViewHolder
            with(holder) {
                val collectionsAdapter = CollectionsAdapter(context, mList)
                recyclerView.layoutManager = LinearLayoutManager(
                    recyclerView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = collectionsAdapter

                title.text = data.name
            }

        } else if (holder.javaClass == PopularViewHolder::class.java) {
            holder as PopularViewHolder
            with(holder) {
                val popularAdapter = PopularAdapter(context, mList)
                recyclerView.layoutManager = GridLayoutManager(
                    recyclerView.context,
                    3
                )
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = popularAdapter

                title.text = data.name
            }
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun getItemViewType(position: Int): Int {
        //val data: Data = listData[position]
        return if (position % 4 == 0) {
            VIEW_TYPE_ONE
        } else if (position % 4 == 1) {
            VIEW_TYPE_TWO
        } else {
            VIEW_TYPE_THREE
        }
    }


    inner class PopularViewHolder(binding: ItemPopularBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var recyclerView = binding.recyclerViewPopularChild
        var title = binding.textTitlePopular
    }

    inner class FeatureViewHolder(val binding: ItemSearchesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var recyclerView = binding.recyclerViewSearchesChild
        var title = binding.textTitleSearches
    }

    inner class CollectionsViewHolder(val binding: ItemCollectionsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var recyclerView = binding.recyclerViewCollectionsChild
        var title = binding.textTitleCollections
    }


}