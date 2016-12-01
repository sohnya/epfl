import week3.Rational

object scratch {
  new Rational(1,2)

  def error(message:String) = throw new Error(message)

  val x = null
  val y : String = x

  if(true)1 else false

}

/** Like an abstract class
  Classes can inherit from at most one clas
  but arbitrarily many traits
  Like interfaces in Java, but can contain
  fields and concrete methods.
  Classes can have value parameters, traits no.
  */

trait Planar {
  def height : Int
  def width : Int
  def surface = height*width
}