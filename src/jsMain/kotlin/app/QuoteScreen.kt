package app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow
import app.di.ClientModule
import org.jetbrains.skiko.wasm.onWasmReady
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.ksp.generated.module

@OptIn(ExperimentalComposeUiApi::class)
class QuoteScreen {

    fun initialize() {
        onWasmReady {
            CanvasBasedWindow {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    KoinApplication(moduleList = { listOf(ClientModule().module) }) {
        Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
            QuoteScreen()
        }
    }
}

@Composable
fun QuoteScreen(viewModel: QuoteViewModel = koinInject()) {
    val state by viewModel.state.collectAsState()
    Text(state.quote, style = MaterialTheme.typography.headlineLarge)
}