package databases.classes

import kotlinx.serialization.Serializable

@Serializable
data class Descriptions (
    val id: Int?,
    val name: Int,
    val description: String,
    val index: Int
)
