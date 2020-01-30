package music.theory
import scala.collection.SortedSet

class PitchClassSet(root: PitchClass, sounds: Set[Interval]) {
  def pitchClasses: Array[PitchClass] = root +: sounds.to[SortedSet].map(_.pitchClassRelativeTo(root)).toArray

  def transposeTo(octave: Int): Array[Pitch] = pitchClasses.map(pitchClass => Pitch(pitchClass, octave))

  def getListOfScales: List[Scale] = PreDefScale.findContain(root, sounds)

  override def toString = "PitchClassSet(" + pitchClasses.map(_.name).mkString(", ") + ")"
}

object PitchClassSet {

  def apply(pitchClasses: Array[PitchClass]): PitchClassSet = {
    val root = pitchClasses(0)
    val intervals = pitchClasses.map(_.intervalWith(root)).toSet
    new PitchClassSet(root, intervals)
  }
}