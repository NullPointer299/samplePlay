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

  def languageList: List[Map[String, Any]] = {
    db.withConnection { implicit c =>
      SQL("SELECT * FROM language ORDER BY id").
        as(mapper.*)
    }
  }
}

//@Singleton
//class DBAccess @Inject()(@NamedDatabase("DB名") db: Database) {
//}

