package com.example.recyclerviewexample
import androidx.lifecycle.ViewModel

class VM: ViewModel() {
    var peliculas : MutableList<Pelicula> = mutableListOf()

    var peli1 = Pelicula("Django Unchained", "Quentin Tarantino", "WESTERN", "2012")
    var peli2 = Pelicula( "Pulp Fiction", "Quentin Tarantino", "CRIMEN", "1994")
    var peli3 = Pelicula( "El club de la lucha", "David Fincher", "DRAMA", "1999")
    var peli4 = Pelicula( "Forest Gump", "Robert Zemeckis", "DRAMA", "1994")
    var peli5 = Pelicula( "La lista de Schindler", "Steven Spielberg", "DRAMA", "1993")
    var peli6 = Pelicula( "Doce hombre sin piedad", "sidney Lumet", "CRIMEN", "1957")
    var peli7 = Pelicula( "Alguien voló sobre el nido del Cuco", "Milos Forman", "DRAMA", "1975")
    var peli8 = Pelicula( "Godfellas", "Martin Scorsese", "CRIMEN", "1990")
    var peli9 = Pelicula( "Scarface", "Brian De Palma", "CRIMEN", "1983")
    var peli10 = Pelicula( "Taxi Driver", "Martin Scorsese", "DRAMA", "1976")

    init{
        peliculas.add(peli1)
        peliculas.add(peli2)
        peliculas.add(peli3)
        peliculas.add(peli4)
        peliculas.add(peli5)
        peliculas.add(peli6)
        peliculas.add(peli7)
        peliculas.add(peli8)
        peliculas.add(peli9)
        peliculas.add(peli10)
    }


    fun nuevaPeli(titulo: String, director: String, ano: String, genero: String){
        var pelicula = Pelicula(titulo, director, ano, genero)
        peliculas.add(pelicula)
    }

    fun editPeli(posicion: Int, titulo: String, director: String, ano: String, genero: String){
        peliculas[posicion].titulo = titulo
        peliculas[posicion].director = director
        peliculas[posicion].year = ano
        peliculas[posicion].genero = genero

    }

    fun deletePeli(posicion: Int){
        peliculas.removeAt(posicion)
    }


}
