package com.example.recyclerviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    lateinit var miRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        miRecyclerView = binding.recycler
        miRecyclerView.layoutManager = LinearLayoutManager(activity)

        miRecyclerView.adapter = Adaptador(this, (activity as MainActivity).modelo.peliculas, activity as MainActivity)

        //setHasOptionsMenu(true)
        activity?.title= "Lista de películas"

        binding.nuevo.setOnClickListener(){
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    public fun rellenarRecycler(view: View){
        miRecyclerView = binding.recycler
        miRecyclerView.layoutManager = LinearLayoutManager(activity)

        miRecyclerView.adapter = Adaptador(this, (activity as MainActivity).modelo.peliculas, activity as MainActivity)

    }
}