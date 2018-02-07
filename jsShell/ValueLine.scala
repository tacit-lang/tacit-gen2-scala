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

object ValueLine extends Render {
  def render: RenderComponent = {
    val root = div(
      Style.root
    )
    (root, new Component(_))
  }

  type Root = html.Div

  final class Component(
    val root: Root
  )

  object Style extends StyleSheet.Inline {
    import Style.dsl._

    val root: StyleA = style(
      marginLeft(2 ch),
      color(Colors.value),
      fontWeight._700,
      &.before(
        content := "\"▶ \"",
        opacity(0.95),
        position.relative,
        bottom(-0.05 em)
      )
    )
  }
}