package su.isd.cleancode.data.repository

import su.isd.cleancode.data.storage.models.User
import su.isd.cleancode.data.storage.UserStorage
import su.isd.clencode.domain.models.SaveUserNameParam
import su.isd.clencode.domain.models.UserName
import su.isd.clencode.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)

        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstname = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

}