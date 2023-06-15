abstract class Banda(
    val dineroRecaudado: Int,
    val listaDeIntengrantes: MutableList<Intengrante>,
    val tareasParaRealizar: MutableList<Tarea>
) {

    fun bancarrota(): Boolean = dineroRecaudado <= 0

    abstract fun quiereAgarrarTarea(tarea: Tarea): Boolean

    fun realizarCambiosEnBanda(): Boolean {
        return true
    }

    fun aceptarTarea(tarea: Tarea) {
        tareasParaRealizar.add(tarea)
    }

    fun eliminarTareaRealizada(tarea: Tarea) {
        tareasParaRealizar.remove(tarea)
    }

    fun realizarTarea(tarea: Tarea){
        eliminarTareaRealizada(tarea)
    }

}


class BandaForajida(dineroRecaudado: Int, listaDeIntengrantes: MutableList<Intengrante>,
                    tareasParaRealizar: MutableList<Tarea>
) : Banda(
    dineroRecaudado,
    listaDeIntengrantes, tareasParaRealizar
) {

    override fun quiereAgarrarTarea(tarea: Tarea): Boolean =
        listaDeIntengrantes.any { it -> it.quiereRealizarTarea(tarea) }


}


class BandaSonora(dineroRecaudado: Int, listaDeIntengrantes: MutableList<Intengrante>,
                  tareasParaRealizar: MutableList<Tarea>
) : Banda(
    dineroRecaudado,
    listaDeIntengrantes, tareasParaRealizar
) {

    override fun quiereAgarrarTarea(tarea: Tarea): Boolean =
        listaDeIntengrantes.all { it -> it.quiereRealizarTarea(tarea) }
}

class BandaTipica(dineroRecaudado: Int, listaDeIntengrantes: MutableList<Intengrante>, val lider: Intengrante,
                  tareasParaRealizar: MutableList<Tarea>
) : Banda(
    dineroRecaudado,
    listaDeIntengrantes, tareasParaRealizar
) {

    override fun quiereAgarrarTarea(tarea: Tarea): Boolean = lider.quiereRealizarTarea(tarea)

}