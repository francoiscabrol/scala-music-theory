package music.theory

import music.{EnumOf, RationalNumber}

import scala.collection.immutable.IndexedSeq
import scala.language.postfixOps
import scala.runtime.RangedProxy

case class Duration(initialNumer: Int, initialDenom: Int) extends RationalNumber[Duration](initialNumer, initialDenom) with Ordered[Duration] with RangedProxy[Duration] with Comparable[Duration]  {
  require(initialNumer > 0, "The numer should be up to 0")
  require(initialDenom > 0, "The denom should be up to 0")

  override protected def makeNew(initialNumer: Int, initialDenom: Int): Duration = Duration(initialNumer, initialDenom)

  private def multiplyBy(i: Int) = {
    Duration(initialNumer, initialDenom) * Duration(i, 1)
  }
  def multiplyBy2 = multiplyBy(2)

  def dividedBy(i: Int) = Duration(initialNumer, initialDenom) * Duration(1, i)
  def dividedBy2 = dividedBy(2)

  override def compare(that: Duration): Int = toFloat.compareTo(that.toFloat)

  override type ResultWithoutStep = IndexedSeq[Duration]

  override def until(end: Duration): IndexedSeq[Duration] = until(end, Duration.zero)

  override def until(end: Duration, step: Duration): IndexedSeq[Duration] = {
    var buffer = List(Duration.zero)
    while(buffer.head < end) {
      val i = buffer.head + step
      buffer = i :: buffer
    }
    buffer.toIndexedSeq
  }

  override def to(end: Duration): IndexedSeq[Duration] = to(end, Duration.zero)

  override def to(end: Duration, step: Duration): IndexedSeq[Duration] = {
    var buffer = List(Duration.zero)
    while(buffer.head < end) {
      val i = buffer.head + step
      buffer = i :: buffer
    }
    buffer.toIndexedSeq
  }

  // TODO implement the dotted method

  override def self: Duration = ???

  override def toString = s"Duration($numer,$denom)"
}

object Duration extends EnumOf[Duration] {

  def zero = Duration(1, 1)

  val WHOLE_NOTE = Duration(1, 1) asValue
  val HALF_NOTE = WHOLE_NOTE dividedBy 2 asValue
  val QUARTER_NOTE = HALF_NOTE dividedBy 2 asValue
  val EIGHT_NOTE = QUARTER_NOTE dividedBy 2 asValue
  val SIXTEENTH_NOTE = EIGHT_NOTE dividedBy 2 asValue
}
