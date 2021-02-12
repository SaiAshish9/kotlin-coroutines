import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(){
    println("${Thread.currentThread().name}")

//   creates a background thread (worker thread)
//    thread {
//        println("${Thread.currentThread().name}")
//        Thread.sleep(1000)
//        println("${Thread.currentThread().name}")
//    }


//    creates a background coroutine that runs on background thread
    GlobalScope.launch {
//        thread t1
        println("${Thread.currentThread().name}")
//        Thread.sleep(1000)
        delay(1000)
//        coroutine is suspended but thread t1 is not blocked
        println("${Thread.currentThread().name}")
    }


// Blocks the current main thread & wait for coroutine to finish
    Thread.sleep(2000)

    runBlocking {
//        creates a new coroutine that blocks the current main thread
        delay(2000)
        mySuspend(1000)
//      wait until coroutine is not completed
    }


    println("${Thread.currentThread().name}")
}


suspend fun mySuspend(time:Long){
    delay(time)
}

//fun main()= runBlocking {
//    delay(2000)
//}
