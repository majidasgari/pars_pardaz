package ir.ac.iust.parspardaz.core.repository

import ir.ac.iust.parspardaz.core.data.Document
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

@Suppress("unused")
interface Repository {

    fun load(base: String) = load(Paths.get(base))
    fun load(base: File) = load(base.toPath())
    fun load(base: Path)

    /**
     * first number is document number, second is number of all documents.
     * third one is the document. if there is no document, it returns 0, 0, null.
     */
    fun next(action: (Int, Int, Document?) -> kotlin.Unit)

//    fun hasNext(): Boolean
//    fun next(): Document?
//    fun size(): Int
}