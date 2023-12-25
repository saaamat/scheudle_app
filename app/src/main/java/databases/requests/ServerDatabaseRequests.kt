package databases.requests

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get

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

suspend fun GetAllNames(): String {
    val client = GetClient()
    return client.get<String>("http://46.29.236.247:8000/names")
}
suspend fun GetWeather(): String {
    val client = GetClient()
    return client.get<String>("http://46.29.236.247:8000/weather")
}

