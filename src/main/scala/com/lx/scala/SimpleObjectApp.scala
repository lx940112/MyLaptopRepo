package com.lx.scala
object SimpleObjectApp {
  def main(args: Array[String]): Unit = {
    val person = new People()
    println(person.name + "——" + person.age)
    person.name = "Messi"
    println(person.name + "——" + person.age)
    println("invoke eat method:" + person.eat())
    //如果函数没有参数可以不写()，但是有一种情况除外
    println("invoke eat method:" + person.eat)
    person.watchFootBall("Barcelona")
    //使用private[this]修饰的，只能在当前类中被访问到，直接person.gender访问
    person.printGender
  }
}
class People {
  var name: String = ""
  val age: Int = 10
  var address: String = _
  //  下边是错的，使用“_”必须声明类型
  //  var address = _
  private[this] val gender = "mail"
  def printGender: Unit = {
    println("Gender is : " + gender)
  }
  def eat(): String = {
    name + " is eat......"
  }
  def watchFootBall(teamName: String): Unit = {
    println(name + "is watching match of " + teamName)
  }
}