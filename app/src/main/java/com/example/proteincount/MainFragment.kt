package com.example.proteincount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proteincount.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val adapter by lazy { UreaAdapter(mutableListOf(),countAvrg(),clicker) }
    private val listM by lazy { mutableListOf<Double>() }
    private val clicker by lazy {
        object : AvrgM {
            override fun clicker(m: Double) {

                listM.add(m)
            }
        } }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        binding.d0button.setOnClickListener {
            binding.averaged0.text = countAvrg().toString()
            openAdapeter()
            binding.recycler.adapter = adapter
        }
        countavrgM()
    }

    private fun countAvrg():Double{
        return String.format("%.3f",(listOf(binding.d01.text.toString().toFloat(),binding.d02.text.toString().toFloat(),binding.d02.text.toString().toFloat()).average())).toDouble()
    }
    private fun openAdapeter(){
        adapter.addItem("lol")
    }

    private fun countavrgM(){
        binding.m0button.setOnClickListener {
            binding.averagem0.text = String.format("%.3f",listM.average().toString().toFloat())
        }
    }

}



