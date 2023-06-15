import java.time.LocalDate

//Falta restar en Abrir deposito

abstract class Tarea(
    val fecha: LocalDate,
    var tareaPendiente: Boolean,
    val personaAQuienRealizar: Persona

) {

    var monto: Double = 0.0


    abstract fun realizarTarea()



    fun mesPar(): Boolean = (fecha.monthValue % 2) == 0

    fun personaConIngresoMensualSuperior(ingresoMinimo: Int) =
        personaAQuienRealizar.ingresoMensualSuperior(ingresoMinimo)

    fun personaContieneLetraProhibida(letra: Char) = personaAQuienRealizar.cotieneLetraProhibida(letra)
}


class DeProteccion(
    val negocio: Negocio, fecha: LocalDate, tareaPendiente: Boolean, monto: Int,
    personaAQuienRealizar: Persona
) : Tarea(
    fecha, tareaPendiente, personaAQuienRealizar
) {
    companion object {
        val porcentajeACobrar: Double = 0.90
    }

    override fun realizarTarea() {
        monto = negocio.pagarProteccion(porcentajeACobrar)
    }
}

class AbrirDeposito(
    val deposito: Deposito, fecha: LocalDate, tareaPendiente: Boolean, monto: Int,
    personaAQuienRealizar: Persona
) : Tarea(
    fecha, tareaPendiente,
    personaAQuienRealizar
) {
    companion object {
        val cantidadAPagarPorMetroCuadrado: Int = 100
    }

    override fun realizarTarea() {
        comprarDeposito()
    }

    fun comprarDeposito() {
        monto = deposito.tamañoDelDepositoEnMetrosCuadrados * cantidadAPagarPorMetroCuadrado
    }
}

class PrestarDinero(
    val persona: Persona, fecha: LocalDate, tareaPendiente: Boolean, monto: Int,
    personaAQuienRealizar: Persona, val dineroPrestado: Double
) : Tarea(
    fecha, tareaPendiente,
    personaAQuienRealizar
) {

    companion object {
        val cantidadDeTareasPorPrestarDinero: Int = 4
    }


    override fun realizarTarea() {
        prestarDinero(dineroPrestado, persona)
    }

    fun prestarDinero(dineroPrestado: Double, persona: Persona) {
        val dineroAPAgarPorMes = dineroPrestado / cantidadDeTareasPorPrestarDinero


    }


}

class CobrarCuotaDeDineroPrestado(
    fecha: LocalDate,
    tareaPendiente: Boolean,
    monto: Int,
    personaAQuienRealizar: Persona
) : Tarea(
    fecha, tareaPendiente,

    personaAQuienRealizar
) {

    override fun realizarTarea() {
        TODO("Not yet implemented")
    }
}