import ir.ac.iust.parspardaz.core.process.toDocument
import ir.ac.iust.parspardaz.core.process.toParagraph
import org.junit.Test

open class SentenceTokenizerTest {

    @Test
    fun parse() {
        val p = "من م.ا.سایه هستم. دقیقا مثل تو. من اچ. جی. ولز (زاده ۱۹۲۰، درگذشت ۱۹۴۰) هستم.".toParagraph()
        assert(p.tokenized)
        assert(p.sentences.size == 3)
        println(p)

        val d = "* دلایل افول و پیشرفت سرخابی‌ها\n این روزها همه به مدرسان می‌روند. شما چطور؟\nنه من نمی‌روم.\n\n* تست\nتست میکنم.".toDocument()
        assert(d.tokenized)
        assert(d.sections.size == 2)
        assert(d.sections.first().tokenized)
        assert(d.sections.first().title != null)
        assert(d.sections.first().paragraphs.size == 2)
        println(d)
    }
}