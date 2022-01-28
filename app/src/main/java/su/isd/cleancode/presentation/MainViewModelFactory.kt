package su.isd.cleancode.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import su.isd.cleancode.data.repository.UserRepositoryImpl
import su.isd.cleancode.data.storage.sharedrefs.SharedPrefUserStorage
import su.isd.clencode.domain.usecase.GetUserNameUseCase
import su.isd.clencode.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE)
    { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context)) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUserCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUserCase = saveUserNameUserCase
        ) as T
    }
}