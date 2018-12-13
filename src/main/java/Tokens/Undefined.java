package Tokens;

public class Undefined extends Token {
    public Undefined() {super();}
    public Undefined(String lexeme, int line_number) {
        super(lexeme, line_number);
    }

    public int accepting_state() {
        return 9;
    }
    @Override
    protected String[] reserved_symbols() {
        return new String[]{};
    }
}
