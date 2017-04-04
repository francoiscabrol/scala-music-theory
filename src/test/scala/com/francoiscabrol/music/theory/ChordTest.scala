package com.francoiscabrol.music.theory

import org.scalatest.{FlatSpec, GivenWhenThen}

class ChordTest extends FlatSpec with GivenWhenThen {

  "Chord" should "be instantiate given D# and a major third interval" in {
    val chord = Chord(PitchClass("D#"), Interval.MAJOR_THIRD)
    assert(chord.root == PitchClass("D#"))
  }

  it should "contains the good pitchClasses given D# and a major third interval" in {
    val chord = Chord(PitchClass("D#"), Interval.MAJOR_THIRD)
    assert(chord.pitchClasses.map(_.name).mkString(", ") == "D#, G")
  }

  it should "be instantiate given D# with 3 intervals" in {
    val chord = Chord(PitchClass("D#"), Interval.MAJOR_THIRD, Interval.PERFECT_FIFTH)
    assert(chord.root == PitchClass("D#"))
  }

  it should "contains the good pitchClasses given D# with 3 intervals" in {
    val chord = Chord(PitchClass("D#"), Interval.MAJOR_THIRD, Interval.PERFECT_FIFTH)
    assert(chord.pitchClasses.map(_.name).mkString(", ") == "D#, G, A#")
  }

  it should "be instantiated given the name Abm" in {
    val chord = Chord("Abm")
    assert(chord.root == PitchClass("Ab"))
  }

  it should "be instantiated given the name Em" in {
    val chord = Chord("Em")
    assert(chord.root == PitchClass("E"))
  }

  it should "be instantiated given the name E" in {
    val chord = Chord("E")
    assert(chord.root == PitchClass("E"))
  }

  it should "be instantiated given the name Ebm" in {
    Given("a chord Ebm")
    val chord = Chord("Ebm")
    Then("the chord's root should be a pitch class Eb")
    assert(chord.root == PitchClass("Eb"))
    And("the chord should be minor")
    assert(chord.is(PreDefChord.MINOR))
    And("the chord should be major")
    assert(!chord.is(PreDefChord.MAJOR))
  }

}
