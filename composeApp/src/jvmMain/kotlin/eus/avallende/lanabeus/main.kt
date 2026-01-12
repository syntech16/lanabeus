package eus.avallende.lanabeus

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import eus.avallende.lanabeus.ui.screens.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "LanabEUS",
    ) {
        App()
    }
}