package backjun.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxResultTest {

    @Test
    public void testGetMaxResult() {
        MaxResult maxResult = new MaxResult();
        assertEquals(27, maxResult.getMaxResult(new int[]{1,2,4,3,5}));
        assertEquals(43, maxResult.getMaxResult(new int[]{6,2,3,3,2,5}));
        assertEquals(45, maxResult.getMaxResult(new int[]{6,2,3,3,2,5,2}));
        assertEquals(42, maxResult.getMaxResult(new int[]{6,2,3,3,1,5}));
        assertEquals(4, maxResult.getMaxResult(new int[]{1,1,1,1}));

        assertEquals(20, maxResult.getMaxResult(new int[]{3,2,6,0}));
        assertEquals(22, maxResult.getMaxResult(new int[]{3,2,6,0,1,1}));


    }

}