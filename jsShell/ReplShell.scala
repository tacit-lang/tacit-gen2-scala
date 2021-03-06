package tacit.jsShell

import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.dom.html
import scala.language.postfixOps
import scalacss.ScalatagsCss._

import CssSettings.Defaults._
import HtmlSettings.Defaults._

object ReplShell extends Render[html.Div] {
  def render: RenderComponent = {
    val repl = Repl()

    val root = div(
      Style.root,
      repl.root
    )
    (root, new Component(_, repl))
  }

  final class Component(
    val root: Root,
    val repl: Repl.Component
  ) extends Shell.Component {
    override def autofocus(): Unit = repl.autofocus()

    def handleClick(event: dom.MouseEvent): Unit = {
      val _ = event

      val selection = document.getSelection()
      val isSelectionEmpty = (
        selection.anchorNode == selection.focusNode
          && selection.anchorOffset == selection.focusOffset
      )

      if (isSelectionEmpty) {
        // Only change focus when the click didn't result in
        // a selection, to avoid interfering with the user's
        // intention
        autofocus()
      }
    }

    document.addEventListener(
      "click",
      handleClick(_),
      useCapture = false)
  }

  object Style extends StyleSheet.Inline {
    import Style.dsl._

    val root: StyleA = style(
      display.flex,
      flexDirection.column,
      alignItems.center,
      minHeight(100 vh)
    )
  }
}
