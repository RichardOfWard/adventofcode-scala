package day1

object Day1 extends App {
  private val fileName = "./src/main/resources/day1.txt"
  private val input = io.Source.fromFile(fileName).mkString
  private val floorFinder = new FloorFinder(input)
  println(floorFinder.findFinalFloor())
}
