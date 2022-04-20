package com.example.recyclerviewexample

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class Adaptador(var fragmento: Fragment , var lista: MutableList<Pelicula>, var activity : MainActivity) : RecyclerView.Adapter<Adaptador.ViewHolder>() {


    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var titulo: TextView
        var director: TextView
        var genero: TextView
        var ano: TextView


        var botonEdit : ImageView
        var botonDelete : ImageView

        var posicion= -1

        init {
            titulo = v.findViewById(R.id.Titulo)
            director = v.findViewById(R.id.director)
            genero = v.findViewById(R.id.genero)
            ano = v.findViewById(R.id.ano)
            botonEdit = v.findViewById(R.id.editIcon)
            botonDelete = v.findViewById(R.id.deleteIcon)
            v.setOnClickListener(){
                val miBundle: Bundle = bundleOf("id" to this.posicion)
                fragmento.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, miBundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_contenedor, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titulo.text = lista[position].titulo
        holder.director.text = lista[position].director
        holder.genero.text = lista[position].genero
        holder.ano.text = lista[position].year

        holder.botonEdit.setOnClickListener(){
            val bundle = bundleOf("id" to position)
            fragmento.findNavController().navigate(R.id.action_SecondFragment_to_forthFragment, bundle)
        }

        holder.botonDelete.setOnClickListener(){

            val bundle = bundleOf("id" to position, "name" to lista[position].titulo)
            activity.popupDelete(bundle)

        }

    }


}