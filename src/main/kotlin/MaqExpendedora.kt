package org.example

object MaqExpendedora{
    public var currentState: MaqExpendedoraState = MaqExpendedoraState.Idle

    fun gestorEstados(bebida: Bebida, dinero: Double){

        when (val estado = currentState) {
            is MaqExpendedoraState.Idle -> {
                estado.onEnter()
                estado.comprobarMonedero(dinero)
            }

            is MaqExpendedoraState.Pagar ->{
                estado.onEnter()
                estado.comprobarPrecio(bebida, dinero )
            }

            is MaqExpendedoraState.ComprobarDisponibilidad -> {
                estado.onEnter()
                estado.disponibilidad(bebida)
            }

            is MaqExpendedoraState.Error -> {
                estado.onEnter()
            }
        }
    }
}