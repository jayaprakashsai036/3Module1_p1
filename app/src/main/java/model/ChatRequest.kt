package project.handson1.model

data class ChatRequest(
    val contents: List<Content>
) {
    constructor(prompt: String) : this(listOf(Content(listOf(Part(prompt)))))
}

data class Content(
    val parts: List<Part>
)

data class Part(
    val text: String
)
