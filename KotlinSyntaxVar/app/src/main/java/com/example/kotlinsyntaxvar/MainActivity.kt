package com.example.kotlinsyntaxvar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    //클래스 밖에 코드 작성 X

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 값을 특정할 때는 타입이 생략된 형태로 작성
        var variable = "추지연"

        // 변수의 타입 특정 (더 좋은 방법)
        var variable2:String
        variable2 = "안녕하세요" // 숫자와 같은 다른 타입 넣을 수 없음

        // << 코틀린의 기본 타입 >>

        // 실수형
        var doubleValue:Double = 35.6
//        var floatValue:Float = 123.7f

        // 정수형
//        var intValue:Int = 123456
        var longValue:Long = 2_147_483_647 // _도 숫자로 인식 (자릿수 편하게 보기 위해)
//        var shortValue:Short = 123
//        var byteValue:Byte = 127

        // 문자형
        var charValue:Char = 'a'
        var stringValue:String = "문자형" // 길이에 상관없이 값을 입력할 수 있다 = 크기를 특정할 수 없음

        // 불린형
        var booleanValue:Boolean = true
        booleanValue = false

        //상수형 (모든 글자를 대문자로 작성)
        val VALVALUE:Boolean = true
//        VALVALUE = false 로 변경할 수 없음


        // 글자 작성 규칙
        var helloWorld = "안녕 세상아!"
        var hello_world = "안녕 세상아!"


    }



}