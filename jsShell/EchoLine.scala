package tacit.jsShell

import org.scalajs.dom.html
import scalacss.ScalatagsCss._
import scalatags.JsDom.all.{
  Double2CssNumber => _,
  Int2CssNumber => _,
  _
}

import CssSettings.Defaults._

object EchoLine extends Render {
  def render: RenderComponent = {
    val root = div(
      Style.root,
      PromptSpan().root
    )
    (root, new Component(_))
  }

  type Root = html.Div

  final class Component(
    val root: Root
  )

  object Style extends StyleSheet.Inline {
    val root: StyleA = style()
  }
}