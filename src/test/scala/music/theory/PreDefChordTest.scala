package music.theory

import org.scalatest.FlatSpec

class PreDefChordTest extends FlatSpec {

  "A PreDef Chord" should "be instantiated" in {
    val chord = PreDefChord.MAJOR(PitchClass("A#"))
    assert(chord.name == "A#")
  }

  "A PreDef Chord Abm" should "be instantiated" in {
    val chord = PreDefChord.MINOR(PitchClass("Ab"))
    assert(chord.name == "Abm")
  }

}
