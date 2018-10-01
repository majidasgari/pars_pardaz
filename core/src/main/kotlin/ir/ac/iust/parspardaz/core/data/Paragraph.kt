package ir.ac.iust.parspardaz.core.data

data class Paragraph(
        var originalText: String,
        var sentences: MutableList<Sentence> = mutableListOf()
) {
    fun forEach(action: (Sentence) -> kotlin.Unit) = sentences.forEach(action)

    fun forEachTokens(action: (Token) -> kotlin.Unit) = sentences.forEach {
        it.forEach(action)
    }
}