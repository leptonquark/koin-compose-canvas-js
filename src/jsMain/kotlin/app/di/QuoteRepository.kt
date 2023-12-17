package app.di

import org.koin.core.annotation.Single

@Single
class QuoteRepository {

    val quotes = listOf(
        "The only way to do great work is to love what you do. - Steve Jobs",
        "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
        "Your time is limited, don't waste it living someone else's life. - Steve Jobs",
        "Believe you can and you're halfway there. - Theodore Roosevelt",
        "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt",
        "Strive not to be a success, but rather to be of value. - Albert Einstein",
        "The only limit to our realization of tomorrow will be our doubts of today. - Franklin D. Roosevelt",
        "It does not matter how slowly you go as long as you do not stop. - Confucius",
        "The best way to predict the future is to invent it. - Alan Kay",
        "Success is walking from failure to failure with no loss of enthusiasm. - Winston Churchill",
        "The way to get started is to quit talking and begin doing. - Walt Disney",
        "Don't watch the clock; do what it does. Keep going. - Sam Levenson",
        "The future depends on what you do today. - Mahatma Gandhi",
        "You are never too old to set another goal or to dream a new dream. - C.S. Lewis",
        "The only person you are destined to become is the person you decide to be. - Ralph Waldo Emerson",
        "Everything you've ever wanted is on the other side of fear. - George Addair",
        "The mind is everything. What you think you become. - Buddha",
        "Do not wait to strike till the iron is hot, but make it hot by striking. - William Butler Yeats",
        "The only limit to our realization of tomorrow will be our doubts of today. - Franklin D. Roosevelt",
        "It always seems impossible until it is done. - Nelson Mandela",
        "Success consists of going from failure to failure without loss of enthusiasm. - Winston Churchill",
        "You miss 100% of the shots you don't take. - Wayne Gretzky",
        "Happiness is not something ready made. It comes from your own actions. - Dalai Lama",
        "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle. - Christian D. Larson",
        "In the middle of difficulty lies opportunity. - Albert Einstein",
        "It's not whether you get knocked down, it's whether you get up. - Vince Lombardi",
        "The only impossible journey is the one you never begin. - Tony Robbins",
        "The future belongs to those who prepare for it today. - Malcolm X",
        "A person who never made a mistake never tried anything new. - Albert Einstein",
        "The secret of getting ahead is getting started. - Mark Twain"
    )
}