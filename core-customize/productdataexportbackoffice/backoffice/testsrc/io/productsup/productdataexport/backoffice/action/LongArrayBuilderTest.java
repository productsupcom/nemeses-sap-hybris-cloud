package io.productsup.productdataexport.backoffice.action;

import org.junit.Assert;
import org.junit.Test;

import de.hybris.bootstrap.annotations.UnitTest;

@UnitTest
public class LongArrayBuilderTest {

    @Test
    public void testNormal() {
        this.testBuilding(10);
    }

    @Test
    public void testOverfill() {
        this.testBuilding(4);
    }

    @Test
    public void testUnderfill() {
        this.testBuilding(100);
    }

    private void testBuilding(final int initialSize) {
        final LongArrayBuilder builder = new LongArrayBuilder(initialSize);
        for (long i = 0; i < 10; i++) {
            builder.append(i);
        }
        final long[] result = builder.build();
        Assert.assertEquals("Length", 10, result.length);
        Assert.assertArrayEquals("Contents", new long[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, result);
    }
}
