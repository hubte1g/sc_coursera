//object Main {
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
    def pascal_dp=List()

    def pascalTailCur(c:Int,r:Int,dp:List[Int], r_calculating:Int): Int={
      if(r<r_calculating)   dp.apply((r+1)*r/2+c)
      else    pascalTailCur(c,r,listizePascalTriangleRowCur(r_calculating,dp,0),r_calculating+1)
    }

    def listizePascalTriangleRowCur(r_calculating:Int, dp:List[Int],r:Int):List[Int]={
      if (r==r_calculating) dp:::List(1)
      else if (r==0)  listizePascalTriangleRowCur(r_calculating, dp:::List(1),r+1)
      else listizePascalTriangleRowCur(r_calculating, dp:::List(dp(dp.length-r_calculating)+dp(dp.length-r_calculating-1)),r+1)
    }

    pascalTailCur(c,r,pascal_dp,0)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balanceCur(chars:List[Char], sum:Int): Boolean={
      if(sum<0) false
      else if (sum==0 && chars.isEmpty) true
      else if (sum!=0 && chars.isEmpty) false
      else {
        if (chars.head=='(') balanceCur(chars.tail,sum+1)
        else if (chars.head==')') balanceCur(chars.tail,sum-1)
        else balanceCur(chars.tail,sum)
      }
    }
    balanceCur(chars,0);
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeCur (money:Int, coins:List[Int], sum:Int) : Int={
      if (coins.isEmpty) sum
      else if (money ==0) 1+sum
      else if (coins.length==1 && money % coins.head==0) 1+sum
      else if (coins.head>money) countChangeCur(money, coins.tail, sum)
      else {
        countChangeCur (money,coins.tail,sum+countChangeCur(money-coins.head,coins,0))
      }
    }
    countChangeCur(money,coins,0)
  }
//}

pascal(2,4)

println("Pascal's Triangle")
for (row <- 0 to 5) {
  for (col <- 0 to row)
    print(pascal(col, row) + " ")
  println()
}



