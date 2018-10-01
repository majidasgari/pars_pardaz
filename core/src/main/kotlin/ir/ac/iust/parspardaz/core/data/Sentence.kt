package ir.ac.iust.parspardaz.core.data

data class Sentence(
        var originalText: String,
        val tokens: MutableList<Token> = mutableListOf()
) {
    fun forEach(action: (Token) -> kotlin.Unit) = tokens.forEach(action)
}