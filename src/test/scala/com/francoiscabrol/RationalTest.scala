package com.francoiscabrol

import org.scalatest.FlatSpec
import scala.language.implicitConversions
import implicitRational._

class RationalTest extends FlatSpec {

  "A rational" should "respect these behaviours" in {

    val r1 = new Rational(3, 5)
    assert(rat"3/5" == r1)
    val r2 = new Rational(2, 7)                     //> r2  : worksheets.Rational = 2/7
    assert(r2 == rat"2/7")
    val r3 = new Rational(5, 9)                     //> r3  : worksheets.Rational = 5/9
    assert(r3 == rat"5/9")

    val r4 = r1 - r2                                         //> res0: worksheets.Rational = 11/35
    assert(r4 == rat"11/35")

    val r5 = r1 * r2                                         //> res1: worksheets.Rational = 6/35
    assert(r5 == rat"6/35")
    assert(r1 != r2)

    assert(r1 / r2 == rat"21/10")                      //> res3: worksheets.Rational = 21/10

    val x = new Rational(1, 3)                      //> x  : worksheets.Rational = 1/3
    val y = new Rational(5, 7)                      //> y  : worksheets.Rational = 5/7
    val z = new Rational(3, 2)                      //> z  : worksheets.Rational = 3/2

    assert(x - y - z == rat"-47/42")                   //> res4: worksheets.Rational = 107/42

    val a = new Rational(5)                         //> a  : worksheets.Rational = 5/1
    assert(a == rat"5/1")
  }
}
