package advent.day3

import scala.collection.mutable

class Deliverer(var houses: mutable.Set[(Int, Int)]) {
  var currentLocation = (0, 0)

  def deliverToNext(direction: Char) = {
    houses.add(currentLocation)
    direction match {
      case '>' =>
        currentLocation = (currentLocation._1 + 1, currentLocation._2)
        houses.add(currentLocation);
      case '<' =>
        currentLocation = (currentLocation._1 - 1, currentLocation._2)
        houses.add(currentLocation)
      case '^' =>
        currentLocation = (currentLocation._1, currentLocation._2 + 1)
        houses.add(currentLocation)
      case 'v' =>
        currentLocation = (currentLocation._1, currentLocation._2 - 1)
        houses.add(currentLocation)
      case '\n' => ()
    }
    houses.add(currentLocation)
  }
}
