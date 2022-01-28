package su.isd.clencode.domain.usecase

import su.isd.clencode.domain.models.SaveUserNameParam
import su.isd.clencode.domain.repository.UserRepository


class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()
        if (oldUserName.firstname == param.name){
            return true
        }
        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}