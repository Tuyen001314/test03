package com.example.task03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginStart
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.example.task03.databinding.ItemCategoriesBinding
import com.example.task03.databinding.ItemCategoriesChildBinding


class CategoriesAdapter() : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {


    private lateinit var context: Context
    private lateinit var mList: MutableList<String>

    constructor(context: Context, mList: MutableList<String>) : this() {
        this.context = context
        this.mList = mList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCategoriesChildBinding = ItemCategoriesChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(mList[position]) {
                binding.textContentCategories.text = this

            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(val binding: ItemCategoriesChildBinding) : RecyclerView.ViewHolder(binding.root)

}