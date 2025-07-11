package contextops.core.service

interface EmbeddingService {
    fun embed(text: String): List<Float>
    fun embedAll(texts: List<String>): List<List<Float>>
}
