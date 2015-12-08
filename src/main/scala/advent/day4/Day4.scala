package advent.day4

import java.security.MessageDigest

import advent.Day

object Day4 extends Day {
  override protected val day = 4

  var requiredPrefix1 = "00000"
  var requiredPrefix2 = "000000"

  var secretKey = loadInput().stripLineEnd

  var possibleCoinsForPart1: Iterator[Int] = 1.until(Int.MaxValue).iterator

  val validCoinsForPart1: Iterator[Int] =
    possibleCoinsForPart1.filter(
      coin => hash(coin).startsWith(requiredPrefix1)
    )


  val firstValidCoinForPart1 = validCoinsForPart1.next()
  println("first coin for part 1: %d".format(firstValidCoinForPart1))

  var possibleCoinsForPart2: Iterator[Int] = firstValidCoinForPart1.until(Int.MaxValue).iterator

  val validCoinsForPart2: Iterator[Int] =
    possibleCoinsForPart2.filter(
      coin => hash(coin).startsWith(requiredPrefix2)
    )

  val firstValidCoinForPart2 = validCoinsForPart2.next()
  println("first coin for part 2: %d".format(firstValidCoinForPart2))

  def hash(coin: Int): String = {
    md5("%s%d".format(secretKey, coin))
  }

  def md5(string: String): String = {
    MessageDigest.getInstance("MD5").digest(string.getBytes).map("%02x".format(_)).mkString
  }
}
