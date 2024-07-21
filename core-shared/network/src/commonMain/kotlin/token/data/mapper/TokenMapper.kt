package token.data.mapper

import token.data.model.Token
import token.data.model.TokenEntity

internal fun TokenEntity.toDomain(): Token = Token(
    accessToken = this.accessToken.orEmpty(),
    refreshToken = this.refreshToken.orEmpty(),
)

internal fun Token.toData(): TokenEntity = TokenEntity(
    accessToken = this.accessToken,
    refreshToken = this.refreshToken,
)