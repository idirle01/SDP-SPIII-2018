package command

object TestCommandPattern extends App {
  val NUMBER_OF_THREADS = 10
  val NUMBER_OF_JOBS = 5

  val pool = new ThreadPool(NUMBER_OF_THREADS)

  val emailJob = new EmailJob
  val smsJob = new SmsJob
  val fileIOJob = new FileIOJob()
  val logJob = new LoggingJob()

  for (i <- 0.until(NUMBER_OF_JOBS)) {
    emailJob.setEmail(new Email)
    smsJob.setSms(new Sms)
    fileIOJob.setFileIO(new FileIO)
    logJob.setLogging(new Logging)
    pool.addJob(emailJob)
    pool.addJob(smsJob)
    pool.addJob(fileIOJob)
    pool.addJob(logJob)
  }

  pool.shutdownPool
}
