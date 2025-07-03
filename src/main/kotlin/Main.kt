import contextops.core.embedding.openai.OpenAIEmbeddingService
import contextops.core.search.dummy.DummySearchService

fun main() {
    val apiKey = System.getenv("OPENAI_API_KEY") ?: error("OPENAI_API_KEY not found")

    val openAi = OpenAIEmbeddingService(apiKey = apiKey)
    val dummySearch = DummySearchService()

    val vector = openAi.embed("ContextOps is the new Code.")
    println("📦 임베딩 결과: ${vector.take(5)}...")

    val searchResults = dummySearch.search(vector, topK = 3)
    println("🔍 검색 결과: $searchResults")
}