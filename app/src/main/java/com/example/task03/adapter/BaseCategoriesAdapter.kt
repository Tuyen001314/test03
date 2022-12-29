package com.example.task03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task03.databinding.ItemCategoriesBinding
import com.example.task03.databinding.ItemColorsBinding
import com.example.task03.databinding.ItemIdeasForYouBinding
import com.example.task03.databinding.ItemSearchesBinding

class BaseCategoriesAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var context: Context
    private lateinit var listData: MutableList<Data>
    private lateinit var mList: MutableList<String>

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
        const val VIEW_TYPE_THREE = 3
        const val VIEW_TYPE_FOUR = 4
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
                SearchesViewHolder(binding)
            }
            VIEW_TYPE_TWO -> {
                val binding: ItemColorsBinding = ItemColorsBinding.inflate(inflater, p0, false)
                ColorsViewHolder(binding)
            }
            VIEW_TYPE_THREE -> {
                val binding: ItemCategoriesBinding =
                    ItemCategoriesBinding.inflate(inflater, p0, false)
                CategoriesViewHolder(binding)
            }
            else -> {
                val binding: ItemIdeasForYouBinding =
                    ItemIdeasForYouBinding.inflate(inflater, p0, false)
                IdeasViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data: Data = listData[position]
        if (holder.javaClass == SearchesViewHolder::class.java) {
            holder as SearchesViewHolder
            with(holder) {
                val searchesAdapter = SearchesAdapter(context, mList)
                recyclerView.layoutManager = LinearLayoutManager(
                    recyclerView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = searchesAdapter

                title.text = data.name

            }
        } else if (holder.javaClass == ColorsViewHolder::class.java) {
            holder as ColorsViewHolder
            with(holder) {
                val colorsAdapter = ColorsAdapter(context, mList)
                recyclerView.layoutManager = LinearLayoutManager(
                    recyclerView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = colorsAdapter

                title.text = data.name
            }

        } else if (holder.javaClass == CategoriesViewHolder::class.java) {
            holder as CategoriesViewHolder
            with(holder) {
                val categoriesAdapter = CategoriesAdapter(context, mList)
                recyclerView.layoutManager = GridLayoutManager(
                    recyclerView.context,
                    2
                )
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = categoriesAdapter

                title.text = data.name
            }
        } else {
            holder as IdeasViewHolder
            with(holder) {
                val ideasAdapter = IdeasAdapter(context, mList)
                recyclerView.layoutManager = LinearLayoutManager(
                    recyclerView.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = ideasAdapter

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
        } else if (position % 4 == 3) {
            VIEW_TYPE_THREE
        } else {
            VIEW_TYPE_FOUR
        }
    }


    inner class CategoriesViewHolder(binding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var recyclerView = binding.recyclerViewCategoriesChild
        var title = binding.textTitleCategories
    }

    inner class SearchesViewHolder(val binding: ItemSearchesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var recyclerView = binding.recyclerViewSearchesChild
        var title = binding.textTitleSearches
    }

    inner class ColorsViewHolder(val binding: ItemColorsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var recyclerView = binding.recyclerViewColorsChild
        var title = binding.textTitleColors
    }

    inner class IdeasViewHolder(val binding: ItemIdeasForYouBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var recyclerView = binding.recyclerViewIdeasChild
        var title = binding.textTitleIdeas
    }

}