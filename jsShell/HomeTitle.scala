package tacit.jsShell

import org.scalajs.dom.html
import scala.language.postfixOps
import scalacss.ScalatagsCss._
import scalatags.JsDom.all.{
  Double2CssNumber => _,
  Int2CssNumber => _,
  _
}

import CssSettings.Defaults._

object HomeTitle extends RenderSimple[html.Heading] {
  def renderSimple: RenderTag =
    h1(
      Style.root,
      "Welcome to Tacit!"
    )

  object Style extends StyleSheet.Inline {
    import Style.dsl._

    val root: StyleA = style(
      marginTop.`0`,
      marginBottom(0.5 em),
      fontSize(2.6 em),
      fontWeight._400,
      lineHeight(1)
    )
  }
}
