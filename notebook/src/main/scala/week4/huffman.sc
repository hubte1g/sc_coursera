//package patmat

//import common._
import scala.collection.immutable._

abstract class CodeTree
  //def weight(tree: CodeTree): Int
case class Fork (left: CodeTree, right: CodeTree, chars:List[Char], weight: Int
                ) extends CodeTree
case class Leaf(char: Char, weight: Int) extends CodeTree

def weight(tree: CodeTree): Int = tree match {
  case Fork(_, _, _, weight) => weight
  case Leaf(_, weight) => weight
}

def chars(tree: CodeTree): List[Char] = tree match {
  case Fork(_, _, chars, _) => chars
  case Leaf(chars, _) => List(chars)
}

def makeCodeTree(left: CodeTree, right: CodeTree) =
  Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right))

def string2Chars(str: String): List[Char] = str.toList

def times(chars: List[Char]): List[(Char, Int)] = {
  def incr(acc: Map[Char, Int], c: Char) = {
    val count = (acc get c).getOrElse(0) + 1
    acc + ((c, count))
  }

  (Map[Char, Int]() /: chars)(incr).iterator.toList

}



val sampleTree = makeCodeTree(
  makeCodeTree(Leaf('x', 1), Leaf('e', 1)),
  Leaf('t', 2)
)

