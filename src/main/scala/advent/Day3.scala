package advent

import advent.utils.Deliverer


object Day3 extends Day {
  val day = 3

  def findHousesWithSantaDelivering() = {
    val houses = new scala.collection.mutable.HashSet[(Int, Int)]()
    val santa = new Deliverer(houses)

    loadInput().foreach(santa.deliverToNext)

    houses.size
  }

  def findHousesWithSantaAndRobotHelper() = {
    val houses = new scala.collection.mutable.HashSet[(Int, Int)]()
    val santa = new Deliverer(houses)
    val robotSanta = new Deliverer(houses)

    val instructionRecipientOrder = Iterator.continually(List(santa, robotSanta)).flatten

    instructionRecipientOrder.zip(loadInput().iterator).foreach {
      case (deliverer, direction) => deliverer.deliverToNext(direction)
    }

    houses.size
  }

  println("With santa working alone: %d".format(findHousesWithSantaDelivering()))

  println("With santa working with robot helper: %d".format(findHousesWithSantaAndRobotHelper()))
}
