package music

import scala.collection.mutable.ListBuffer
import scala.language.implicitConversions

trait EnumOf[Value] {

  val objects = ListBuffer[Value]()

  implicit class ValueRegistrable(val value: Value) {
    asValue

    def asValue: Value = {
      objects += value
      value
    }
  }

  def values = objects.toList

}
