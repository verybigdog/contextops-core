package contextops.core.model

import kotlinx.serialization.json.JsonElement


data class SearchResult(
    val id: String,
    val score: Float,
    val payload: Map<String, JsonElement>? = null
)