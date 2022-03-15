package com.khesya.idn.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mengatur nama dari action bar
        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment_container))
    }

    /**
     *  fungsi onSupportNavigateUp berfungsi untuk menyambungkan fragment
     *  yang kita buat dengan main activity dengan memanggil findNavController kita yang memanggil id dari  xml
     *  yang menjadi nav host fragment kita
     *  NavHostFragment terletak dixml, berfungsi sebagai host (dasar)
     *  dari semua halaman lain
     *  NavController kelas yang digunakan untuk melakukan eksekusi
     *  navigasi yang sudah dibuat
     */

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_container)
        return navController.navigateUp() ||  super.onSupportNavigateUp()
    }
}