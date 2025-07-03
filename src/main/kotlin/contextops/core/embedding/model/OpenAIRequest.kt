package contextops.core.embedding.model

import kotlinx.serialization.Serializable

@Serializable
data class OpenAIRequest(
    val model: String,
    val input: String
)
