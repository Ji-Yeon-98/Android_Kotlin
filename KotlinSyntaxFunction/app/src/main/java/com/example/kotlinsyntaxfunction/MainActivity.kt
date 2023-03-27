package com.example.kotlinsyntaxfunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //함수를 사용하는 용도 -> 코드를 분류하기 위해서

       functionName()
        functionParam("값", 153)

        var pi = getPi()
        Log.d("함수3", "pi=${pi}")
    }

    //기본 함수
    fun functionName(){
        //코드블럭
    }

    //입력값이 있는 함수
    fun functionParam(param1:String, param2:Int){
        Log.d("함수2", "param1=${param1}, param2=${param2}")
    }

    //출력값이 있는 함수
    fun getPi() : Double{
        return 3.141592
    }

}