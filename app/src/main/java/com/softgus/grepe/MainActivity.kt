package com.softgus.grepe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.softgus.grepe.config.MySQLConnector
import com.softgus.grepe.databinding.ActivityMainBinding
import java.time.LocalDateTime
import com.softgus.grepe.dao.Person

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun pointRegister(view: View) {
        val date = LocalDateTime.now()
        queryPerson(binding.editTextMatriculaCPF.text.toString())
        binding.editTextMatriculaCPF.setText("")
        binding.textViewData.setText("${date.dayOfMonth}/${date.monthValue}/${date.year}")
        binding.textViewHora.setText(LocalDateTime.now().toLocalTime().toString().subSequence(0,8))
        Toast.makeText(applicationContext,"Presença registrada com sucesso!",Toast.LENGTH_SHORT).show()
    }

    private fun queryPerson (key: String) {
        if(key == "123") {
            binding.textViewNomeServidor.setText("Alex Lima")
            binding.textViewSetor.setText("CGPA | CTI")
            binding.textViewFuncao.setText("Supervisor")
        } else {
            val person = Person("456", "qwer")
            println("Usuários: ${person.getUsers()}")
            println("Estamos na MainActivity")
            /*val temp = ArrayList(person?.queryPerson("3025136"))
            if(!temp.isEmpty()) {
                println(temp.get(1).toString());
                println(temp.get(2).toString());
                println(temp.get(3).toString().substring(temp.get(3).toString().indexOf('/') + 2));
            }*/
            //val users = Person().getUsers()
            /*for (user in users) {
                //println("USUÁRIO", "${user}")
                Log.d("USUÁRIO", "${user}")
            }*/
            binding.textViewNomeServidor.setText("Fulano de tal")
            binding.textViewSetor.setText("CGPA | CTI")
            binding.textViewFuncao.setText("Técnico em TI")
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
