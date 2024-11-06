package nl.tudelft.jpacman.board;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

    /**
     this is a comment of boardtestnullsquare.
     */
public class BoardTestNullSquare { 
    private Board boardWithSquare;
    private Board boardWithNullSquare;
    private Square square;
    /**
     this is a comment of boardtestnullsquare.
     */
    @BeforeEach 
    void setUp() { 
        square = new BasicSquare();
    /**
     this is a comment of boardtestnullsquare.
     */
        Square[][] gridWithSquare = {{ square }};
        boardWithSquare = new Board(gridWithSquare);

    /**
     this is a comment of boardtestnullsquare.
     */
        Square[][] gridWithNullSquare = {{ null }};
        boardWithNullSquare = new Board(gridWithNullSquare);
    }
    /**
     this is a comment of boardtestnullsquare.
     */
    @Test 
    void testSquareAtValidSquare() {
        Square retrievedSquare = boardWithSquare.squareAt(0, 0);
        assertThat(retrievedSquare).isEqualTo(square);
    }
    /**
     this is a comment of boardtestnullsquare.
     */
    @Test 
    void testSquareAtNullSquare() {
        assertThrows(AssertionError.class, () -> {
            boardWithNullSquare.squareAt(0, 0);
        });
    }
}

