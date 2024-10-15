package ru.itis.itis_android_inception_24

import android.content.Context

fun main() {
//    typesSample()
//    val sumValue = sum(
//        arg1 = 5,
//        arg2 = 6,
//    )
//    funWithDefaultValues(arg1 = 5, arg2 = 4)
//    SampleClass(
//        firstProperty = "First",
//        secondProperty = "Second",
//        thirdArg = ""
//    )
//    val classEx = SampleClass("", "")
//    val sumClass = ValuesSumClass()
//    sumClass.firstArg = 5
//
//    println("Result: ${sumClass.firstArg}")
//
//    SampleClass(secondProperty = "")
//    SampleClass3(firstProperty = "", newField = "")
//    val firstClass = DataClassSample(
//        firstProperty = "first",
//        secondProperty = "second"
//    )
//    val secondClass = DataClassSample(
//        firstProperty = "first",
//        secondProperty = "second"
//    )
//
//    if (nullableProp != null) {
//        println("ShowResult: $nullableProp")
//    } else {
//        println("ShowResult: Empty")
//    }
//
//    val result2 = secondClass.secondProperty ?: throw IllegalStateException()
//
//    val result3 = DataClassWithInt(
//        firstProp = "Sample",
//        secondProp = 5,
//        thirdProp = 11,
//    )
//
//    val propsSum: Int = if (result3.thirdProp != null) {
//        println()
//        println()
//        result3.secondProp + result3.thirdProp!!
//    } else {
//        println()
//        println()
//        println()
//        result3.secondProp
//    }
//
//
//    val propsSum2: Int
//
//    if (result3.thirdProp != null) {
//        propsSum2 = result3.secondProp + result3.thirdProp!!
//    } else {
//        propsSum2 = result3.secondProp
//    }
//
//    val firstString: String = "result"
//    val secondString: String? = null
//
//    val innerDataSample = InnerNullableClassSample(
//        firstProp = "Odin",
//        secondProp = 5,
//        classData = DataClassWithInt(
//            firstProp = "Str",
//            secondProp = 11,
//            thirdProp = 6,
//        )
//    )
//
//    val innerDataSample2 = InnerNullableClassSample(
//        firstProp = "Odin",
//        secondProp = 5,
//        classData = DataClassWithInt(
//            firstProp = "Str",
//            secondProp = 11,
//            thirdProp = 6,
//        )
//    )
//
//
//    with(innerDataSample) {
//        println("TEST TAG - First: $firstProp Second: $secondProp Third: $classData")
//    }
//
//    val newClass = innerDataSample.classData?.apply {
//        thirdProp = 5
//        fourthProp = 6
//        fifthProp = 7
//    }
//
//    val letFuncSample = innerDataSample.classData?.thirdProp?.let { intProp ->
//        // Some Logic sample
//        11 + intProp
//    }
//
//    val alsoFuncSample = innerDataSample.classData?.also {
//        println("Value: $it")
//    }
//
//    val defaultBooleanCheck: Boolean? = innerDataSample.secondProp > innerDataSample2.secondProp
//
//    val sampleIntForWhen = innerDataSample.secondProp + innerDataSample2.secondProp
//
//    val whenOperatorValue = when (sampleIntForWhen) {
//        10 -> {
//            if (defaultBooleanCheck == true) {
//                "First"
//            } else {
//                "FirstAndSecond"
//            }
//        }
//
//        12 -> "Second"
//
//        else -> "Third"
//    }
//
//    val whenSecondValue = when {
//        sampleIntForWhen == 10 && defaultBooleanCheck == true -> "First"
//
//        sampleIntForWhen == 10 && defaultBooleanCheck != true -> "FirstAndSecond"
//
//        sampleIntForWhen == 12 -> "Second"
//
//        else -> "Third"
//    }
//
//    val collectionSample = listOf(1, 2, 3, 4)
//
//    for (index in 0 until 10 step 4) {
//
//    }
//
//    repeat(500) {
//    }
//
//    var counter = 0
//    var sum = 0
//    while (++counter < 100) {
//        sum += innerDataSample.secondProp + innerDataSample2.secondProp
//    }
//
//    do {
//        println("TEST TAG")
//        counter++
//    } while (counter < 1000)
//
//    firstFor@ for (i in 0 .. 100) {
//        secondFor@ for (j in 0 .. 100) {
//            if (j == 61) {
//                continue
//            }
//            if (i == 50 && j == 60) {
//                continue@firstFor
//            }
//        }
//    }
//
//    val castExample: Any = DataClassWithInt(
//        firstProp = "first",
//        secondProp = 5
//    )
//
//    if (castExample is DataClassWithInt) {
//        println("TEST TAG - Yep it's true")
//    }
//
//    (castExample as? String)?.let {
//
//    }
//
//    val listSample = listOf("first", "plain", "val", "secondUser", "thirdUser", "")
//    val sequenceSample = sequenceOf("first", "plain", "val", "secondUser", "thirdUser", "")
//
//    val result = listSample.asSequence()
//        .filter { userName ->
//            userName.length > 3
//        }
//        .map { userName ->
//            "${userName}_${userName.length}"
//        }
//        .filter { userName ->
//            userName.length > 6
//        }
//        .filter { userName ->
//            userName.contains("t")
//        }
//        .map { userName ->
//            "$userName@gmail.com"
//        }
//
//    result.toList().let {
//
//    }
//
//    result.forEach { userEmail ->
//        println("TEST TAG - UserEmail: $userEmail")
//    }

    val str = "sampleString".stringClassExtension()
    println("TEST TAG - Result: $str")

    val classWithInnerFun = SampleClassWithInnerFunc()
    sampleWithFunctionalType(
        action = { _, _, arg3: Char ->
            val resultString = "TEST TAG - Work result: $arg3"
            println(resultString)
            resultString
        }
    )

    sampleWithFunctionalType(
        action = classWithInnerFun::argumentFuncSample
    )

}

