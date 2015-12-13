package advent.utils

import org.scalatest.FlatSpec

class SensibleSantaString$Test extends FlatSpec {
  it should "reject strings without a repeated pair" in {
    checkExamples(
      List("", "aaa"),
      expected = false
    )
  }

  it should "reject strings which don't container a letter whose repeat is separated by exactly 1 letter" in {
    checkExamples(
      List("", "aabbaa"),
      expected = false
    )
  }

  it should "accept provided valid examples" in {
    checkExamples(
      List("xyxy", "aabcdcfgaa", "qjhvhtzxzqqjkmpb", "xxyxx"),
      expected = true
    )
  }

  it should "reject provided invalid examples" in {
    checkExamples(
      List("uurcxstgmygtbstg", "ieodomkazucvgmuy"),
      expected = false
    )
  }

  def checkExamples(examples: Iterable[String], expected: Boolean): Any = {
    for (example <- examples) {
      assertResult(expected, example)(new SensibleSantaString(example).isNice)
    }
  }
}
