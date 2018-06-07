object Example extends App {
  type Duel = (String, String)
  type Result = (String, Int)
  type Quiz = List[Result]
  type Course = List[Quiz]

  def duels(dwarves: List[String]): List[Duel] = dwarves.flatMap { dwarf1 =>
    dwarves.filter(_ != dwarf1).map { dwarf2 =>
      (dwarf1, dwarf2)
    }
  }

  def duels2(dwarves: List[String]): List[Duel] =
    for (
      dwarf1 <- dwarves;
      dwarf2 <- dwarves;
      if dwarf1 != dwarf2
    ) yield (dwarf1, dwarf2)

  def duels3(dwarves: List[String]): List[Duel] = dwarves match {
    case x :: y :: Nil => (x, y) :: (y, x) :: Nil
    case x :: y :: xs => (duels3(x :: y :: Nil) ++ duels3(x :: xs) ++ duels3(y :: xs)).distinct
  }

  def winner(duels: List[(Duel, Int)]): String = {
    val victoriousDwarves = duels.map {
      case ((dwarf1, dwarf2), i) =>
        if (i == 1) dwarf1 else dwarf2
    }

    val dwarvesToVictories = victoriousDwarves.groupBy(x => x).map {
      case (dwarf, victories) =>
        (dwarf, victories.size)
    }
    val sorted = dwarvesToVictories.toList.sortWith {
      case (d1, d2) => d1._2 > d2._2
    }
    sorted.head._1
  }
}