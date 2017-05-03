package music.theory

import Interval._

case class PreDefScale(regex: String, sounds: Set[Interval]) {

  def apply(root: PitchClass) = toScale(root)

  def suffix: String = {
    regex.split("|")(0)
  }

  def toScale(root: PitchClass): Scale = new Scale(root, sounds)
}

object PreDefScale {
  def find(sounds: Set[Interval]): Option[PreDefScale] = values.find(p => p.sounds == sounds)

  def exists(predef: PreDefScale): Boolean = values.exists(p => p.sounds == predef.sounds)

  def apply(regex: String, sounds: Interval*): PreDefScale = PreDefScale(regex, sounds.toSet)

  def retrieve(suffix: String): Option[PreDefScale] = {
    values.find(_.regex.contains(suffix))
  }

  val MAJOR = PreDefScale("Major", MAJOR_SECOND, MAJOR_THIRD, PERFECT_FOUR, PERFECT_FIFTH, MAJOR_SIXTH, MAJOR_SEVEN)
  val MINOR = PreDefScale("Minor", MAJOR_SECOND, MINOR_THIRD, PERFECT_FOUR, PERFECT_FIFTH, MAJOR_SIXTH, MAJOR_SEVEN)

  val values = List(MAJOR, MINOR)
}