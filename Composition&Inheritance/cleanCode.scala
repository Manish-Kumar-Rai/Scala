abstract class Element {
    def contents:Vector[String]
    def height:Int = contents.length
    def width:Int = if height == 0 then 0 else contents(0).length
}

class VectorElement(
    val contents:Vector[String]
) extends Element

class LineElement(s:String) extends VectorElement(Vector(s)){
    override def height = 1
    override def width = s.length
}

class UniformElement(
    ch:Char,
    override val width:Int, 
    override val height:Int
) extends Element {
    private val line = ch.toString * width
    def contents = Vector.fill(height)(line)
}

// --- Declaring final members

/*
In Scala, final members are methods or variables that cannot be overridden or redefined in subclasses.
*/

