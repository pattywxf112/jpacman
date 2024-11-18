package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.npc.ghost.Blinky;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/**
 * This is a test class for MapParser.
 */

@ExtendWith(MockitoExtension.class)
public class MapParserTest {
    @Mock
    private BoardFactory boardFactory;
    @Mock
    private LevelFactory levelFactory;
    @Mock
    private Blinky blinky;

    /**
     * Test for the parseMap method (good map).
     */

    @Test
    public void testParseMapGood() {
        MockitoAnnotations.initMocks(this);
        assertNotNull(boardFactory, "BoardFactory mocked.");
        assertNotNull(levelFactory, "LevelFactory mocked.");
        when(levelFactory.createGhost()).thenReturn(blinky);
        MapParser mapParser = new MapParser(levelFactory, boardFactory);
        List<String> map = new ArrayList<>();
        map.add("############");
        map.add("#P        G#");
        map.add("############");
        mapParser.parseMap(map);
        verify(levelFactory, times(1)).createGhost();
        verifyNoMoreInteractions(levelFactory);
    }

    /**
     * Test for the parseMap method (bad map).
     */
    @Test
    public void testParseMapWrong1() {
        assertNotNull(boardFactory, "BoardFactory mocked.");
        assertNotNull(levelFactory, "LevelFactory mocked.");
        MapParser mapParser = new MapParser(levelFactory, boardFactory);
        List<String> map = new ArrayList<>();
        map.add("############");
        map.add("#P      G");
        map.add("#############");

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
            () -> mapParser.parseMap(map),
            "Expected parseMap to throw an IllegalArgumentException for an invalid map."
        );

        assertEquals("Invalid map format: inconsistent row lengths.", thrown.getMessage());
    }
    
}
