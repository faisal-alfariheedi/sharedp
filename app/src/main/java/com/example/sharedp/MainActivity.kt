package com.example.sharedp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var inin1: EditText
    lateinit var inin2: EditText
    lateinit var spbut: Button
    lateinit var acbut:Button
    lateinit var sp : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inin1 = findViewById(R.id.ed1)
        inin2=findViewById(R.id.ed2)
        spbut= findViewById(R.id.spbut)
        acbut= findViewById(R.id.intbut)
        spbut.setOnClickListener{
            saverestore(false)
            intent = Intent(this,ac2::class.java)
            startActivity(intent)
        }
        acbut.setOnClickListener{
            intent = Intent(this,ac2::class.java)
            intent.putExtra("inin1",inin1.text.toString())
            intent.putExtra("inin2",inin2.text.toString())
            startActivity(intent)
        }


    }
    private fun saverestore(s:Boolean) {
        sp = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        if (s) {


        } else {

            with(sp.edit()) {
                putString("inin1", inin1.text.toString())
                putString("inin2", inin2.text.toString())

                apply()
            }
        }
    }
}