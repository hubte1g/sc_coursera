object cbn_example {
  @annotation.tailrec
  // src/main/scala/progscala2/rouunding/call-by-name.sc
  /**
    * Accepts two argument lists:
    * - a single by-name parameter that is conditional
    * - a single by-name value that is the body to be eval'd each iteration
    */
  def continue(conditional: => Boolean)(body: => Unit): Unit = {
    if (conditional) {
      //  test the condition
      body //  if still true evaluate body
      continue(conditional)(body) //  then call the continue recursively
    }
  }

  var count = 0
  continue(count < 6) {
    println(s"at $count")
    count += 1
  }

}