package advent.utils

class SensibleSantaString(string: String) {
  private def hasRepeatedPair: Boolean = string.matches( """^.*([a-z][a-z]).*\1.*$""")

  var isNice: Boolean = hasRepeatedPair && string.matches("""^.*([a-z]).\1.*$""")
}
