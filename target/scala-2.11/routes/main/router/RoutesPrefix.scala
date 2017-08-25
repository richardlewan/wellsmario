
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sbejjanki/git/wellsmario/conf/routes
// @DATE:Fri Aug 25 15:14:43 MDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
