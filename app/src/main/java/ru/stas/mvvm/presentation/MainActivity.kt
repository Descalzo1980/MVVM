package ru.stas.mvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.stas.mvvm.databinding.ActivityMainBinding
import ru.stas.mvvm.domain.model.SaveUserNameParam
import ru.stas.mvvm.domain.usecase.GetUserNameUseCase
import ru.stas.mvvm.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveData.setOnClickListener {
            val text = binding.etPutData.text.toString()
            val param = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = param)
            binding.tvData.text = "Save data = $result"
        }

        binding.btnGetData.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            binding.tvData.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}