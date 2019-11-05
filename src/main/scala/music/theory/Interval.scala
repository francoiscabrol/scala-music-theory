package music.theory

class Interval(val semitones: Int) {

  def +(interval: Interval): PreDefChord = PreDefChord(this, interval)

  def pitchClassRelativeTo(root: PitchClass): PitchClass = Pitch(root.integerNotation + semitones).pitchClass
}

object Interval {

  case object I0 extends Interval(0)
  case object I1 extends Interval(1)
  case object I2 extends Interval(2)
  case object I3 extends Interval(3)
  case object I4 extends Interval(4)
  case object I5 extends Interval(5)
  case object I6 extends Interval(6)
  case object I7 extends Interval(7)
  case object I8 extends Interval(8)
  case object I9 extends Interval(9)
  case object I10 extends Interval(10)
  case object I11 extends Interval(11)
  case object I12 extends Interval(12)

  val PERFECT_UNISON, DIMINISHED_SECOND = I0
  val MINOR_SECOND, AUGMENTED_UNISION = I1
  val MAJOR_SECOND, DIMINISHED_THIRD = I2
  val MINOR_THIRD, AUGMENTED_SECOND = I3
  val MAJOR_THIRD, DIMINISHED_FOURTH = I4
  val PERFECT_FOUR, AUGMENTED_THIRD = I5
  val DIMINISHED_FIFTH, AUGMENTED_FOURTH = I6
  val PERFECT_FIFTH, DIMINISHED_SIXTH = I7
  val MINOR_SIXTH, AUGMENTED_FIFTH = I8
  val MAJOR_SIXTH, DIMINISHED_SEVENTH = I9
  val MINOR_SEVEN, AUGMENTED_SIXTH = I10
  val MAJOR_SEVEN, DIMINISHED_OCTAVE = I11
  val PERFECT_OCTAVE, AUGMENTED_SEVEN = I12
}