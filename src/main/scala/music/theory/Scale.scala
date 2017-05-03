package music.theory

case class Scale(root: PitchClass, sounds: Set[Interval]) extends PitchClassSet {
  require(sounds.size > 0, "A scala sould have at least 1 interval")

  def name = {
    val suffix = PreDefScale.find(sounds) match {
      case Some(predef) => predef.suffix
      case None => "No-name"
    }
    root.name + suffix
  }

  def is(predef: PreDefScale): Boolean = PreDefScale.find(sounds) match {
    case Some(p) => p == predef
    case None => false
  }

  override def toString = "Scale(" + pitchClasses.map(_.name).mkString(", ") + ")"
}

object Scale {

  private val withAlteration = "([A-Za-z]{1})([#b]{0,1}\\s)([A-Za-z]*)".r

  def apply(root: PitchClass, sounds: Interval*): Scale = Scale(root, sounds.toSet)

  def apply(name: String): Scale = {
    val (rootName, prefix) = name match {
      case withAlteration(root, alt, prefix) => (root+alt.trim, prefix)
      case _ => throw new IllegalArgumentException(s"Impossible to parse the scale's name $name")
    }
    val root = PitchClass(rootName)
    val predef = PreDefScale.retrieve(prefix)
    predef match {
      case Some(p) => p.toScale(root)
      case None => throw new IllegalArgumentException(s"Impossible to find the scale $prefix")
    }
  }

}
