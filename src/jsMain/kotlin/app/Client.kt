package app

import app.di.ClientModule
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module


fun main() {
    startKoin {
        printLogger()
        modules(ClientModule().module)
    }
    QuoteScreen().initialize()
}