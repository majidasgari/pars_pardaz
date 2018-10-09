package ir.ac.iust.parspardaz.core.process

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.process.DocumentPreprocessor
import ir.ac.iust.parspardaz.core.data.Paragraph
import ir.ac.iust.parspardaz.core.data.Sentence
import ir.ac.iust.parspardaz.core.data.Token
import java.io.StringReader

object SentenceTokenizer {

    private val abbreviations = mutableSetOf("الف", "ا", "ب", "پ",
            "ت", "ث", "ج", "جیم", "چ", "ح", "حا", "خ", "د", "دال", "ذ", "ذال",
            "ر", "ز", "ژ", "س", "سین", "ش", "شین", "ص", "صاد", "ض", "ضاد",
            "ط", "طا", "ظ", "ظا", "ع", "عین", "ف", "ق", "قاف", "ک", "کاف", "گ", "گاف",
            "ل", "لام", "م", "میم", "ن", "نون", "و", "واو", "ه", "ی",
            "A", "a", "ای", "B", "b", "بی", "C", "c", "سی", "D", "d", "دی",
            "E", "e", /*"ای",*/ "F", "f", "اف", "G", "g", "جی", "H", "h", "اچ", "ایچ",
            "I", "i", "آی", "J", "j", "جی", "K", "k", "کی", "L", "l", "ال",
            "M", "m", "ام", "N", "n", "ان", "O", "o", "اُ", "P", "p", "پی", "Q", "q", "کیو",
            "R", "r", "آر", "S", "s", "اس", "T", "t", "تی", "W", "w", "دبلیو", "دابلیو",
            "X", "x", "ایکس", "اکس", "Y", "y", "وای", "ایگرگ", "Z", "z", "زی", "زد")

    fun split(paragraph: String): Paragraph {
        val dp = DocumentPreprocessor(StringReader(paragraph))
        val p = Paragraph(paragraph)
        val sentences = mutableListOf<List<HasWord>>()
        for (sentence in dp) {
            println("sentence: $sentence")
            val lastSentence = if (sentences.isNotEmpty()) sentences.last() as MutableList<HasWord> else null
            if (lastSentence != null && lastSentence.size >= 2 &&
                    lastSentence.last().word() == "." &&
                    abbreviations.contains(lastSentence[lastSentence.size - 2].word())) {
                sentence.forEach { lastSentence.add(it) }
                sentences[sentences.size - 1] = lastSentence
            } else sentences.add(sentence)
        }
        for (sentence in sentences) {
            val s = Sentence(sentence.joinToString(" ", transform = { it.word() }))
            for (token in sentence)
                s.tokens.add(Token(token.word()))
            p.sentences.add(s)
            s.tokenized = true
        }
        p.tokenized = true
        return p
    }
}