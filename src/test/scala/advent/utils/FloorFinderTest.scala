package advent.utils

import org.scalatest.FlatSpec

class FloorFinderTest extends FlatSpec {
  it should "start on floor 0" in {
    assertFloorForInput(0, "")
  }

  it should "go up a floor for an open parenthesis" in {
    assertFloorForInput(1, "(")
  }

  it should "go down a floor for an open parenthesis" in {
    assertFloorForInput(-1, ")")
  }

  it should "track floors correctly" in {
    assertFloorForInput(2, "(()(())))(((")
  }

  it should "ignore newlines" in {
    assertFloorForInput(0, "\n")
  }

  it should "find index where the floor first becomes -1" in {
    assertResult(5) {
      new FloorFinder("(())))").findIndexWhenFloorBecomesNegative()
    }
  }

  private def assertFloorForInput(expected: Int, input: String): Unit = {
    assertResult(expected) {
      new FloorFinder(input).findFinalFloor()
    }
  }
}
