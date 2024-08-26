// Data structures

// Tuples

// Immutable Lists

val captainStuff = ("Picard", "Enterprise-D", "NCC-1701-D")
println(captainStuff)

// 인덱스로 개별 필드 참조하기 Refer to the individual fields with a ONE-BASED index
var captainStuffOne = captainStuff._1
println(captainStuffOne)
println(captainStuff._2)
println(captainStuff._3)

// Key-Value Pair
val picardsShip = "Picard" -> "Enterprice-D"
println(picardsShip._2)

// 서로 다른 타입을 가지는 튜플 예시
val aBunchOfStuff = ("Kirk", 1964, true)
println(aBunchOfStuff._1)

// Lists - 서로 다른 타입의 항목을 가질 수 없음
// Like a tuple, but more functionality
// Must be of same type
val shipList = List("Enterprise", "Defiant", "Voyager", "Deep Space Nine")

// 인덱스로 개별 요소 추출 - zero-based
val shipListOne = shipList(0)
println(shipListOne)

println(shipList.head)

// 첫번째를 제외한 나머지 리스트를 반환
println(shipList.tail)


for (ship <- shipList) {
  println(ship)
}

// 함수 리터럴
val backwardShips = shipList.map( (ship:String) => {
  ship.reverse
})

for (ship <- backwardShips) {
  println(ship)
}

// Map - Reduce
// reduce() to combine together all the items in a collection using some function
val numberList = List(1, 2, 3, 4, 5)
val sum = numberList.reduce( (x:Int, y: Int) => (x + y))
println(sum)

// filter()
val iHateFives = numberList.filter( (x:Int) => x != 5)
println(iHateFives)

val iHateThrees = numberList.filter(_ != 3)
println(iHateThrees)

// Concatenate Lists
val moreNumbers = List(6, 7, 8)
val lotsOfNumbers = numberList ++ moreNumbers
println(lotsOfNumbers)

val reversed = lotsOfNumbers.reverse
println(reversed)

val sorted = reversed.sorted
println(sorted)

val lotsOfDuplicates = lotsOfNumbers ++ lotsOfNumbers
println(lotsOfDuplicates)

val distinctValues = lotsOfDuplicates.distinct
println(distinctValues)

val maxValue = lotsOfNumbers.max
println(maxValue)

val totalValue = lotsOfNumbers.sum
println(totalValue)

val hasTree = iHateThrees.contains(3)
println(hasTree)


// Map (Key - Value)
val shipMap = Map("Kirk" -> "Enterprise", "Picard" -> "Enterprise-D", "Sisko" -> "Deep Space Nine", "Janeway" -> "Voyager")
println(shipMap)
println(shipMap("Janeway"))
println(shipMap.contains("Archer"))

val archersShip = util.Try(shipMap("Archer")) getOrElse "Unknown"
println(archersShip)

// EXERCISE
//// Create a list of the numbers 1-20; your job is to print out numbers that are evenly divisible by three. (Scala's
//// modula operator, like other languages, is %, which gives you the remainder after division. For example, 9 % 3 = 0
//// because 9 is evenly divisible by 3.) Do this first by iterating through all the items in the list and testing each
//// one as you go. Then, do it again by using a filter function on the list instead.
val numbers = List.range(1, 20)
for (num <- numbers) {
  if (num % 3 == 0) {
    println(num)
  }
}

val numberWithDivisibleByThree = numbers.filter(_ % 3 == 0)
println(numberWithDivisibleByThree)
