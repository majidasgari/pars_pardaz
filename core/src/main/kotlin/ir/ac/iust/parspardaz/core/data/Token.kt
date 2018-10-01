package ir.ac.iust.parspardaz.core.data

data class Token(
        var content: String,
        var pos: String,
        var tags: MutableMap<String, Any>
)