package com.example.recyclerviewexample

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewexample.databinding.FragmentForthBinding
import com.example.recyclerviewexample.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ForthFragment : Fragment() {

    private var _binding: FragmentForthBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentForthBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id: Int = arguments?.getInt("id") ?:-1

        //setHasOptionsMenu(true)
        activity?.title= "Editar película"

        val spinner = binding.editgeneroSelect
        val generos = listOf("WESTERN", "CRIMEN", "ROMANCE", "COMEDIA", "DRAMA")
        val adaptadorSelect = ArrayAdapter(activity as MainActivity, R.layout.simple_spinner_item, generos)
        spinner.adapter = adaptadorSelect
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val tutorialsName: String = parent.getItemAtPosition(position).toString()
                Toast.makeText(parent.context, "Selected: $tutorialsName", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val titulo = binding.edittituloInput
        titulo.setText((activity as MainActivity).modelo.peliculas[id].titulo)
        val director = binding.editdirectorInput
        director.setText((activity as MainActivity).modelo.peliculas[id].director)
        val ano = binding.editanoinput
        ano.setText((activity as MainActivity).modelo.peliculas[id].year)
        val genero = binding.editgeneroSelect
        var pos = 0
        if ((activity as MainActivity).modelo.peliculas[id].genero == "WESTERN") {
            pos = 0
        } else if ((activity as MainActivity).modelo.peliculas[id].genero == "CRIMEN"){
            pos = 1
        } else if ((activity as MainActivity).modelo.peliculas[id].genero == "ROMANCE"){
            pos = 2
        } else if ((activity as MainActivity).modelo.peliculas[id].genero == "COMEDIA"){
            pos = 3
        } else {
            pos = 4
        }
        genero.setSelection(pos)


        val botonGuardar = binding.buttonFirst3
        botonGuardar.setOnClickListener {
            var titulo = binding.edittituloInput.text.toString()
            var director = binding.editdirectorInput.text.toString()
            var ano = binding.editanoinput.text.toString()
            var genero = binding.editgeneroSelect.selectedItem.toString()
            if (!titulo.equals("") && !director.equals("") && !ano.equals("")){
                (activity as MainActivity).modelo.editPeli(id, titulo, director, ano, genero)
                findNavController().navigate(com.example.recyclerviewexample.R.id.action_forthFragment_to_SecondFragment)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}