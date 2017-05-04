import music.theory._

//val numer = 2
//val denom = 4
//val bar = (numer / denom) / 4
//val beat = (numer / denom) % 4
//// (240 ticks per beats)
//val subticks = (numer * (240 * 16)) / denom - (240*16*(bar*4+beat))
//val sixteenth = subticks / 240
//val tick = subticks % 240

implicit val signature = Signature(4)
//
//val bar = 1
//val beat = 2
//val sixteenth = 0
//val tick = 0
//
//val beats = bar * signature.numberOfBeatsPerBar + beat
//val subticks = sixteenth * 240 + tick
//val p1 = new Position(beats, 1)
//val p2 = new Position(subticks, 240 * 16)
//val position = new Position(beats, 1) + new Position(subticks, 240 * 16)
//
val position = Position(1, 2, 0, 0)
val des = position.destructure
