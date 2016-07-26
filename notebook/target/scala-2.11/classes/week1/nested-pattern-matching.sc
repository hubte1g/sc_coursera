object nested {
  /* function that removes zero indexed
   * nth element from the supplied list and
   * returns the resulting list.
   * First attempt transcribes step-by-step
   * thought approach. **Exhibits code duplication**
   */
  def removeAt[T](n: Int, xs: List[T]): List[T] = n match {
    case 0 => xs match {
      case Nil => Nil
      case y :: ys => removeAt(n - 1, ys)
    }
    case _ => xs match {
      case Nil => Nil
      case y :: ys => y :: removeAt(n - 1, ys)
    }
  }

  /* second attempt extracts duplicate cases outside of the match.
   * Meets goals but blends if logic with pattern matching.
   * yields warnings that match may not be exhaustive
   */
  def removeAtDeDup[T](n: Int, xs: List[T]): List[T] =
  if (xs.isEmpty) Nil
  else n match {
    case 0 => xs match {
      case y :: ys => removeAtDeDup(n - 1, ys)
    }
    case _ => xs match {
      case y :: ys => y :: removeAtDeDup(n - 1, ys)
    }
  }

  /* next simplification attempt
   * Inverst the order of the high level pattern match subjects
   * by making the subject that's being pattern matched redundantly
   * rise to become primary pattern match with the other subject then
   * becoming secondary
   */
  def removeAtFin[T](n: Int, xs: List[T]): List[T] =
    xs match {
      case Nil => Nil
      case y :: ys => n match {
        case 0 => removeAtFin(n - 1, ys)
        case _ => y :: removeAt(n - 1, ys)
      }
    }

  /* Bonus: Most concise nested pattern matching
   *
   */
  def removeAtConcise[T](n: Int, xs: List[T]): List[T] =
  (xs take n) ::: (xs drop n+1)
}

