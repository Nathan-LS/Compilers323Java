package Tokens;

public class Identifier extends Token {
    public Identifier() { super(); }
    public Identifier(String lexeme, int line_number) {
        super(lexeme, line_number);
    }

    @Override
    public int accepting_state() {
        return 2;
    }

    @Override
    protected String[] reserved_symbols() {
        return new String[]{};
    }
}
