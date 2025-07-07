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

// Map
// import scala.collection.mutable.Map

// val capital = Map("USA"->"Washington","France"->"Paris")
// capital += ("India"->"Delhi")

// HashMap
