// Function that returns another function

def sum(f:Int=>Int) : (Int,Int)=> Int = {
  def sumF(a:Int,b:Int) : Int = {
    if(a>b) 0
    else f(a) + sumF(a+1,b)
  }
  sumF // Will be returned
}

def sumInts = sum(x=>x)
def sumCubes = sum(x=>x*x*x)

sumInts(1,3)

def cube(x : Int) : Int = x*x*x
sum(cube)(1,2) // Same as (sum(cube))(1,2)

// Multiple parameter lists
// Using functions that return functions

def sum2(f:Int=>Int)(a:Int,b:Int) : Int = {
  if(a>b) 0
  else f(a) + sum2(f)(a+1,b)
}

sum2(cube)(1,2)
sum2(cube)