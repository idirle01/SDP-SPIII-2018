package state

fun main(args: Array<String>){
  val robot = Robot()
  robot.walk()
  robot.cook()
  robot.walk()
  robot.off()
  robot.walk()
  robot.off()
  robot.cook()
}
