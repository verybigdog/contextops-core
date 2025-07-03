package contextops.core.search.qdrant.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class QdrantPoint(
    val id: String,
    val score: Float,
    val payload: Map<String, JsonElement>? = null
)