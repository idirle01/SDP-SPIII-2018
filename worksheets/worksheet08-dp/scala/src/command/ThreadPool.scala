package command

import java.util.concurrent.BlockingQueue

import java.util.concurrent.LinkedBlockingQueue

class ThreadPool(n: Int) {

  private val jobQueue: BlockingQueue[Job] = new LinkedBlockingQueue()

  private val jobThreads = new Array[Thread](n)

  @volatile private var shutdown: Boolean = _

  for (i <- 0 until n) {
    jobThreads(i) = new Worker("Pool Thread " + i)
    jobThreads(i).start()
  }

  def addJob(r: Job): Unit = {
    try jobQueue.put(r)
    catch {
      case e: InterruptedException => Thread.currentThread().interrupt()
    }
  }

  def shutdownPool: Unit = {
    val SLEEP_TIME = 1000

    while (!jobQueue.isEmpty)
      try {
        Thread.sleep(SLEEP_TIME)
      } catch {
        case e: InterruptedException => e.printStackTrace()
      }
    shutdown = true
    for (workerThread <- jobThreads) {
      workerThread.interrupt()
    }
  }

  private class Worker(name: String) extends Thread(name) {

    override def run: Unit = {
      while (!shutdown)
        try {
          val r: Job = jobQueue.take()
          r.run
        } catch {
          case e: InterruptedException => {}
        }
    }
  }
}
