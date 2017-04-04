package com.francoiscabrol.music.theory

import scala.runtime.RangedProxy

trait PitchClassSet {
  val root: PitchClass
  val sounds: Set[Interval]

  def pitchClasses: Array[PitchClass] = root +: sounds.map(_.pitchClassRelativeTo(root)).toArray
}