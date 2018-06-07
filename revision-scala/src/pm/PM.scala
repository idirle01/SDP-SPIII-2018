case class User(
  id: Int,
  firstName: String,
  lastName: String,
  age: Int,
  gender: Option[String]
)

object PM extends App {
  val user = User(2, "Johanna", "Doe", 30, None)
  
  user.gender match {
    case Some(gender) => println("Gender: " + gender)
    case None => println("Gender: not specified")
  }
}