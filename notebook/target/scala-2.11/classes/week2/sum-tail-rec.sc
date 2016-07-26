object session2 {
  println("Tail recursive version of a sum")

  // higher order functions introduction
  // uses 'identity function =>
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int =
    /*
     * terminate if lower bound is greater than upper bound
     * return accumulator if true
     */
      if (a > b) acc
      /*
       * initial bound is incremented by 1,
       * f() applied to a plus previous accumulator
       */
      else loop(a + 1, f(a) + acc)

    loop(a, 0) // (initial lower bound, initial acc val)
  }

  // test
  sum(x => x * x, 3, 5)


  /* re-write sum as fuction that returns another function
   * Returned function sumF applies the given function parameter f and sums results
   */
  def sum2(f: Int => Int): (Int, Int) => Int = {
    // locally define function in body and do computation of two bounds
    def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
    sumF
  }

  // ?
  sum2(x => x + x)(6,5)

  /* rewrite for conciseness
   * What is the type? It is a function that takes a function as argument,
   * and returns a function that takes two integers as argument and returns and integer
   * Int => Int => Int is actually Int => (Int => Int)
   */
  def sumC(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sumC(f)(a + 1, b)

  // ?
  sumC(x => x + x)(6,5)

}