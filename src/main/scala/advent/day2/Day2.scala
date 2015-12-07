package advent.day2

import advent.Day

object Day2 extends Day {
  val day = 2

  val boxes = loadInput().lines.map(parseBox).toSeq

  val paper = boxes.map(dims =>
      (dims(0) * dims(1) * 2
        + dims(1) * dims(2) * 2
        + dims(0) * dims(2) * 2
        + shortestTwoSides(dims).product
        ))
    .sum

  println("Paper required: %d".format(paper))


  val ribbon = boxes.map(dims =>
    (shortestTwoSides(dims).sum * 2
      + dims.product)
  ).sum

  println("Ribbon required: %d".format(ribbon))

  private def parseBox(line: String) = line.split('x').map(_.toInt)

  private def shortestTwoSides(dims: Array[Int]): Array[Int] = dims.sortWith(_ < _).slice(0, 2)
}
