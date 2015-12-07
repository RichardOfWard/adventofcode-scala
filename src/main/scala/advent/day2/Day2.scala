package advent.day2

import advent.Day

object Day2 extends Day {
  val day = 2

  val paper = loadInput().lines
    .map(parseBox)
    .map(dims =>
      (dims(0) * dims(1) * 2
        + dims(1) * dims(2) * 2
        + dims(0) * dims(2) * 2
        + dims.sortWith(_<_).slice(0, 2).product
        ))
    .sum

  println(paper)

  private def parseBox(line: String) = {
    line.split('x').map(_.toInt)
  }
}
