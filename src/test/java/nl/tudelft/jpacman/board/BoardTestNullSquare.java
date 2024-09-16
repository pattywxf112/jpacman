package nl.tudelft.jpacman.board;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTestNullSquare {

    private Board boardWithSquare;
    private Board boardWithNullSquare;

    private Square square;

    @BeforeEach
    void setUp() {
        square = new BasicSquare();

        // Board with a valid square
        Square[][] gridWithSquare = {{ square }};
        boardWithSquare = new Board(gridWithSquare);

        // Board with a null square
        Square[][] gridWithNullSquare = {{ null }};
        boardWithNullSquare = new Board(gridWithNullSquare);
    }

    @Test
    void testSquareAtValidSquare() {
        Square retrievedSquare = boardWithSquare.squareAt(0, 0);
        assertThat(retrievedSquare).isEqualTo(square);
    }

    @Test
    void testSquareAtNullSquare() {
        assertThrows(AssertionError.class, () -> {
            boardWithNullSquare.squareAt(0, 0);
        });
    }
}
