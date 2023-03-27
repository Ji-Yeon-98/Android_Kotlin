package com.example.kotlinsyntaxfor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //for
        // 일반적으로 몇 번의 횟수를 반복하는 형태
//        for(변수 in 시작값, 종료값){
//            //코드블럭
//        }

        for(index in 10 downTo 1 step 2){ //until : 미만, step : 띄어넘기, downTo : 반대로
            Log.d("반복문", "index = ${index}")
        }

        var intArray = intArrayOf(0, 10, 20, 30, 40, 50, 60, 70, 80)

        for(value in intArray){
            Log.d("반복문2", "value=${value}")
        }

        //while
//        while(반복할 조건){
//
//        }

        var out = 0
        while(out < 3){ //조건이 true일 때 까지
            Log.d("while", "현재 out = ${out}")
            out = out + 1
        }

        var out1 = 3

       do{ //무조건 1번은 실행
           Log.d("while2", "현재 out = ${out}")
           out1 = out1 + 1
       }while(out < 3)



       //control loop
       for(index in 0..10){
           if(index > 5) break //continue : 무언가를 스킵하고 싶을 때
           Log.d("포", "현재 숫자 = ${index}")
       }

        for(index in 0..10){
            if(index == 5) continue //continue : 무언가를 스킵하고 싶을 때
            Log.d("포2", "현재 숫자 = ${index}")
        }


    }
}