package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    * Pascal's triangle is a 'recurrence relation',
    * an equation that recursively defines a sequence
    * of a multidimensional array of values, once one
    * or more initial terms are given: each further term
    * of the sequence or array is defined as a function of
    * the preceding terms.
    *
    * The problem is to recursively compute a binomial coefficient
    * within Pascal's triangle, expressed as:
    * r     =     r-1     +     r-1
    * c            c            c-1
    *
    * Recursion moves up through the triangle to sum the values.
    *
    */
  def pascal(column: Int, row: Int): Int = {
    if (column == 0 || column == row) 1
    else pascal(column - 1, row - 1) + pascal(column, row - 1)
  }


  /**
    * Exercise 2
    */
  import collection.mutable
  import collection.mutable.Queue

  def balance(chars: List[Char]): Boolean = {

    val queue = new mutable.Queue[Char]()

    def test (chars: List[Char], q: Queue[Char]): Boolean =
    {
      chars match {
        case Nil => q.isEmpty
        case '(' :: tail => q += '('; test(chars.tail,q)
        case ')' :: tail => if (q.isEmpty) false else {q.dequeue ; test(chars.tail,q)}
        case x :: tail => test(chars.tail,q)
      }
    }
    test (chars,queue)
  }

  /**
    * Exercise 3
    */
  /* def countChange(money: Int, coins: List[Int]): Int = {
    def recurs(m: Int, cs: List[Int], cnt: Int): Int =
      if (m >0) cnt // No Change, keep count
      else if (cs.isEmpty) {
        if ( m == 0) cnt + 1 else cnt
    }
      else recurs(m, cs.tail, cnt) + recurs(m-cs.head, cs, cnt)
    if ( money > 0 ) recurs(money, coins, 0) else 0
  } */
  def countChange(m: Int, cs: List[Int]): Int = cs match {
    case Nil => if(m == 0) 1 else 0
    // must do pass-by-value to stop the recursions
    case c :: rs => (0 to m/c) map (k => countChange(m-k*c,rs)) sum  // k is each value in '0 to m/c'
  }

}