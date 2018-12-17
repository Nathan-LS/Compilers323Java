package Lexer;
import Tokens.*;
import Tokens.Integer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class LexerTest {
    private ClassLoader classLoader;

    @BeforeEach
    void setUp() {
        this.classLoader = getClass().getClassLoader();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void Lexer_constr() throws FileNotFoundException, NullPointerException {
        File file = new File(this.classLoader.getResource("LexerTextCases/test_File_1.txt").getFile());
        Lexer l = new Lexer(file, false);
    }

    @Test
    void lex_state_mapper() {
    }

    @Test
    void lexer()throws IOException {
        Lexer lex = new Lexer(new File(this.classLoader.getResource("LexerTextCases/test_File_1.txt").getFile()), false);
        assertTrue(lex.lexer("", 1) instanceof Separator);
        assertTrue(lex.lexer("", 1) instanceof Keyword);
        assertTrue(lex.lexer("", 1) instanceof Identifier);
        assertTrue(lex.lexer("", 1) instanceof Operator);
        assertTrue(lex.lexer("", 1) instanceof Real);
        assertTrue(lex.lexer("", 1) instanceof Separator);
        assertTrue(lex.lexer("", 1) instanceof Identifier);
        assertTrue(lex.lexer("", 1) instanceof Operator);
        assertTrue(lex.lexer("", 1) instanceof Integer);
        assertTrue(lex.lexer("", 1) instanceof Separator);
        assertTrue(lex.lexer("", 1) instanceof Separator);
        assertThrows(EOFException.class, ()->{lex.lexer("", 1);});
        assertThrows(EOFException.class, ()->{lex.lexer("", 1);});
    }

    @Test
    void lexer_2() throws IOException{
        Lexer lex = new Lexer(new File(this.classLoader.getResource("LexerTextCases/test_File_1.txt").getFile()), false);
        assertTrue(lex.lexer() instanceof Separator);
        assertTrue(lex.lexer() instanceof Keyword);
        assertTrue(lex.lexer() instanceof Identifier);
        assertTrue(lex.lexer() instanceof Operator);
        assertTrue(lex.lexer() instanceof Real);
        assertTrue(lex.lexer() instanceof Separator);
        assertTrue(lex.lexer() instanceof Identifier);
        assertTrue(lex.lexer() instanceof Operator);
        assertTrue(lex.lexer() instanceof Integer);
        assertTrue(lex.lexer() instanceof Separator);
        assertTrue(lex.lexer() instanceof Separator);
        assertThrows(EOFException.class, ()->{lex.lexer();});
        assertThrows(EOFException.class, ()->{lex.lexer();});
    }

    @Test
    void lexer_peek() throws IOException{
        Lexer lex = new Lexer(new File(this.classLoader.getResource("LexerTextCases/test_File_1.txt").getFile()), false);
        assertEquals(lex.lexer_peek(), lex.lexer_peek());
        assertEquals(lex.lexer_peek(), lex.lexer());
        assertNotEquals(lex.lexer(), lex.lexer_peek());
    }

    @Test
    void load_remaining() throws IOException{
        Lexer lex = new Lexer(new File(this.classLoader.getResource("LexerTextCases/test_File_1.txt").getFile()), false);
        assertEquals(lex.load_remaining(), 11);
    }
}