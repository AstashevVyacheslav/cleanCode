package su.isd.clencode.domain.repository

import su.isd.clencode.domain.models.SaveUserNameParam
import su.isd.clencode.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}