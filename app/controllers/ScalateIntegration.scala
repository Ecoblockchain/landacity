package controllers

import org.fusesource.scalate.TemplateEngine
import org.fusesource.scalate.layout.DefaultLayoutStrategy
import org.fusesource.scalate.util.FileResourceLoader
import play.api.Play.current
import play.api._
import play.api.http.{ContentTypeOf, ContentTypes, Writeable}
import play.api.mvc.Codec
import play.api.libs.concurrent.Execution.Implicits._
import scala.language.postfixOps

object Scalate {

  var format = Play.configuration.getString("scalate.format") match {
    case Some(configuredFormat) => configuredFormat
    case _ => "scaml"
  }

  lazy val scalateEngine = {
    val engine = new TemplateEngine
    engine.resourceLoader = new FileResourceLoader(Some(Play.getFile("app/views")))
    engine.layoutStrategy = new DefaultLayoutStrategy(engine, "app/views/layouts/default." + format)
    engine.classpath = "tmp/classes"
    engine.workingDirectory = Play.getFile("tmp")
    engine.combinedClassPath = true
    engine.classLoader = Play.classloader
    engine
  }

  def apply(template: String) = Template(template)

  case class Template(name: String) {

    def render(args: (Symbol, Any)*) = {
      ScalateContent{
        scalateEngine.layout(name, args.map {
          case (k, v) => k.name -> v
        } toMap)
      }
    }

  }

  case class ScalateContent(val cont: String)

  implicit def writeableOf_ScalateContent(implicit codec: Codec): Writeable[ScalateContent] = {
    Writeable[ScalateContent] { scalate: ScalateContent => codec.encode(scalate.cont) }
  }

  implicit def contentTypeOf_ScalateContent(implicit codec: Codec): ContentTypeOf[ScalateContent] = {
    ContentTypeOf[ScalateContent](Some(ContentTypes.HTML))
  }
}
