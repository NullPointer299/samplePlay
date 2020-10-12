package controllers

import javax.inject._
import models.{DBAccess, Employee}
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(db: DBAccess)(cc: ControllerComponents)
  extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index: Action[AnyContent] = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def top: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.top())
  }

  def topSubmit: Action[AnyContent] = Action {
    Ok(views.html.show(db.employeeList()))
  }


}
