package music.theory

trait PitchClassSet {
  val root: PitchClass
  val sounds: Set[Interval]

  def pitchClasses: Array[PitchClass] = root +: sounds.map(_.pitchClassRelativeTo(root)).toArray

  def transposeTo(octave: Int): Array[Pitch] = pitchClasses.map(pitchClass => Pitch(pitchClass, octave))
}