// -----------------Closures
/*
In Scala, a closure is a function that captures the bindings of free variables (variables defined outside the function) and retains access to them even when the function is used in a different context.
*/

val more = 10
val addMore = (x:Int) => x + more

/*
In Scala, "surrounding scope" refers to the block of code (or environment) outside a function or expression where variables are defined and available.
*/
