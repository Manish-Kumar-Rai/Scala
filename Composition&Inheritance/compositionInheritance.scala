// ------------ Composition and Inheritance

/*
Composition means one class holds a reference to another, using the referenced class to help it fulfill its mission. Inheritance is the superclass/subclass relationship.
*/

// ----- Abstract classes
/*
A class with abstract members must itself be declared abstract, which is done
by writing an abstract modifier in front of the class keyword.
*/

abstract class Element {
    def contents:Vector[String]
// ---Defining parameterless methods
    def height:Int = contents.length
    def width:Int = if height == 0 then 0 else contents(0).length

}

/*
Note that the contents method in class Element does not carry an abstract modifier.
A method is abstract if it does not have an implementation (i.e., no equals sign or body).
Methods that have an implementation are called concrete.
*/

/*
By contrast, methods defined with empty parentheses, such as def height(): Int, are
called empty-paren methods. The recommended convention is to use a parameterless method whenever there are no parameters and the method accesses state only by reading fields of the containing object (in particular, it
does not change mutable state). 

Important : This convention supports the uniform access
principle, which says that client code should not be affected by a decision
to implement an attribute as a field or method.
*/

/*
Important :
    To summarize, it is encouraged in Scala to define methods that take no parameters and have no side effects as parameterless methods (i.e., leaving off the empty parentheses). On the other hand, you should never define a method
    that has side-effects without parentheses, because invocations of that method would then look like a field selection. So your clients might be surprised to see the side effects.
*/

// ---- Extending classes

/*
To instantiate an element, therefore, we will need to create a subclass that extends Element
and implements the abstract contents method.
*/

// Defining VectorElement as a subclass of Element

class VectorElement(conts:Vector[String]) extends Element {
    def contents:Vector[String] = conts
}

/*
Inheritance means that all members of the superclass are also members
of the subclass, with two exceptions. First, private members of the superclass
are not inherited in a subclass. Second, a member of a superclass is
not inherited if a member with the same name and parameters is already implemented in the subclass.
*/

/*
Subtyping means that a value of the subclass can be used wherever a
value of the superclass is required.
*/

val e:Element = new VectorElement(Vector("hello"))
/*
This line declares a variable e of type Element, but assigns it an object of type VectorElement.

🔹 What's Going On?
VectorElement is a subclass of Element (it extends Element).
So wherever an Element is expected, a VectorElement is also acceptable.
This is what subtyping means: a subclass can be used in place of a superclass.
 */

// -- Overriding methods and fields

/*
Another difference is that in Scala, fields and methods belong to the same namespace. 
This makes it possible for a field to override a parameterless method.
*/

//---- Overriding a parameterless method with a field
class VectorElement(conts:Vector[String]) extends Element {
    val contents:Vector[String] = conts  // field
}

/*
In Scala it is forbidden to define a field and method with the same name in the same class,
whereas this is allowed in Java.
*/

// ------------- Defining parametric fields
/*
A field defined as a class parameter.
*/

class VectorElement(val contents:Vector[String]) extends Element
/*
You can also prefix a class parameter with var, in which case the corresponding field would be reassignable.
Finally, it is possible to add modifiers,such as private, protected,
or override to these parametric fields, just as you can for any other class member.
*/

class Cat {
    val dangerous = false
}

// short-hand definition
class Tiger (
    override val dangerous:Boolean,
    private var age:Int
) extends Cat

// conventional definition
// class Tiger(param1:Boolean,param2:Int) extends Cat {
//     override val dangerous = param1
//     private var age = param2
// }

// ------Invoking superclass constructors