package Tokens;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class TokenGeneratorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void get_token() {
        TokenGenerator token_gen = new TokenGenerator();
        assertTrue(token_gen.get_token(0, "", 0) instanceof Undefined);
        assertTrue(token_gen.get_token(1, "", 0) instanceof Undefined);
        assertTrue(token_gen.get_token(2, "", 0) instanceof Identifier);
        assertTrue(token_gen.get_token(3, "", 0) instanceof Undefined);
        assertTrue(token_gen.get_token(4, "", 0) instanceof Integer);
        assertTrue(token_gen.get_token(5, "", 0) instanceof Undefined);
        assertTrue(token_gen.get_token(6, "", 0) instanceof Real);
        assertTrue(token_gen.get_token(7, "", 0) instanceof Operator);
        assertTrue(token_gen.get_token(8, "", 0) instanceof Separator);
        assertTrue(token_gen.get_token(9, "", 0) instanceof Undefined);
        assertTrue(token_gen.get_token(10, "", 0) instanceof Undefined);
    }

    @Test
    void is_accepting_state() {
        TokenGenerator token_gen = new TokenGenerator();
        int accepting_states[] = {2, 4, 6, 7, 8, 9};
        for (int i =0; i <= 25; ++i){
            final int val_compare = i;
            boolean accepting = IntStream.of(accepting_states).anyMatch(x -> x == val_compare);
            if (accepting){
                assertTrue(token_gen.is_accepting_state(i));
            }else{
                assertFalse(token_gen.is_accepting_state(i));
            }
        }
    }
}