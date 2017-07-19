package tacit

sealed trait OutputBlock

object OutputBlock {
  case class NormalText(text: String) extends OutputBlock
  case class ErrorHighlightPrevious(index: Int, length: Int) extends OutputBlock
  case class ErrorHighlightNew(index: Int, length: Int) extends OutputBlock
  case class ErrorMessage(text: String) extends OutputBlock
  case class Nothing() extends OutputBlock
  case class Multi(blocks: Seq[OutputBlock]) extends OutputBlock
  def Multi(blocks: OutputBlock*): Multi = Multi(blocks: Seq[OutputBlock])
}
