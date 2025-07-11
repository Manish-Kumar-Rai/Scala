abstract class Element {
    def contents:Vector[String]
    def height:Int = contents.length
    def width:Int = if height == 0 then 0 else contents(0).length
}

class VectorElement(
    val contents:Vector[String]
) extends Element