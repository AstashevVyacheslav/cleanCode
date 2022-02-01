package su.isd.cleancode.di

import org.koin.dsl.module
import su.isd.clencode.domain.usecase.GetUserNameUseCase
import su.isd.clencode.domain.usecase.SaveUserNameUseCase


val domainModule = module {

    factory<GetUserNameUseCase> {

        GetUserNameUseCase(userRepository = get())

    }

    factory<SaveUserNameUseCase> {

        SaveUserNameUseCase(userRepository = get())

    }

}