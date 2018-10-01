package ir.ac.iust.parspardaz.core.repository

import ir.ac.iust.parspardaz.core.data.Document
import ir.ac.iust.parspardaz.core.utils.PathWalker
import java.nio.charset.Charset
import java.nio.file.Path

@Suppress("unused")
class SimpleTextRepository(
        private val charset: Charset = Charsets.UTF_8,
        private val pattern: Regex? = null,
        private val maxDepth: Int? = null
) : Repository {

    private lateinit var paths: List<Path>

    override fun load(base: Path) {
        this.paths = PathWalker.getPath(base, pattern, maxDepth)
    }

    override fun next(action: (Int, Int, Document?) -> Unit) {
        paths.forEachIndexed { index, path ->
            val document = Document(path.toFile().readText(charset))
            action(index, paths.size, document)
        }
    }
}