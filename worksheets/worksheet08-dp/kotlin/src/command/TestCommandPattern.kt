package command

fun main(args: Array<String>) {
    val NUMBER_OF_THREADS = 10
    val NUMBER_OF_JOBS = 5

    val pool = ThreadPool(NUMBER_OF_THREADS)

    val emailJob = EmailJob()
    val smsJob = SmsJob()
    val fileIOJob = FileIOJob()
    val logJob = LoggingJob()

    for (i in 1 until NUMBER_OF_JOBS) {
        emailJob.setEmail(Email())
        smsJob.setSms(Sms())
        fileIOJob.setFileIO(FileIO())
        logJob.setLogging(Logging())
        pool.addJob(emailJob)
        pool.addJob(smsJob)
        pool.addJob(fileIOJob)
        pool.addJob(logJob)
    }

    pool.shutdownPool()
}
