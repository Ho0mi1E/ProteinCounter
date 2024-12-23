package com.example.proteincount

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.proteincount.databinding.ItemUreaBinding
import java.util.Locale

class UreaViewHolder(item:View, private val avrg:Double,private val binding:ItemUreaBinding,private val clicker: AvrgM): ViewHolder(binding.root) {


    companion object {
        fun newInstance(parent: ViewGroup,avrg: Double,binding: ItemUreaBinding,clicker: AvrgM) = UreaViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_urea, parent, false
            ), avrg,binding,clicker
        )

    }


    fun add() {
        binding.buttomCount.setOnClickListener {
            if (binding.d1.text.isNotEmpty() && binding.d2.text.isNotEmpty() && binding.d3.text.isNotEmpty()) {
                val list = listOf(
                    binding.d1.text.toString().toDouble(),
                    binding.d2.text.toString().toDouble(),
                    binding.d3.text.toString().toDouble()
                )
                val avr = list.average()
                val c = (avr / avrg) * 8.3
                val m = c * 6
                val list1 = listOf(avr, c, m).map { String.format("%.3f", it).toDouble() }
                binding.textResult.text = "△D:=${list1[0]}\nС:=${list1[1]}"
                binding.textMResult.text = "${list1[2]}"
            }

        }

    }
    fun show() {
        binding.check.setOnCheckedChangeListener { _, ischecked ->
            if (ischecked) {
                binding.buttomSaveM.visibility = View.VISIBLE
            }
            else binding.buttomSaveM.visibility = View.GONE
        }
        binding.buttomSaveM.setOnClickListener {
            clicker.clicker(binding.textMResult.text.toString().toDouble())
        }

    }


}