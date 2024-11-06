package nl.tudelft.jpacman.board;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//this is a comment
public class BoardTestNullSquare { //this is a comment of boardtestnullsquare
//this is a comment
    private Board boardWithSquare;
    private Board boardWithNullSquare;

    private Square square;
//this is a comment
    @BeforeEach //this is beforeach
    void setUp() { //this is a comment
        square = new BasicSquare();

        // Board with a valid square
        Square[][] gridWithSquare = {{ square }};
        boardWithSquare = new Board(gridWithSquare);

        // Board with a null square
        Square[][] gridWithNullSquare = {{ null }};
        boardWithNullSquare = new Board(gridWithNullSquare);
    }
//this is a comment
    @Test //thisisatest
    void testSquareAtValidSquare() {
        Square retrievedSquare = boardWithSquare.squareAt(0, 0);
        assertThat(retrievedSquare).isEqualTo(square);
    }
//this is a comment
    @Test //thisisatestaswell
    void testSquareAtNullSquare() {
        assertThrows(AssertionError.class, () -> {
            boardWithNullSquare.squareAt(0, 0);
        });
    }
}
