package org.example

sealed class MaqExpendedoraState {

    object Idle : MaqExpendedoraState() {
        fun onEnter(){
            println("En Idle")
        }
        fun comprobarMonedero(dinero: Double){
            if(dinero > 0){
                MaqExpendedora.currentState = Pagar(dinero)
            }
            else{
                val mensaje = "NO se ha introducido dinero."
                MaqExpendedora.currentState = Error(mensaje)
            }
        }
    }
    data class Pagar(val precio:Double) : MaqExpendedoraState() {
        fun onEnter(){
            println("Comprobando el pago de "+ precio+"€")
        }
        fun comprobarPrecio(bebida: Bebida, dinero: Double){
            if (dinero < bebida.precio){
                val mensaje = "La cantidad introducida es insuficiente"
                MaqExpendedora.currentState = Error(mensaje)
            }
            else{
                println("La cantidad introducida es suficiente")
                println("Devolviendo " + (dinero - bebida.precio) + "€" )
                MaqExpendedora.currentState = ComprobarDisponibilidad
            }
        }
    }
    object ComprobarDisponibilidad : MaqExpendedoraState() {
        fun onEnter(){
            println("En comprobar diponibilidad")
        }
        fun disponibilidad(bebida: Bebida){
            if(bebida.disponible){
                println("La bebida está disponible\nSirviendo bebida ${bebida.nombre}")

            }
            else{
                val mensaje = "La bebida no está disponible"
                MaqExpendedora.currentState = Error(mensaje)

            }
        }
    }

    data class Error(val mensaje: String) : MaqExpendedoraState(){
        fun onEnter(){
            println("[Error]")
            println("Sucedió el siguiente error: $mensaje")
            println("Volviendo a Idle")
            MaqExpendedora.currentState = Idle

        }
    }




}