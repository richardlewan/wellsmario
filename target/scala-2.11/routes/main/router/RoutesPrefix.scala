
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/rlewan/git/wellsmario/conf/routes
// @DATE:Mon Aug 28 09:19:18 MDT 2017


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
