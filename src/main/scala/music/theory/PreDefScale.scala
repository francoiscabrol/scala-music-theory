package music.theory

import Interval._

case class PreDefScale(regex: String, sounds: Set[Interval]) {

  def apply(root: PitchClass) = toScale(root)

  def suffix: String = {
    regex
  }

  def toScale(root: PitchClass): Scale = new Scale(root, sounds)
}

object PreDefScale {
  def find(sounds: Set[Interval]): Option[PreDefScale] = values.find(p => p.sounds == sounds)

  private def getIntervals(sounds: Set[Interval]): List[Int] = {
    var previous: Int = 0;
    val l = sounds.toSeq.sorted.map(s => {
      val res = s.semitones - previous
      previous = s.semitones
      res
    })
    l.toList
  }

  def isMatchRootDegree(thisIntervals: List[Int], intervals: List[Int], count: Int = 0, acc: Int = 0): Boolean = {
      if (thisIntervals.isEmpty || intervals.isEmpty) {
        false
      }

      val interval = thisIntervals(0)
      val value = intervals(0)

      if (acc + value == interval) {
        if (thisIntervals.size == 1) {
          true
        } else {
          isMatchRootDegree(thisIntervals.drop(1), intervals.drop(1), count + 1, 0)
        }
      } else if (acc + value > interval) {
        false
      } else {
        isMatchRootDegree(thisIntervals, intervals.drop(1), count + 1, acc + value)
      }
  }

  type Degree = Int

  def findContain(root:PitchClass, sounds: Set[Interval]): List[Scale] = {
    val thisIntervals = getIntervals(sounds)
    values.map(p => {
      // Compute the scale's intervals
      val intervals = getIntervals(p.sounds)
      //p.sounds.intersect(sounds).size >= sounds.size
      val matched = for (i <- 0 until 12) yield (isMatchRootDegree(thisIntervals, intervals.drop(i) ::: intervals.take(i)), i)
      matched.filter(value => value._1).map(value => p(Pitch(root.integerNotation + value._2).pitchClass))
    }).flatten
  }

  def exists(predef: PreDefScale): Boolean = values.exists(p => p.sounds == predef.sounds)

  def apply(regex: String, sounds: Interval*): PreDefScale = PreDefScale(regex, sounds.toSet)

  def retrieve(suffix: String): Option[PreDefScale] = {
    values.find(_.regex.contains(suffix))
  }

  val MAJOR = PreDefScale("Major", MAJOR_SECOND, MAJOR_THIRD, PERFECT_FOUR, PERFECT_FIFTH, MAJOR_SIXTH, MAJOR_SEVEN)
  val MINOR = PreDefScale("Minor", MAJOR_SECOND, MINOR_THIRD, PERFECT_FOUR, PERFECT_FIFTH, MINOR_SIXTH, MINOR_SEVEN)
  val MINOR_MELODIC = PreDefScale("Minor Melodic", MAJOR_SECOND, MINOR_THIRD, PERFECT_FOUR, PERFECT_FIFTH, MAJOR_SIXTH, MAJOR_SEVEN)

  val values = List(MAJOR, MINOR, MINOR_MELODIC)
}