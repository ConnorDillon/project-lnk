// Generated from Link.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LinkParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LinkVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LinkParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LinkParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LinkParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(LinkParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(LinkParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Field}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(LinkParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(LinkParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Apply}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApply(LinkParser.ApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ApplyExpr}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyExpr(LinkParser.ApplyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Object}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(LinkParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyObject(LinkParser.EmptyObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(LinkParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyArray(LinkParser.EmptyArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Stream}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStream(LinkParser.StreamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyStream}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStream(LinkParser.EmptyStreamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(LinkParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(LinkParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(LinkParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link LinkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(LinkParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cons}
	 * labeled alternative in {@link LinkParser#oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCons(LinkParser.ConsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link LinkParser#oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(LinkParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOper}
	 * labeled alternative in {@link LinkParser#oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOper(LinkParser.ExprOperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link LinkParser#oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(LinkParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LinkParser#oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(LinkParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link LinkParser#oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(LinkParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link LinkParser#oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(LinkParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OperPipe}
	 * labeled alternative in {@link LinkParser#pipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperPipe(LinkParser.OperPipeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PipeOper}
	 * labeled alternative in {@link LinkParser#pipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeOper(LinkParser.PipeOperContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinkParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(LinkParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinkParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(LinkParser.PairContext ctx);
}