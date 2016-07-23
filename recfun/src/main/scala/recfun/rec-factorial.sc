// non-rec
def factorial(n: Int): Int =
  if (n == 0 ) 1 else n * factorial(n-1)

factorial(9)


def factRec(n: List[Int]) : Int = {
  n match {
    case x :: tail => tail * factRec(n-1)
    //case Nil => 0 /
  }
}

factRec(9)

def sum(xs: List[Int]): Int = {
  //'standard' approach, non-tail-recursive
  xs match {
    case x :: tail => x + sum(tail) // if there is an element, add it to the sum of the tail
    case Nil => 0 // if there are no elements, then the sum is 0
  } // tail-recursive: http://stackoverflow.com/questions/12496959/summing-values-in-a-list
}