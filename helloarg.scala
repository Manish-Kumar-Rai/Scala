@main def hello(args:String*) = println("Hello "+args(0)+" !")

// scala helloarg.scala -- Planet
// helloarg.scala: the source file containing the @main method
// -- : tells scala-cli to treat everything after it as arguments to the program
// Planet: the argument passed to your @main function, accessible via args(0)
