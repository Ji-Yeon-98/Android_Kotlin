package com.example.basicsyntaxnullsafety

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myName:String = "메시"

        // null : 메모리의 공간을 차지하고 있음
        var number:Int? = null      //nullable : null을 입력할 수 있는 변수에 ?를 붙임
        var newVariable: Activity? = null

        Log.d("Null Test", "문자열의 길이 = ${myName.length}")

        // 1. Null Pointer Exception
        // 2. Safe call : 변수 뒤에 ?를 붙여주면 ?다음을 실행 X
        // 3. Elvis Expression (? : 값) : null 일경우 result에 입력되는 지정값을 표현해줄 수 있다.
        var result = number?.plus(37) ?: 51
        var result2 = result.plus(53)


    }
}