package music.theory

import org.scalatest.FlatSpec

class PreDefScaleTest extends FlatSpec {

  "A PreDef Scale A# Major" should "be instantiated" in {
    val scale = PreDefScale.MAJOR(PitchClass("A#"))
    assert(scale.name == "A# Major")
  }

  "A PreDef Scale Ab Minor" should "be instantiated" in {
    val scale = PreDefScale.MINOR(PitchClass("Ab"))
    assert(scale.name == "Ab Minor")
  }

  "A Dm chord" should "match a specific list of scales" in {
    val classes = Chord("Dm").getListOfScales.map(_.name).mkString(", ")
    assert(classes.contains("D Minor Melodic"))
    assert(classes.contains("D Minor"))
  }

  "A E chord" should "match a specific list of scales" in {
    val chords = Chord("E").getListOfScales.map(_.name).mkString(", ")
    assert(chords.contains("E Major"))
  }

  "A F# chord" should "match a specific list of scales" in {
    val chords = Chord("F#m").getListOfScales.map(_.name).mkString(", ")
    assert(chords.contains("F# Minor Melodic"))
    assert(chords.contains("F# Minor"))
  }

  "A Cm chord" should "match a specific list of scales" in {
    val chords = Chord("Cm").getListOfScales.map(_.name).mkString(", ")
    assert(chords.contains("C Minor Melodic"))
    assert(chords.contains("C Minor"))
  }

  "isMatchRootDegree" should "work" in {
    val res = PreDefScale.isMatchRootDegree(List(3, 4), List(2, 1, 2, 2, 2, 1))
    assert(res === true)
  }
}
