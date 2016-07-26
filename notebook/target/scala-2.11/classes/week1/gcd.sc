import scala.annotation.tailrec

val a = 100.0
val b = 99.0

b/a
a%b

@tailrec
def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)

// re-uses stack frame; re-writing sequence of constant size
// and therefore a computation that is executed in constant space

gcd(2,47)

// not tail-recursive
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

factorial(9)

// attempt tail-recursive (constant stack frame, no overflow)
// # imperative programming
def factorialRec(n: Int): Int = {
  def loop(acc: Int, n: Int) : Int =
    if (n == 0) acc // return accumulator instead of 1
    else loop(acc * n, n -1) // n not equal to 0
      loop(1, n) // initial value set as n==0
      // loop needs result type to compile
}

factorialRec(9)

// using 'helper function idiom' alternative (same as above)
def factorialAcc2(x: BigInt): BigInt = {
  @tailrec
  def f(x: BigInt, acc: BigInt): BigInt = {
    if (x == 0) acc else f(x -1, x * acc)
  }
  f(x, 1)
}

factorialAcc2(9)

// Pattern matched quivalent

def factorialPatt(x: BigInt) : BigInt =  {
  @tailrec
  def f(x:BigInt, acc: BigInt): BigInt = x match {
    case y: BigInt if y == 0 => acc
    case _ => f(x - 1, x * acc)
  }
  f(x,1)
}

factorialPatt(9)








