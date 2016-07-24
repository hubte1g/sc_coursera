import math.abs

object fixedPoint {
  println("This is a fixed point algorithm exercise")
  println("Expressiveness of language can be" +
    " increased when passing functions as arguments")

  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {

    /* iteration method to test whether the guess is close enough to result
     * If not, then iterate
     */
    def iterate(guess: Double): Double = {
      println("guess = " + guess) // troubleshooting
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  fixedPoint(x => 1 + x / 2)(1)

  /*
   * Return to square root example
   */
  def sqrt(x: Double) = // fixedPoint(y => x /y)(1)  // does not converge
  fixedPoint(y => (y + x / y) / 2)(1) // take average instead to converge  // >> 'Average Damping'
  sqrt(2)

  /* Implement 'Average Damping'
   * Begin by observing that square root of x is a fixed point of the function y => x/y
   * Then, the iteration converges by averaging successive values
   * The technique of stabilizing by averaging can be abstracted into its own function
   *
   */
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  /* Write square root funtion using fixedPoint() and averageDamp()
   *
   * averageDamp() is a function that takes a function and returns to another function
   *
   * 'dampens' the [unconverging oscillations]
   */

  def sqrtWithAvgDmp(x: Double) = fixedPoint(averageDamp(y => x / y))(1)
  sqrtWithAvgDmp(2)

}