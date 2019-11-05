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
    val classes = Chord("C").pitchClasses
    println(classes)
    // println(classes.getListOfScales.map(_.name))
    assert(true)
  }
}
