package models

import java.util.Date

import javax.inject._
import play.api.db._
import anorm._
import anorm.SqlParser._

@Singleton
class DBAccess @Inject()(dbApi: DBApi) {

  private val db = dbApi.database("default")

  val langParser: RowParser[Int ~ String ~ Int] =
    int("id") ~
      str("name") ~
      int("experience")

  val langMapper: RowParser[Map[String, Any]] = langParser.map {
    case id ~ name ~ experience =>
      Map("id" -> id,
        "name" -> name,
        "experience" -> experience)
  }

  val employeeParser: RowParser[Int ~ String ~ String ~ String ~ String ~ Date] = {
    int("id") ~
      str("user_id") ~
      str("last_name") ~
      str("first_name") ~
      str("mail_address") ~
      date("hire_date")
  }

  val employeeMapper: RowParser[Employee] = employeeParser.map {
    case id ~ user_id ~ last_name ~ first_name ~ mail_address ~ hire_date =>
      Employee(id, user_id, last_name, first_name, mail_address, hire_date)
  }

  def languageList(): List[Map[String, Any]] = {
    db.withConnection { implicit c =>
      SQL("SELECT * FROM language ORDER BY id")
        .as(langMapper.*)
    }
  }

  def employeeList(): List[Employee] = {
    db.withConnection { implicit c =>
      SQL("SELECT * FROM user ORDER BY id")
        .as(employeeMapper.*)
    }
  }

  def insert(): Option[Long] = {
    db.withConnection { implicit c =>
      SQL("INSERT INTO language(name, experience) " +
        "VALUES('Java', 4)").executeInsert()
    }
  }

  def insertTwo(): List[Int] = {
    db.withConnection { implicit c =>
      SQL("INSERT INTO language(name, experience) " +
        "VALUES('C', 5), ('Ruby', 2)").executeInsert(
        int(1).+)
    }
  }

  def update: Int = {
    db.withConnection { implicit c =>
      SQL("UPDATE language " +
        "SET experience = 999 " +
        "WHERE name = 'Scala'").executeUpdate()
    }
  }

  def delete: Int = {
    db.withConnection { implicit c =>
      SQL("DELETE FROM language " +
        "WHERE name = 'C'").executeUpdate()
    }
  }

  def search(language: String): Option[Map[String, Any]] = {
    db.withConnection { implicit c =>
      SQL("SELECT *" +
        "FROM language" +
        "WHERE name = {language}")
        .on("language" -> language)
        .as(langMapper.singleOpt)
    }
  }

}

//@Singleton
//class DBAccess @Inject()(@NamedDatabase("DB名") db: Database) {
//}

