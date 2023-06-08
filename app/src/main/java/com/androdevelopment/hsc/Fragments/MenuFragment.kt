package com.androdevelopment.hsc.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.androdevelopment.hsc.Adapters.MenuAdapter
import com.androdevelopment.hsc.Models.MenuModel
import com.androdevelopment.hsc.R


class MenuFragment : Fragment(), MenuAdapter.OnMenuClick {

    private lateinit var view: View

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MenuAdapter
    private lateinit var list: MutableList<MenuModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        view = inflater.inflate(R.layout.fragment_menu, container, false)

        recyclerView = view.findViewById(R.id.recyclerMenu)


        setRecyclerView()

        return view
    }

    private fun setRecyclerView() {
        list = mutableListOf()
        adapter = MenuAdapter(list, this)

        list.add(MenuModel(R.drawable.logo, "Settings", "Settings",false))
        list.add(MenuModel(R.drawable.logo, "Clubs", "HSC",false))
        list.add(MenuModel(R.drawable.logo, "Academics", "HSC",false))
        list.add(MenuModel(R.drawable.logo, "News", "HSC",false))
        list.add(MenuModel(R.drawable.logo, "Gallery", "HSC",false))
        list.add(MenuModel(R.drawable.logo, "Restaurants", "HSC",false))
        list.add(MenuModel(R.drawable.logo, "Rate the app", "Social Media",false))
        list.add(MenuModel(R.drawable.logo, "Facebook", "Social Media",false))
        list.add(MenuModel(R.drawable.logo, "Instagram", "Social Media",false))


        list.sortBy { it.collection }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            addItemDecoration(DividerItemDecoration(view.context, VERTICAL))
            adapter = this@MenuFragment.adapter
        }


    }

    override fun onMenuClick(item: MenuModel) {

        Toast.makeText(view.context, "HSC", Toast.LENGTH_SHORT).show()
    }

}