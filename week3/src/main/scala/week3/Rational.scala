package week3

class Rational(x:Int,y:Int) {

  private def gcd(a:Int,b:Int) : Int = if(b==0) a else gcd(b,a%b)

  require(y!=0, "denominator must be non zero")

  def this(x:Int) = this(x,1)

  def numer = x
  def denom = y

  def +(that:Rational) =
    new Rational(numer*that.denom + that.numer*denom,
      denom*that.denom)

  def -(that:Rational) = this + -that

  def *(that:Rational) =
    new Rational(numer*that.numer,denom*that.denom)

  def unary_- : Rational = new Rational(-numer,denom)

  override def toString = numer/gcd(numer,denom) + "/" + denom/gcd(numer,denom)

  def <(that:Rational) = {
    numer*that.denom < that.numer*denom
  }

  def max(that:Rational) = {
    if(this<that) that else this
  }


}