package com.softgus.grepe

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.softgus.grepe.databinding.ActivityMainBinding
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun pointerRegister(view: View) {
        val date = LocalDateTime.now()
        queryPerson(binding.editTextMatriculaCPF.text.toString())
        binding.editTextMatriculaCPF.setText("")
        binding.textViewData.setText("${date.dayOfMonth}/${date.monthValue}/${date.year}")
        binding.textViewHora.setText(LocalDateTime.now().toLocalTime().toString().subSequence(0,8))
        Toast.makeText(applicationContext,"Presença registrada com sucesso!",Toast.LENGTH_SHORT).show()
    }

    private fun queryPerson (key: String) {
        if(key == "123") {
            binding.textViewNomeServidor.setText("Alexsandro de Lima Costa")
            binding.textViewSetor.setText("CGPA | CTI")
            binding.textViewFuncao.setText("Supervisor")
        } else {
            binding.textViewNomeServidor.setText("Guilherme Lacerda de Lima Costa")
            binding.textViewSetor.setText("CGPA | CTI")
            binding.textViewFuncao.setText("Aprendiz")
        }
    }

    fun resetInfo(view: View) {
        binding.textViewNomeServidor.setText("Nome")
        binding.textViewSetor.setText("Setor")
        binding.textViewFuncao.setText("Função")
        binding.textViewData.setText("Data")
        binding.textViewHora.setText("Hora")
    }
}