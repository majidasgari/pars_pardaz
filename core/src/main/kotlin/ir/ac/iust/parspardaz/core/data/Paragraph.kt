package ir.ac.iust.parspardaz.core.data

data class Paragraph(
        var originalText: String,
        var tokenized: Boolean = false,
        var sentences: MutableList<Sentence> = mutableListOf()
) {
    fun forEach(action: (Sentence) -> kotlin.Unit) = sentences.forEach(action)

    fun forEachIndexed(action: (index: Int, Sentence) -> Unit) = sentences.forEachIndexed(action)

    fun forEachTokens(action: (Token) -> kotlin.Unit) = sentences.forEach {
        it.forEach(action)
    }

    override fun toString(): String {
        return "Paragraph\n\t${sentences.joinToString("\n\t")}"
    }


}