package com.francoiscabrol.music.theory

import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

class PitchTest extends FlatSpec with Matchers with GivenWhenThen {

  "A Pitch" should "throw an error" in {
    val thrown = intercept[IllegalArgumentException] {
      val pitch = Pitch("prout")
    }
    assert(thrown.getMessage == "Impossible to parse the pitch name 'prout'")
  }

  it should "be instantiate" in {
    val pitch = Pitch("Ab2")
    assert(pitch.name == "Ab2")
  }

  it should "return the next pitch for a given pitchclass when next() is called" in {
    Given("the pitch C0")
    val C0 = Pitch("C0")
    When("called next A")
    val pitch = C0 next PitchClass("A")
    Then("the returned pitch should be A0")
    assert(pitch == Pitch("A0"))
  }

  it should "be compared" in {
    (Pitch("D5") == Pitch("D5")) should be (true)
    (Pitch("D5") == Pitch("D#5")) should be (false)
  }

  it should "return the hashCode" in {
    Pitch("C4").hashCode() shouldBe a [Integer]
  }
}
