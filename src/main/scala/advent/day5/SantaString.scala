package advent.day5

class SantaString(string: String) {
  private val hasAtLeastThreeVowels: Boolean = string.count("aeiou".toList.contains) >= 3

  private val hasALetterRepeatedConsecutively: Boolean = string.matches(".*([a-z])\\1.*")

  private val containsBadSequence: Boolean = SantaString.badSequences.exists(string.contains)

  var isNice: Boolean =
    (hasAtLeastThreeVowels
      && hasALetterRepeatedConsecutively
      && !containsBadSequence)

}

object SantaString {
  val badSequences = List("ab", "cd", "pq", "xy")
}
