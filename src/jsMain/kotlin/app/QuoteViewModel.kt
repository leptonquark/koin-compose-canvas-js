package app

import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.annotation.Single

data class QuoteState(val quote: String)

private const val RESUME_URL = "/resume.pdf"

@Single
class QuoteViewModel () {
    val state = MutableStateFlow(QuoteState("There once was a ship that was lost at sea."))
}



