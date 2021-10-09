# Generated from Link.g4 by ANTLR 4.9.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .LinkParser import LinkParser
else:
    from LinkParser import LinkParser

# This class defines a complete generic visitor for a parse tree produced by LinkParser.

class LinkVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by LinkParser#prog.
    def visitProg(self, ctx:LinkParser.ProgContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#defn.
    def visitDefn(self, ctx:LinkParser.DefnContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#pipe.
    def visitPipe(self, ctx:LinkParser.PipeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Or.
    def visitOr(self, ctx:LinkParser.OrContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#MulDiv.
    def visitMulDiv(self, ctx:LinkParser.MulDivContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#String.
    def visitString(self, ctx:LinkParser.StringContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Int.
    def visitInt(self, ctx:LinkParser.IntContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Field.
    def visitField(self, ctx:LinkParser.FieldContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#EmptyObject.
    def visitEmptyObject(self, ctx:LinkParser.EmptyObjectContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Stream.
    def visitStream(self, ctx:LinkParser.StreamContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Compare.
    def visitCompare(self, ctx:LinkParser.CompareContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Lambda.
    def visitLambda(self, ctx:LinkParser.LambdaContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Call.
    def visitCall(self, ctx:LinkParser.CallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#EmptyStream.
    def visitEmptyStream(self, ctx:LinkParser.EmptyStreamContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#CallGroup.
    def visitCallGroup(self, ctx:LinkParser.CallGroupContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#EmptyArray.
    def visitEmptyArray(self, ctx:LinkParser.EmptyArrayContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#AddSub.
    def visitAddSub(self, ctx:LinkParser.AddSubContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Dot.
    def visitDot(self, ctx:LinkParser.DotContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Do.
    def visitDo(self, ctx:LinkParser.DoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Array.
    def visitArray(self, ctx:LinkParser.ArrayContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Float.
    def visitFloat(self, ctx:LinkParser.FloatContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Not.
    def visitNot(self, ctx:LinkParser.NotContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#ExprGroup.
    def visitExprGroup(self, ctx:LinkParser.ExprGroupContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#And.
    def visitAnd(self, ctx:LinkParser.AndContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Assign.
    def visitAssign(self, ctx:LinkParser.AssignContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Object.
    def visitObject(self, ctx:LinkParser.ObjectContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#Id.
    def visitId(self, ctx:LinkParser.IdContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#If.
    def visitIf(self, ctx:LinkParser.IfContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#PipeGroup.
    def visitPipeGroup(self, ctx:LinkParser.PipeGroupContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by LinkParser#pair.
    def visitPair(self, ctx:LinkParser.PairContext):
        return self.visitChildren(ctx)



del LinkParser