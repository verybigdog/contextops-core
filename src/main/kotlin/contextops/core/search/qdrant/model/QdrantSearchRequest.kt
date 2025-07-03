package contextops.core.search.qdrant.model

import kotlinx.serialization.Serializable

@Serializable
data class QdrantSearchRequest(
    val vector: List<Float>,
    val top: Int,
    val withPayload: Boolean = true
)