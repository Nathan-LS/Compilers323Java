package Tokens;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeywordTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void is_symbol() {
        Keyword k = new Keyword();
        for (String s : k.reserved_symbols()){
            assertTrue(k.is_symbol(s));
            assertFalse(k.is_symbol(s.toUpperCase()));
        }
    }

    @Test
    void is_empty_space() {
    }

    @Test
    void accepting_state() {
    }

    @Test
    void reserved_symbols() {
    }
}