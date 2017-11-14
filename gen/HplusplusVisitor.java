// Generated from D:/GitHub/hpp/src/main/antlr4\Hplusplus.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HplusplusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HplusplusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(HplusplusParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(HplusplusParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(HplusplusParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(HplusplusParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#memberDefs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDefs(HplusplusParser.MemberDefsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#memberDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDef(HplusplusParser.MemberDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#fieldDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDef(HplusplusParser.FieldDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#methodDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDef(HplusplusParser.MethodDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(HplusplusParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(HplusplusParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(HplusplusParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(HplusplusParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(HplusplusParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(HplusplusParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#varDefStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefStmt(HplusplusParser.VarDefStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(HplusplusParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(HplusplusParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(HplusplusParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(HplusplusParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#blockStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(HplusplusParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(HplusplusParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(HplusplusParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#observeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObserveStmt(HplusplusParser.ObserveStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(HplusplusParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(HplusplusParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(HplusplusParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(HplusplusParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#uniOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniOp(HplusplusParser.UniOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#binOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinOp(HplusplusParser.BinOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#instantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiation(HplusplusParser.InstantiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvocation(HplusplusParser.InvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#memberSelection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberSelection(HplusplusParser.MemberSelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#assocExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssocExpr(HplusplusParser.AssocExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#self}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf(HplusplusParser.SelfContext ctx);
	/**
	 * Visit a parse tree produced by {@link HplusplusParser#it}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIt(HplusplusParser.ItContext ctx);
}