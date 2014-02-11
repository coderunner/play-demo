package controllers

import play.api.mvc._
import play.api.libs.json.Json
import models.UserStore
import concurrent.ExecutionContext.Implicits.global
import models.UserStore.User

object ApplicationApi extends Controller {
  implicit val userWrites = Json.writes[User]

  def index = Action {
    Ok(Json.toJson(UserStore.Users.values))
  }

  def get(id: Long) = Action {
    Ok(Json.toJson(UserStore.Users(id)))
  }

  def search(name: String) = Action.async {
    UserStore.search(name).map(result => Ok(Json.toJson(result)))
  }
}