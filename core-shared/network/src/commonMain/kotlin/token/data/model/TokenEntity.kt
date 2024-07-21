package token.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenEntity(
    @SerialName("token") val accessToken: String? = null,
    @SerialName("refreshToken") val refreshToken: String? = null,
)