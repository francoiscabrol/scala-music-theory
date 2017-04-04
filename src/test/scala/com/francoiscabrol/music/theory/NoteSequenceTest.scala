package com.francoiscabrol.music.theory

import org.scalatest.FlatSpec
import Duration._

class NoteSequenceTest extends FlatSpec {

  "A NoteSequence" should "be create given a pitch list" in {
    NoteSequence.createLinear(List(Pitch("A2"), Pitch("C3")), Position(0))
  }
}
