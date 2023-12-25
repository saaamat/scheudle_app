package databases.classes

import kotlinx.serialization.Serializable

@Serializable
data class Names (
    val id: Int?,
    val name: String
)