package app

import app.di.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.annotation.Single

data class QuoteState(val quote: String)

private const val RESUME_URL = "/resume.pdf"

@Single
class QuoteViewModel(val quoteRepository: QuoteRepository) {
    val state = MutableStateFlow(QuoteState(quoteRepository.quotes.random()))
}



