package music.theory

import org.scalatest.FlatSpec

class PositionTest extends FlatSpec {

  "A Position" should "throw an error if the numer is inferior to 0" in {
    val thrown = intercept[IllegalArgumentException] {
      val position = Position(-1, 9)
    }
    assert(thrown.getMessage == "requirement failed: The numer should be up or equal to 0")
  }

  it should "be instantiate taking the position (first bar, third beat, first 16th, first tick" in {
    implicit val signature = Signature(4)
    val position = Position(1, 3, 0, 0)
    assert(position.toFloat == 7)
  }
}
