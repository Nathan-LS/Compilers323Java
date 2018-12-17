package Tokens;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Token {
    private String lexeme;
    private int line_number;
    static List<String> empty_space = Arrays.asList("\n", "\t", " ", "-1", "\r");

    public Token(){
        this.lexeme = "None";
        this.line_number = -1;
    }
    public Token(String lexeme, int line_number){
        this.lexeme = lexeme;
        this.line_number = line_number;
    }
    public boolean is_symbol(String compare_char){
        return(Arrays.asList(this.reserved_symbols()).contains(compare_char));
    }

    @Override
    public String toString() {
        return String.format("token: %-12s lexeme: %-12s" + "line: %s", getClass().getSimpleName(), lexeme, line_number);
    }

    public static boolean is_empty_space(String compare_char){
        return Token.empty_space.contains(compare_char);
    }
    protected abstract String[] reserved_symbols();
    public abstract int accepting_state();
}

