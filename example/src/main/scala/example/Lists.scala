package example


object Lists {

  /**
    * This method computes the sum of all elements in the list xs. There are
    * multiple techniques that can be used for implementing this method, and
    * you will learn during the class.
    *
    * For this example assignment you can use the following methods in class
    * `List`:
    *
    *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
    *  - `xs.head: Int` returns the head element of the list `xs`. If the list
    * is empty an exception is thrown
    *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
    * list `xs` without its `head` element
    *
    * ''Hint:'' instead of writing a `for` or `while` loop, think of a recursive
    * solution.
    *
    * @param xs A list of natural numbers
    * @return The sum of all elements in `xs`
    */
  def sum(xs: List[Int]): Int = {
    //'standard' approach, non-tail-recursive
    xs match {
      case x :: tail => x + sum(tail) // if there is an element, add it to the sum of the tail
      case Nil => 0 // if there are no elements, then the sum is 0
    } // tail-recursive: http://stackoverflow.com/questions/12496959/summing-values-in-a-list
  }

  /**
    * This method returns the largest element in a list of integers. If the
    * list `xs` is empty it throws a `java.util.NoSuchElementException`.
    *
    * You can use the same methods of the class `List` as mentioned above.
    *
    * ''Hint:'' Again, think of a recursive solution instead of using looping
    * constructs. You might need to define an auxiliary method.
    *
    * @param xs A list of natural numbers
    * @return The largest element in `xs`
    * @throws java.util.NoSuchElementException if `xs` is an empty list
    */
  /*   def max(xs: List[Int]): Option[Int]= xs match {
      case Nil => None
      case List(x: Int) => Some(x)
      case x :: y :: rest => max( (if (x > y) x else y) :: rest )
    }  //  http://stackoverflow.com/questions/19044114/how-to-find-the-largest-element-in-a-list-of-integers-recursively
  }
*/
  def max[T](xs: List[T])(implicit ord: Ordering[T]): T = xs match {
    case Nil => throw new NoSuchElementException("max of empty list")
    case head :: Nil => head
    case head :: tail => ord.max(head, max(tail))
  }  //  http://stackoverflow.com/questions/12506791/scala-implement-a-generic-recursive-max-function
}
