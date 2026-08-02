package project.handson1.network

import project.handson1.model.ChatRequest
import project.handson1.model.ChatResponse
import project.handson1.utils.Constants.END_POINT
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(END_POINT)
    suspend fun getAIResponse(
        @Body request: ChatRequest
    ): ChatResponse

}