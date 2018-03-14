package command

import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class ThreadPool(n: Int) {
    private val jobQueue: BlockingQueue<Job> = LinkedBlockingQueue<Job>()
    private val jobThreads = arrayOfNulls<Thread?>(n)
    private var shutdown = false

    init {
        for (i in 0 until n) {
            jobThreads[i] = Worker("Pool Thread " + i)
            jobThreads[i]!!.start()
        }
    }

    fun addJob(r: Job) {
        try {
            jobQueue.put(r)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

    fun shutdownPool() {
        val SLEEP_TIME = 1000L

        while (!jobQueue.isEmpty())
            try {
                Thread.sleep(SLEEP_TIME)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        shutdown = true
        for (workerThread in jobThreads) {
            workerThread!!.interrupt()
        }
    }

    inner class Worker(name: String) : Thread(name) {

        override fun run() {
            while (!shutdown)
                try {
                    val r: Job = jobQueue.take()
                    r.run()
                } catch (e: InterruptedException) {
                    return
                }
        }
    }
}
