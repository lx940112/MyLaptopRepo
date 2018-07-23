package com.lx.scalaiotest

import java.io.PrintWriter
import java.io.File

import scala.io.Source

/**
  * Created  by  Mr.lx  on 2018-07-22 16:54
  **/
object ScalaIOTest01 {

  def main(args: Array[String]): Unit = {

    //文件读取
    /*val file = Source.fromFile("F:/domain.txt")
    var count = 0
    for(line <- file.getLines)
    {
      count += 1
      println(count+"\t"+line)
    }
    file.close*/

    //文件写入
    /* val writer = new PrintWriter(new File("learningScala.txt"))
     for(i <- 1 to 100)
       writer.println(i)
     writer.close()*/
    var domains = Array("www.ruozedata.com", "www.zhibo8.com", "www.dongqiudi.com")
    var charStr = Array("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
    val length = charStr.length
    val writer = new PrintWriter(new File("F:/domainData.txt"))
    for (i <- 1 to 10000) {
      var domainIndex = (new util.Random).nextInt(3)
      var charNum = (new util.Random).nextInt(3) + 2
      var str = ""
      for (i <- 1 to charNum) {
        var charIndex: Int = (new util.Random).nextInt(length)
        str += charStr(charIndex)
      }

    }


  }
  (new util.Random).nextInt(36)+1
}
