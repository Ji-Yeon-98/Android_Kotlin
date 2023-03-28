package com.example.kotlinsyntaxclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //클래스의 사용
        //1. 초기화
        var cls = CLASS() // 인스턴스 : 메모리에 로드되어 있는 클래스

        //내부의 변수와 함수 사용 가능
        cls.variable
        cls.function()

        //2. companion object로 만들기
        Log.d("태그", "메세지")


        // 클래스 상속
        var parent = Parent()
        parent.showHouse()

        var child = Child()
        child.showMoney()
        child.showHouse()

        var son = Son()
        var result1 = son.getNumber()
        var result2 = son.getNumber("hi")
        
    }
}





//변수(property)와 함수(method)의 모음
class CLASS {

    init{
        //클래스를 초기화하면 호출된다.
    }

    var variable:String = "" //변수 - 프로퍼티

    fun function(){          //함수 - 메서드
        var variable_local = ""
    }
}


class Log{

    companion object{
        var variable = "난 누구"
        fun d(tag:String, msg:String){
            print("[$tag] : $msg")
        }
    }

}

// 상속을 사용하는 이유
// 1. 기존의 작성된 코드를 재활용하기 위해서
// 2. 코드를 재활용하는데 -> 체계적인 계층구조로 사용하기 위해서

open class Parent{
    var money = 50000000
    open var house = "강남 200평 아파트"

    open fun showHouse(){
        Log.d("클래스", "parent's house=${house}")
    }

}


class Child : Parent(){

    // 부모 클래스와 같은 변수를 재정의하고 싶다면 override 사용
    override var house = "강남 10평 오피스텔"

    //상속 받으면 부모 클래스의 프로퍼티와 메서드를 내것처럼 사용할 수 있음
    fun showMoney(){
        Log.d("클래스", "money=${money}")
    }

    override fun showHouse(){
        Log.d("클래스", "child's house=${house}")
    }

}


class Son{

    // 같은 이름으로 여러개를 태울 수 있을 때 오버로드
    fun getNumber() : Int{
        return 1
    }

    fun getNumber(param:String):Int{
        return 2
    }

}
