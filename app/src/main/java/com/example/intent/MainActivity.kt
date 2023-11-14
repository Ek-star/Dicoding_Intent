package com.example.intent

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

// 2. Lalu, tambahkan beberapa baris yang berfungsi untuk menambahkan event onClick pada button btnMoveActivityseperti ini.
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result -> if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
        val selectedValue: Int? =
            result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
        tvResult.text = "Hasil : $selectedValue"
    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ALUR
        // 1. Masuk ke MainActivity, tambahkan beberapa baris kode yang berfungsi untuk memperkenalkan button yang sudah ditambahkan di layout seperti ini.
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        // Mengirim data pada Intent
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        // Latihan Mengirim Data dengan Parcelable
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        // Latihan Implicit Intent
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        // Latihan Mendapatkan Nilai Balik dari Intent
        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                // 3. Setelah activity tujuan sudah berhasil diciptakan, sekarang saatnya menambahkan suatu intent pada method onClick() di MainActivity menjadi sebagai berikut.
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
                // Metode startActivity(moveIntent) akan menjalankan activity baru tanpa membawa data. Objek intent yang diinputkan adalah objek moveIntent yang ketika kode ini dijalankan maka akan membuka MoveActivity.
            }


            R.id.btn_move_activity_data -> {

                // Sekarang saatnya kita menambahkan data pada Intent menggunakan putExtra di dalam MainActivity
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )

                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "081294537182"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
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