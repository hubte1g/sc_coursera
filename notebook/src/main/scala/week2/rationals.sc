object rationals {
  println("Welcome to the Scala worksheet for Rationals")
  val x: Rational = new Rational(1, 2)
  x.numer  // 'in-fix operator [dot]'  [object.member]
  x.denom
  // ? Must place members outside of object/class to run in worksheet
}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

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
