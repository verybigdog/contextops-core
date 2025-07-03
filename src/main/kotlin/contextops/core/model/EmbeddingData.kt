package contextops.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmbeddingData(
    val embedding: List<Float>,
    @SerialName("index") val index: Int
)
