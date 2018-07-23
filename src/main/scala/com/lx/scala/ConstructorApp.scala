package com.lx.scala

/**
  * author: Mr.lx
  * CreateTime: 2018-07-21 15:28
  **/
object ConstructorApp {
  def main(args: Array[String]): Unit = {
    val person = new Person("Jack", 25)
//    println(person.name + ":" + person.age + ":" + person.school)
    // 如果主构造器中的val被去掉，就无法使用person.访问，为什么？
    val person2 = new Person("Rose",18,"Female")
    println(person2.name+":"+person2.age+":"+person2.gender)
  }

}

//主构造器
class Person(val name: String, val age: Int) {
  println("Person main constructor enter ......")
  val school = "sau"
  var gender: String = _
  // 附属构造器
  def this(name: String, age: Int, gender: String) {
    // 附属构造器的第一行代码必须要调用主构造器或者其他附属构造器
    this(name, age)
    println("Person other constructor leave ......")
    this.gender = gender
  }
  println("Person main constructor leave ......")
}