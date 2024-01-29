// Flow control



// If / else:
if (1 > 3) println("Impossible!") else println("The world makes sense.")

if (1 > 3) {
  println("Impossible!")
  println("Really?")
} else {
  println("The world makes sense.")
  println("still.")
}

// Matching
val number = 3
number match {
  case 1 => println("One")
  case 2 => println("Two")
  case 3 => println("Three")
  case _ => println("Something else")
}

// For loop
for (x <- 1 to 4) {
  val squared = x * x
  println(squared)
}

// While loop
var x = 10
while (x >= 0) {
  println(x)
  x -= 1
}

// do-while loop
x = 0
do { println(x); x += 1 } while (x <= 10)

// Expressions
{ val x = 10; x + 20 } // return 문이 없어도, 블록의 마지막 구문이 반환값
println({val x = 10; x + 20})

// EXERCISE
// Write some code that prints out the first 10 values of the Fibonacci sequence.
// This is the sequence where every number is the sum of the two numbers before it.
// So, the result should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
var a = 0
var b = 1
for (i <- 1 to 10) {
  println(a)
  var c = a + b;
  a = b;
  b = c;
}

