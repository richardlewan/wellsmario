
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
"""),format.raw/*12.1*/("""<script type="text/javascript" src=""""),_display_(/*12.38*/routes/*12.44*/.Assets.versioned("/javascripts/jquery-2.2.0.min.js")),format.raw/*12.97*/(""""></script>
<script type='text/javascript' src='"""),_display_(/*13.38*/routes/*13.44*/.Assets.versioned("javascripts/app.js")),format.raw/*13.83*/("""'></script>

<ul id="results"></ul>

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
                  DATE: Fri Aug 25 15:33:06 MDT 2017
                  SOURCE: /Users/sbejjanki/git/wellsmario/app/views/index.scala.html
                  HASH: 25bda27c1bd97dfb19a6c67771a1dbcb3315c20f
                  MATRIX: 738->1|834->3|862->199|893->204|928->230|968->232|996->233|1060->270|1075->276|1149->329|1225->378|1240->384|1300->423|1368->461
                  LINES: 27->1|32->1|34->7|38->11|38->11|38->11|39->12|39->12|39->12|39->12|40->13|40->13|40->13|44->17
                  -- GENERATED --
              */
          