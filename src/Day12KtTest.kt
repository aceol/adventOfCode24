import org.testng.Assert;
import org.testng.Assert.assertEquals
import org.testng.annotations.Test;
import kotlin.math.exp

class Day12KtTest {

    @Test
    fun testEx1() {
        val expected = 10
        var result = day121("day12_ex_01.txt")
        assertEquals(result, expected)
    }
}