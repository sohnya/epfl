/**
  * Created by hiltunen on 12/12/16.
  */

// Peano numbers

abstract class Nat {
  def isZero : Boolean
  def predecessor : Nat
  def successor = new Succ(this)
  def +(that: Nat) : Nat
  def -(that:Nat) :Nat
}

object Zero extends Nat {
  def isZero = true
  def predecessor = throw new java.lang.Error("Nats can only be positive or zero")
  def +(that: Nat) = that
  def -(that:Nat) = if(that.isZero) this else throw new java.lang.Error("Negative number")
}

class Succ(n : Nat) extends Nat {
  def isZero = false
  def predecessor = n
  def +(that: Nat) = new Succ(n + that)
  def -(that:Nat) = if(that.isZero) this else n - that.predecessor
}
