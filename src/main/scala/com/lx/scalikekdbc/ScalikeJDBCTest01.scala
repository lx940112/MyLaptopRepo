package com.lx.scalikekdbc

import scalikejdbc._

/**
  * author: Mr.lx
  * CreateTime: 2018-07-22 10:33
  **/
object ScalikeJDBCTest01 {

  val url = "jdbc:mysql://192.168.88.150:3306/scalikejdbctest?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull"
  val username = "root"
  val password = "root"
  // initialize JDBC driver & connection pool
  //  初始化JDBC驱动和连接池
  Class.forName("com.mysql.jdbc.Driver")
  ConnectionPool.singleton(url, username, password)
  // ad-hoc session provider on the REPL
  implicit val session = AutoSession


  def  createTabel: Unit ={
    // table creation, you can run DDL by using #execute as same as JDBC
    //  建表，你可使用DDL
    sql"""
    create table if NOT EXISTS members (
    id serial not null primary key,
    name varchar(64),
    created_time timestamp not null
    )
  """.execute.apply()
  }

  def insertData: Unit ={
    // insert initial data
    //  插入初始化数据
    Seq("Jack", "Tom", "Rose") foreach { name =>
      sql"insert into members (name, created_time) values (${name}, current_timestamp)".update.apply()
    }
  }

  def selectResultAsMap():List[Map[String, Any]]={
    // for now, retrieves all data as Map value
    //  现在，以Map的格式获取数据
    val entities: List[Map[String, Any]] = sql"select * from members".map(_.toMap).list.apply()
    entities
  }

  def main(args: Array[String]): Unit = {

    // find all members
    val members: List[Member] = sql"select * from members".map(rs => Member(rs)).list.apply()

  }

}
// defines entity object and extractor
//定义实体对象和提取器
import org.joda.time._
case class Member(id: Long, name: Option[String], createdTime: DateTime){
  override def toString: String = super.toString
}

object Member extends SQLSyntaxSupport[Member] {
  override val tableName = "members"
  def apply(rs: WrappedResultSet) = new Member(
    rs.long("id"), rs.stringOpt("name"), rs.jodaDateTime("created_time"))
}


