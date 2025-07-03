## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

# contextops-core
A modular memory and context engine for modern AI — because context is the new code.


# 🧠 ContextOps Core

> Context is the new Code.

**ContextOps Core** is the memory engine behind modern intelligent systems.

This library provides essential building blocks for:
- Document chunking
- Embedding services
- Vector search integration
- Lightweight memory storage

Designed for flexibility, extensibility, and context-awareness.

---

## 📦 Modules

- `core/` — pure Kotlin, no framework dependency
- `spring-support/` — Spring Boot adapter for DI
- `demo-app/` — Quick start REST API example

## 🛠️ Features

- OpenAI & HuggingFace embedding service
- Pluggable chunking strategies
- Qdrant vector search adapter (others pluggable)
- Interface-first architecture

## 🚀 Getting Started

```kotlin
val service = OpenAIEmbeddingService(apiKey)
val vector = service.embed("ContextOps is the new Code.")
```
## 🙌 Maintainers

Created with 💙 by [@verybigdog](https://github.com/verybigdog) and friends of Mentat & Questy.
