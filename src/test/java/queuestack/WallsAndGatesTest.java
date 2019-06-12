package queuestack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallsAndGatesTest {

    private int[][] input;
    private WallsAndGates wallsAndGates;

    @BeforeEach
    public void setUp() {
        input = new int[][] {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        wallsAndGates = new WallsAndGates();
    }

    @Test
    void wallsAndGates() {
        wallsAndGates.wallsAndGates(input);
    }
}