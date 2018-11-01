from Tokens import *
from CompilerExceptions import *
import argparse
import Lexer


class SyntaxAnalyzer(object):
    def __init__(self, file_ptr, argp: argparse.ArgumentParser):
        self.Lexer = Lexer.Lexer(file_ptr, argp)
        self.__print = argp.syntax

    def run_analyzer(self):
        try:
            self.r_Rat18F()
            print("Syntax ok")
        except CSyntaxError as ex:
            print(ex)
        finally:  # regardless of errors finish obtaining all tokens and write them to file
            self.Lexer.finish_iterations()
            self.Lexer.write_tokens()

    def t_lexeme(self, val, bt_pos=None):
        if self.Lexer.lexer_peek(bt_pos).is_lexeme(val):
            self.Lexer.lexer(bt_pos)
        else:
            raise CSyntaxError(self.Lexer.lexer_peek(), str(val))

    def t_type(self, val, bt_pos=None):
        if self.Lexer.lexer_peek(bt_pos).is_type(val):
            self.Lexer.lexer(bt_pos)
        else:
            raise CSyntaxError(self.Lexer.lexer_peek(), val.type_name())

    def r_Rat18F(self):
        """Rat18F -> $$ ID = ID + ID $$"""
        try:
            p = self.Lexer.bt_get()
            self.t_lexeme('$$')
            self.t_type(TokenIdentifier)
            self.t_lexeme('=')
            self.t_type(TokenIdentifier)
            self.t_lexeme('+')
            self.t_type(TokenIdentifier)
            self.t_lexeme('$$')
        except StopIteration:  # end of file
            raise CSyntaxError

    def r_OptFunctionDefinitions(self):
        pass

    def r_FunctionDefinitions(self):
        pass

    def r_Function(self):
        pass

    def r_OptParameterList(self):
        pass

    def r_ParameterList(self):
        pass

    def r_Parameter(self):
        pass

    def r_Qualifier(self):
        pass

    def r_Body(self):
        pass

    def r_OptDeclarationList(self):
        pass

    def r_DeclarationList(self):
        pass

    def r_Declaration(self):
        pass

    def r_IDs(self):
        pass

    def r_StatementList(self):
        pass

    def r_Statement(self):
        pass

    def r_Compound(self):
        pass

    def r_Assign(self):
        pass

    def r_If(self):
        pass

    def r_Return(self):
        pass

    def r_Print(self):
        pass

    def r_Scan(self):
        pass

    def r_While(self):
        pass

    def r_Condition(self):
        pass

    def r_Relop(self):
        pass

    def r_Expression(self):
        pass

    def r_Term(self):
        pass

    def r_Factor(self):
        pass

    def r_Primary(self):
        pass

    def r_Empty(self):
        pass


