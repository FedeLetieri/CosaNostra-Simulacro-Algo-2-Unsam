class Persona(
    val ingresosMensuales:Int,
    val nombre:String,
    val depositosEnPosicion:MutableList<Deposito>
) {

    fun ingresoMensualSuperior(monto:Int) = ingresosMensuales >= monto

    fun cotieneLetraProhibida(letra: Char) = nombre.contains(letra)



}

object Vito{

}