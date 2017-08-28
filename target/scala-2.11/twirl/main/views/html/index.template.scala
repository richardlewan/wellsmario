
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),format.raw/*7.4*/("""



"""),_display_(/*11.2*/main("Retirement Robbery")/*11.28*/ {_display_(Seq[Any](format.raw/*11.30*/("""

"""),format.raw/*13.1*/("""<h1 align="center">Retirement Robbery: Wells Fargo vs. SoFi Wealth</h2>
<table id="results" align="center" cellpadding="10"  border="1"></table>
<br>
<p id="finalResult" align="center" bgcolor="#fafc79"></p>
""")))}),format.raw/*17.2*/("""




"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon Aug 28 10:09:56 MDT 2017
                  SOURCE: /Users/rlewan/git/wellsmario/app/views/index.scala.html
                  HASH: 675d54888435a857633335735b6ae962c7785f70
                  MATRIX: 738->1|834->3|862->199|893->204|928->230|968->232|997->234|1236->443
                  LINES: 27->1|32->1|34->7|38->11|38->11|38->11|40->13|44->17
                  -- GENERATED --
              */
          