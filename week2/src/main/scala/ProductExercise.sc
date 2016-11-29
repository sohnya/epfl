def product(f:Int=>Int)(a:Int,b:Int) : Int = {
  if(a>b) 1
  else f(a)*product(f)(a+1,b)
}

def factorial(a:Int): Int ={
   if(a==0) 1
  else a*factorial(a-1)
}

def sum(f:Int=>Int)(a:Int,b:Int) : Int = {
  if(a>b) 0
  else f(a) + sum(f)(a+1,b)
}

def factorialSum(a:Int,b:Int) = sum(factorial)(a,b)
def factorialProduct(a:Int,b:Int) = product(factorial)(a,b)

factorialSum(2,3)
factorialProduct(2,3)

def fact(n:Int) = product(x=>x)(1,n)

fact(4)

def mapReduce(f:Int=>Int, combine:(Int,Int)=>Int,zero:Int)(a:Int,b:Int) : Int = {
  if(a>b) zero
  else combine(f(a),mapReduce(f,combine,zero)(a+1,b))
}

mapReduce(x=>x,(x,y)=>x+y,0)(2,4)
mapReduce(x=>x,(x,y)=>x*y,1)(2,4)
mapReduce(factorial,(x,y)=>x*y,1)(2,3)

def product2(f:Int=>Int)(a:Int,b:Int) :Int = mapReduce(f,(x,y)=>x*y,1)(a,b)

product2(factorial)(2,3)
