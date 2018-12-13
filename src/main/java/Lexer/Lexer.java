package Lexer;


import Tokens.*;

import java.io.*;

import java.util.List;
import java.util.logging.FileHandler;

public class Lexer {
    private final int[][] lexeme_table  = new int[][]{
            {2, 4, 7, 8, 9, 9},
            {2, 3, 9, 9, 9, 9},
            {2, 3, 9, 9, 9, 9},
            {9, 4, 9, 9, 5, 9},
            {9, 6, 9, 9, 9, 9},
            {9, 6, 9, 9, 9, 9},
            {9, 9, 9, 9, 9, 9},
            {9, 9, 9, 9, 9, 9},
            {9, 9, 9, 9, 9, 9}};

    private TokenGenerator tokenGen = new TokenGenerator();
    private BufferedReader reader;
    private boolean console_print;
    private int line_number = 1;
    private int current_index = 0;
    private List<Token> tokens;
    private final int starting_state = 1;


    public Lexer(File input_file, boolean console_print) throws FileNotFoundException {
        try{
            this.reader = new BufferedReader(new FileReader(input_file));
            this.console_print = console_print;
        } catch (FileNotFoundException e){
            System.out.println(e.toString());
            throw e;
        }
    }

    private int file_peek() throws IOException{
        this.reader.mark(1);
        int i = this.reader.read();
        this.reader.reset();
        return i;
    }

    protected int lex_state_mapper(char ch, int current_state){
        if (Character.isLetter(ch)){
            return this.lexeme_table[current_state -1][0];
        }
        else if (Character.isDigit(ch)){
            return this.lexeme_table[current_state -1][1];
        }
        else if (new Operator().is_symbol(String.valueOf(ch))){
            return this.lexeme_table[current_state -1][2];
        }
        else if (new Separator().is_symbol(String.valueOf(ch))){
            return this.lexeme_table[current_state -1][3];
        }
        else if (ch == '.'){
            return this.lexeme_table[current_state -1][4];
        }
        else{
            return this.lexeme_table[current_state -1][5];
        }
    }

    protected Token lexer(String token_str, int current_state)throws IOException{
        int int_char = this.file_peek();
        char next_char = (char) int_char;
        if (current_state != this.starting_state){
            String next_str = token_str + next_char;
            if (new Operator().is_symbol(next_str)){
                this.reader.read();
                return new Operator(next_str, this.line_number);
            }
            else if (new Separator().is_symbol(next_str)){
                this.reader.read();
                return new Separator(next_str, this.line_number);
            }
            else if (current_state == new Separator().accepting_state() || current_state == new Operator().accepting_state()){
                return tokenGen.get_token(current_state, token_str, this.line_number);
            }
            else ;
        }
        if (Token.is_empty_space(String.valueOf(next_char)) || int_char == -1 || this.tokenGen.is_reserved_symbol(String.valueOf(next_char))){
            if (this.tokenGen.is_accepting_state(current_state)){
                if (new Keyword().is_symbol(token_str)){
                    return new Keyword(token_str, this.line_number);
                }
                else{
                    return this.tokenGen.get_token(current_state, token_str, this.line_number);
                }
            }
            else if (current_state != this.starting_state){
                return new Undefined(token_str, this.line_number);
            }
            else ;
        }
        if (int_char == -1 ){
            throw new EOFException();
        }
        next_char = (char) this.reader.read();
        if (next_char == '\r' || next_char == '\n'){
            this.line_number++;
        }
        int next_state = current_state;
        if (!Token.is_empty_space(String.valueOf(next_char))){
            token_str += next_char;
            next_state = this.lex_state_mapper(next_char, current_state);
        }
        return this.lexer(token_str, next_state);
    }

}
