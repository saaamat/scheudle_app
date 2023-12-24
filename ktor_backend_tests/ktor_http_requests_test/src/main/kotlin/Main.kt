import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.Serializable

suspend fun main() {
    val client = HttpClient(CIO)
    {
        install(JsonFeature)
        {
            serializer = KotlinxSerializer()
        }
    }
    val name: List<Names> = client.get("http://172.30.75.117:8000/names/")
    println(name)
    val response: HttpResponse = client.post("http://172.30.75.117:8000/names/") {
        contentType(ContentType.Application.Json)
        body = Names(id = null, name = "Тест новый")
    }
    println(response)
}

@Serializable
data class Descriptions (val id: Int?, val description: String, val index: Int)

@Serializable
data class Events (val id: Int, val start_time: String, val end_time: String, val subject_name: String, val location: String, val instructors: String, val event_type: String, val subject_name_short: String)

@Serializable
data class Names (val id: Int?, val name: String)

@Serializable
data class Profiles (val id: Int?, val name: String, val index: Int)

@Serializable
data class ProfilesEvents (val id: Int, val profile: Int, val event: Int)