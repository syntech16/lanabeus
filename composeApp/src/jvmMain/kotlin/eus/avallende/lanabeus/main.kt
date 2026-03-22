package eus.avallende.lanabeus

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import eus.avallende.lanabeus.ui.screens.App
import lanabeus.composeapp.generated.resources.Res
import lanabeus.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = stringResource(Res.string.app_name),
    ) {
        App()
    }
}