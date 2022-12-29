package com.example.task03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task03.databinding.ItemColorsBinding
import com.example.task03.databinding.ItemColorsChildBinding



class ColorsAdapter() : RecyclerView.Adapter<ColorsAdapter.ViewHolder>() {


    private lateinit var context: Context
    private lateinit var mList: MutableList<String>

    constructor(context: Context, mList: MutableList<String>) : this() {
        this.context = context
        this.mList = mList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemColorsChildBinding = ItemColorsChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(mList[position]) {
                //binding.textView.text = this

                if(position == 0) {
                    val param = binding.constraintColors.layoutParams as ViewGroup.MarginLayoutParams
                    param.setMargins(10, 0, 0, 0)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(val binding: ItemColorsChildBinding) : RecyclerView.ViewHolder(binding.root)

}