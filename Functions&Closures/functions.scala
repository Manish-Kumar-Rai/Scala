// ------------------Functions 

// ---Methods

/*
The most common way to define a function is as a member of some object;
such a function is called a method.
*/

val text = """The most common way to define a function is as a member of some object;
such a function is called a method."""

object Padding {
    def padLines(text:String,minWidth:Int):String = {
        val paddedLines = 
            for line <- text.linesIterator yield
                padLine(line,minWidth)
        paddedLines.mkString("\n")
    }

    private def padLine(line:String,minWidth:Int):String = {
        if line.length >= minWidth then line
        else line + " "*(minWidth - line.length) 
    }
}

// ----------- Local functions
/*
Scala offers an additional approach: you can define functions
inside other functions. Just like local variables, such local functions are visible only in their enclosing block
*/

def padLines(text:String,minWidth:Int):String = {
    def padLine(line:String,minWidth:Int):String = {
        if line.length >= minWidth then line
        else line + "_"*(minWidth - line.length)
    }
    val paddedLines = 
        for line <- text.linesIterator yield
            padLine(line,minWidth)
    paddedLines.mkString("\n")
}

/*
Note: local functions can access the parameters of their enclosing function.
*/

def padLinesRefactor(text:String,minWidth:Int):String = {
    def padLine(line:String):String = {
        if line.length >= minWidth then line
        else line + "_"*(minWidth - line.length)
    }
    val paddedLines = 
        for line <- text.linesIterator yield
            padLine(line)
    paddedLines.mkString("\n")
}

// ------------- First-class functions

/*
Scala has first-class functions. Not only can you define functions and call
them, but you can write down functions as unnamed literals and then pass
them around as values.
*/

val myList:List[Int] = List(1,2,3)

/*
Function values are objects, so you can store them in variables if you like.
They are functions, too, so you can invoke them using the usual parentheses
function-call notation.
*/

val increase = (x:Int) => x + 1
// when writing in repl use {} for block.
val addTwo = (x:Int) =>
    val increment = 2
    x + 2

val someNumbers:List[Int] = List(-11, -10, -5, 0, 5, 10)

// someNumbers.foreach((x:Int) => println(x))

// someNumbers.filter((x:Int) => x>0)

// ------Short forms of function literals
// 1. One way to make a function literal more brief is to leave off the parameter types.
// 2. A second way to remove useless characters is to leave out parentheses around a parameter whose type is inferred.

// someNumbers.filter(x => x>0)

// ----- Placeholder syntax
/*
To make a function literal even more concise, you can use underscores as
placeholders for one or more parameters, so long as each parameter appears
only one time within the function literal.
*/
// someNumbers.filter(_ > 0)

/*
Sometimes when you use underscores as placeholders for parameters,
the compiler might not have enough information to infer missing parameter
types.
In such cases, you can specify the types using a colon,
*/
val f = (_:Int) + (_:Int)

/*
Note that _ + _ expands into a literal for a function that takes two parameters. This is why you can use this short form only if each parameter appears
in the function literal exactly once. Multiple underscores mean multiple parameters, not reuse of a single parameter repeatedly.
*/

// ----------- Partially applied functions
def sum(a:Int,b:Int,c:Int) = a + b + c
/*
A partially applied function is an expression in which you don’t supply all of the arguments needed by the function. Instead, you supply some, or none, of the needed arguments.
*/
val a = sum(_,_,_) // or val a = sum

val b = sum(1,_,3) //partially applied arguments