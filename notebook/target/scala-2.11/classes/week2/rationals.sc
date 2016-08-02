object rationals {
  println("Welcome to the Scala worksheet for Rationals")
  val x: Rational = new Rational(1, 2)
  x.numer  // 'in-fix operator [dot]'  [object.member]
  x.denom
  // ? Must place members outside of object/class to run in worksheet
}

class Rational(x: Int, y: Int) {  // 'initialization code'
  /** private gcd() and g so that clients of class Rational() cannot see gcd as it is
    * for implementation purposes only
    * Can only be accessed from inside the Rational() class
    * DATA ABSTRACTION
    */
  // preconditions
  require(y != 0, "denominator must be nonzero")
  //require(y > 0, "denominator must be positive")

  def this(x: Int) = this(x, 1)  // secondary constructor // new Rational(2)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x,y)  // calculate gcd immediately so that its val can be reused in the calcs of numer and denom
  // def numer = x
  // def denom = y
  def numer = x / g
  def denom = y / g

  def less(that: Rational) = numer * that.denom < that.numer * denom
  // Note that a simple name x, which refers to another member of the class,
  //  is an abbreviation of this.x -- an equivalent would be:
  //   def less(that: Rational) = this.numer * that.denom < that.numer * this.denom

  /* if current rational number (this) < other rational number (that) then (that) otherwise current (this)
   * Note: fp can can use 'this' or 'self' // refers to rational number as whole
   *  On the inside of a class, the name 'this' represents the object on
   *  which the current method is executed
   */
  // `this` represents the object on which the current method is executed
  def max(that: Rational) = if (this.less(that)) that else this

  def add(that: Rational) =
    new Rational(
    numer * that.denom + that.numer * denom,
    denom * that.denom)

  def neg: Rational = new Rational(-numer, denom)  // evaluates to -x

  def sub(that: Rational) = add(that.neg) // subtract by add paramater [that] negated

  override def toString = numer + "/" + denom

}

/* Use Rational class as pure data type to implement arithmetic
 *
 */
def addRational(r: Rational, s: Rational): Rational =
new Rational(
  r.numer * s.denom + s.numer * r.denom,
  r.denom * s.denom)

def makeString(r: Rational) =
  r.numer + "/" + r.denom

makeString(addRational(new Rational(1, 2), new Rational(2,3)))

val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)
//val x: Rational = new Rational(1, 2)
  x.numer  // 'in-fix operator [dot]'  [object.member]
  x.denom
//val y = new Rational(2,3)
x.add(y)

x.neg
x.sub(y).sub(z)

// LECTURE 2.6
y.add(y)  //  must still simplify rational number  // works after gcd() add to Rational()

x.less(y) // true
x.max(y) // gives max

val strange = new Rational (1, 9)  // must make exception with require()
//strange.add(strange)// add `strange` to itself

new Rational(90)

