package com.example.a18reciclerview

//Creamos la lista de elementos que añadiremos mas tarde a la vista del RecyclerView
class Nombres(val nombre: String){
    companion object {
        //Creamos una lista mutable de Nombres para poder añadir o eliminar elementos mas tarde
        val listaNombres: MutableList<Nombres> = mutableListOf(
            Nombres("Alvaro"),
            Nombres("Manu"),
            Nombres("Anxo"),
            Nombres("Alejandro"),
            Nombres("Sergio"),
            Nombres("Pablo"),
            Nombres("David"),
            Nombres("Anxo V"),
            Nombres("Osian"),
            Nombres("Jorge"),
            Nombres("Diego"),
            Nombres("Ivan"),
            Nombres("Ruben"),
            Nombres("Agustin"),
            Nombres("Alex"),
            Nombres("Laura"),
            Nombres("Carla"),
            Nombres("Abigail"),
            Nombres("Anxo F"),
            Nombres("Adrian"),
            Nombres("Hector"),
            Nombres("Marcos")
        )
    }
}