//   promotion to a new job at work
trait Promoteable {
  def promote()
}

//   successful students get promoted to the next grade level
trait GoodStudent {
  def promote()
}

//   Represents an employee of a corporation.
abstract case class Employee(name: String, var salary: Double)  {
  def promote()

  def print () {
    println("Name  : {0}", name)
    println("Salary: {0}", salary)
  }
}

//   represents a computer programmer at a corporation
//   programmers are eligible for promotion within the company
class Programmer(name: String, sal: Double, averageOT: Double) extends Employee(name, sal) with Promoteable {

  // Implement the Promote method from the IPromoteable interface
  override def promote() {
    salary *= 1.1
  }

  override def print () {
    println("Programmer")
    super.print()
    println("Average OT: {0}", averageOT)
  }
}

//   represents a manager at a corporation
//   managers are eligible for promotion within the company
//   all managers are required to take continuing education
//	 so they implement IGoodStudent
class Manager(name: String, sal: Double, secretaryName: String) extends Employee(name, sal) with Promoteable with GoodStudent {

  // Implement the promote method from the Promoteable interface
  override def promote() {
    salary *= 1.5
  }

  override def print () {
    println("Manager")
    super.print()
    println("Secretary: " + secretaryName)
  }
}

//   represents an intern at a corporation
//   interns are temporary employees so they are not eligible for promotion
class Intern(name: String, sal: Double,  lengthOfInternship: Int) extends Employee (name, sal) {

  override def promote() {}

  override def print () {
    println("Intern")
    super.print()
    println("Length of internship(months): " + lengthOfInternship)
  }
}

class TraitsTest {
    val emps = new Array[Employee](3)

    emps(0) = new Intern("Bob", 4000, 3)
    emps(1) = new Programmer("Sally", 45000, 4.6)
    emps(2) = new Manager("Ann", 120000, "George")

    emps.foreach{ println}

    emps.foreach{ _.promote}

    emps.foreach{ println}

}
