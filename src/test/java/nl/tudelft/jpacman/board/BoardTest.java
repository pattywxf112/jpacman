package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link Board}.
 */
public class BoardTest {

    private Board board;
    private Square square;

    /**
     * Set up a 1x1 board.
     */
    @BeforeEach
    void setUp() {
        square = new BasicSquare();
        Square[][] grid = {{ square }};
        board = new Board(grid);

    }

    /**
     Test board's dimensions is correct.
     */
    @Test
    void testBoardDimensions() {
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
    }

}
