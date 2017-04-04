package com.francoiscabrol.music.theory

import org.scalatest.FlatSpec

class PitchRangeTest extends FlatSpec {
  "PitchRange" should "be instantiate" in {
    val range = PitchRange(Pitch("C2"), Pitch("D3"))
    assert(range.toSeq.map(_.name).mkString(",") == "C2,C#2,D2,D#2,E2,F2,F#2,G2,G#2,A2,A#2,B2,C3,C#3,D3")
  }
}
