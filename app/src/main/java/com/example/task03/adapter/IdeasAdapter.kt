package com.example.task03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task03.databinding.ItemCategoriesChildBinding
import com.example.task03.databinding.ItemIdeasChildBinding
import com.example.task03.databinding.ItemIdeasForYouBinding

import com.example.task03.databinding.ItemSearchesBinding


class IdeasAdapter() : RecyclerView.Adapter<IdeasAdapter.ViewHolder>() {


    private lateinit var context: Context
    private lateinit var mList: MutableList<String>


    constructor(context: Context, mList: MutableList<String>) : this() {
        this.context = context
        this.mList = mList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemIdeasChildBinding = ItemIdeasChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(mList[position]) {
                binding.textContentColors.text = this
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(val binding: ItemIdeasChildBinding) : RecyclerView.ViewHolder(binding.root)

}