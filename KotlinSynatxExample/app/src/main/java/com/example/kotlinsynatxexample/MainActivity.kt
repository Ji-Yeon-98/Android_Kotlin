package com.example.kotlinsynatxexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinsynatxexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    val TAG = "MainAvtivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // 변수
        var myName = "추지연"
        Log.d(TAG, "my name=$myName")

        myName = "추지연2" // 값 변경 가능
        Log.d(TAG, "my name=$myName")


        // 상수 (주로 대문자로 선언)
        //변수에 저장한 값을 바꿀 필요가 없을 때 (값 변경 불가능)
        val PI = 3.141592
        Log.d(TAG, "pi=$PI")



        var myNumbers = "1,2,3,4,5,6"
        var thisWeekNumbers = "1,2,3,4,5,6"

        if(myNumbers == thisWeekNumbers){
            binding.tvLog.text = "당첨되었습니다."
        }else{
            binding.tvLog.text = "당첨되지 않았습니다."
        }



        for( idx in 1..10){
            binding.tvLog.append("\n현재 숫자는 ${idx}입니다.")
        }


    }
}