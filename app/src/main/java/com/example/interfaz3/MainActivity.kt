package com.example.interfaz3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val title = remember { mutableStateOf("Inicio") }
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            val navigationController = rememberNavController()

            // Correct theme for Material2
            MaterialTheme {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        MyTopAppBar(title = title.value){
                            scope.launch { scaffoldState.drawerState.open() }
                        }
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(id="inicio", title= "inicio", contentDescription = "go to screen inicio", icon = Icons.Default.Home),
                                MenuItem(id="ingresarUsuario", title= "usuario", contentDescription = "go to screen usuario", icon = Icons.Default.Person),
                                MenuItem(id="crearVotacion", title= "votacion", contentDescription = "go to screen votacion", icon = Icons.Default.ThumbUp),
                                MenuItem(id="cargarPropietarios", title= "propietarios", contentDescription = "go to screen propietarios", icon = Icons.Default.AccountBox),
                                MenuItem(id="cronometro", title= "cronometro", contentDescription = "go to screen cronometro", icon = Icons.Default.PlayArrow),
                                MenuItem(id="ordenDelDia", title= "orden", contentDescription = "go to screen orden", icon = Icons.Default.Check),
                                MenuItem(id="propuestas", title= "propuestas", contentDescription = "go to screen propuestas", icon = Icons.Default.AddCircle)
                            ),
                            onItemClick = {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                    when(it.id){
                                        "inicio" -> {
                                            title.value = "inicio"
                                            navigationController.navigate(Routes.PantallaInicio.route)
                                        }
                                        "ingresarUsuario" -> {
                                            title.value = "usuario"
                                            navigationController.navigate(Routes.PantallaIngresarUsuario.route)
                                        }
                                        "crearVotacion" -> {
                                            title.value = "votacion"
                                            navigationController.navigate(Routes.PantallaCrearVotacion.route)
                                        }
                                        "cargarPropietarios" -> {
                                            title.value = "propietarios"
                                            navigationController.navigate(Routes.PantallaCargarPropietarios.route)
                                        }
                                        "ordenDelDia" -> {
                                            title.value = "orden"
                                            navigationController.navigate(Routes.PantallaOrdenDelDia.route)
                                        }
                                        "cronometro" -> {
                                            title.value = "cronometro"
                                            navigationController.navigate(Routes.PantallaCronometro.route)
                                        }
                                        "propuestas" -> {
                                            title.value = "propuestas"
                                            navigationController.navigate(Routes.PantallaPropuestas.route)
                                        }
                                    }
                                }
                            }

                        )
                    }
                ) {
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.PantallaInicio.route
                    ){
                        composable(Routes.PantallaInicio.route) { PantallaInicio() }
                        composable(Routes.PantallaIngresarUsuario.route) { PantallaIngresarUsuario() }
                        composable(Routes.PantallaCrearVotacion.route) { PantallaCrearVotacion() }
                        composable(Routes.PantallaCargarPropietarios.route) { PantallaCargarPropietarios() }
                        composable(Routes.PantallaCronometro.route) { PantallaCronometro() }
                        composable(Routes.PantallaOrdenDelDia.route) { PantallaOrdenDelDia() }
                        composable(Routes.PantallaPropuestas.route) { PantallaPropuestas() }
                    }
                }
            }
        }
    }
}
