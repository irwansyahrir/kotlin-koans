package iv_properties

import org.junit.Assert.*
import org.junit.Test

class _33_Lazy_Property {
    @Test fun testLazy() {
        var initialized = false
        val lazyProperty = LazyProperty { initialized = true; 42 }
        assertFalse("Property shouldn't be initialized before access", initialized)
        val result: Int = lazyProperty.lazy
        assertTrue("Property should be initialized after access", initialized)
        assertEquals(42, result)
    }

    @Test fun initializedOnce() {
        var initialized = 0
        val lazyProperty = LazyProperty { initialized++; 42 }
        lazyProperty.lazy
        lazyProperty.lazy
        assertEquals("Lazy property should be initialized once", 1, initialized)
    }

    @Test
    fun `initialized without initial value`() {
        var initialized = 0
        val lazyProperty = LazyProperty {initialized++}
        var result = lazyProperty.lazy
        assertEquals( "Use the initial value of the class", 0, result)

        result += 100
        assertEquals( "Use the initial value of the class", 100, result)

        val anotherResult = lazyProperty.lazy  // buat apa ya ini?
        assertEquals("What will be here?", 0, anotherResult)

        assertEquals("Lazy property should be initialized once", 1, initialized)
    }
}
