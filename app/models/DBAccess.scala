package models

import javax.inject._
import play.api.db._
import anorm._
import anorm.SqlParser._

@Singleton
class DBAccess @Inject()(dbApi: DBApi) {

  private val db = dbApi.database("default")

  val parser: RowParser[Int ~ String ~ Int] =
    int("id") ~
      str("name") ~
      int("experience")

  val mapper: RowParser[Map[String, Any]] = parser.map {
    case id ~ name ~ experience =>
      Map("id" -> id,
        "name" -> name,
        "experience" -> experience)
  }

  def languageList(): List[Map[String, Any]] = {
    db.withConnection { implicit c =>
      SQL("SELECT * FROM language ORDER BY id")
        .as(mapper.*)
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
        .as(mapper.singleOpt)
    }
  }

}

//@Singleton
//class DBAccess @Inject()(@NamedDatabase("DB名") db: Database) {
//}

