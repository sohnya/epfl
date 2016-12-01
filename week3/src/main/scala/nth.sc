import week3._

def nth[T](list:List[T],n:Int) : T = {
  if(list.isEmpty) throw new IndexOutOfBoundsException
  if(n==0) list.head
  else nth(list.tail,n-1)
}

val list = new Cons(1,new Cons(2,new Cons(3, new Nil)))
nth(list,5)