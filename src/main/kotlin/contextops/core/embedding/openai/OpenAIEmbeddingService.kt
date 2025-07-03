package contextops.core.embedding.openai

import contextops.core.service.EmbeddingService
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.coroutines.runBlocking

class OpenAIEmbeddingService(
    private val apiKey: String,
    private val model: String = "text-embedding-3-small"
) : EmbeddingService {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    override fun embed(text: String): List<Float> = runBlocking {
        val response = client.post("https://api.openai.com/v1/embeddings") {
            headers {
                append("Authorization", "Bearer $apiKey")
            }
            setBody(OpenAIRequest(model, text))
        }.body<OpenAIResponse>()

        response.data.first().embedding
    }

    override fun embedAll(texts: List<String>): List<List<Float>> {
        return texts.map { embed(it) }
    }
}

@Serializable
data class OpenAIRequest(
    val model: String,
    val input: String
)

@Serializable
data class OpenAIResponse(
    val data: List<EmbeddingData>
)

@Serializable
data class EmbeddingData(
    val embedding: List<Float>,
    @SerialName("index") val index: Int
)
