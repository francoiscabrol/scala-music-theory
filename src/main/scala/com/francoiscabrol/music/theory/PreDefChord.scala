package com.francoiscabrol.music.theory

import Interval._

import scala.collection.mutable.ListBuffer

case class PreDefChord(sounds: Set[Interval]) {

  def apply(root: PitchClass) = newChord(root)

  def +(interval: Interval): PreDefChord = PreDefChord(sounds + interval)

  def suffix: String = {
    val name = new StringBuilder()
    if (sounds.contains(MINOR_THIRD)) name ++= "m"
    if (sounds.contains(DIMINISHED_THIRD) && sounds.contains(DIMINISHED_FIFTH)) name ++= "dim"
    if (sounds.contains(MAJOR_SEVEN)) name ++= "7M"
    if (sounds.contains(MINOR_SEVEN)) name ++= "7"
    name.toString
  }

  def newChord(root: PitchClass): Chord = new Chord(root, sounds)
}

object PreDefChord {

  def apply(sounds: Interval*): PreDefChord = PreDefChord(sounds.toSet)

  def retrieve(suffix: String): PreDefChord = {
    var l = ListBuffer[Interval]()
    if (suffix.contains("m")) l ++= MINOR.sounds
    else if (suffix.contains("dim")) l ++= DIMINISHED.sounds
    else l ++= MAJOR.sounds
    if (suffix.contains("7")) l += Interval.MINOR_SEVEN
    else if (suffix.contains("7M")) l += Interval.MAJOR_SEVEN
    PreDefChord(l.toSet)
  }

  val MAJOR = PreDefChord(MAJOR_THIRD, PERFECT_FIFTH)
  val MINOR = PreDefChord(MINOR_THIRD, PERFECT_FIFTH)
  val DIMINISHED = PreDefChord(DIMINISHED_THIRD, DIMINISHED_FIFTH)
  val MINOR_SEVEN = MINOR + Interval.MINOR_SEVEN
  val SEVEN = MAJOR + Interval.MINOR_SEVEN
  val SEVEN_MAJOR = MAJOR + Interval.MAJOR_SEVEN
}