package advent.day3

import advent.Day

import scala.collection.mutable

object Day3 extends Day {
  val day = 3

  var houses = new mutable.HashSet[(Int, Int)]()
  var location = (0, 0)
  houses.add(location)

  loadInput().foreach {
    case '>' => location = (location._1 + 1, location._2); houses.add(location)
    case '<' => location = (location._1 - 1, location._2); houses.add(location)
    case '^' => location = (location._1, location._2 + 1); houses.add(location)
    case 'v' => location = (location._1, location._2 - 1); houses.add(location)
    case '\n' => ()
  }

  println(houses.size)
}
