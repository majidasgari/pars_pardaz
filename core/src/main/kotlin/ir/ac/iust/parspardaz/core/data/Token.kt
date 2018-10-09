package ir.ac.iust.parspardaz.core.data

data class Token(
        var content: String,
        var pos: String? = null,
        var tags: MutableMap<String, Any> = mutableMapOf()
) {
    override fun toString(): String {
        return if (pos != null && tags.isNotEmpty())
            "$content ($pos, $tags)"
        else if (pos == null && tags.isNotEmpty())
            "$content ($tags)"
        else if (pos != null && tags.isEmpty())
            "$content ($pos)"
        else content
    }
}