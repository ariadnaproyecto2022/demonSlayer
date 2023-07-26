package com.oropeza.ec3_asot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oropeza.ec3_asot.databinding.ItemDemonBinding
import com.oropeza.ec3_asot.model.DemonSlayer

class RVDemonListAdapter(var demons: List<DemonSlayer>): RecyclerView.Adapter<DemonVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemonVH {
        val binding = ItemDemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DemonVH(binding)
    }

    override fun getItemCount(): Int = demons.size

    override fun onBindViewHolder(holder: DemonVH, position: Int) {
        holder.bind(demons[position])
    }
}

class DemonVH(private val binding: ItemDemonBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(demon: DemonSlayer) {
        Glide.with(binding.root)
            .load(demon.image)
            .into(binding.imageView)
        binding.txtNameDemon.text = demon.name
    }
}