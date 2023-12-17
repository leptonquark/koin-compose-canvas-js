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
import org.jetbrains.skiko.wasm.onWasmReady
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(ExperimentalComposeUiApi::class)
class QuoteScreen: KoinComponent {
    private val quoteViewModel: QuoteViewModel by inject()

    fun initialize() {
        onWasmReady {
            CanvasBasedWindow {
                val state by quoteViewModel.state.collectAsState()
                    QuoteScreen(state.quote)
            }
        }
    }
}

@Composable
fun QuoteScreen(quote: String){
    Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
        Text(quote, style = MaterialTheme.typography.headlineLarge)
    }
}