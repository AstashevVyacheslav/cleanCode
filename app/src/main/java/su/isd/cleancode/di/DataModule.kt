package su.isd.cleancode.di

import org.koin.dsl.module
import su.isd.cleancode.data.repository.UserRepositoryImpl
import su.isd.cleancode.data.storage.UserStorage
import su.isd.cleancode.data.storage.sharedrefs.SharedPrefUserStorage
import su.isd.clencode.domain.repository.UserRepository


val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}