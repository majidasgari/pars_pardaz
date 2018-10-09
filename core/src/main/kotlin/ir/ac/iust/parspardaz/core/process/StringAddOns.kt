package ir.ac.iust.parspardaz.core.process

import ir.ac.iust.parspardaz.core.data.Document
import ir.ac.iust.parspardaz.core.data.Paragraph
import ir.ac.iust.parspardaz.core.data.Section
import ir.ac.iust.parspardaz.core.data.Sentence

fun String.toSentence() = WordTokenizer.split(this)

fun String.toParagraph() = SentenceTokenizer.split(this)

fun String.toParagraphs(): MutableList<Paragraph> {
    val splits = this.split("\n")
    val result = mutableListOf<Paragraph>()
    splits.forEach { if (it.isNotBlank()) result.add(it.toParagraph()) }
    return result
}

fun String.toSection(): Section {
    val sec = Section(this)
    val paragraphs = this.toParagraphs()
    if (this.startsWith("* ")) {
        val fs = paragraphs.first().sentences.first()
        sec.title = Sentence(fs.originalText)
        fs.forEachIndexed { index, token -> if (index > 0) sec.title!!.tokens.add(token) }
        sec.title!!.tokenized = true
        for ((index, p) in paragraphs.withIndex()) if (index > 0) sec.paragraphs.add(p)
    } else {
        for (p in paragraphs) sec.paragraphs.add(p)
    }
    sec.tokenized = true
    return sec
}

fun String.toSections(): MutableList<Section> {
    val splits = this.split("\n* ")
    val result = mutableListOf<Section>()
    for ((index, s) in splits.withIndex()) {
        result.add((if (index > 0) "* $s" else s).toSection())
    }
    return result
}

fun String.toDocument(): Document {
    val document = Document(this)
    val sections = this.toSections()
    for (s in sections) document.sections.add(s)
    document.tokenized = true
    return document
}