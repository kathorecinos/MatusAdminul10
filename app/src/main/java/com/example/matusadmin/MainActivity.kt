package com.example.matusadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonSave.setOnClickListener{
            
        }



        saveFireStore()


        private fun saveFireStore(
            VIN: String,
            Importadora: String,
            Correo: String,
            Telefono: String
        ) {
            val db = FirebaseFirestore.getInstance()
            val user: MutableMap<String, Any> = HashMap()
            user["Nombre"] = Nombre
            user["Importadora"] = Importadora
            user["Correo"] = Correo
            user["Telefono"] = Telefono

            db.collection("users")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(this@userData, "record added succesfully", Toast.LENGTH_LONG)
                        .show()
                    var intent = Intent(this, dataSendActivity::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener {
                    Toast.makeText(this@userData, "record failed", Toast.LENGTH_LONG).show()
                }
        }

        }


    }
