package com.example.logexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.logexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLog.setOnClickListener {
            //TAG : 안드로이드의 많은 로그 중에 무엇인지 찾기 위해 (보통 액티비티 이름)
            Log.d(TAG, "Hello Kotlin!")
        }

    }
}