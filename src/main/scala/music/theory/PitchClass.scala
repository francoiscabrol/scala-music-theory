package music.theory

object Alteration extends Enumeration {
  val Sharp, Bemol = Value
}

case class PitchClass(integerNotation: Int, alteration: Alteration.Value = Alteration.Sharp ) extends Ordered[PitchClass] {
  require(Range(0, 12).contains(integerNotation), "Should be a valid pitch class")

  def name: String = name(alteration)

  def name(alteration: Alteration.Value): String = {
    alteration match {
      case Alteration.Sharp => PitchClass.basicSharp(integerNotation)
      case Alteration.Bemol => PitchClass.basicBemol(integerNotation)
    }
  }

  override def toString = "PitchClass(" + name + ")"

  override def compare(that: PitchClass): Int = integerNotation.compareTo(that.integerNotation)
}

object PitchClass {
  val basic = Array("C", "D", "E", "F", "G", "A", "B")
  val basicBemol = Array("C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B")
  val basicSharp = Array("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
  val all = for (i <- 0 until 12) yield PitchClass(i)

  private def parse(name: String): (Int, Alteration.Value) = {
    if (basicBemol.contains(name))
      (basicBemol.indexOf(name), Alteration.Bemol)
    else
      (basicSharp.indexOf(name), Alteration.Sharp)
  }

  def apply(name: String): PitchClass = {
    val (integerNotation, alteration) = parse(name)
    new PitchClass(integerNotation, alteration)
  }
}
