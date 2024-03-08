import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.viewmodel.ViewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi

@Composable
fun App() {
    PreComposeApp {

        val colors = getColorsTheme()
        AppTheme {
            Column(modifier = Modifier.fillMaxSize()) {
                Text("Bienvenidos")
                Text("Curso Kotlin Multiplataforma con Compose")
                Text("Curso Kotlin Multiplataforma con Compose")
                Text("Curso Kotlin Multiplataforma con Compose")
            }
        }
    }
}