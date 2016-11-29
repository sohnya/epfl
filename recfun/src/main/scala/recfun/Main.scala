package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {

      if(c==0 && r==0) 1

      else {
      val leftParent = if (c==0) 0 else pascal(c-1,r-1)
      val rightParent = if(c==r) 0 else pascal(c,r-1)

      leftParent + rightParent
      }
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def balanceRecursive(chars : List[Char], openBrackets : Int) : Boolean = {

        var newOpenBrackets: Int = openBrackets

        if (chars.head=='(') {
          newOpenBrackets = openBrackets + 1
        } else if(chars.head==')' && openBrackets!=0){
          newOpenBrackets = openBrackets-1
        }

        if(newOpenBrackets>0 && chars.tail.isEmpty) false //Parantheses have not been closed
        else if(chars.head==')' && openBrackets==0) false // Closing paranthesis without opening
        else if(newOpenBrackets==0 && chars.tail.isEmpty) true //All paranetheses have been closed at end of String
        else balanceRecursive(chars.tail,newOpenBrackets)
        }

      balanceRecursive(chars, 0)

    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {

      if(money==0) 1
      else if(money>0 && coins.nonEmpty) {
        countChange(money - coins.head,coins) + countChange(money,coins.tail)
      }else 0

    }
  }
