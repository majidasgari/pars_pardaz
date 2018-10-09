package ir.ac.iust.parspardaz.core.data

data class Sentence(
        var originalText: String,
        var tokenized: Boolean = false,
        val tokens: MutableList<Token> = mutableListOf()
) {
    fun forEach(action: (Token) -> kotlin.Unit) = tokens.forEach(action)

    fun forEachIndexed(action: (index: Int, Token) -> Unit) = tokens.forEachIndexed(action)

    override fun toString(): String {
        return "Sentence(tokens=$tokens)"
    }


}