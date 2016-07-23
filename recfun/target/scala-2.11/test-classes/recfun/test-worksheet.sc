List(1,2,7) match {
  case x :: xf :: xm => println(x + " " + xf + ";" + xm + x)
  case _ => println("")
}

List(9,5) match {
  case x :: xs => println(x + " " + xs)
  case _ => println("")
}

val list = 8 +: 1 +: 2 +: Nil

1 :: Nil :: 9 :: Nil :: Nil

Nil

val l = List(1,2,3); val l2 = List(9,9)
val l3 = List(7,7,7,7)
l :: l2 :: l3

List(9,0,6).tail

