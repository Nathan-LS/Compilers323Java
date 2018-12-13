package Tokens;

public class Operator extends Token {
    public Operator() {super();}
    public Operator(String lexeme, int line_number) {
        super(lexeme, line_number);
    }

    public int accepting_state() {
        return 7;
    }
    @Override
    protected String[] reserved_symbols() {
        return new String[]{
                "+",
                "-",
                "=",
                "*",
                "/",
                ">",
                "<",
                "^=",
                "=<",
                "=>",
                "=="
        };
    }
}
