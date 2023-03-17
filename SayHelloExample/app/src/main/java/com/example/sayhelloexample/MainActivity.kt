package com.example.sayhelloexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sayhelloexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 변환된 binding 클래스 : ActivityMainBinding
    // inflate로 활성화된 ActivityMainBinding 클래스를 binding 변수에 담아서 사용 (activity_main.xml 파일의 모든 변수 사용 가능)
    // 기본적으로 생성된 activity 파일에는 layoutinflater가 담겨있어서 inflate 안에 layoutinflater 사용
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root) //binding 사용하기 때문에 binding.root로 사용

        binding.btnSay.setOnClickListener {
            binding.tvSay.text = "Hello Kotlin!"
        }

    }
}