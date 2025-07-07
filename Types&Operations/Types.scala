// -------------------- Basic Types and Operations --------------

/*
Types Byte, Short, Int, Long, and Char are called integral types. The integral
types plus Float and Double are called numeric types
*/

//------- Integer literals
/*
If the number begins with a 0x or 0X, it is hexadecimal (base 16)
*/
// val hex = 0x5 // 5: Int
// val hex2 = 0x00FF // 255: Int
// val magic = 0xcafebabe // -889275714: Int
// val billion = 1_000_000_000 // 1000000000: Int

/*
Note that the Scala REPL always prints integer values in base 10, no
matter what literal form you may have used to initialize it
*/

// val dec1 = 31 // 31: Int
// val dec2 = 255 // 255: Int
// val dec3 = 20 // 20: Int

/*
If an integer literal ends in an L or l, it is a Long; otherwise it is an Int
*/
// val prog = 0XCAFEBABEL // 3405691582: Long
// val tower = 35L // 35: Long
// val of = 31l // 31: Long

/*
If an Int literal is assigned to a variable of type Short or Byte, the
literal is treated as if it were a Short or Byte type so long as the literal value
is within the valid range for that type.
*/

// val little: Short = 367 // 367: Short
// val littler: Byte = 38 // 38: Byte

//------ Floating point literals

/*
Floating point literals are made up of decimal digits, optionally containing a
decimal point, and optionally followed by an E or e and an exponent.
*/

// val big = 1.2345 // 1.2345: Double
// val bigger = 1.2345e1 // 12.345: Double
// val biggerStill = 123E45 // 1.23E47: Double
// val trillion = 1_000_000_000e3 // 1.0E12: Double

/*
If a floating-point literal ends in an F or f, it is a Float; otherwise it is a Double.
Optionally, a Double floating-point literal can end in D or d.
*/
// val little = 1.2345F // 1.2345: Float
// val littleBigger = 3e5f // 300000.0: Float

// val anotherDouble = 3e5 // 300000.0: Double
// val yetAnother = 3e5D // 300000.0: Double

// ------------- Larger numeric literals
/*
In Scala 3 includes an experimental feature that eliminates size limits for
numeric literals and allows them be used to initialize arbitrary types. You
can enable the feature with this language import
*/
// import scala.language.experimental.genericNumberLiterals

// val invoice: BigInt = 1_000_000_000_000_000_000_000
// val pi: BigDecimal = 3.1415926535897932384626433833

// -----------------Character literals

/*
Character literals are composed of any Unicode character between single
quotes.
*/

// val a = 'A'

/*
In addition to providing an explicit character between the single quotes, you
can identify a character using its Unicode code point. To do so, write \u
followed by four hex digits with the code point.
*/

// val a = '\u0041'
// val d = '\u0044'
/*
 Unicode escapes do work in Scala (like in Java), but only when written directly in the source file.
*/
// val B\u0041\u0044 = 1

// val backslash = '\\'

// -------------------- String literals
/*
A string literal is composed of characters surrounded by double quotes.
*/

// val myName = "Manish"
// val escapes = "\\\"\'"

// val rawStrings = """
// Welcome to Ultamax 3000.
// Type "HELP" for help.
// """

/*
The issue is that the leading spaces before the second line are included in the
string! To help with this common situation, you can call stripMargin on
strings. To use this method, put a pipe character (|) at the front of each line,
and then call stripMargin on the whole string
*/

// println("""|Welcome to Ultamix 3000.
//            |Type "HELP" for help.""".stripMargin)

//--------Boolean literals
/*
The Boolean type has two literals, true and false:
*/
// val bool = true // true: Boolean
// val fool = false // false: Boolean

// -------------------- String interpolation
/*
A flexible mechanism , which allows
you to embed expressions within string literals
*/
// val name = "Manish"
// println(s"Hello, $name!")
// println(s"mulitply : ${6 * 8}")

/*
Scala provides two other string interpolators by default: raw and f. The
raw string interpolator behaves like s, except it does not recognize character
literal escape sequences.
*/

// val raw = raw"No\\\\escape"

/*
The f string interpolator allows you to attach printf-style formatting
instructions to embedded expressions. You place the instructions after the
expression, starting with a percent sign (%), using the syntax specified by
java.util.Formatter
*/

// println(f"${math.Pi}%.3f")