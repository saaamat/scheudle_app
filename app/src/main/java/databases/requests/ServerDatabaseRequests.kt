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
suspend fun PostName(client : HttpClient) {
    val name: List<Names> = client.get("http://192.168.50.171:8000/names/")
    println(name[0].name)
    val response: HttpResponse = client.post("http://192.168.50.171:8000/names/") {
        contentType(ContentType.Application.Json)
        body = Names(id = null, name = "Опять тест")
    }
    println(response.status)
}

suspend fun main () {
    PostName(GetClient())
}