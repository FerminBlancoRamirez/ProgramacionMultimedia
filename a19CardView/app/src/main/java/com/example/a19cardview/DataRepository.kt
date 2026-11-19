package com.example.a19cardview

class DataRepository {
    var items: MutableList<Anime?>

    init {
        // Inicializa la lista Y la POBLAMOS
        items = ArrayList<Anime?>()
        items.add(Anime(R.drawable.angel, "Angel Beats", 230))
        items.add(Anime(R.drawable.death, "Death Note", 456))
        items.add(Anime(R.drawable.fate, "Fate Stay Night", 342))
        items.add(Anime(R.drawable.nhk, "Welcome to the NHK", 645))
        items.add(Anime(R.drawable.suzumiya, "Suzumiya Haruhi", 459))
        /*Ejemplo de acceso
            for(Anime anime: items) {
                System.out.println(anime.getNombre() + " - " + anime.getVisitas());
            }
    */
    }

    // Método para obtener la lista
    fun obtenerListaAnimes(): MutableList<Anime?> {
        return items
    }
}
