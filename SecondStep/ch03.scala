// Parameterize arrays with types

// val big = new java.math.BigInteger("12456")

// val greetStrings:Array[String] = new Array[String](3)
// greetStrings(0) = "Hello"
// greetStrings(1) = ", "
// greetStrings(2) = "world!\n"
// for i <- 0 to 2 do // 2 is included
//     println(greetStrings(i))


// ----------the following is semantically equivalent to the code
// val greetStrings:Array[String] = new Array[String](3)
// greetStrings.update(0,"Hello")
// greetStrings.update(1," ")
// greetStrings.update(2,"World\n")

// for i <- 0.to(2) do
//     print(greetStrings.apply(i))

//  ------more concise way to create and initialize arrays
// val numNames = Array("One","Two","Three")
// val numNames = Array.apply("One","Two","Three")

// an immutable sequence of objects that share the same type 
// val myList:List[Int] = List(1,2,3)
// val myList = List(1,2,3)

// ----list concatenation
// val oneTwo = List(1,2)
// val threeFour = List(3,4)
// val oneTwoThreeFour = oneTwo ::: threeFour

// "Cons" operator, prepend an element, is right operand, for append use :+
// any method that ends with colon is right operand
// val zeroOneTwo = 0 :: oneTwo // (0,1,2)  oneTwo.::(0)

// val nameSurname = "Name" :: "Surname" :: Nil  // Nil is empty list

// Like lists, tuples are immutable, but unlike lists, tuples can contain different types of elements.
// val pair = (99,"balls")

// Sets
// immutable Set
// var jetSet = Set("Boeing","Airbus")
// jetSet += "Lear"
// val query = jetSet.contains("Cessna") // false

// mutable Set
// import scala.collection.mutable
// val movieSet = mutable.Set("Spotlight", "Moonlight")
// movieSet += "Parasite"
// movieSet now contains: "Spotlight", "Moonlight", "Parasite"

//HashSet
// import scala.collection.immutable.HashSet
// val hashSet = HashSet("Tomatoes", "Chilies")
// val ingredients = hashSet + "Coriande

// Map and HashMap
// import scala.collection.mutable.Map

// val capital = Map("USA"->"Washington","France"->"Paris")
// capital += ("India"->"Delhi")

// Learn to recognize the functional style
//  Note: var for imperative and val for functional
// Imperative Style using var
// def printArgs(args:List[String]):Unit = {
//     var i = 0
//     while i < args.length do
//         println(args(i))
//         i += 1
// }

// You can transform this bit of code into a more functional style by getting rid of the var
// def printArgs(args:List[String]):Unit =
//     for arg <- args do
//         println(arg)

//  --- Or this
// def printArgs(args:List[String]):Unit = {
//     args.foreach(println)
// }

// A more functional approach would be to define a method that formats
// the passed args for printing, but just returns the formatted string

// def formatStrings(args:List[String]) = args.mkString("\n")

// Transform with map and for-yield

/*
When programming in an imperative style, you mutate data structures in
place until you achieve the goal of the algorithm. In a functional style, you
transform immutable data structures into new ones to achieve the goal
*/

// An important method that facilitates functional transformations on immutable collections is map
// val adjectives = List("One","Two","Red","Blue")

// val nouns = adjectives.map(adj => adj + " Fish.")

/*
Another way to perform this transformation is to use a for expression in
which you introduce the body with the keyword yield instead of do
*/
// val nouns = {
//     for adj <- adjectives yield
//         adj + " Fish"
// }
/*
Note: The for-yield produces exactly the same result as map because the compiler transforms
 the for-yield expression into the map call.
*/

/*
Note: If the function passed to map results in a different type, then
the List returned by map will have that type as its element type
*/

// val lengths = nouns.map(noun => noun.length)
// val lengths = {
//     for noun <- nouns yield
//         noun.length
// }

/*
The map method appears on many types, not just List. This enables
for expressions to be used with many types. One example is Vector, which
is an immutable sequence that provides “effectively constant time” performance for all its operations.
*/

// val ques = Vector("Who","Where","What","Why")

// val usingMap = ques.map(q => q.toLowerCase() + "?")

// val usingForYield = {
//     for q <- ques yield
//         q.toLowerCase() + "?"
// }

/*
OPTIONS:
    An Option is either a Some, which indicates that a
value exists, or None, which indicates that no value exists
*/

// the result type of find is always Option[String]
// val startsW = ques.find(q=>q.startsWith("W")) //Some(Who)
// val hasLen4 = ques.find(q=> q.length == 4)   //Some(What)
// val hasLen5 = ques.find(q=> q.length == 5)  //Some(Where)
// val startsH = ques.find(q=> q.startsWith("H"))  //None

/*
One way to think of Option, however, is as a collection that contains either zero (the
None case) or one (the Some case) elements.
*/