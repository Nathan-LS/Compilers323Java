package Tokens;

public class Real extends Token {
    public Real() {super();}
    public Real(String lexeme, int line_number) {
        super(lexeme, line_number);
    }

    @Override
    public int accepting_state() {
        return 6;
    }
    @Override
    protected String[] reserved_symbols() {
        return new String[]{};
    }
}
