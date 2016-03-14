package controllers

import grizzled.slf4j.Logging
import play.api._
import play.api.mvc._
import com.github.tototoshi.play2.scalate._

class Index extends Controller with Logging {

  def index = Action {
    Ok(Scalate.render("index.jade", Map(
      "title" -> "Landing page"
    )))
  }
}
