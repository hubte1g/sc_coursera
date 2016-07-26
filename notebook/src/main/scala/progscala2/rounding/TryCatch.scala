package progscala2.rounding

/**
  * Created by Kizmet4 on 7/25/2016.
  * Run with sbt 'run-main progscala2.rounding.TryCatch <filepath>
  */
object TryCatch {
  // src/main/scala/progscala2/rounding/TryCatch.scala
  /** Usage: scala rounding.TryCatch filename1 filename 2 .. */
  def main(args: Array[String]) = {
    args foreach (arg => countLines(arg))
  }

  import scala.io.Source
  import scala.util.control.NonFatal

  def countLines(fileName: String) = {
    println() // Add a blank line for legibility
    var source: Option[Source] = None
    try {
      source = Some(Source.fromFile(fileName))
      val size = source.get.getLines().size
      println(s"file $fileName has $size lines")
    } catch {
      case NonFatal(ex) => println(s"Non fatal exceoption! $ex")
    } finally {
      for (s <- source) {
        println(s"Closing $fileName...")
        s.close
      }
    }
  }
}
