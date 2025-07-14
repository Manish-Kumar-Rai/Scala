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