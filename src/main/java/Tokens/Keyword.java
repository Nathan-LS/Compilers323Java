package Tokens;

public class Keyword extends Token {
    public Keyword() {super();}
    public Keyword(String lexeme, int line_number){
        super(lexeme, line_number);
    }

    @Override
    public int accepting_state() {
        return -1;
    }
    protected String[] reserved_symbols(){
        return new String[]{
                "int",
                "if",
                "else",
                "ifend",
                "while",
                "whileend",
                "return",
                "get",
                "put",
                "function",
                "real",
                "boolean",
                "true",
                "false"
        };
    }
}
