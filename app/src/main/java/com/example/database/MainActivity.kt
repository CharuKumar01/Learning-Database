package com.example.database

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.database.databinding.ActivityMainBinding
import com.google.android.gms.common.util.DataUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var bind : ActivityMainBinding
    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val navBars = insets.getInsets(WindowInsetsCompat.Type.navigationBars())
            v.updatePadding(bottom = navBars.bottom)
            insets
        }

        database = ContactDatabase.getDatabase(this)

        lifecycleScope.launch {
            lifecycleScope.launch {
                database.contactDao().insertContact(Contact(0, "Charu", "7247871944", Date()))
            }
        }
        database.contactDao().getContact().observe(this, Observer { list ->
            Log.d("DB_CHECK", list.toString())
        })
    }
}