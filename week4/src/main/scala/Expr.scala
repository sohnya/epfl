/**
  * Created by hiltunen on 17/12/16.
  */

trait Expr {
  def eval : Int = this match {
    case Number(n) => n
    case Sum(e1,e2) => e1.eval + e2.eval
  }

  def show(e:Expr) : String = this match {
    case Number(n) => n.toString
    case Sum(e1,e2) => show(e1) + " + " + show(e2)
  }

  show(Sum(Number(2),Number(3)))

}


case class Number(n:Int) extends Expr

case class Sum(e1:Expr, e2:Expr) extends Expr

/**trait Expr {
  def isNumber : Boolean
  def isSum : Boolean
  def numValue : Int
  def leftOp : Expr
  def rightOp : Expr

  def eval(e:Expr) : Int = {
    e.numValue
  }

}

class Number(n:Int) extends Expr {
  def isNumber : Boolean = true
  def isSum : Boolean = false
  def numValue : Int = n
  def leftOp : Expr = throw new Error("Number.leftOp")
  def rightOp : Expr = throw new Error("Number.rightOp")
}

class Sum(e1:Expr , e2:Expr) extends Expr {
  def isNumber : Boolean = false
  def isSum : Boolean = true
  def numValue : Int = throw new Error("Sum.numValue")
  def leftOp : Expr = e1
  def rightOp : Expr = e2
}
*/