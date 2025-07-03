package contextops.core.service

interface VectorSearchService<T> {
    fun search(query: List<Float>, topK: Int): List<T>
}