// --------- Packages, Imports, and Exports

//  Two ways to define packages

/*
package bobsrocket.navigation
class Navigator
*/

/*
package bobsrocket.navigation:
    class Navigator
*/

// ---- Concise access to related code


// package bobsrockets
//     package navigation:
//         class Navigator:
//             // No need to say bobsrockets.navigation.StarMap
//             val map = new StartMap
//         class StartMap
//     class Ship:
//        // No need to say bobsrockets.navigation.Navigator
//         val nav = new navigation.Navigator
//     package fleets:
//         class Fleet:
//             // No need to say bobsrocket.Ship
//             def addShip = new Ship
//             /*
//             Note that this kind of access is only available if you explicitly nest the packaging.
//             If you stick to one package per file, then—like in Java—the only names available will be the ones defined in the current package.
//             */

// package bobsrockets:
//     class Ship

// package bobsrockets.fleets:
//     class Fleet:
//         // Doesn't compile! Ship is not in scope.
//         def addShip = new Ship

// --This style of multiple package clauses without braces is called chained package clauses.
// package bobsrockets
// package fleets
// class Fleet:
//     // No need to say bobsrockets.Ship
//     def addShip = new Ship

// // In file launch.scala
// package launch:
//     class Booster3
// // In file bobsrockets.scala
// package bobsrockets:
//     package launch:
//         class Booster2
//     package navigation:
//         package launch:
//             class Booster1
//         class MissionControl:
//             val booster1 = new launch.Booster1
//             val booster2 = new bobsrockets.launch.Booster2
//             val booster3 = new _root_.launch.Booster3

// ---- Imports

// package bobsdelights:
//     abstract class Fruit(
//         val name:String,
//         val color:String
//     )

//     object Fruit:
//         class Apple extends Fruit("Apple","Red")
//         class Orange extends Fruit("Orange","Orange")
//         class Pear extends Fruit("Pear","Yellowish")
//         val menu = List(Apple,Orange,Pear)

// ------- Implicit imports

import java.lang.* // everything in the java.lang package
import scala.* // everything in the scala package
import Predef.* // everything in the Predef object

/*
These three import clauses are treated a bit specially in that later imports overshadow earlier ones.
*/

// ----------- Access modifiers

// -----Private members
/*
Private members in Scala are treated similarly to Java. A member labeled
private is visible only inside the class or object that contains the member
definition.In Scala, this rule applies also for inner classes.

Java would permit both accesses
because it lets an outer class access private members of its inner classes.
*/

class Outer:
    class Inner:
        private def f = "f"
        class InnerMost:
            def printf:Unit = println(f)

        def printf:Unit = println(f)

// --Protected members

/*
In Scala, a protected member is only accessible from subclasses
of the class in which the member is defined. In Java such accesses are also
possible from other classes in the same package.
*/

// package p:
//     class Super:
//         protected def f = "f"
    
//     class Sub extends Super:
//         f  //OK

//     class Other
//         // (new Super).f  // error: f is not accessible

// In Java, the latter access would be still permitted because Other is in the same package as Super. 

// ------ Public members

/*
Scala has no explicit modifier for public members: Any member not labeled
private or protected is public. Public members can be accessed from
anywhere.
*/


// --------------  Scope of protection -------------

/*
Access modifiers in Scala can be augmented with qualifiers. A modifier
of the form private[X] or protected[X] means that access is private or
protected “up to” X, where X designates some enclosing package, class or
singleton object.
*/

// package bobsrocket
// package navigation:
//     private[bobsrocket] class Navigator2:
//         protected[navigation] def useStarchart() = {}
//         class LogOfJourney:
//             private[Navigator2] val distance = 100

// package launch:
//     import navigation.*
//     object Vechicle:
//         private[launch] val guide = new Navigator2



// ---- Visibility and companion objects

class Rocket:
    import Rocket.fuel
    private def canGoHomeAgain = fuel > 20
object Rocket:
    private def fuel = 10
    def chooseStrategy(rocket: Rocket) =
        if rocket.canGoHomeAgain then
            goHome()
        else
            pickAStar()
    def goHome() = {}
    def pickAStar() = {}

/*
Scala’s access rules privilege companion objects and classes when it
comes to private or protected accesses. A class shares all its access rights
with its companion object and vice versa.
In particular, an object can access all private members of its companion class, just as a class can access all
private members of its companion object.
*/

// ----- Top-level definitions

/*
Any kind of definition that you can put inside a class can also be at the top level of a package.
*/

// ---- Exports
/*
Exports make composition relationships as concise and easy to express
as inheritance relationships. Exports also offer more flexibility than extends
clauses, since members can be renamed or omitted.
*/

