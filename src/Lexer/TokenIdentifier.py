from .TokenBase import TokenBase


class TokenIdentifier(TokenBase):
    @classmethod
    def reserved(cls):
        return
        yield

    @classmethod
    def accepting_states(cls):
        yield 2
