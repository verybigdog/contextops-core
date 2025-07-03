package contextops.core.service

interface EmbeddingService {
    fun embed(text: String): List<Float>
}