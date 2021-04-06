package com.example.matusadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import com.google.firebase.firestore.FirebaseFirestore
lateinit var option : Spinner


class nameUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_user)
        option = findViewById(R.id.sp_options) as Spinner

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                TODO("Not yet implemented")
            }

        }

        val db = FirebaseFirestore.getInstance()
        db.collection("users")
                .get()
                .addOnCompleteListener {
                    val result: StringBuffer = StringBuffer()
                    if (it.isSuccessful){
                        for (document in it.result!!) {
                            result.append(document.data.getValue("users")).append("\n\n")
                        }


                    }
                }





    }
}