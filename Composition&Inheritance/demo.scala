abstract class Element {
    def demo = "Element's implementation invoked"
}

class VectorElement extends Element {
    override def demo = "VectorElement's implementation invoked"
}

class LineElement extends VectorElement {
    override def demo = "LineElement's implementation invoked"
}

class UniformElement extends Element

/*
class VectorElement extends Element {
    final override def demo = "VectorElement's implementation invoked"
}
*/

/*
final class VectorElement extends Element {
    override def demo = "VectorElement's implementation invoked"
}
*/