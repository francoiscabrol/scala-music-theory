package music.theory

import org.scalatest.FlatSpec

class DurationTest extends FlatSpec {

  "A Duration" should "throw an error if the numer is inferior to 0" in {
    val thrown = intercept[IllegalArgumentException] {
      val duration = Duration(-1, 9)
    }
    assert(thrown.getMessage == "requirement failed: The numer should be up to 0")
  }

  it should "be instantiale from the enum" in {
    val duration = Duration.QUARTER_NOTE
    assert(duration.toFloat == 0.25f)
  }

  it should "return a dotted quater note" in {
    val duration = Duration.QUARTER_NOTE.dotted
    assert(duration.toFloat == 0.375f)
  }
}
