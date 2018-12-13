package Lexer;
import Tokens.*;
import Tokens.Integer;


import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class LexerTest {
    private ClassLoader classLoader;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.classLoader = getClass().getClassLoader();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void Lexer_constr() throws FileNotFoundException, NullPointerException {
        File file = new File(this.classLoader.getResource("LexerTextCases/test_File_1.txt").getFile());
        Lexer l = new Lexer(file, false);
    }

    @org.junit.jupiter.api.Test
    void lex_state_mapper() {
    }

    @org.junit.jupiter.api.Test
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
}