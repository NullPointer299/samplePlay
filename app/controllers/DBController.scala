package controllers

import javax.inject._
import models.DBAccess
import play.api.mvc
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents}

@Singleton
class DBController @Inject()(db: DBAccess)(cc: ControllerComponents) extends AbstractController(cc){

  def languageList: mvc.Action[AnyContent] = Action {
    Ok(db.languageList.toString)
  }
}
