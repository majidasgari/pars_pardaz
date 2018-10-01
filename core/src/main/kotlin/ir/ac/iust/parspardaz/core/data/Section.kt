package ir.ac.iust.parspardaz.core.data

data class Section(
        var title: String? = null,
        var originalText: String,
        var paragraphs: MutableList<Paragraph> = mutableListOf()
) {
    fun forEach(action: (Paragraph) -> kotlin.Unit) = paragraphs.forEach(action)

    fun forEachSentences(action: (Sentence) -> kotlin.Unit) = paragraphs.forEach {
        it.forEach(action)
    }

    fun forEachTokens(action: (Token) -> kotlin.Unit) = paragraphs.forEach {
        it.forEachTokens(action)
    }
}