// ------------------------ Classes and Objects ---------------------------------------


// ---------------Class
/*
A class is a blueprint for objects. Once you define a class, you can create
objects from the class blueprint with the keyword new.
*/

// class ChecksumAccumulator {
//     private var sum = 0

//     def add(b:Byte):Unit = {
//         sum += b
//     }

//     def checksum():Int = {
//         return ~(sum & 0xFF) + 1
//     }

// }

// More Concise
// class ChecksumAccumulator{
//     private var sum = 0

//     def add(b:Byte):Unit = sum += b

//     def checksum():Int = ~(sum & 0xFF) + 1
// }

// val acc = new ChecksumAccumulator
// val csa = new ChecksumAccumulator

// val result = if x < 2 then {
//     "too small"
// }else{
//     "ok"
// }

// --------------------Singleton objects

/*
A singleton object definition looks like a class defi-
nition, except instead of the keyword class you use the keyword object.
When a singleton object
shares the same name with a class, it is called that class’s companion object.
You must define both the class and its companion object in the same source
file. The class is called the companion class of the singleton object. A class
and its companion object can access each other’s private members
*/

// import scala.collection.mutable

// object ChecksumAccumulator {
//     private val cache = mutable.Map.empty[String,Int]

//     def calculate(s:String):Int = {
//         if cache.contains(s) then {
//             cache(s)
//         }else {
//             val acc = new ChecksumAccumulator
//             for c <- s do {
//                 acc.add((c>>8).toByte)
//                 acc.add(c.toByte)
//             }
//             val cs = acc.checksum()
//             cache += (s -> cs)
//             return cs
//         }
//     }
//     def showCache():mutable.Map[String,Int]= return cache
// }

// ----------------- Case Class

/*
When you write a class, you need implementations of methods such as
equals, hashCode, toString, accessor methods, or factory methods. These
can be time-consuming and error-prone to write. Scala offers “case classes,”
which can generate implementations of several methods based on the values
passed to its primary constructor.
*/

case class Person(name:String,age:Int)