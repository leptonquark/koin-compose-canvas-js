package app

import org.koin.core.context.startKoin


fun main() {
    startKoin { printLogger() }
    QuoteScreen().initialize()
}