package contextops.core.search.qdrant

import contextops.core.model.SearchResult
import contextops.core.search.qdrant.model.QdrantSearchRequest
import contextops.core.search.qdrant.model.QdrantSearchResponse
import contextops.core.service.VectorSearchService
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class QdrantSearchService(
    private val baseUrl: String,
    private val collectionName: String,
    private val client: HttpClient = defaultClient
) : VectorSearchService<SearchResult> {

    override fun search(query: List<Float>, topK: Int): List<SearchResult> = runBlocking {
        val response: QdrantSearchResponse = client.post("$baseUrl/collections/$collectionName/points/search") {
            contentType(ContentType.Application.Json)
            setBody(
                QdrantSearchRequest(
                    vector = query,
                    top = topK,
                    withPayload = true
                )
            )
        }.body()

        response.result.map {
            SearchResult(id = it.id, score = it.score, payload = it.payload)
        }
    }

    companion object {
        val defaultClient = HttpClient {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
}
