package com.example.kotlinsyntaxarray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var variable:Int = 157

        //배열
        // Int -> IntArray
        var intArr:IntArray = IntArray(10)

        // index : 0부터 시작
        intArr[0] = 10
        intArr[1] = 20
        intArr[2] = 30
        intArr[3] = 40
        intArr[4] = 50

        intArr[9] = 100

        Log.d("array", "9번 인덱스의 값 = ${intArr[9]}")

        //정해져 있는 여러 개의 값을 하나의 변수에 놓고 저장할 필요가 있을 때 배열 사용
        var weekArray = CharArray(7)
        weekArray[0] = '월'
        weekArray[1] = '화'

        weekArray[6] = '일'


        //컬렉션 (개수 측정 X, 동적) = 뮤터블리스트
        // 리스트 (배열과 같음)

        //<> : Generic(제네릭)
        var mutalbelist = mutableListOf<Int>()

        //값 넣기 (자동으로 인덱스 생성)
        mutalbelist.add(5)  //index 0
        mutalbelist.add(10) //index 1
        mutalbelist.add(75) //index 2
        mutalbelist.add(35) //index 3

        Log.d("컬렉션", "3번 인덱스 = ${mutalbelist[3]}")
        Log.d("컬렉션", "3번 인덱스 = ${mutalbelist.get(3)}")


        //맵 (key, value 형태)
        var mutalbeMap = mutableMapOf<String, String>()
        mutalbeMap.put("변수1", "값1")
        mutalbeMap.put("변수2", "값2")
        mutalbeMap.put("변수3", "값3")

        Log.d("맵", "맵 변수1의 값은 = ${mutalbeMap.get("변수1")}")

    }
}