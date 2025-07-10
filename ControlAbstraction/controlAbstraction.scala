// ------------------------Control Abstraction

// --Reducing code duplication

object FileMatcher {
    private def filesHere = (new java.io.File(".")).listFiles

    def filesEnding(query:String) = {
        for file <- filesHere if file.getName.endsWith(query)
        yield file
    }

    def filesContaining(query:String) = {
        for file <- filesHere if file.getName.contains(query)
        yield file
    }

    def filesRegex(query:String) = {
        for file <- filesHere if file.getName.matches(query)
        yield file
    }
}

//  we can short the above code using function value

object FileMatcher2 {
    private def filesHere = (new java.io.File(".")).listFiles

    def filesMatching(query:String,matcher:(String,String) => Boolean) =
        for file <- filesHere if matcher(file.getName,query)
        yield file

    def filesEnding(query:String) = 
        filesMatching(query,_.endsWith(_))

    def filesContaining(query:String) = 
        filesMatching(query,_.contains(_))

    def filesRegex(query:String) = 
        filesMatching(query,_.matches(_))
}

object FileMatcher2Shorter {
    private def filesHere = (new java.io.File(".")).listFiles

    def filesMatching(matcher:(String) => Boolean) =
        for file <- filesHere if matcher(file.getName)
        yield file

    def filesEnding(query:String) = 
        filesMatching(_.endsWith(query))

    def filesContaining(query:String) = 
        filesMatching(_.contains(query))

    def filesRegex(query:String) = 
        filesMatching(_.matches(query))
}

// --- Simplifying client code

// imperative way
val myList = List(1,2,3,5)

def containsNeg(nums:List[Int]) = {
    var exists = false
    for num <- nums do if num < 0 then exists = true
    exists
}

//  Or more concise way
def containsNeg2(nums:List[Int]) = nums.exists( _ < 0)


def containsOdd(nums: List[Int]): Boolean = {
    var exists = false
    for num <- nums do
        if num % 2 == 1 then
        exists = true
    exists
}

def containsOdd2(nums:List[Int]) = nums.exists(_ % 2 == 1)

/*
There are many other looping methods in Scala’s standard library. As
with exists, they can often shorten your code if you recognize opportunities
to use them.
*/

// --- Currying
/*
A carried function is applied to multiple argument lists, instead of just one.
*/
def plainOldSum(x:Int,y:Int) = x + y

def curriedSum(x:Int)(y:Int) = x + y

val onePlus = curriedSum(1)

def fisrtFunc(x:Int) = (y:Int) => x + y

// ---Writing new control structures

// --the “twice” control structure

def twice(op:Double => Double,x:Double) = op(op(x))

/*
One way in which you can make the client code look a bit more like a
built-in control structure is to use curly braces instead of parentheses to surround the argument list. In any method invocation in Scala in which you’re
passing in exactly one argument, you can opt to use curly braces to surround
the argument instead of parentheses.
*/

val s = "Hello, World"
// s.charAt(1)
// s.charAt{1}
/*
Note: This curly braces technique will work, only if you’re passing in one argument.
*/

// ----By-name parameters

var assertionsEnabled = true

def myAssert(predicate: () => Boolean) = {
    if assertionsEnabled && !predicate() then
        throw new AssertionError
}

/*
To make a by-name parameter, you give the parameter a type starting with => instead of
() =>. For example, you could change myAssert’s predicate parameter into a by-name parameter by changing its type, “() => Boolean”, into
“=> Boolean
*/

def byNameAssert(predicate: => Boolean) = {
    if assertionsEnabled && !predicate then
        throw new AssertionError
}

// byNameAssert(5>3)

def boolAssert(predicate: Boolean) = {
    if assertionsEnabled && !predicate then
        throw new AssertionError
}

// boolAssert(5>3)