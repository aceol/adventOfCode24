package adv_12_2025

import org.testng.Assert.assertEquals
import org.testng.annotations.Test;

class Day12KtTest {

    @Test
    fun testEx1_01() {
        val expected = 140
        var result = day121("adv_12_2025/day12_ex_01.txt")
        assertEquals(result, expected)
    }

    @Test
    fun testEx1_02() {
        val expected = 772
        var result = day121("adv_12_2025/day12_ex_02.txt")
        assertEquals(result, expected)
    }

    @Test
    fun testEx1_03() {
        val expected = 1930
        var result = day121("adv_12_2025/day12_ex_03.txt")
        assertEquals(result, expected)
    }
}