// --------------------- Operators are methods

// val sum = 1 + 2
// val anothersum = 1.+(2)
// val longSum = 1 + 2L  // Scala invokes 1.+(2L)

/*
You can use any method in operator notation, so long as it takes
just one parameter
*/
// val s = "Hello, world"
// println(s `indexOf` 'o')

// println(s.toLowerCase)

// import scala.language.postfixOps
// println(s toLowerCase)

//---------- Arithmetic operations

// 1.2 + 2.3 // 3.5: Double
// 3 - 1 // 2: Int
// 'b' - 'a' // 1: Int
// 2L * 3L // 6: Long
// 11 / 4 // 2: Int
// 11 % 4 // 3: Int
// 11.0f / 4.0f // 2.75: Float
// 11.0 % 4.0 // 3.0: Double

// val neg = 1 + -3 // -2: Neg
// val y = +3 // 3: Int
// -neg // 2: Int

// ----- Relational and logical operations

// 1 > 2 // false: Boolean
// 1 < 2 // true: Boolean
// 1.0 <= 1.0 // true: Boolean
// 3.5f >= 3.6f // false: Boolean
// 'a' >= 'A' // true: Boolean
// val untrue = !true // false: Boolean

// val toBe = true // true: Boolean
// val question = toBe || !toBe // true: Boolean
// val paradox = toBe && !toBe // false: Boolean

/*
The && and || operations short-circuit as in Java: expressions built from
these operators are only evaluated as far as needed to determine the result.
In other words, the right-hand side of && and || expressions won’t be evaluated if the left-hand side determines the result
*/

/*
If you want to evaluate the right hand side no matter what, use & and | instead.
*/

// -------Bitwise operations

// 1 & 2 // 0: Int
// 1 | 2 // 3: Int
// 1 ˆ 3 // 2: Int
// ~1 // -2: Int

// -1 >> 31 // -1: Int
// -1 >>> 31 // 1: Int
// 1 << 2 // 4: Int

// ------------ Object equality

/*
If you want to compare two objects for equality, you can use either == or its
inverse !=.
*/

// 1 == 2 // false: Boolean
// 1 != 2 // true: Boolean
// 2 == 2 // true: Boolean

// These operations actually apply to all objects, not just basic types.

// List(1, 2, 3) == List(1, 2, 3) // true: Boolean
// List(1, 2, 3) == List(4, 5, 6) // false: Boolean

// you can compare two objects that have different types:

// 1 == 1.0 // true: Boolean
// List(1, 2, 3) == "hello" // false: Boolean

// List(1, 2, 3) == null // false: Boolean
// null == List(1, 2, 3) // false: Boolean
// ("he" + "llo") == "hello" // true: Boolean

// ------------Operator precedence and associativity

/*
Operator precedence determines which parts of an expression are evaluated
before the other parts.Scala decides precedence based on the first character of the methods used in
operator notation.
*/

/*
Table 5.3 · Operator precedence
(all other special characters)
* / %
+ -
:
< >
= !
&
ˆ
|
(all letters)
(all assignment operators)
*/

/*
When multiple operators of the same precedence appear side by side in
an expression, the associativity of the operators determines the way operators
are grouped.
The associativity of an operator in Scala is determined by its
last character.
No matter what associativity an operator has, however, its operands are
always evaluated left to right.
If the methods end in ‘:’, they are
grouped right to left; otherwise, they are grouped left to right
*/