package com.androdevelopment.hsc.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.androdevelopment.hsc.Adapters.SportsAdapter
import com.androdevelopment.hsc.Models.SportModel
import com.androdevelopment.hsc.R
import com.androdevelopment.hsc.databinding.FragmentSportsBinding
import java.util.UUID


class SportsFragment : Fragment() {

    private lateinit var binding: FragmentSportsBinding

    private lateinit var sportsAdapter: SportsAdapter
    private val sportsList = arrayListOf<SportModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentSportsBinding.inflate(layoutInflater, container, false)



        setRecyclerView()
        return binding.root
    }

    private fun setRecyclerView() {
        sportsAdapter = SportsAdapter(sportsList)

        val item = SportModel(UUID.randomUUID(),"Swimming",0)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)
        sportsList.add(item)


        binding.recyclerSports.apply {
            layoutManager =
                GridLayoutManager(binding.root.context, 2, GridLayoutManager.VERTICAL, false)
                itemAnimator = DefaultItemAnimator()
                adapter = sportsAdapter
        }
    }
}