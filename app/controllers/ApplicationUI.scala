package controllers

import play.api.mvc._
import models.UserStore

import views._

object ApplicationUI extends Controller {

  def index = Action {
    Ok(html.index(UserStore.Users.values))
  }

  def get(id: Long) = Action {
    Ok(html.get(UserStore.Users(id)))
  }

}
