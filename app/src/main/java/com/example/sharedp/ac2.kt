package com.example.sharedp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ac2 : AppCompatActivity() {
    lateinit var tv1: TextView
    lateinit var tv2: TextView
    lateinit var spbut: Button
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ac2)
        tv1=findViewById(R.id.tv1)
        tv2=findViewById(R.id.tv2)
        spbut= findViewById(R.id.spbutton)
        tv1.text= intent.getStringExtra("inin1").toString()
        tv2.text= intent.getStringExtra("inin2").toString()
        spbut.setOnClickListener {
            saverestore(true)

        }

    }
    private fun saverestore(s:Boolean) {
        sp = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        if (s) {
            tv1.text=sp.getString("inin1","")
            tv2.text=sp.getString("inin2","")


        } else {


        }
    }
}