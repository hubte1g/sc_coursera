object sqrtIter {
  // println("Welcome to sqrtIter worksheet")

  def abs(x: Double) = if (x < 0) -x else x

  // blockas are expressions in Scala

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess // predicate
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.0000001 // smaller than some epsilon value
    /* abs val must be proportionate to epsilon,
     * otherwise small numbers will not have precision
     * or large numbers will not terminate
     */
    def improve(guess: Double) =
    (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  sqrt(2)
  sqrt(4)

  sqrt(1e-6)
  sqrt(1e60)

}

