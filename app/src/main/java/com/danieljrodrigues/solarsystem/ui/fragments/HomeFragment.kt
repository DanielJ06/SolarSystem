package com.danieljrodrigues.solarsystem.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.danieljrodrigues.solarsystem.R
import com.danieljrodrigues.solarsystem.adapters.SmallPlanetCardAdapter
import com.danieljrodrigues.solarsystem.databinding.FragmentHomeBinding
import com.danieljrodrigues.solarsystem.models.Card

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val mAdapter by lazy { SmallPlanetCardAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.planetsRv.adapter = mAdapter
        binding.planetsRv.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false
        )
        val data: ArrayList<Card> = ArrayList()
        data.add(Card( 1, "Terra"))
        data.add(Card( 2, "Marte"))
        data.add(Card( 1, "Vênus"))
        data.add(Card( 1, "Saturno"))
        mAdapter.setData(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}