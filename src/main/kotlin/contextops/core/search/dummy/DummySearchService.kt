package contextops.core.search.dummy

import contextops.core.search.VectorSearchService

class DummySearchService : VectorSearchService<String> {
    override fun search(query: List<Float>, topK: Int): List<String> {
        return List(topK) { index -> "dummy-result-$index" }
    }
}