class SampleClassWithInnerFunc {

    fun argumentFuncSample(arg1: Int, arg2: String, arg3: Char): String {
        println("TEST TAG - Work result: $arg1")
        return ""
    }

}


fun typesSample() {

    var strSample: String = "str1"
    val strSample2 = "str2"

    val m = 5
    val secondInt = 6
    var counter = 0

    println("TEST TAG - $strSample $strSample2 ${m + secondInt} ${++counter}")
}

fun sum(arg1: Int, arg2: Int): Int = arg1 + arg2

fun funWithDefaultValues(
    arg1: Int,
    arg2: Int,
    arg3: Int = 5,
): Int {
    return arg1 + arg2 + arg3
}

open class SampleClass(
    protected open val firstProperty: String = "first",
    val secondProperty: String,
    thirdArg: String = "third",
) {
    init {
        parentFunSample()
    }

    protected open fun parentFunSample() {
        println("MyLog")
    }
    //   constructor(arg1: String, arg2: String): this(arg1, arg2, "")
}

class SampleClass2(thirdArg: String) {

    val firstProperty: String
    val secondProperty: String

    init {
        firstProperty = thirdArg
        secondProperty = thirdArg + "Result"
    }
}

class SampleClass3(
    override val firstProperty: String,
    newField: String
) : SampleClass(firstProperty = firstProperty, secondProperty = newField) {

    init {
        parentFunSample()
    }

    override fun parentFunSample() {
        super.parentFunSample()
        println("TEST TAG - Child Log")
    }

    private companion object {
        private const val FIRST_CONTS = "SOME_STRING"

        private fun staticFuncSample(input: String) {
            println("TEST - Do something: $input")
        }
    }
}

class ValuesSumClass {

    var firstArg: Int = 0
        set(value) {
            val m = 5
            val m2 = 6
            val res = m2 - m
            field = value + res
        }

    var secondArg: Int = 0

}

abstract class AbstractClassSample {

    abstract fun funInClass()
}

interface InterfaceSample {

    val inputValue: String?

    fun firstFun() {
        println("TEST TAG - 5")
    }

    fun secondFun()
}

interface InterfaceSample2 {

    fun funInSecondInt()
}


interface InterfaceSample3 {}


interface InterfaceSample4 {}

class NewClass : AbstractClassSample(), InterfaceSample, InterfaceSample2, InterfaceSample3,
    InterfaceSample4 {

    override val inputValue: String? = null

    override fun funInClass() {
        val m = 5
        val m2 = 6
        println("TEST TAG - ${m + m2}")
    }

    override fun firstFun() {
        super.firstFun()
    }

    override fun secondFun() {

    }

    override fun funInSecondInt() {

    }
}

class PlainClassSample(
    val firstProperty: String,
    val secondProperty: String,
)

data class DataClassSample(
    val firstProperty: String,
    val secondProperty: String? = null,
)

data class DataClassWithInt(
    val firstProp: String,
    val secondProp: Int,
    var thirdProp: Int? = null,
    var fourthProp: Int? = null,
    var fifthProp: Int = 0,
)

data class InnerNullableClassSample(
    val firstProp: String,
    val secondProp: Int,
    val classData: DataClassWithInt? = null,
)

val nullableProp: String? = null

fun String.stringClassExtension(): String {
    return this.plus("_input")
}

fun stringClassExtension2(input: String): String {
    return input.plus("_input")
}

fun sampleWithFunctionalType(
    action: (Int, String, Char) -> String
) {
    val first = 5
    val second = 6
    println("TEST - Middle Result: ${first + second}")
    action(first + second, "str", 's') // action.invoke()
}

class SampleContextExample() {

    fun pasteSomeData(ctx: Context) {
        val stringRes = ctx.getString(R.string.admin_button_text)
    }
}

