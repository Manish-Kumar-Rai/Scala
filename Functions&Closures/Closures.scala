// -----------------Closures
/*
In Scala, a closure is a function that captures the bindings of free variables (variables defined outside the function) and retains access to them even when the function is used in a different context.
*/

var more = 10
val addMore = (x:Int) => x + more

/*
In Scala, "surrounding scope" refers to the block of code (or environment) outside a function or expression where variables are defined and available.
*/

/*
Changes made by a closure to a captured variable are visible outside the closure.
*/

val someNumbers = List(-11,-5,0,5)
var sum = 0

// someNumbers.foreach(sum += _)

/*
What if a closure accesses some variable that has several different copies
as the program runs? For example, what if a closure uses a local variable of
some function, and the function is invoked many times? Which instance of
that variable gets used at each access?
ANS: The instance used is the one that was active at the time the closure was created.
*/

def makeIncrease(more:Int) = (x:Int) => x + more

val inc1 = makeIncrease(1)
val inc9999 = makeIncrease(9999)

// -------------- Special function call forms

// --Repeated parameters
/*
To denote a repeated parameter, place an asterisk after the type of the parameter.
*/

def echo(args:String*):Unit = {
    for arg <- args do println(arg)
}
/*
Inside the function, the type of the repeated parameter is a Seq of the declared type of the parameter
*/

/*
Note: if you have a sequence of the appropriate type, and you attempt to pass it as
a repeated parameter, you’ll get a compiler error.
To accomplish this, you’ll need to append the sequence argument with a symbol (*).
*/

val seq = Seq("What's","up","bro?")
// echo(seq*)

// --Named arguments
/*
Named arguments allow you to pass arguments to a function in a different order.
The syntax is simply that each argument is preceded by a parameter name and an equals sign.
*/
def speed(dist:Int,time:Float):Float = dist / time

// speed(time = 10,dist=100)

/*
It is also possible to mix positional and named arguments. In that case, the
positional arguments come first. Named arguments are most frequently used
in combination with default parameter values.
*/

// --Default parameter values

// object Rational {
//     def apply(numer:Int,denom:Int = 1) = {
//         new Rational(numer,denom)
//     }
// }

// ----- SAM Types
/*
In Java, a lambda expression can be used anywhere an instance of a class
or interface that contains just a single abstract method (SAM) is required.
*/
/*
A SAM type is a trait (or abstract class) with exactly one abstract method.

Scala lets you use a lambda expression to create an instance of a SAM type — especially when interoperating with Java code or using Java interfaces.
*/

// val button = new JButton()
// button.addActionListener(
//     _ => println("pressed")
// )

/*
Scala enables a function literal to be used in this case, because as in Java,
Scala will allow a function type to be used where an instance of a class or
trait declaring a single abstract method (SAM) is required.
*/
trait Increaser {
    def increase(x:Int):Int 
}

def increaseOne(increaser:Increaser):Int = {
    increaser.increase(1)
}

// increaseOne(
//     new Increaser{
//         def increase(x:Int):Int = x + 7
//     }
// )

// increaseOne(i => i + 7)

//----------- Tail recursion
/*
Functions like approximate, which call themselves as their last action, are called tail recursive.
Note: The Scala compiler detects tail recursion and replaces it with a
jump back to the beginning of the function, after updating the function parameters with the new values.

A tail-recursive function will not build a new stack frame for each call; all
calls will execute in a single frame.
*/

/*
def approximate(guess:Double):Double = {
    if isGoogEnough(guess) then guess
    else approximate(improve(guess))
}

def approximateLoop(initialGuess:Double):Double = {
    var guess = initialGuess
    while !isGoodEnough(guess) do {
        guess = improve(guess)
    }
    guess
}

*/

/*
This function is not tail recursive, because it performs an increment operation
after the recursive call.
*/
def boom(x:Int):Int = {
    if x == 0 then throw new Exception("boom!")
    else boom(x - 1) + 1
}
// tail recursive function
def bang(x:Int):Int = {
    if x == 0 then throw new Exception("bang!")
    else bang(x-1)
}

/*
Note:Scala only optimizes directly recursive calls back to the same function making the call. If the recursion is indirect, as in the following example
of two mutually recursive functions, no optimization is possible
*/

def isEven(x:Int):Boolean = {
    if x == 0 then true else isOdd(x -1)
}

def isOdd(x:Int):Boolean = {
    if x == 0 then false else isEven(x-1)
}

/*
You also won’t get a tail-call optimization if the final call goes to a function
value.
*/
// val funcValue = nestedFun

// def nestedFun(x:Int):Int = {
//     if x != 0 then
//         println(x)
//         funcValue(x-1)
// }

/*
Important:
    Tail-call optimization is limited to situations where a method or nested function calls itself directly as its last operation, without going through a function value or some other intermediary
*/