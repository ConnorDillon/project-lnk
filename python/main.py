#!/usr/bin/env python3
import sys
from antlr4 import *
from LinkLexer import LinkLexer
from LinkParser import LinkParser
from LinkVisitor import LinkVisitor

def main(argv):
    input_stream = FileStream(argv[1])
    lexer = LinkLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = LinkParser(stream)
    tree = parser.prog()
    printer = Visitor()
    for result in printer.visit(tree):
        print(result)

class ID:
    def __init__(self, id_):
        if isinstance(id_, str):
            self.id = id_
        else:
            self.id = id_.getText()

    def __repr__(self):
        return self.id

class Stream:
    def __init__(self, *items):
        self.items = items

    def __repr__(self):
        if len(self.items) == 1:
            return f"({self.items[0]},)"
        else:
            return f"({', '.join(map(str, self.items))})"

class Expr:
    def __init__(self, *parts):
        self.parts = parts

    def __repr__(self):
        return f"({' '.join(map(str, self.parts))})"

class Visitor(LinkVisitor):     
    def visitProg(self, ctx):         
        return [self.visit(x) for x in ctx.defn()] +\
               [self.visit(x) for x in ctx.expr()] +\
               [self.visit(x) for x in ctx.pipe()]

    def visitDefn(self, ctx):         
        if ctx.expr():
            arg = self.visit(ctx.expr())
        else:
            arg = self.visit(ctx.pipe())
        return Expr(ID("def"), ID(ctx.ID(0)), [ID(x) for x in ctx.ID()][1:], arg)

    def visitPipe(self, ctx):         
        return Expr(ID("|"), *(self.visit(x) for x in ctx.expr()))

    def operator(self, ctx):         
        return Expr(ID(ctx.op.text), *(self.visit(x) for x in ctx.expr()))

    def visitAddSub(self, ctx):         
        return self.operator(ctx)

    def visitMulDiv(self, ctx):         
        return self.operator(ctx)

    def visitCompare(self, ctx):         
        return self.operator(ctx)

    def visitNot(self, ctx):         
        return Expr(ID("not"), self.visit(ctx.expr()))

    def visitAnd(self, ctx):         
        return self.operator(ctx)

    def visitOr(self, ctx):         
        return self.operator(ctx)

    def visitDo(self, ctx):         
        return Expr(ID("do"), *(self.visit(x) for x in ctx.expr()))

    def visitIf(self, ctx):         
        return Expr(ID("if"), *(self.visit(x) for x in ctx.expr()))

    def visitDot(self, ctx):         
        return ID(".")

    def visitField(self, ctx):         
        return ID(ctx)

    def visitAssign(self, ctx):         
        return Expr(ID("="), *(ID(ctx.ID()), self.visit(ctx.expr())))

    def visitId(self, ctx):
        return ID(ctx)

    def visitCall(self, ctx):
        return Expr(ID(ctx.ID()), *(self.visit(x) for x in ctx.expr()))

    def visitLambda(self, ctx):
        return Expr("->", [ID(x) for x in ctx.ID()], self.visit(ctx.expr()))

    def visitInt(self, ctx):
        return int(ctx.getText())

    def visitFloat(self, ctx):
        return float(ctx.getText())

    def visitObject(self, ctx):
        obj = {}
        for c in range(ctx.getChildCount()):
            child = ctx.getChild(c)
            if isinstance(child, LinkParser.PairContext):
                try:
                    key = ID(child.ID())
                except:
                    key = child.STRING().getText()[1:-1]
                obj[key] = self.visit(child.expr())
            elif str(child) not in (',', '{', '}'):
                key = ID(str(child))
                obj[key] = key
        return obj

    def visitEmptyObject(self, ctx):
        return {}

    def visitArray(self, ctx):
        return [self.visit(x) for x in ctx.expr()]

    def visitEmptyArray(self, ctx):
        return []

    def visitStream(self, ctx):
        return Stream(*(self.visit(x) for x in ctx.expr()))

    def visitEmptyStream(self, ctx):
        return Stream()

    def visitString(self, ctx):
        return ctx.getText()[1:-1]

    def visitExprGroup(self, ctx):
        return self.visit(ctx.expr())

    def visitCallGroup(self, ctx):
        return Expr(*(self.visit(x) for x in ctx.expr()))

    def visitPipeGroup(self, ctx):
        return self.visit(ctx.pipe())
 
if __name__ == '__main__':
    main(sys.argv)
