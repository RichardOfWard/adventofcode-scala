package advent

import advent.utils.LightBank

object Day6 extends Day {
  val day = 6

  val misTranslatedToggle = (v: Boolean) => !v
  val misTranslatedTurnOn = (v: Boolean) => true
  val misTranslatedTurnOff = (v: Boolean) => false
  val misTranslatedOperations = Map[String, (Boolean => Boolean)](
    "toggle" -> misTranslatedToggle,
    "turn on" -> misTranslatedTurnOn,
    "turn off" -> misTranslatedTurnOff
  )
  val misTranslatedLightValueFunc = (i: Int, l: Boolean) => i + (if (l) 1 else 0)

  val toggle = (v: Int) => v + 2
  val turnOn = (v: Int) => v + 1
  val turnOff = (v: Int) => List(v - 1, 0).max
  val operations = Map[String, (Int => Int)](
    "toggle" -> toggle,
    "turn on" -> turnOn,
    "turn off" -> turnOff
  )
  val lightValueFunc = (i: Int, l: Int) => i + l


  val inputRegex = """(toggle|turn off|turn on) ([0-9]+),([0-9]+) through ([0-9]+),([0-9]+)""".r

  def runInputThroughLightBank[LightType](lightBank: LightBank[LightType]) =
    for (line <- loadInput().lines) {
      line match {
        case inputRegex(cmd, x1, y1, x2, y2) =>
          lightBank.namedOpOnRange(x1.toInt, y1.toInt, x2.toInt, y2.toInt, cmd)
      }
    }

  val lightBankForPart1 = new LightBank[Boolean](false, misTranslatedOperations, misTranslatedLightValueFunc)
  runInputThroughLightBank(lightBankForPart1)
  println("day 6 part 1: %d".format(lightBankForPart1.countLightState))

  val lightBankForPart2 = new LightBank[Int](0, operations, lightValueFunc)
  runInputThroughLightBank(lightBankForPart2)
  println("day 6 part 2: %d".format(lightBankForPart2.countLightState))
}
