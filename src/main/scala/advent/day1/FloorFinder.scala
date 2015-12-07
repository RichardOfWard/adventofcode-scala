package advent.day1

class FloorFinder(input: String) {
  def findFinalFloor(): Int =
    floorsVisited.last

  def findIndexWhenFloorBecomesNegative(): Int =
    floorsVisited.indexOf(-1)

  def floorsVisited: IndexedSeq[Int] =
    directions.scanLeft(0)((prevFloor, direction) => prevFloor + direction)

  private def directions: IndexedSeq[Int] =
    input.map {
      case '(' => 1
      case ')' => -1
      case '\n' => 0
    }
}
