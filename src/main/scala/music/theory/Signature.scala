package music.theory

// Example Signature(4, 4)
case class Signature(timeUnitsPerBar:Int, timeUnit: Int) {
  require(Array(1, 2, 4, 8).contains(timeUnit), "The time unit should be 1, 2, 4 or 8")
  def timeUnitDuration: Duration = timeUnit match {
    case 1 => Duration.WHOLE_NOTE
    case 2 => Duration.HALF_NOTE
    case 4 => Duration.QUARTER_NOTE
    case 8 => Duration.EIGHT_NOTE
  }

  def quarterNotesPerBar: Int = ((timeUnitDuration / Duration.QUARTER_NOTE).toFloat * timeUnitsPerBar).toInt
}
