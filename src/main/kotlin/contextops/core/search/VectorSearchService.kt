package contextops.core.search

interface VectorSearchService<T> {
    fun search(query: List<Float>, topK: Int): List<T>
}