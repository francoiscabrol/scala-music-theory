package music.theory

import org.scalatest.FlatSpec

class ScaleTest extends FlatSpec {

  "A Scale" should "be instantiate given 'A Minor'" in {
    val scala = Scale("A Minor")
    assert(scala.root == PitchClass("A"))
  }

  it should "be instantiate given A# Minor" in {
    val scala = Scale("A# Minor")
    assert(scala.root == PitchClass("A#"))
  }

  it should "be a minor scale given 'Ab Minor" in {
    val scala = Scale("Ab Minor")
    assert(scala.is(PreDefScale.MINOR))
  }

  it should "not be a minor scale given Ab Major" in {
    val scale = Scale("Ab Major")
    assert(!scale.is(PreDefScale.MINOR))
  }

  it should "be a major scale given Ab Major" in {
    val scale = Scale("Ab Major")
    assert(scale.is(PreDefScale.MAJOR))
  }

  it should "return the notes sorted in the right order" in {
    val scale = Scale("C Major")
    assert(scale.pitchClasses.map(_.name).mkString(", ") === "C, D, E, F, G, A, B")
  }

}
