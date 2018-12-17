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

    @Test
    void write_tokens() throws IOException{
        Lexer lex = new Lexer(new File(this.classLoader.getResource("LexerTextCases/test_File_1.txt").getFile()), false);
        lex.write_tokens("tokens_test_File_1.txt");
    }

    @Test
    void write_tokens_multi()throws IOException{
        File TestCases = new File(this.classLoader.getResource("LexerTextCases").getFile());
        for (File assert_file: TestCases.listFiles()){
            if (assert_file.getName().startsWith("assert_")){
                System.out.println(String.format("Testing file: %s",assert_file.getName()));
                File input_file = new File(this.classLoader.getResource("LexerTextCases/" + assert_file.getName().replace("assert_", "")).getFile());
                Lexer lex = new Lexer(input_file, false);
                File test_output = lex.write_tokens("assert_test.txt");
                BufferedReader reader_output = new BufferedReader(new FileReader(test_output));
                BufferedReader reader_assert = new BufferedReader(new FileReader(assert_file));
                try {
                    String output_line, assert_line = null;
                    while ((output_line = reader_output.readLine()) != null && (assert_line = reader_assert.readLine()) != null) {
                        assertEquals(output_line, assert_line);
                    }
                    if (output_line == null && reader_assert.readLine() != null) {
                        fail();
                    }
                    if (assert_line == null && reader_output.readLine() != null) {
                        fail();
                    }
                }
                finally {
                    reader_output.close();
                    reader_assert.close();
                }
            }
        }
    }
}