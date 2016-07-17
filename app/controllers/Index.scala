package controllers

import javax.inject.{ Inject, Singleton }
import grizzled.slf4j.Logging
import play.api._
import play.api.mvc._
import com.github.tototoshi.play2.scalate._

@Singleton
class Index @Inject() (scalate: Scalate) extends Controller with Logging {

  def index = Action {
    Ok(scalate.render("index.jade", Map(
      "title" -> "Landing page"
    )))
  }
}
