def sum(xs: List[Int]): Int = {
  //@tailrec
  def inner(xs: List[Int], accum: Int): Int = {
    xs match {
      case x :: tail => inner(tail, accum + x)
      case Nil => accum
    }
  }
  inner(xs, 0)
}