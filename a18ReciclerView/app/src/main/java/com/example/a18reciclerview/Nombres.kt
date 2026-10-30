package com.example.a18reciclerview

//Creamos la lista de elementos que añadiremos mas tarde a la vista del RecyclerView
class Nombres(val nombre: String, val countryCode: String, val capital: String){
    companion object {
        //Creamos una lista mutable de Nombres para poder añadir o eliminar elementos mas tarde
        val listaNombres: MutableList<Nombres> = mutableListOf(
            Nombres("España", "es", "Madrid"),
            Nombres("México", "mx", "Ciudad de México"),
            Nombres("Argentina", "ar", "Buenos Aires"),
            Nombres("Colombia", "co", "Bogotá"),
            Nombres("Chile", "cl", "Santiago"),
            Nombres("Perú", "pe", "Lima"),
            Nombres("Uruguay", "uy", "Montevideo"),
            Nombres("Venezuela", "ve", "Caracas"),
            Nombres("Ecuador", "ec", "Quito"),
            Nombres("Guatemala", "gt", "Ciudad de Guatemala"),
            Nombres("Costa Rica", "cr", "San José"),
            Nombres("Brasil", "br", "Brasilia"),
            Nombres("Panamá", "pa", "Ciudad de Panamá"),
            Nombres("Bolivia", "bo", "Sucre"),
            Nombres("Paraguay", "py", "Asunción"),
            Nombres("Francia", "fr", "París"),
            Nombres("Italia", "it", "Roma"),
            Nombres("Alemania", "de", "Berlín"),
            Nombres("Portugal", "pt", "Lisboa"),
            Nombres("Reino Unido", "gb", "Londres"),
            Nombres("Japón", "jp", "Tokio"),
            Nombres("Estados Unidos", "us", "Washington D.C.")
        )
    }
}