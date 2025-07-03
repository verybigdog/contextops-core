package contextops.core.model

data class SearchResult(
    val id: String,
    val score: Double,
    val metadata: Map<String, Any>? = null
)
