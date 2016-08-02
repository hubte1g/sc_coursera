object intsets {
  println("Welcom to the Scala Intsets Worksheet")
  // new IntSet  // class IntSet is abstract, cannot be instantiated
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4
}

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(that: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false

  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  override def toString = "."

  def union(that: IntSet): IntSet = that
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x // if less than look in left subtree
    else if (x > elem) right contains x // if greater than look in right
    else true // element has been found (is equal to x)

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def toString = "{" + left + elem + right + "}"

  def union(that: IntSet): IntSet =
    ((left union right) // set without initial element
      union that) incl elem // union other set and include element back into the set
  /* Can assume that recursion will terminate:
   * Every call to union is on a set smaller than what we started with
   */
}

val t1 = new NonEmpty(3, new Empty, new Empty)
val t2 = t1 incl 4