package Tokens;

import java.util.ArrayList;
import java.util.List;

public class TokenGenerator {
    private List<Token> token_defs = new ArrayList<Token>();

    public TokenGenerator() {
        this.token_defs.add(new Identifier());
        this.token_defs.add(new Integer());
        this.token_defs.add(new Keyword());
        this.token_defs.add(new Operator());
        this.token_defs.add(new Real());
        this.token_defs.add(new Separator());
        this.token_defs.add(new Undefined());
    }

    public Token get_token(int current_state, String token_str, int line_number) {
        for (Token t : this.token_defs) {
            if (t.accepting_state() == current_state) {
                try {
                    return t.getClass().getConstructor(String.class, int.class).newInstance(token_str, line_number);

                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }
        }
        return new Undefined(token_str, line_number);
    }
    public boolean is_accepting_state(int current_stare){
        for(Token s : this.token_defs){
            if (s.accepting_state() == current_stare){
                return true;
            }
        }
        return false;
    }
    public boolean is_reserved_symbol(String compare_str){
        for (Token s : this.token_defs){
            if (s.is_symbol(compare_str)){
                return true;
            }
        }
        return false;
    }
}
