package org.example

fun main() {
    println("-----------------------------------------------------")

    // Primero una sin error
    // Idle -> Pagar
    MaqExpendedora.gestorEstados(Bebida.MONSTER, 2.0)
    // Pagar -> Disponibilidad
    MaqExpendedora.gestorEstados(Bebida.MONSTER, 2.0)
    //Disponibilidad
    MaqExpendedora.gestorEstados(Bebida.MONSTER, 2.0)

    println("-----------------------------------------------------")
    // AHora una con error en Idle
    MaqExpendedora.currentState = MaqExpendedoraState.Idle
    // Idle y se queda
    MaqExpendedora.gestorEstados(Bebida.MONSTER, 0.0)
    // error
    MaqExpendedora.gestorEstados(Bebida.MONSTER, 0.0)

    println("-----------------------------------------------------")
    //Ahora una con error en pagar
    // Idle -> Pagar
    MaqExpendedora.gestorEstados(Bebida.MONSTER, 1.0)
    // EN pagar ve que no es suficiente, por lo que vuelve a Idle
    MaqExpendedora.gestorEstados(Bebida.MONSTER, 1.0)
    // Error
    MaqExpendedora.gestorEstados(Bebida.MONSTER, 1.0)

    println("-----------------------------------------------------")
    // Ahora una con error en disponibilidad

    // Idle -> Pagar
    MaqExpendedora.gestorEstados(Bebida.FANTA, 2.0)
    // Pagar -> Disponibilidad
    MaqExpendedora.gestorEstados(Bebida.FANTA, 2.0)
    //Disponibilidad -> Error
    MaqExpendedora.gestorEstados(Bebida.FANTA, 2.0)
    // Error -> Idle
    MaqExpendedora.gestorEstados(Bebida.FANTA, 2.0)
}