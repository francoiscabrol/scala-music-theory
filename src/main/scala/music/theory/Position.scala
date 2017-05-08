package music.theory

import music.RationalNumber

case class Position private(initialNumer: Int, initialDenom: Int = 1) extends RationalNumber[Position](initialNumer, initialDenom) with Ordered[Position] {

  require(initialNumer >= 0, "The numer should be up or equal to 0")
  require(initialDenom > 0, "The denom should be up to 0")

  type Bar = Int
  type Beat = Int
  type Sixteenth = Int
  type Tick = Int

  def +(d: Duration): Position = this + Position(d.numer, d.denom)
  def -(d: Duration): Position = this - Position(d.numer, d.denom)

  def destructure(implicit signature: Signature): (Bar, Beat, Sixteenth, Tick)  = {
    val bar = (numer / denom) / signature.quarterNotesPerBar
    val beat = (numer / denom) % signature.quarterNotesPerBar
    val subticks = (numer * (240 * 16)) / denom - (240*16*(bar*4+beat))
    val sixteenth = subticks / 240
    val tick = subticks % 240
    (bar, beat, sixteenth, tick)
  }

  override def compare(that: Position): Int = toFloat.compareTo(that.toFloat)

  override protected def makeNew(initialNumer: Int, initialDenom: Int): Position = Position(initialNumer, initialDenom)
}

// Like for reason: http://www.iu.edu/~emusic/361/rsn-timing.htm
// (number of bar, number of beat, number of 16th (of beat), number of tick (240 tick/16th))
object Position {

  def zero: Position = Position(0)

  def apply(bar: Int, beat: Int, sixteenth: Int, tick: Int)(implicit signature: Signature): Position = {
    val beats = bar * signature.quarterNotesPerBar + beat
    val subticks = sixteenth * 240 + tick
    val position = new Position(beats, 1) + new Position(subticks, 240 * 16)
    position
  }
}
