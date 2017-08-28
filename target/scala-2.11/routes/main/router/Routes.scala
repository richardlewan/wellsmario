
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/rlewan/git/wellsmario/conf/routes
// @DATE:Mon Aug 28 09:19:18 MDT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_0: controllers.HomeController,
  // @LINE:13
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_0: controllers.HomeController,
    // @LINE:13
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index""", """controllers.HomeController.index()"""),
    ("""GET""", this.prefix, """controllers.HomeController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """calc""", """controllers.HomeController.calc()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """results""", """controllers.HomeController.getResults()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index")))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """index"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_login1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_login1_invoker = createInvoker(
    HomeController_0.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "login",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_calc2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("calc")))
  )
  private[this] lazy val controllers_HomeController_calc2_invoker = createInvoker(
    HomeController_0.calc(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "calc",
      Nil,
      "POST",
      """""",
      this.prefix + """calc"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_getResults3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("results")))
  )
  private[this] lazy val controllers_HomeController_getResults3_invoker = createInvoker(
    HomeController_0.getResults(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getResults",
      Nil,
      "GET",
      """""",
      this.prefix + """results"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index())
      }
  
    // @LINE:8
    case controllers_HomeController_login1_route(params) =>
      call { 
        controllers_HomeController_login1_invoker.call(HomeController_0.login())
      }
  
    // @LINE:9
    case controllers_HomeController_calc2_route(params) =>
      call { 
        controllers_HomeController_calc2_invoker.call(HomeController_0.calc())
      }
  
    // @LINE:10
    case controllers_HomeController_getResults3_route(params) =>
      call { 
        controllers_HomeController_getResults3_invoker.call(HomeController_0.getResults())
      }
  
    // @LINE:13
    case controllers_Assets_versioned4_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned4_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
