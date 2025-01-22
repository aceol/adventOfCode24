import org.testng.Assert;
import org.testng.Assert.assertEquals
import org.testng.annotations.Test;
import kotlin.math.exp

class Day10KtTest {

    @Test
    fun testEx1() {
        val expected = 2
        var result = day101("day10_ex1")
        assertEquals(result, expected)
    }

    @Test
    fun testEx2() {
        val expected = 4
        var result = day101("day10_ex2")
        assertEquals(result, expected)
    }

    @Test
    fun testEx3() {
        val expected = 3
        var result = day101("day10_ex3")
        assertEquals(result, expected)
    }

    @Test
    fun testEx4() {
        val expected = 36
        var result = day101("day10_ex4")
        assertEquals(result, expected)
    }

}