@main def whileLoop(args:String*):Unit = {
    var i:Int = 0
    while i<args.length do
        println(args(i))
        i += 1
    
}