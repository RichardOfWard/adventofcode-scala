package advent

import advent.utils.{SensibleSantaString, SantaString}

object Day5 extends Day {
  override protected def day: Int = 5

  def countNiceStrings = loadInput().lines.map(new SantaString(_)).count(_.isNice)

  println("Nice strings (part 1): %d".format(countNiceStrings))

  def countSensibleNiceStrings= loadInput().lines.map(new SensibleSantaString(_)).count(_.isNice)

  println("Nice strings (part 2): %d".format(countSensibleNiceStrings))
}
