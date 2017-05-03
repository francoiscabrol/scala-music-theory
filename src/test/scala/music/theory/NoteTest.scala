package music.theory

import org.scalatest.FlatSpec

class NoteTest extends FlatSpec {

  "A Note" should "be instantiate given a Pitch A2" in {
    val note = Note(Pitch("A2"), Duration.QUARTER_NOTE)
    assert(note.duration == Duration.QUARTER_NOTE)
  }

  it should "be instantiate given a string A2" in {
    val note = Note("A2", Duration.QUARTER_NOTE)
    assert(note.duration == Duration.QUARTER_NOTE)
  }

}
