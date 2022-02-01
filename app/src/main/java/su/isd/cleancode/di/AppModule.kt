package su.isd.cleancode.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import su.isd.cleancode.presentation.MainViewModel

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUserCase = get()
        )
    }
}