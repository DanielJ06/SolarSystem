package com.danieljrodrigues.solarsystem.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danieljrodrigues.solarsystem.R
import com.danieljrodrigues.solarsystem.databinding.SmallPlanetCardBinding
import com.danieljrodrigues.solarsystem.models.Card

class SmallPlanetCardAdapter : RecyclerView.Adapter<SmallPlanetCardAdapter.MyViewHolder>() {

    private var planets = emptyList<Card>()

    class MyViewHolder(private val binding: SmallPlanetCardBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(planet: Card) {
            binding.card = planet
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SmallPlanetCardBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPlanet = planets[position]
        holder.bind(currentPlanet)
    }

    override fun getItemCount(): Int {
        return planets.size
    }

    fun setData(data: ArrayList<Card>) {
        planets = data
    }
}