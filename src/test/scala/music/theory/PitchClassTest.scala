package music.theory

import org.scalatest.FlatSpec

class PitchClassTest extends FlatSpec {

  "A PitchClass" should "throw an error" in {
    val thrown = intercept[IllegalArgumentException] {
      val pitch = PitchClass("prout")
    }
    assert(thrown.getMessage == "requirement failed: Should be a valid pitch class")
  }

  it should "be instantiate" in {
    val pitch = PitchClass("Ab")
    assert(pitch.name(Alteration.Bemol) == "Ab")
  }

  "PitchClass.all" should "list all the pitch classes for Sharps" in {
    assert(PitchClass.all.map(_.name).mkString(", ") == "C, C#, D, D#, E, F, F#, G, G#, A, A#, B")
  }

  it should "list all the pitch classes for Bemols" in {
    assert(PitchClass.all.map(_.name(Alteration.Bemol)).mkString(", ") == "C, Db, D, Eb, E, F, Gb, G, Ab, A, Bb, B")
  }

  "PitchClass.integerNotation" should "return the integer notation" in {
    val i = PitchClass("D").integerNotation
    assert(i == 2)
  }
}
