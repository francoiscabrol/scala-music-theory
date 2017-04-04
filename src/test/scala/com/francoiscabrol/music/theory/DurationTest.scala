package com.francoiscabrol.music.theory

import org.scalatest.FlatSpec

class DurationTest extends FlatSpec {

  "A Duration" should "throw an error" in {
    val thrown = intercept[IllegalArgumentException] {
      val duration = Duration(-1, 9)
    }
    assert(thrown.getMessage == "requirement failed: The time should be up to 0")
  }

  "A Duration" should "be instantiale from enumration" in {
    val duration = Duration.QUARTER_NOTE
    assert(duration.toFloat == 0.25f)
  }
}
