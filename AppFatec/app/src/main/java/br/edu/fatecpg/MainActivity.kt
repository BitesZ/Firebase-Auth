package br.edu.fatecpg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.btnLogar.setOnClickListener{

            val email = binding.edtEmail.text.toString()
            val pass = binding.edtPass.text.toString()

            auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Logado", Toast.LENGTH_SHORT).show();
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent);
                        finish()
                    } else {
                        Toast.makeText(this, "Falha ao logar", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        binding.viewBottom.setOnClickListener{
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent);
            finish()
        }
    }}
