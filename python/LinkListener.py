# Generated from Link.g4 by ANTLR 4.9.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .LinkParser import LinkParser
else:
    from LinkParser import LinkParser

# This class defines a complete listener for a parse tree produced by LinkParser.
class LinkListener(ParseTreeListener):

    # Enter a parse tree produced by LinkParser#prog.
    def enterProg(self, ctx:LinkParser.ProgContext):
        pass

    # Exit a parse tree produced by LinkParser#prog.
    def exitProg(self, ctx:LinkParser.ProgContext):
        pass


    # Enter a parse tree produced by LinkParser#defn.
    def enterDefn(self, ctx:LinkParser.DefnContext):
        pass

    # Exit a parse tree produced by LinkParser#defn.
    def exitDefn(self, ctx:LinkParser.DefnContext):
        pass


    # Enter a parse tree produced by LinkParser#pipe.
    def enterPipe(self, ctx:LinkParser.PipeContext):
        pass

    # Exit a parse tree produced by LinkParser#pipe.
    def exitPipe(self, ctx:LinkParser.PipeContext):
        pass


    # Enter a parse tree produced by LinkParser#Or.
    def enterOr(self, ctx:LinkParser.OrContext):
        pass

    # Exit a parse tree produced by LinkParser#Or.
    def exitOr(self, ctx:LinkParser.OrContext):
        pass


    # Enter a parse tree produced by LinkParser#MulDiv.
    def enterMulDiv(self, ctx:LinkParser.MulDivContext):
        pass

    # Exit a parse tree produced by LinkParser#MulDiv.
    def exitMulDiv(self, ctx:LinkParser.MulDivContext):
        pass


    # Enter a parse tree produced by LinkParser#String.
    def enterString(self, ctx:LinkParser.StringContext):
        pass

    # Exit a parse tree produced by LinkParser#String.
    def exitString(self, ctx:LinkParser.StringContext):
        pass


    # Enter a parse tree produced by LinkParser#Int.
    def enterInt(self, ctx:LinkParser.IntContext):
        pass

    # Exit a parse tree produced by LinkParser#Int.
    def exitInt(self, ctx:LinkParser.IntContext):
        pass


    # Enter a parse tree produced by LinkParser#Field.
    def enterField(self, ctx:LinkParser.FieldContext):
        pass

    # Exit a parse tree produced by LinkParser#Field.
    def exitField(self, ctx:LinkParser.FieldContext):
        pass


    # Enter a parse tree produced by LinkParser#EmptyObject.
    def enterEmptyObject(self, ctx:LinkParser.EmptyObjectContext):
        pass

    # Exit a parse tree produced by LinkParser#EmptyObject.
    def exitEmptyObject(self, ctx:LinkParser.EmptyObjectContext):
        pass


    # Enter a parse tree produced by LinkParser#Stream.
    def enterStream(self, ctx:LinkParser.StreamContext):
        pass

    # Exit a parse tree produced by LinkParser#Stream.
    def exitStream(self, ctx:LinkParser.StreamContext):
        pass


    # Enter a parse tree produced by LinkParser#Compare.
    def enterCompare(self, ctx:LinkParser.CompareContext):
        pass

    # Exit a parse tree produced by LinkParser#Compare.
    def exitCompare(self, ctx:LinkParser.CompareContext):
        pass


    # Enter a parse tree produced by LinkParser#Lambda.
    def enterLambda(self, ctx:LinkParser.LambdaContext):
        pass

    # Exit a parse tree produced by LinkParser#Lambda.
    def exitLambda(self, ctx:LinkParser.LambdaContext):
        pass


    # Enter a parse tree produced by LinkParser#Call.
    def enterCall(self, ctx:LinkParser.CallContext):
        pass

    # Exit a parse tree produced by LinkParser#Call.
    def exitCall(self, ctx:LinkParser.CallContext):
        pass


    # Enter a parse tree produced by LinkParser#EmptyStream.
    def enterEmptyStream(self, ctx:LinkParser.EmptyStreamContext):
        pass

    # Exit a parse tree produced by LinkParser#EmptyStream.
    def exitEmptyStream(self, ctx:LinkParser.EmptyStreamContext):
        pass


    # Enter a parse tree produced by LinkParser#CallGroup.
    def enterCallGroup(self, ctx:LinkParser.CallGroupContext):
        pass

    # Exit a parse tree produced by LinkParser#CallGroup.
    def exitCallGroup(self, ctx:LinkParser.CallGroupContext):
        pass


    # Enter a parse tree produced by LinkParser#EmptyArray.
    def enterEmptyArray(self, ctx:LinkParser.EmptyArrayContext):
        pass

    # Exit a parse tree produced by LinkParser#EmptyArray.
    def exitEmptyArray(self, ctx:LinkParser.EmptyArrayContext):
        pass


    # Enter a parse tree produced by LinkParser#AddSub.
    def enterAddSub(self, ctx:LinkParser.AddSubContext):
        pass

    # Exit a parse tree produced by LinkParser#AddSub.
    def exitAddSub(self, ctx:LinkParser.AddSubContext):
        pass


    # Enter a parse tree produced by LinkParser#Dot.
    def enterDot(self, ctx:LinkParser.DotContext):
        pass

    # Exit a parse tree produced by LinkParser#Dot.
    def exitDot(self, ctx:LinkParser.DotContext):
        pass


    # Enter a parse tree produced by LinkParser#Do.
    def enterDo(self, ctx:LinkParser.DoContext):
        pass

    # Exit a parse tree produced by LinkParser#Do.
    def exitDo(self, ctx:LinkParser.DoContext):
        pass


    # Enter a parse tree produced by LinkParser#Array.
    def enterArray(self, ctx:LinkParser.ArrayContext):
        pass

    # Exit a parse tree produced by LinkParser#Array.
    def exitArray(self, ctx:LinkParser.ArrayContext):
        pass


    # Enter a parse tree produced by LinkParser#Float.
    def enterFloat(self, ctx:LinkParser.FloatContext):
        pass

    # Exit a parse tree produced by LinkParser#Float.
    def exitFloat(self, ctx:LinkParser.FloatContext):
        pass


    # Enter a parse tree produced by LinkParser#Not.
    def enterNot(self, ctx:LinkParser.NotContext):
        pass

    # Exit a parse tree produced by LinkParser#Not.
    def exitNot(self, ctx:LinkParser.NotContext):
        pass


    # Enter a parse tree produced by LinkParser#ExprGroup.
    def enterExprGroup(self, ctx:LinkParser.ExprGroupContext):
        pass

    # Exit a parse tree produced by LinkParser#ExprGroup.
    def exitExprGroup(self, ctx:LinkParser.ExprGroupContext):
        pass


    # Enter a parse tree produced by LinkParser#And.
    def enterAnd(self, ctx:LinkParser.AndContext):
        pass

    # Exit a parse tree produced by LinkParser#And.
    def exitAnd(self, ctx:LinkParser.AndContext):
        pass


    # Enter a parse tree produced by LinkParser#Assign.
    def enterAssign(self, ctx:LinkParser.AssignContext):
        pass

    # Exit a parse tree produced by LinkParser#Assign.
    def exitAssign(self, ctx:LinkParser.AssignContext):
        pass


    # Enter a parse tree produced by LinkParser#Object.
    def enterObject(self, ctx:LinkParser.ObjectContext):
        pass

    # Exit a parse tree produced by LinkParser#Object.
    def exitObject(self, ctx:LinkParser.ObjectContext):
        pass


    # Enter a parse tree produced by LinkParser#Id.
    def enterId(self, ctx:LinkParser.IdContext):
        pass

    # Exit a parse tree produced by LinkParser#Id.
    def exitId(self, ctx:LinkParser.IdContext):
        pass


    # Enter a parse tree produced by LinkParser#If.
    def enterIf(self, ctx:LinkParser.IfContext):
        pass

    # Exit a parse tree produced by LinkParser#If.
    def exitIf(self, ctx:LinkParser.IfContext):
        pass


    # Enter a parse tree produced by LinkParser#PipeGroup.
    def enterPipeGroup(self, ctx:LinkParser.PipeGroupContext):
        pass

    # Exit a parse tree produced by LinkParser#PipeGroup.
    def exitPipeGroup(self, ctx:LinkParser.PipeGroupContext):
        pass


    # Enter a parse tree produced by LinkParser#pair.
    def enterPair(self, ctx:LinkParser.PairContext):
        pass

    # Exit a parse tree produced by LinkParser#pair.
    def exitPair(self, ctx:LinkParser.PairContext):
        pass



del LinkParser