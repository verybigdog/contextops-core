import contextops.core.embedding.openai.OpenAIEmbeddingService
import contextops.core.search.dummy.DummySearchService
import io.github.cdimascio.dotenv.dotenv

fun main() {
    val dotenv = dotenv()
    val apiKey = dotenv["OPENAI_API_KEY"] ?: error("API key not found!")
    val openAi = OpenAIEmbeddingService(apiKey = apiKey)
    val dummySearch = DummySearchService()

    val vector = openAi.embed("ContextOps is the new Code.")
    println("📦 임베딩 결과: ${vector.take(5)}...")

    val searchResults = dummySearch.search(vector, topK = 3)
    println("🔍 검색 결과: $searchResults")
}