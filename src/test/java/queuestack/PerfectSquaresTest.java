package queuestack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfectSquaresTest {

    private PerfectSquares perfectSquares;

    @BeforeEach
    public void setUp() {
        perfectSquares = new PerfectSquares();
    }

    @Test
    public void whenGive12_ThenReturn3(){
        assertEquals(3, perfectSquares.numSquares(12));
    }

}