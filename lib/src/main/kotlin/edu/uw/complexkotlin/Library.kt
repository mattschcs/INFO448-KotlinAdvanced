/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package edu.uw.complexkotlin

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15).
// use map() to return a list with "", "FIZZ" (for 3s) or "BUZZ" (for 5s).
// use fold() to compress the array of strings down into a single string.
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ for 0..15.
// store this lambda into 'fizzbuzz' so that the tests can call it

//Extra Credit :
// Write new tests from 1 to 50 and from 1 to 100,
// Introduce DOH! when evenly divided by seven,
    // added 3 condition
    // when a number can be divided by 3,5,7 -> FIZZBUZZDOH!
    // when a number can be divided by 3,7 -> FIZZDOH!
    // when a number can be divided by 5, 7 ->  BUZZDOH!
    // To test it, added the test case from one to seven, twenty one, thirty five and hundred and five
val fizzbuzz : (IntRange) -> String = {
    range -> range.map { it->
    when {
        it % 3 == 0 && it % 5 == 0 && it % 7 == 0 -> "FIZZBUZZDOH!"
        it % 3 == 0 && it % 7 == 0 -> "FIZZDOH!"
        it % 5 == 0 && it % 7 == 0 -> "BUZZDOH!"
        it % 3 == 0 && it % 5 == 0 -> "FIZZBUZZ"
        it % 3 == 0 -> "FIZZ"
        it % 5 == 0 -> "BUZZ"
        it % 7 == 0 -> "DOH!"
        else -> ""
    }
}.fold(""){ acc, s -> acc + s }
}

// Example usage
/*
if (fizzbuzz(1..2) == "")
    println("Success!")
if (fizzbuzz(1..3) == "FIZZ")
    println("Success!")
if (fizzbuzz(1..5) == "FIZZBUZZ")
    println("Success!")
*/

// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
// Create r1 as a lambda that calls process() with message "FOO" and a block that returns "BAR"
// process function () block wrap it with lambda
val r1 = { process("FOO") {"BAR"}  }

// Create r2 as a lambda that calls process() with message "FOO" and a block that upper-cases 
// r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"
val r2_message = "wooga"
val r2 = {
    process("FOO") { r2_message.uppercase().repeat(3)}

}

// write an enum-based state machine between talking and thinking

// Extra Credit: Seneca the Younger

//Seneca the Younger is a Roman philosopher who adheres to the principles of Stoicism, a school of thought that emphasizes reason, self-control, and virtue as essential to a good life.

enum class Philosopher {
// create an class "Command" that can be used as a function.
// To do this, provide an "invoke()" function that takes a 
// single parameter ("message" of type String). Command's
// primary constructor should take a String argument ("prompt").
// When invoked, the Command object should return a String
// containing the prompt and then the message.
// Example:
// val cmd = Command(": ")
// val result = cmd("Hello!")
// result should equal ": Hello!"
    THINKING {
        override fun toString(): String {
            return "Deep thoughts...."  // Corrected to four dots
        }
    },
    TALKING {
        override fun toString(): String {
            return "Allow me to suggest an idea..."
        }
    };

    // switch states
    fun signal(): Philosopher {
        return when (this) {
            THINKING -> TALKING
            TALKING -> THINKING
        }
    }
}


class Command(val prompt: String) {
    operator fun invoke(message: String): String {
        return "$prompt$message"
    }
}