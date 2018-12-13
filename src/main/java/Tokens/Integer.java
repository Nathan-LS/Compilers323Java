package Tokens;

public class Integer extends Token {
    public Integer() {super();}
    public Integer(String lexeme, int line_number) {
        super(lexeme, line_number);
    }

    public int accepting_state() {
        return 4;
    }

    @Override
    protected String[] reserved_symbols() {
        return new String[]{};
    }
}
