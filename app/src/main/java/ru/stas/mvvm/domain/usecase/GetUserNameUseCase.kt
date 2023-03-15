package ru.stas.mvvm.domain.usecase

import ru.stas.mvvm.domain.model.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Boo", lastName = "Hello")
    }
}