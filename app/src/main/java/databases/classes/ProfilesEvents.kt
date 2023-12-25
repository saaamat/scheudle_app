package databases.classes

import kotlinx.serialization.Serializable

@Serializable
data class ProfilesEvents (
    val id: Int,
    val profile: Int,
    val event: Int
)
