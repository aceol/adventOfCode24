package year2021

import org.testng.Assert.assertEquals
import org.testng.annotations.Test;

class Day12KtTest {

    @Test
    fun testEx1() {
        val expected = 10
        var result = day121("year2021/day12_ex_01.txtex_01.txt")
        assertEquals(result, expected)
    }

    @Test
    fun testEx2() {
        val expected = 19
        var result = day121("year2021/day12_ex_02.txtex_02.txt")
        assertEquals(result, expected)
    }

    @Test
    fun testEx3() {
        val expected = 226
        var result = day121("year2021/day12_ex_03.txtex_03.txt")
        assertEquals(result, expected)
    }
}