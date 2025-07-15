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