object Memo {
  def memo[A, B](f: A => B): A => B = {
    val cache = collection.mutable.Map[A, B]()
    (a: A) => {
      cache get a match {
        case Some(b) => b
        case None =>
          val b = f(a)
          cache(a) = b
          b
      }
    }
  }
}
