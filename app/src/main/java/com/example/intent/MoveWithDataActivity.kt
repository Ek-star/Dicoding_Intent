package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {

    // Selanjutnya untuk menerima data dari Activity asal, ambil data dari Intent berdasarkan key dan tampilkan ke dalam TextView seperti berikut.
    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        // Selanjutnya untuk menerima data dari Activity asal, ambil data dari Intent berdasarkan key dan tampilkan ke dalam TextView seperti berikut.
        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text = "Name : $name, Your Age : $age"
        tvDataReceived.text = text
    }
}