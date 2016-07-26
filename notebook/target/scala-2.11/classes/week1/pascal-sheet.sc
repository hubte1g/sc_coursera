import scala.collection.mutable.ListBuffer

object Main {
  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }
}
def pascal(column: Int, row:Int): Int = {
  if (column == 0 || column == row) 1
  else pascal(column - 1, row - 1) + pascal(column, row - 1)
}

/**
 * pascal(c,r)
 * pascal(9,10)
 *
 * if (9 == 0 || 9 == 10) 1  // false
 * else pascal(9 - 1, 10 - 1) + pascal(9, 10 - 1)
 *   // pascal(8,9)  +  pascal(9,9)
 *
 */

// Print triangle
  println("Pascal's Triangle")
  for (row <- 0 to 10) {
    for (col <- 0 to row)
      print(pascal(col, row) + " ")
    println()
  }


println(pascal(0,2))


