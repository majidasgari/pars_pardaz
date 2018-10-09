package ir.ac.iust.parspardaz.core.process

import edu.stanford.nlp.process.PTBTokenizer
import ir.ac.iust.parspardaz.core.data.Sentence
import ir.ac.iust.parspardaz.core.data.Token
import java.io.StringReader

object WordTokenizer {

    fun split(sentence: String): Sentence {
        val s = Sentence(sentence)
        val tokenizer = PTBTokenizer.newPTBTokenizer(StringReader(sentence))
        tokenizer.forEach {
            s.tokens.add(Token(it.word()))
        }
        s.tokenized = true
        return s
    }
}