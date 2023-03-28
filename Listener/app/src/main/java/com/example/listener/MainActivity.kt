package com.example.listener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.listener.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val listener = object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                Log.d("리스너", "클릭되었습니다.")
//            }
//            override fun aaa(){
//                // 중괄호 안에 생략 불가능
//            }
//        }
//
//        binding.button.setOnClickListener(listener)

        binding.button.setOnClickListener {
            Log.d("리스너", "클릭되었습니다.")
        }

    }
}