package singleton

object Cat extends Runnable {
  def run() {
    // do nothing
  }
}

object Main extends App {
  Cat.run()
}