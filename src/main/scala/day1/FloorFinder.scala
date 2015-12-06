package day1

class FloorFinder(input: String) {
  def findFinalFloor(): Int =
    input
      .map {
        case '(' => 1
        case ')' => -1
        case '\n' => 0
      }
      .sum
}
