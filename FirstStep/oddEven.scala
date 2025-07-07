@main def oddEven(args:String*):Unit = {
    var i:Int = 0;
    while i < args.length  do {
        if (args(i).toInt % 2 == 0) then println(args(i) + " Even");
        else println(args(i)+" Odd");
        i += 1;
    }
}