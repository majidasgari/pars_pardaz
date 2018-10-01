package ir.ac.iust.parspardaz.core.data

data class Document(
        var originalText: String,
        var sections: MutableList<Section> = mutableListOf()
) {
    fun forEach(action: (Section) -> kotlin.Unit) = sections.forEach(action)

    fun forEachParagraphs(action: (Paragraph) -> kotlin.Unit) = sections.forEach {
        it.forEach(action)
    }

    fun forEachSentences(action: (Sentence) -> kotlin.Unit) = sections.forEach {
        it.forEachSentences(action)
    }

    fun forEachTokens(action: (Token) -> kotlin.Unit) = sections.forEach {
        it.forEachTokens(action)
    }
}