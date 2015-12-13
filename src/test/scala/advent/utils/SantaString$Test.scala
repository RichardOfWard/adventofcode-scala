package advent.utils

import org.scalatest.FlatSpec

class SantaString$Test extends FlatSpec {
  it should "reject strings without three vowels" in {
    checkExamples(
      List("", "ccc", "cccacac", "iecc"),
      expected = false
    )
  }

  it should "allow disallow strings with a repeated letter" in {
    checkExamples(
      List("axaxax"),
      expected = false
    )
  }

  it should "disallow strings with bad sequences: ab, cd, pq, xy" in {
    checkExamples(
      List("aaaxxab", "aaaxxcd", "pq", "aaakkxy"),
      expected = false
    )
  }

  it should "allow strings with three vowels and a letter repeated consecutively and no bad sequences" in {
    checkExamples(
      List("aaa", "eee", "iii", "ooo", "uuu", "aeizz", "xazegovzz", "aeiouaeiouaeiouzz", "ugknbfddgicrmopn"),
      expected = true
    )
  }

  it should "disallow bad examples provided" in {
    checkExamples(
      List("jchzalrnumimnmhp", "haegwjzuvuyypxyu", "dvszwmarrgswjxmb"),
      expected = false
    )
  }


  def checkExamples(examples: Iterable[String], expected: Boolean): Any = {
    for (example <- examples) {
      assertResult(expected, example)(new SantaString(example).isNice)
    }
  }
}
