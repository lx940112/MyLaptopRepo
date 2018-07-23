package com.lx.highfunction

/**
  * Created  by  Mr.lx  on 2018-07-22 20:16
  **/
object FunctionApp {
  def main(args: Array[String]): Unit = {
    val l = List(1,2,3,4,5,6,7,8,9)
//  l.reduce()
    println(l.map(_ * 2))
    val i = 1/0
  }
}
