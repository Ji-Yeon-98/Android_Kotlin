package com.example.kotlinsyntaxcondition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val first = 300
        val second = 500
        val third = 270

        // 비교연산자 >, <, >=, <=, ==, !=
        val result = 1 != 2
        Log.d("compare", "1 != 2 결과 = ${result}")

        val result2 = "홍길동" == "추지연"
        Log.d("compare", "홍길동 == 추지연 결과 = ${result2}")

        // 논리연산자
        val result3 = first < 500   // true
        val result4 = second < 500  //false

        var logic1 = result3  && result4
        Log.d("compare", "논리연산 && 결과 = ${logic1}")

        var logic2 = result3 || result4
        Log.d("compare", "논리연산 || 결과 = ${logic2}")

        var logic3 = !result3
        Log.d("compare", "논리연산 ! 결과 = ${logic3}")

        // if

//        if(조건식 = 비교연산 + 논리연산) {
//            //코드 블럭
//       }else if{
//
//       }else{
//            //위의 if 조건을 만족하지 않았을 때 실행되는 코드 블럭
//        }

        var month = 6
        if(month > 9){
            Log.d("if", "가을 옷 입기")
        }else if(month > 6 && month <= 9){
            Log.d("if", "여름 옷 입기")
        }else if(month > 3 && month < 7){
            Log.d("if", "봄 옷 입기")
        }else{
            Log.d("if", "집에 있기")
        }


        // when - 거의 대부분의 언어 switch (if문의 확장판)

        when(month){
            9, 10, 11, 12 -> Log.d("when", "가을 옷 입기")
            7, 8, 9 -> Log.d("when", "여름 옷 입기")
            4, 5, 6 -> Log.d("when", "봄 옷 입기")
            else -> Log.d("when", "집에 있기")
        }

    }

}