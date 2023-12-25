package databases.classes

import kotlinx.serialization.Serializable

@Serializable
data class Events (
    val id: Int,
    val start_time: String,
    val end_time: String,
    val subject_name: String,
    val location: String,
    val instructors: String,
    val event_type: String,
    val subject_name_short: String
)