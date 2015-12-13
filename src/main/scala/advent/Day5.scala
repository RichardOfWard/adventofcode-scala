package advent

import advent.utils.SantaString

object Day5 extends Day {
  override protected def day: Int = 5

  def countNiceStrings = loadInput().lines.map(new SantaString(_)).count(_.isNice)

  println("Nice strings: %d".format(countNiceStrings))
}