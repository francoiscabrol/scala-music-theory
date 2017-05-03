package music.theory

case class Chord(root: PitchClass, sounds: Set[Interval]) extends PitchClassSet {
  require(sounds.size > 0, "A chord sould have at least 1 interval")

  def name = {
    val predef = PreDefChord(sounds)
    val suffix = predef.suffix
    root.name + suffix
  }

  def is(predef: PreDefChord) = PreDefChord(sounds) == predef

  override def toString = "Chord(" + pitchClasses.map(_.name).mkString(", ") + ")"
}

object Chord {

  private val withAlteration = "([A-Za-z]{1})([#b]{0,1})([A-Za-z0-9#b]*)".r

  def apply(root: PitchClass, sounds: Interval*): Chord = Chord(root, sounds.toSet)

  def apply(name: String): Chord = {
    val (rootName, enrichment) = name match {
      case withAlteration(root, alt, enrichment) => (root+alt, enrichment)
      case _ => throw new IllegalArgumentException(s"Impossible to parse the chord's name $name")
    }
    val root = PitchClass(rootName)
    val predef = PreDefChord.retrieve(enrichment)
    predef.newChord(root)
  }

}