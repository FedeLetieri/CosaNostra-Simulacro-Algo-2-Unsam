class AsignadorDeTareas(
    val listaDeTareas: MutableList<Tarea>,
    val listaDeBandas: MutableList<Banda>
) {

    fun agregarTarea(tarea: Tarea) {
        listaDeTareas.add(tarea)
    }

    fun asignarTotalTareas() {
        listaDeTareas.toList().forEach {
            val bandaElegida: Banda = elegirTareaALaPrimeraBandaDisponible(it)
            asignarTarea(it, bandaElegida)
        }
    }


    fun asignarTarea(tarea: Tarea, banda: Banda) {
        eliminarTareaDeLista(tarea)
        banda.aceptarTarea(tarea)
    }


    fun eliminarTareaDeLista(tarea:Tarea){
        listaDeTareas.remove(tarea)
    }

    fun elegirTareaALaPrimeraBandaDisponible(tarea: Tarea): Banda =
        listaDeBandas.firstOrNull { it.quiereAgarrarTarea(tarea) && !it.bancarrota() } ?: ningunaBandaElegida(tarea)


    fun ningunaBandaElegida(tarea:Tarea): Banda{
        listaDeBandas.forEach { it.realizarCambiosEnBanda() }
        return elegirTareaALaPrimeraBandaDisponible(tarea)}

    fun mandarNotificacion(notificacionSender:NotificacionSender){}

}