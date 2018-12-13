package Tokens;

public class Separator extends Token {
    public Separator() {super();}
    public Separator(String lexeme, int line_number) {
        super(lexeme, line_number);
    }

    public int accepting_state() {
        return 8;
    }
    @Override
    protected String[] reserved_symbols() {
        return new String[]{
                "(",
                ")",
                ",",
                "{",
                "}",
                ";",
                ":",
                "$$"
        };
    }
}
