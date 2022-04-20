package com.example.recyclerviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewexample.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setHasOptionsMenu(true)
        activity?.title= "Nueva película"

        val spinner = binding.editgeneroSelect
        val generos = listOf("WESTERN", "CRIMEN", "ROMANCE", "COMEDIA", "DRAMA")
        val adaptadorSelect = ArrayAdapter(activity as MainActivity, android.R.layout.simple_spinner_item, generos)
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

        val botonGuardar = binding.buttonFirst2

        botonGuardar.setOnClickListener {
            var titulo = binding.edittituloInput.text.toString()
            var director = binding.editdirectorInput.text.toString()
            var ano = binding.editanoinput.text.toString()
            var genero = binding.editgeneroSelect.selectedItem.toString()
            if (!titulo.equals("") && !director.equals("") && !ano.equals("")){
                (activity as MainActivity).modelo.nuevaPeli(titulo, director, ano, genero)
                findNavController().navigate(R.id.action_thirdFragment2_to_SecondFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}