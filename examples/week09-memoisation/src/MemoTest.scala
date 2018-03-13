object MemoTest extends App {

  val mf = Memo.memo(FibMain.fib)
  println(mf(10))
  println(mf(10))


  val memolength = Memo.memo {
    xs: List[Int] =>
      println("Computing...")
      xs.length
  }

  println(memolength(List(1, 2, 3, 4, 5, 6, 7)))
  println(memolength(List(1, 2, 3, 4, 5, 6, 7)))
}
