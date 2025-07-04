// Introduction to Scala

import java.math.BigInteger

// var capital = Map("US"-> "Washington", "France" -> "Paris")
// capital += ("Japan" -> "Tokyo")
// println(capital("France"))

def factorial(x:BigInt):BigInt = {
    if (x == 0) 1
    else x*factorial(x-1)
}

def factorial2(x:BigInteger):BigInteger = {
    if (x == BigInteger.ZERO) BigInteger.ONE
    else x.multiply(factorial2(x.subtract(BigInteger.ONE)))
}

// factorial2(BigInteger.valueOf(30))

// Scala lets you add new types that can be used as conveniently as built-in types. The same extension principle
// also applies to control structures 

// class SetSpec extends AnyFunSuit :
//     test("An empty Set should have size 0") {
//         assert(Set.empty.size == 0)
//     }
//     test("Invoking head on an empty Set should Fail"){
//         assertThrows[NoSuchElementException]{
//             Set.empty.head
//         }
//     }

// val x = 1 to 3
// val it = x.iterator
// eventually{it.next() shouldBe 3}