package music.theory

import music.RationalNumber

case class NoteSequence(sequence: Map[Position, Note])

object NoteSequence {

  def createLinear(pitches: List[Pitch], start: Position): NoteSequence = {
    val notes = pitches.map(Note(_, Duration.WHOLE_NOTE))
    val sequence = notes.zip(Stream from start.initialNumer).toMap.mapValues(Position(_, 1)).map(_.swap)
    NoteSequence(sequence)
  }
}
