package databases.classes

import kotlinx.serialization.Serializable

@Serializable
data class Profiles (
    val id: Int?,
    val name: String,
    val index: Int
)