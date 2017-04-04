package com.francoiscabrol.music.theory

import com.francoiscabrol.{RationalNumber}

case class Position(initialNumer: Int, initialDenom: Int = 1) extends RationalNumber[Position](initialNumer, initialDenom) with Ordered[Position] {

  def +(d: Duration): Position = this + Position(d.numer, d.denom)
  def -(d: Duration): Position = this - Position(d.numer, d.denom)

  override def compare(that: Position): Int = toFloat.compareTo(that.toFloat)

  override protected def makeNew(initialNumer: Int, initialDenom: Int): Position = Position(initialNumer, initialDenom)
}

case class NoteSequence(sequence: Map[Position, Note])

object NoteSequence {

  def createLinear(pitches: List[Pitch], start: Position): NoteSequence = {
    val notes = pitches.map(Note(_, Duration.WHOLE_NOTE))
    val sequence = notes.zip(Stream from start.initialNumer).toMap.mapValues(Position(_, 1)).map(_.swap)
    NoteSequence(sequence)
  }
}
