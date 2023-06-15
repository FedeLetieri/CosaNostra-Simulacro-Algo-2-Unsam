class Intengrante(
    var personalidad: Personalidad
) {

    fun cambiarPersonalidad(personalidadNueva: Personalidad){
        personalidad = personalidadNueva
    }

    fun quiereRealizarTarea(tarea: Tarea) = personalidad.quiereRealizarTarea(tarea)

}