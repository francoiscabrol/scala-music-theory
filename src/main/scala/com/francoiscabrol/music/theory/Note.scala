package com.francoiscabrol.music.theory

case class Note(pitch: Pitch, duration: Duration)

object Note {
  def apply(pitchName: String, duration: Duration): Note = new Note(Pitch(pitchName), duration)
}
