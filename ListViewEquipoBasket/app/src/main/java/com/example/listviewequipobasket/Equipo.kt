package com.example.listviewequipobasket

class Equipo(//sin setters porque no se van a modificar los datos
    //getters para obtener los datos
    @JvmField val nombre: String?,
    @JvmField val ciudad: String?,
    @JvmField val pais: String?,
    @JvmField val fundacion: Int,
    @JvmField val idImage: Int
) {
    override fun toString(): String {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", fundacion=" + fundacion +
                ", idImage=" + idImage +
                '}'
    }
}
