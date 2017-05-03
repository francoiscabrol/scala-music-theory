package music.theory

import scala.collection.immutable.IndexedSeq
import scala.runtime.RangedProxy

case class Pitch(pitchClass: PitchClass, octave: Int) extends Ordered[Pitch] with RangedProxy[Pitch] with Comparable[Pitch] {

  def name: String = pitchClass.name + octave

  def integerNotation: Int = (12 * octave) + pitchClass.integerNotation

  def next(pitchClass: PitchClass): Pitch = Pitch(integerNotation + pitchClass.integerNotation)

  def add(that: Pitch) = Pitch(this.integerNotation + that.integerNotation)

  override def toString = "Pitch(" + name + ")"

  override def compare(that: Pitch): Int = integerNotation.compareTo(that.integerNotation)

  def canEqual(a: Any) = a.isInstanceOf[Pitch]

  override def equals(that: Any): Boolean = {
    that match {
      case p: Pitch => canEqual(this) && this.hashCode == that.hashCode
      case _ => false
    }
  }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + pitchClass.integerNotation;
    result = prime * result + (if (name == null) 0 else name.hashCode)
    return result
  }

  override type ResultWithoutStep = IndexedSeq[Pitch]

  override def until(end: Pitch): IndexedSeq[Pitch] = until(end, Pitch(1))

  override def until(end: Pitch, step: Pitch): IndexedSeq[Pitch] = for (i <- integerNotation until end.integerNotation by step.integerNotation) yield Pitch(i)

  override def to(end: Pitch, step: Pitch): IndexedSeq[Pitch] = for (i <- integerNotation to end.integerNotation by step.integerNotation) yield Pitch(i)

  override def to(end: Pitch): IndexedSeq[Pitch] = to(end, Pitch(1))

  override def self: Pitch = this

}

object Pitch {

  type Octave = Int

  val pattern = "([A-Za-z#]+)([0-9]+)".r

  private def parse(name: String):(PitchClass, Octave) = {
    try {
      val pattern(pitchClassString, octaveString) = name
      val pitchClass = PitchClass(pitchClassString)
      val octave = octaveString.toInt
      (pitchClass, octave)
    } catch {
      case _: Throwable => throw new IllegalArgumentException("Impossible to parse the pitch name '"+name+"'")
    }
  }

  def apply(name: String) = {
    val (pitchClass, octave) = parse(name)
    new Pitch(pitchClass, octave)
  }

  def apply(integerNotation: Int) = {
    val pitchClassInteger = integerNotation % 12
    val octave = (integerNotation - pitchClassInteger) / 12
    new Pitch(PitchClass(pitchClassInteger), octave)
  }
}
