import Element.elem

abstract class Element {
    def contents:Vector[String]
    def height:Int = contents.length
    def width:Int = if height == 0 then 0 else contents(0).length

    def above(that:Element):Element = {
        val this1 = this.widen(that.width)
        val that1 = that.widen(this.width)
        elem(this1.contents ++ that1.contents)
    }

    def widen(w:Int):Element = {
        if w <= width then this
        else
            val left = elem(' ',(w-width)/2,height)
            val right = elem(' ',w-width-left.width,height)
            left `beside` this `beside` right
    }
    // def beside(that:Element):Element = {
    //     val newContents = new Array[String](this.contents.length)
    //     for i <- 0 until newContents.length do
    //         newContents(i) = this.contents(i) + that.contents(i)
    //     elem(newContents.toVector)
    // }

    def beside(that:Element):Element = {
        val this1 = this.heighten(that.height)
        val that1 = that.heighten(this.height)    
        elem(for (line1,line2) <- this1.contents.zip(that1.contents)
        yield line1+line2)
    }

    def heighten(h:Int):Element = {
        if h <= height then this
        else
            val top = elem(' ',width,(h-height)/2)
            val bottom = elem(' ',width,h-height-top.height)
            top `above` this `above` bottom
    }

    override def toString = contents.mkString("\n")
}

object Element {
    private class VectorElement(
        val contents:Vector[String]
    )extends Element

    private class LineElement(s:String) extends Element {
        val contents = Vector(s)
        override def height = 1
        override def width = s.length
    }

    private class UniformElement(
        ch:Char,
        override val width:Int, 
        override val height:Int
    )extends Element {
        private val line = ch.toString * width
        def contents = Vector.fill(height)(line)
    }

    def elem(contents:Vector[String]):Element = VectorElement(contents)
    
    def elem(line:String):Element = LineElement(line)

    def elem(ch:Char,width:Int,height:Int):Element = UniformElement(ch,width,height)
}

 

// class LineElement(s:String) extends VectorElement(Vector(s)){
//     override def height = 1
//     override def width = s.length
// }







