package com.example.interfaz3

sealed class Routes(val route: String) {
    object PantallaInicio: Routes("inicio")
    object PantallaIngresarUsuario: Routes("ingresarUsuario")
    object PantallaCrearVotacion: Routes("crearVotacion")
    object PantallaCargarPropietarios: Routes("cargarPropietarios")
    object PantallaCronometro: Routes("cronometro")
    object PantallaOrdenDelDia: Routes("ordenDelDia")
    object PantallaPropuestas: Routes("propuestas")
}
