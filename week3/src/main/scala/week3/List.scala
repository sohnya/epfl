package week3

import java.util.NoSuchElementException

trait List[T] {
  def isEmpty : Boolean
  def head : T
  def tail : List[T]

  def singleton[T](element:T) = new Cons[T](element, new Nil[T])
}

class Cons[T](val head:T, val tail:List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T]{
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}