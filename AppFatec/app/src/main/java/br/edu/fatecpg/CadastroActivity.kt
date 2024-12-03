package br.edu.fatecpg

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.databinding.ActivityCadastroBinding
import br.edu.fatecpg.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class CadastroActivity : AppCompatActivity() {
    private lateinit var Binding: ActivityCadastroBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        auth = Firebase.auth
        Binding.btnCriar.setOnClickListener{
            val cademail = Binding.Email.text.toString()
            val cadpass = Binding.Pass.text.toString()
            auth.createUserWithEmailAndPassword(cademail, cadpass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Conta Criada", Toast.LENGTH_SHORT).show();
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent);
                        finish()
                    }
                    else {
                        Toast.makeText(this, "Falha ao criar conta", Toast.LENGTH_SHORT).show()
                    }

                    }

        }
    }
}

