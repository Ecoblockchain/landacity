package controllers

import grizzled.slf4j.Logging
import play.api._
import play.api.mvc._

class Index extends Controller with Logging {

  def index = Action {
    Ok(Scalate("index.jade").render(
      'title -> "Landing page"
    ))
  }
}
