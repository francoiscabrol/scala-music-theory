package com.francoiscabrol.music.theory

case class PitchRange(min: Pitch, max: Pitch) {
  require(max > min, "The max pitch should be superior to the min pitch")

  def toSeq: IndexedSeq[Pitch] = for (i <- min.integerNotation until max.integerNotation + 1) yield Pitch(i)
//  def toSeq: IndexedSeq[Pitch] = Stream(min, max).toIndexedSeq

}
