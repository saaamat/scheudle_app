package databases.requests

import com.example.dashboard.R
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import databases.classes.Names
import io.ktor.client.statement.request

suspend fun GetClient(): HttpClient {
    val client = HttpClient(CIO)
    {
        install(JsonFeature)
        {
            serializer = KotlinxSerializer()
        }
    }
    return client
}

suspend fun GetAllNames(): List<Names> {
    val client = HttpClient(CIO)
    {
        install(JsonFeature)
        {
            serializer = KotlinxSerializer()
        }
    }
    val names: List<Names> = client.get("https://4ccf-90-151-85-183.ngrok-free.app/names")
    return names
}
suspend fun main () {
    GetAllNames()
}