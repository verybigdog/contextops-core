package contextops.core.embedding.model

import contextops.core.model.EmbeddingData
import kotlinx.serialization.Serializable

@Serializable
data class OpenAIResponse(
    val data: List<EmbeddingData>
)