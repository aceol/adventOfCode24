import org.testng.Assert;
import org.testng.Assert.assertEquals
import org.testng.annotations.Test;
import kotlin.math.exp

class Day11KtTest {

    @Test
    fun testEx1() {
        val expected = 7
        var result = day111("0 1 10 99 999", 1)
        assertEquals(result, expected)
    }

    @Test
    fun testEx1_2_6cycles() {
        val expected = 22
        var result = day111("125 17", 6)
        assertEquals(result, expected)
    }

    @Test
    fun testEx1_3_25cycles() {
        val expected = 55312
        var result = day111("125 17", 25)
        assertEquals(result, expected)
    }

    @Test
    fun testEx2_1_25cycles() {
        val expected = 55312.toLong()
        var result = day112("125 17", 25)
        assertEquals(result, expected)
    }
}