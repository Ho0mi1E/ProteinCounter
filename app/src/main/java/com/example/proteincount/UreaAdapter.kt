package com.example.proteincount

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.proteincount.databinding.FragmentMainBinding
import com.example.proteincount.databinding.ItemUreaBinding

class UreaAdapter(private val items: MutableList<String>,private val avrg:Double,private val clciker: AvrgM) :Adapter<UreaViewHolder>() {
     lateinit var binding: ItemUreaBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UreaViewHolder {
        binding = ItemUreaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UreaViewHolder.newInstance(parent,avrg,binding,clciker)
    }

    override fun onBindViewHolder(holder: UreaViewHolder, position: Int) {
        holder.add()
        holder.show()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem(item: String) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }
}