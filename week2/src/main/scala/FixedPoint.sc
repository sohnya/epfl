import math.abs

def fixedPoint(f: Double=>Double)(firstGuess : Double) : Double = {

  val tolerance = 0.0001

  def averageDamp(f:Double=>Double)(x:Double) = (x+f(x))/2

  def isCloseEnough(x : Double, y:Double) : Boolean = {
    abs((x-y)/x)/x < tolerance
  }

  def iterate(guess : Double) : Double = {
    //val next = f(guess)
    val next = averageDamp(f)(guess)
    if(isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}

def sqrt(x : Double) = fixedPoint(y=>x/y)(1)

sqrt(2)