package su.isd.clencode.domain.usecase

import su.isd.clencode.domain.models.UserName
import su.isd.clencode.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}