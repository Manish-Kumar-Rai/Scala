// --------------------- Built-in Control Structures

/*
Scala has only a handful of built-in control structures. The only control structures are if, while, for, try, match, and function calls
*/

// --------------If expressions

// var fileName = "test.txt"

// if !args.isEmpty then fileName = args(0)

// val fileName = if !args.isEmpty then fileName = args(0) else "test.txt"

// ---------- While loops

def gcdLoop(x:Long,y:Long):Long = {
    var a = x
    var b = y
    while a != 0 do {
        val temp = a
        a = b % a
        b = temp
    }
    return b
}

// using recursion function
def gcd(x:Long,y:Long):Long = {
    if y == 0 then x else gcd(y,x%y)
}

// -------- For expressions
// --Iteration through collections

var filesHere = (new java.io.File(".")).listFiles()

for file <- filesHere do {
    println(file.toString().drop(2))
}

// Range
for i <- 1 to 4 do {
    println(s"Iteration: $i")
}

/*
If you don’t want to include the upper bound of the range in the values that
are iterated over, use until instead of to.
*/

for i <- 1 until 4 do {
    println(s"Iteration: $i")
}

for i <- 0 until filesHere.length do {
    println(s"Iteration: $i")
}

// ---- Filtering
/*
Sometimes you don’t want to iterate through a collection in its entirety; you
want to filter it down to some subset. You can do this with a for expression
by adding a filter, an if clause inside the for’s parentheses.
*/

for file <- filesHere if file.getName.endsWith(".scala") do
println(file)

for file <- filesHere do {
    if file.getName.endsWith(".scala") then println(file.toString().drop(2))
}

/*
You can include more filters if you want. Just keep adding if clauses
*/
for
    file <- filesHere
    if file.isFile
    if file.getName.endsWith("scala")
do println(file)

for
    file <- filesHere
    if (file.isFile && file.getName.endsWith("scala"))
do println(file)

// ----Nested iteration
//  <- = generator clause

def fileLines(file:java.io.File) = scala.io.Source.fromFile(file).getLines().toArray

def grep(pattern: String): Unit = {
  for
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    if line.trim.matches(pattern)
  do
    println(s"${file.toString.drop(2)} : ${line.trim}")
}

// Producing a new collection

def scalaFiles = {
    for 
        file <- filesHere
        if file.getName.endsWith(".scala")
    yield file
}

val forLineLengths = 
    for
        file <- filesHere
        if file.getName.endsWith(".scala")
        line <- fileLines(file)
        trimmed = line.trim
        if trimmed.matches(".*for.*")
    yield trimmed.length

//  -- Exception handling with try expressions

// Throwing exceptions
/*
Throwing an exception in Scala looks the same as in Java. You create an
exception object and then throw it with the throw keyword:
*/

throw new IllegalArgumentException

def half(n:Int):Int = {
    if n % 2 == 0 then
        n/2
    else
        throw new RuntimeException("n must be even.")
}

// Catching exceptions
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

var f: FileReader = null
try {
  f = new FileReader("input.txt")
  println("File opened successfully")
}catch {
  case ex: FileNotFoundException =>
    println("File not found: ")
  case ex: IOException =>
    println("I/O error: ")
}finally{
    if (f != null) f.close()
}

// -- Yielding a value

import java.net.URL
import java.net.MalformedURLException

def urlFor(path: String) =
    try new URL(path)
    catch case e: MalformedURLException =>
        new URL("http://www.scala-lang.org")

def f(): Int = try return 1 finally return 2 //2

def g(): Int = try 1 finally 2 //1

// ---Match expression

val food:String = ""

food match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
}

// A match expression that yields a value.
val firstArg = if !args.isEmpty then args(0) else ""
val friend =
    firstArg match{
        case "salt" => "pepper"
        case "chips" => "salsa"
        case "eggs" => "bacon"
        case _ => "huh?"
    }
println(friend)

// ---Living without break and continue

var i = 0
var foundit = false
// Looping without break or continue.
while (i < args.length && !foundit) {
    if !args(i).startsWith("-"){
        if args(i).endsWith(".scala"){
            foundit = true
        }else{
            i += 1
        }
    }else{
        i += 1
    }
}

// A recursive alternative to looping with vars.
def searchFrom(i:Int):Int = {
    if i >= args.length then -1
    else if args(i).startsWith("-") then searchFrom(i + 1)
    else if args(i).endsWith(".scala") then i
    else searchFrom(i + 1)
}

// ------Variable scope

/*
Variable declarations in Scala programs have a scope that defines where
you can use the name. The most common example of scoping is that indentation generally introduces a new scope, so anything defined at a particular indentation level leaves scope after an outdent.
*/

def printMultiTable(): Unit = {
  var i = 1
  while (i <= 10) {
    var j = 1
    while (j <= 10) {
      val prod = (i * j).toString
      var k = prod.length
      while (k < 4) {
        print(" ")
        k += 1
      }
      print(prod)
      j += 1
    }
    println()
    i += 1
  }
}

/*
You can, on the other hand, define a variable in an inner scope that has the
same name as a variable in an outer scope.
*/

val a = 1
if a == 1 then
    val a = 2 // Compiles just fine
    println(a)
println(a)


// ----------Refactoring imperative-style code

def makeRowSeq(row:Int) = {
    for col <- 1 to 10 yield
        val prod = (row * col).toString
        val padding = " " * (4 - prod.length)
        padding + prod
}

def makeRow(row:Int) = makeRowSeq(row).mkString

def multiTable() = {
    val tableSeq = {
        for row <- 1 to 10 yield
            makeRow(row)
    }
    tableSeq.mkString("\n")
}