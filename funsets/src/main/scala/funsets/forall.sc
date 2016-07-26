def contains(s: Set, elem: Int): Boolean = s(elem)

val bound = 1000

def forall(s: Set, p: Int => Boolean): Boolean = {
  def iter(a: Int): Boolean = {
    if (a > bound) true   //   if _ > 1000
    else if (contains(s,a) && !p(a)) false
    else iter(a + 1)
  }

  iter(-bound)
}