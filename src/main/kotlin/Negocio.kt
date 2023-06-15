class Negocio {

    var ventasObtenidasEnElMes:Double = 0.0

    fun pagarProteccion(porcentajeACobrar: Double):Double {
        val montoAPagar:Double = porcentajeACobrar*ventasObtenidasEnElMes
        ventasObtenidasEnElMes -= montoAPagar
        return montoAPagar
    }
}