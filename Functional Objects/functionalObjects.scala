// -----------  Functional Objects

// ---------- class Rational

/*
One, maybe rather trivial, observation is that in mathematics, rational
numbers do not have mutable state. You can add one rational number to
another, but the result will be a new rational number.
*/

// ---- Constructing a Rational

/*
The Scala compiler will compile any code you place in the class body,
which isn’t part of a field or a method definition, into the primary constructor
*/

/*
In Scala, constructors other than the primary constructor are called auxiliary constructors.
*/

class Rational(n:Int,d:Int){
    // println(s"Created $n / $d")
    require(d != 0)  //precondition
    private val g:Int = gcd(n.abs,d.abs)
    val numer:Int = n / g
    val denom:Int = d / g
    def this(n:Int) = this(n,1) // Auxilary Constructor

    private def gcd(a:Int,b:Int):Int = {
        if b == 0 then {
            a
        }else{
            gcd(b,a%b)
        }
    }

    override def toString = s"$numer/$denom" //override the default implementation by adding a method toString to class Rational

    def add(that:Rational):Rational = {
        Rational(numer* that.denom + that.numer * denom,denom * that.denom)
    }

    def lessThan(that:Rational):Boolean = {
        this.numer * that.denom < this.denom * that.numer 
    }

    def max(that:Rational) = {
        if this.lessThan(that) then {
            that
        }else{
            this
        }
    }
}

val x = Rational(1,3)
val y = Rational(5,7)