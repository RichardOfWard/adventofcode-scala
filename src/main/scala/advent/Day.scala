package advent

import scala.io.Source

trait Day extends App {
  protected def day: Int

  def loadInput(): String = {
    val fileName = "./src/main/resources/day%d.txt".format(day)
    Source.fromFile(fileName).mkString
  }
}
