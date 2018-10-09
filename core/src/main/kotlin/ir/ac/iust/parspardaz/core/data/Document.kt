package ir.ac.iust.parspardaz.core.data

data class Document(
        var originalText: String,
        var title: String? = null,
        var tokenized: Boolean = false,
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

    override fun toString(): String {
        return if (title != null)
            "<document title=$title>\n${sections.joinToString("\n")}i\n</document>"
        else
            "<document>\n${sections.joinToString("\n")}\n</document>"
    }

}