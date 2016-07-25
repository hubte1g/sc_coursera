import javax.annotation.Resource
// Exhibits the idea of 'separation of concerns'
// rerun with -feature
//set scalacOptions += "-feature"
import scala.util.control.NonFatal

// src/main/progscala2/rounding/TryCatchArm.scala
// example: a reusable application resource manager

object manage {
  def apply[
    R <: {def close(): Unit},
    T]
    (resource: => R)  // 'by-name' parameter, a function we call without parentheses
    (f: R => T) = {
    var res: Option[R] = None
    try {
      res = Some(resource)  // is a val // Only reference 'resource' Once !!
      // ESSENTIALLY becomes // val res = Some(Source.fromFile(filename))
      f(res.get)
    } catch {
      case NonFatal(ex) => println(s"Non fatal exception! $ex")
    } finally {
      if (res != None) {
        println(s"Closing resource...")
        res.get.close
      }
    }
  }
}
// continue p.88
object TryCatchARM {???}