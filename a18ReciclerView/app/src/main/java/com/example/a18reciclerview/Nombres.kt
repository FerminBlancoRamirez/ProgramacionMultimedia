package com.example.a18reciclerview

//Creamos la lista de elementos que añadiremos mas tarde a la vista del RecyclerView
class Nombres(val nombre: String, val countryCode: String){
    companion object {
        //Creamos una lista mutable de Nombres para poder añadir o eliminar elementos mas tarde
        val listaNombres: MutableList<Nombres> = mutableListOf(
            Nombres("España", "es"),
            Nombres("México", "mx"),
            Nombres("Argentina", "ar"),
            Nombres("Colombia", "co"),
            Nombres("Chile", "cl"),
            Nombres("Perú", "pe"),
            Nombres("Uruguay", "uy"),
            Nombres("Venezuela", "ve"),
            Nombres("Ecuador", "ec"),
            Nombres("Guatemala", "gt"),
            Nombres("Costa Rica", "cr"),
            Nombres("Brasil", "br"),
            Nombres("Panamá", "pa"),
            Nombres("Bolivia", "bo"),
            Nombres("Paraguay", "py"),
            Nombres("Francia", "fr"),
            Nombres("Italia", "it"),
            Nombres("Alemania", "de"),
            Nombres("Portugal", "pt"),
            Nombres("Reino Unido", "gb"),
            Nombres("Japón", "jp"),
            Nombres("Estados Unidos", "us")
        )
    }
}