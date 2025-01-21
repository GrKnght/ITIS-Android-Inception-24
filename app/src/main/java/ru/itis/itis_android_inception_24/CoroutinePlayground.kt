package ru.itis.itis_android_inception_24

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.random.Random

fun main() {
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    scope.launch {
        val jobsList = mutableListOf<Deferred<Unit>>()
        repeat(99) { count ->
            jobsList.add(async(start = CoroutineStart.LAZY) {
                delay(1000L)
                if (Random.nextInt(0, 6) == 3) {
                    throw IllegalStateException("Invalid state")
                }
                println("TEST TAG - Result $count")
            })
        }
        jobsList.awaitAll()
    }
    scope.launch {
        delay(2000L)
        println("TEST TAG - Second launch result")
    }
//    runBlocking() {
//        val jobsList = mutableListOf<Deferred<Unit>>()
//
//        var successCounter = 0
//
//        launch {
//            repeat(99) { count ->
//                jobsList.add(async(start = CoroutineStart.LAZY) {
//                    delay(1000L)
//                    if (Random.nextInt(0, 6) == 3) {
//                        throw IllegalStateException("Invalid state")
//                    }
//                    successCounter++
//                    println("TEST TAG - Result $count")
//                })
//            }
//            jobsList.awaitAll()
//        }
//    }
}


