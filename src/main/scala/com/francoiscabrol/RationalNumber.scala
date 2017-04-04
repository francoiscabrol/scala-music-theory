package com.francoiscabrol

import scala.math._

package object implicitRational {
  implicit class RationalString(val sc: StringContext) extends AnyVal {
    def rat(args: String*): Rational = {
      Rational(sc.parts(0))
    }
  }
}

case class Rational(initialNumer: Int, initialDenom: Int = 1) extends RationalNumber[Rational](initialNumer, initialDenom) with Ordered[Rational] {
  require(initialDenom != 0, "denominator must be nonzero")

  override def equals(o:Any): Boolean = o match {
    case r: Rational => r.numer == numer && r.denom == denom
    case _ => false
  }

  override def compare(that: Rational): Int = that.toFloat.compareTo(this.toFloat)

  override protected def makeNew(numer: Int, denom: Int): Rational = Rational(numer, denom)
}

object Rational {
  private val regex = "([-0-9]+)([/]{0,1})([-0-9]+)".r

  def apply(s: String): Rational = {
    val regex(initialNumer, separator, initialDenom) = s
    new Rational(initialNumer.toInt, initialDenom.toInt)
  }
}

// Thanks to https://gist.github.com/jmcclell/7795997
abstract class RationalNumber[Self <: RationalNumber[Self]](initialNumer: Int, initialDenom: Int) {

  private val gcd = {
    def gcdRec(x: Int, y: Int): Int = {
      if(y == 0) x else gcdRec(y, x % y)
    }
    abs(gcdRec(initialNumer, initialDenom))
  }

  protected def makeNew(numer: Int, denom: Int): Self

  val numer = (if(initialDenom < 0) -abs(initialNumer) else abs(initialNumer)) / gcd
  val denom = abs(initialDenom) / gcd

  def unary_- : Self =
    makeNew(-numer, denom)

  def +(that: Self) : Self =
    makeNew(that.numer * denom + numer * that.denom, denom * that.denom)

  def -(that: Self) =
    makeNew(numer * that.denom - that.numer * denom, denom * that.denom)

  def *(that: Self) =
    makeNew(numer * that.numer, denom * that.denom)

  def /(that: Self) = {
    val reverted = makeNew(that.denom, that.numer)
    this * reverted
  }

  def toFloat: Float = numer.toFloat / denom

  def equals(o:Any): Boolean
}
