interface Personalidad {
    abstract fun quiereRealizarTarea(tarea: Tarea):Boolean
}


object AltoPerfil : Personalidad {
    override fun quiereRealizarTarea(tarea: Tarea):Boolean = condicionCobrarTarea(tarea)

    fun condicionCobrarTarea(tarea: Tarea):Boolean = tarea.monto >= 1000

}

object Culposos : Personalidad {

    val ingresoMinimo:Int = 500

    override fun quiereRealizarTarea(tarea: Tarea):Boolean = tarea.personaConIngresoMensualSuperior(ingresoMinimo)
}

object Alternantes : Personalidad {
    override fun quiereRealizarTarea(tarea: Tarea):Boolean = cambioDePersonalidad(tarea).quiereRealizarTarea(tarea)

    fun cambioDePersonalidad(tarea:Tarea): Personalidad{
        return if(tarea.mesPar()){
             Culposos
        }
        else AltoPerfil
    }

}

object Cabuleros : Personalidad {

    val letraProhibida: Char = 'x'

    override fun quiereRealizarTarea(tarea: Tarea):Boolean= tarea.personaContieneLetraProhibida(letraProhibida)
}

class Combinada(val listaDePersonalidades:MutableList<Personalidad>) : Personalidad {



    override fun quiereRealizarTarea(tarea: Tarea):Boolean =
        listaDePersonalidades.all{it -> it.quiereRealizarTarea(tarea)}
}

