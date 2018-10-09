package ir.ac.iust.parspardaz.core.data

data class Section(
        var originalText: String,
        var title: Sentence? = null,
        var tokenized: Boolean = false,
        var paragraphs: MutableList<Paragraph> = mutableListOf()
) {
    fun forEach(action: (Paragraph) -> kotlin.Unit) = paragraphs.forEach(action)

    fun forEachIndexed(action: (index: Int, Paragraph) -> Unit) = paragraphs.forEachIndexed(action)

    fun forEachSentences(action: (Sentence) -> kotlin.Unit) = paragraphs.forEach {
        it.forEach(action)
    }

    fun forEachTokens(action: (Token) -> kotlin.Unit) = paragraphs.forEach {
        it.forEachTokens(action)
    }

    override fun toString(): String {
        return if (title != null)
            "<section title=$title>\n${paragraphs.joinToString("\n")}\n</section>"
        else "<section>\n${paragraphs.joinToString("\n")}\n</section>"
    }


}