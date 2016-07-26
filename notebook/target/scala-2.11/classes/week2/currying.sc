object currying {
  /*
   * Exercises to eventually define functions piecewise,
   *  one function parameter to another
   *
   * Write a function that calculates the product of the values of
   *  a function for the points on a given interval
   */
  def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1 // if bounds are empty return the Unit Value for multiplication (1)
  else f(a) * product(f)(a + 1, b)

  product(x => x * x)(3, 7)

  /*
   * Factorial example written in terms of product()
   */
  def factorial(n: Int) = product(x => x)(1, n)

  factorial(5)

  /*
   * Write a more general function that generalizes bot sum and product
   * This is in fact a version of MapReduce
   * Requires new parameter called 'combine' that takes two integers,
   * returns int with unit value (zero) which is the value to return if the interval is empty
   */

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  /*
   * Create version of product() that uses mapReduce()
   *
   */
  def mapReduceProduct(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a, b)

  mapReduceProduct(x => x * x)(3, 4)

}