package su.isd.cleancode.data.storage

import su.isd.cleancode.data.storage.models.User


interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}