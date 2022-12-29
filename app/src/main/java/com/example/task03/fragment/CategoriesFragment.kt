package com.example.task03.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.arch.core.executor.DefaultTaskExecutor
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task03.R
import com.example.task03.adapter.*
import com.example.task03.databinding.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var mList: MutableList<String> = ArrayList()
    private var listData: MutableList<Data> = ArrayList()

    private lateinit var binding: FragmentCategoriesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fakeData()
        setUpRecyclerView()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoriesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setUpRecyclerView() {

        listData.add(Data("Popular Searches"))
        listData.add(Data("Colors"))
        listData.add(Data("Ideas for you"))
        listData.add(Data("Categories bo"))

        val baseCategoriesAdapter = context?.let { BaseCategoriesAdapter(it, listData, mList) }
        binding.apply {
            recyclerViewBase.layoutManager = LinearLayoutManager(
                binding.recyclerViewBase.context,
                LinearLayoutManager.VERTICAL,
                false
            )
            recyclerViewBase.setHasFixedSize(true)
            recyclerViewBase.adapter = baseCategoriesAdapter
        }
    }

    fun fakeData() {
        val random = Random()
        for (i in 0..10) mList.add(java.lang.String.valueOf(random.nextInt(100)))
    }
}