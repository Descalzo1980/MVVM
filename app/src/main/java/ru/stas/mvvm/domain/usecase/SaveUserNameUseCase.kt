package ru.stas.mvvm.domain.usecase

import ru.stas.mvvm.domain.model.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean{
        if(param.name.isEmpty()){
            return false
        }else{
            return true
        }
    }
}