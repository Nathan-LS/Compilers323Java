from .Singleton import Singleton
import os


class InstructionGenerator(metaclass=Singleton):
    def __init__(self):
        self.pc_counter = 1
        self.jump_stack = []
        self.pending_instructions = []

    def get_pc(self)->int:
        return self.pc_counter

    def generate_instruction(self, op, oprnd):
        if oprnd == 'true':
            oprnd = 1
        elif oprnd == 'false':
            oprnd = 0
        else:
            pass
        self.pending_instructions.append({'addr': self.pc_counter, 'op': op, 'oprnd': str(oprnd)})
        self.pc_counter += 1

    def push_jumpstack(self, instr_address):
        self.jump_stack.append(instr_address)

    def back_patch(self, jump_addr):
        addr = self.jump_stack.pop()
        entry = self.pending_instructions[addr-1]
        entry['oprnd'] = jump_addr
        self.pending_instructions[addr-1] = entry

    def write_instructions(self, filename, console_print=False):
        fname = (os.path.join(os.path.dirname(filename), "instructions_{}".format(os.path.basename(filename))))  # prefix syntax to file name
        header = "{:<15} {:<16} {:<8}".format('Address', 'OP', 'Oprnd')
        with open(fname, 'w') as f:  # open file for write
            f.write(header)
            if console_print:
                print(header)
            for s in self.pending_instructions:
                instr = "{:<15} {:<16} {:<8}".format(s.get('addr'), s.get('op'), s.get('oprnd'))
                f.write(instr + '\n')
                if console_print:
                    print(instr)
            print("Wrote {} instructions to the file: ""'{}'.".format(len(self.pending_instructions), fname))

    def get_instructions(self)->list:
        return self.pending_instructions
