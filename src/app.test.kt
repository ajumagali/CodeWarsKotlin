import kotlin.test.assertEquals
import org.junit.Test
import kotlin.math.sqrt

class CodeWarsTest {
    @Test
    fun oneVowel() {
        assertEquals(1, getCount("know"))
    }

    @Test
    fun primeNumber() {
        assertEquals(true, isPrime(11))
    }

    @Test
    fun backwardsPrime() {
        assertEquals("70001 70009 70061 70079 70121 70141 70163 70241", backwardsPrime(70000, 70245))
    }

    fun backwardsPrime(start: Long, end: Long): String {
        var output : String = ""

        var number : Long = start
        while (number <= end) {
            if (number != reverseNumber(number) && isPrime(number) && isPrime(reverseNumber(number))) {
                output += number
                output += " "
            }
            number++
        }
        return output.removeSuffix(" ")
    }

    fun reverseNumber(number : Long) : Long{
        return number.toString().reversed().toLong()
    }

    fun isPrime(number : Long) : Boolean {
        (2..sqrt(number.toDouble()).toLong()).forEach {
            if (number % it == 0L)
                return false
        }

        return true
    }

    fun getCount(str : String) : Int {
        var count = 0
        for (c in str) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                count++
        }

        return count
    }
}