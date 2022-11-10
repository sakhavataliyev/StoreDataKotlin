package com.aliyev.storedatakotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Degisken tanimlandi
    lateinit var sharedPreferences: SharedPreferences
    var sharedData : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// SharedPreferences Initialize
        sharedPreferences = getSharedPreferences("com.aliyev.storedatakotlin", MODE_PRIVATE)

        sharedData = sharedPreferences.getInt("age", -1)

        if (sharedData == -1 ){
            textAge.text = "Age: "
        } else{
            textAge.text = "Your Age: ${sharedData}"
        }
    }


    fun save(view : View){

        val myAge = inputAge.text.toString().toIntOrNull()

        if (myAge != null){
            textAge.text = "Your Age: ${myAge}"
            sharedPreferences.edit().putInt("age", myAge).apply()
        }

    }

    fun delete(view : View){
        sharedData = sharedPreferences.getInt("age", -1)
        sharedPreferences.edit().remove("age").apply()

        if (sharedData != -1){
            textAge.text = "Your Age:"
        }

    }
}