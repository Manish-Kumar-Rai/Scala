// --------------- Traits

/*
Traits are a fundamental unit of code reuse in Scala. A trait encapsulates
method and field definitions, which can then be reused by mixing them into
classes. Unlike class inheritance, in which each class must inherit from just
one superclass, a class can mix in any number of traits.
*/

trait Philosophical:
    def philosophize:String = "I consume memory, therefore I am!"

/*
Once a trait is defined, it can be mixed in to a class using either the
extends or with keywords, or a comma.
*/

// class Frog extends Philosophical:
//     override def toString = "green"

/*
A trait also defines a type. Here’s an example in which Philosophical is
used as a type.
*/

// val phil:Philosophical = new Frog

/*
If you wish to mix a trait into a class that explicitly extends a superclass,
you use extends to indicate the superclass and a comma (or with) to mix in
the trait.
*/

class Animal
trait HasLegs

class Frog extends Animal , Philosophical , HasLegs:
    override def toString = "green"
    override def philosophize: String = s"It ain't easy being $this!"
// class Frog extends Animal with Philosophical with HasLegs:
//     override def toString = "green"

/*
Note:The key difference between classes and traits is that whereas in classes,
super calls are statically bound, in traits, they are dynamically bound.
*/

// ---------- Thin versus rich interfaces

/*
One major use of traits is to automatically add methods to a class in terms
of methods the class already has. That is, traits can enrich a thin interface,
making it into a rich interface.
*/

/*
A rich interface has many methods, which make it
convenient for the caller. Clients can pick a method that exactly matches
the functionality they need. A thin interface, on the other hand, has fewer
methods, and thus is easier on the implementers.
*/

// class Rational(n:Int,d:Int) extends Ordered[Rational]:
//     require(d != 0)
//     private val g:Int = gcd(n.abs,d.abs)
//     val numer:Int = n / g
//     val denom:Int = d / g
//     def this(n:Int) = this(n,1) // Auxilary Constructor

//     private def gcd(a:Int,b:Int):Int = 
//         if b == 0 then 
//             a
//         else
//             gcd(b,a%b)
    
//     override def toString = s"$numer/$denom"

//     def compare(that:Rational):Int = 
//         (this.numer * that.denom) - (that.numer * this.denom)

// end Rational

// ---- Traits as stackable modifications
/*
Traits let you modify the methods of a class, and they do
so in a way that allows you to stack those modifications with each other.
*/        

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue:
    def put(x:Int):Unit
    def get():Int

class BasicIntQueue extends IntQueue:
    private val buf = ArrayBuffer.empty[Int]
    def get():Int = buf.remove(0)
    def put(x:Int):Unit = buf += x
    
trait Doubling extends IntQueue:
    abstract override def put(x:Int):Unit = super.put(2 * x)

trait Incrementing extends IntQueue:
    abstract override def put(x:Int):Unit = super.put(x + 1)

trait Filtering extends IntQueue:
    abstract override def put(x:Int):Unit = if x >= 0 then super.put(x)

// class MyQueue extends BasicIntQueue,Doubling

// ----You must use with, not commas, to mix traits into an anonymous class
// traits further to the right take effect first

// val queue = new BasicIntQueue with Incrementing with Filtering

// --- Why not multiple inheritance?

/*
One difference is especially important: the interpretation of super. With
multiple inheritance, the method called by a super call can be determined
right where the call appears. With traits, the method called is determined
by a linearization of the classes and traits that are mixed into a class. This
is the difference that enables the stacking of modifications.
*/

/*
identify exactly which superclass method they want when they say super. You
can in fact do that in Scala, by specifying the superclass in square brackets
after super.
*/

trait MyQueue extends BasicIntQueue,Incrementing,Doubling:
    override def put(x:Int):Unit = 
        super[Incrementing].put(x)
        super[Doubling].put(x)

class Demo extends MyQueue

/*
the main thing you need to know is that, in any linearization, a class is always linearized in front of all its
superclasses and mixed in traits.
*/

// ----- Trait parameters
/*
In short, you must specify a trait’s parameter value when defining a class
that mixes in the trait.
*/
trait Philosophical2(msg:String):
    def philosophize: String = msg

// class Duck extends Animal,Philosophical2("I quak, therefore I am!")    

/*
you must initialize the trait when defining the class that mixes
in the trait highest up in the hierarchy.
*/
class ProfoundAnimal extends Animal,
    Philosophical2("In the beginning was the deed.")
/*
If a class’s superclass does not itself extend the trait, you must specify
the trait parameter when defining the class
*/
class Frog2 extends ProfoundAnimal, Philosophical2
/*
On the other hand, if the class’s superclass also extends the trait, then
you can no longer provide the trait parameter when defining the class.
*/

/*
a trait cannot pass parameters to its parent traits.
*/