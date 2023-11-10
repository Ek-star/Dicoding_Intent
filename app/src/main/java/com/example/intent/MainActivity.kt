package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

// 2. Lalu, tambahkan beberapa baris yang berfungsi untuk menambahkan event onClick pada button btnMoveActivityseperti ini.
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ALUR
        // 1. Masuk ke MainActivity, tambahkan beberapa baris kode yang berfungsi untuk memperkenalkan button yang sudah ditambahkan di layout seperti ini.
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                // 3. Setelah activity tujuan sudah berhasil diciptakan, sekarang saatnya menambahkan suatu intent pada method onClick() di MainActivity menjadi sebagai berikut.
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

    // Intent adalah mekanisme untuk melakukan sebuah action dan komunikasi antar komponen aplikasi misal Activity, Service, dan Broadcast Receiver. Ada tiga penggunaan umum intent dalam aplikasi Android yaitu sebagai berikut.

    // 1. Memindahkan satu activity ke activity lain dengan atau tidak membawa data.
    // 2. Menjalankan background service, misalnya melakukan sinkronisasi ke server dan menjalankan proses berulang (periodic/schedulertask).
    // 3. Mengirimkan obyek broadcast ke aplikasi yang membutuhkan. Misal, ketika aplikasi membutuhkan proses menjalankan sebuah background service setiap kali aplikasi selesai melakukan booting. Aplikasi harus bisa menerima obyek broadcast yang dikirimkan oleh sistem Android untuk eventbooting tersebut.

    // Explicit Intent
    // Adalah tipe Intent yang digunakan untuk menjalankan komponen lain dengan tujuan yang sudah jelas atau eksplisit. Umumnya Intent ini digunakan untuk berpindah ke Activity lain pada satu aplikasi. Misalnya, dari MainActivity menuju ke DetailActivity.

    // Implicit Intent
    // Adalah tipe intent yang tidak memerlukan detail nama kelas yang ingin diaktifkan. Model ini memungkinkan komponen dari aplikasi lain bisa merespon request intent yang dijalankan.

    // Penggunaan tipe Intent ini umumnya diperuntukkan untuk menjalankan fitur/fungsi dari komponen aplikasi lain. Contohnya ketika kita membutuhkan fitur untuk mengambil foto. Daripada membuat sendiri fungsi kamera, lebih baik kita menyerahkan proses tersebut pada aplikasi kamera bawaan dari peranti atau aplikasi kamera lain yang telah terinstal sebelumnya di peranti.

    // Hal yang sama misalnya ketika kita membutuhkan fungsi berbagi konten. Kita bisa memanfaatkan intent untuk menampilkan aplikasi mana saja yang bisa menangani fitur tersebut.
}