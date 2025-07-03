package contextops.core.search.qdrant.model

import kotlinx.serialization.Serializable

@Serializable
data class QdrantSearchResponse(
    val result: List<QdrantPoint>
)
