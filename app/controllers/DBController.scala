package controllers

import javax.inject._
import models.DBAccess
import play.api.mvc._

@Singleton
class DBController @Inject()(db: DBAccess)(cc: ControllerComponents) extends AbstractController(cc) {

  def languageList: Action[AnyContent] = Action {
    Ok(db.languageList().toString)
  }

  def userList: Action[AnyContent] = Action{
    Ok(db.userList().toString)
  }

  def insert: Action[AnyContent] = Action {
    val ret = db.insert()
    Ok("insert!!!" + ret)
  }

  def insertTwo: Action[AnyContent] = Action {
    val ret = db.insertTwo()
    Ok("insertTwo!!!" + ret)
  }

  def update: Action[AnyContent] = Action{
    Ok(db.update.toString)
  }

  def delete: Action[AnyContent] = Action{
    Ok(db.delete.toString)
  }

  def search: Action[AnyContent] = Action{
    Ok(db.search("").get.mkString(" "))
  }
}
