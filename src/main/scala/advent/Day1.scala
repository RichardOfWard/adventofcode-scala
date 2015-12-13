package advent

import advent.utils.FloorFinder

object Day1 extends Day {
  val day = 1
  println("Final floor: %d".format(new FloorFinder(loadInput()).findFinalFloor()))
  println("First trip to basement at move %d".format(new FloorFinder(loadInput()).findIndexWhenFloorBecomesNegative()))
}
