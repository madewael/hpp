// Generated from D:/GitHub/hpp/src/main/antlr4\Hplusplus.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HplusplusParser}.
 */
public interface HplusplusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(HplusplusParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(HplusplusParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(HplusplusParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(HplusplusParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(HplusplusParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(HplusplusParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(HplusplusParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(HplusplusParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#memberDefs}.
	 * @param ctx the parse tree
	 */
	void enterMemberDefs(HplusplusParser.MemberDefsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#memberDefs}.
	 * @param ctx the parse tree
	 */
	void exitMemberDefs(HplusplusParser.MemberDefsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#memberDef}.
	 * @param ctx the parse tree
	 */
	void enterMemberDef(HplusplusParser.MemberDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#memberDef}.
	 * @param ctx the parse tree
	 */
	void exitMemberDef(HplusplusParser.MemberDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#fieldDef}.
	 * @param ctx the parse tree
	 */
	void enterFieldDef(HplusplusParser.FieldDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#fieldDef}.
	 * @param ctx the parse tree
	 */
	void exitFieldDef(HplusplusParser.FieldDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#methodDef}.
	 * @param ctx the parse tree
	 */
	void enterMethodDef(HplusplusParser.MethodDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#methodDef}.
	 * @param ctx the parse tree
	 */
	void exitMethodDef(HplusplusParser.MethodDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(HplusplusParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(HplusplusParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(HplusplusParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(HplusplusParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(HplusplusParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(HplusplusParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(HplusplusParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(HplusplusParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(HplusplusParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(HplusplusParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(HplusplusParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(HplusplusParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#varDefStmt}.
	 * @param ctx the parse tree
	 */
	void enterVarDefStmt(HplusplusParser.VarDefStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#varDefStmt}.
	 * @param ctx the parse tree
	 */
	void exitVarDefStmt(HplusplusParser.VarDefStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(HplusplusParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(HplusplusParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(HplusplusParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(HplusplusParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(HplusplusParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(HplusplusParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(HplusplusParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(HplusplusParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(HplusplusParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(HplusplusParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(HplusplusParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(HplusplusParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(HplusplusParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(HplusplusParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#observeStmt}.
	 * @param ctx the parse tree
	 */
	void enterObserveStmt(HplusplusParser.ObserveStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#observeStmt}.
	 * @param ctx the parse tree
	 */
	void exitObserveStmt(HplusplusParser.ObserveStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(HplusplusParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(HplusplusParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(HplusplusParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(HplusplusParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(HplusplusParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(HplusplusParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(HplusplusParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(HplusplusParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#uniOp}.
	 * @param ctx the parse tree
	 */
	void enterUniOp(HplusplusParser.UniOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#uniOp}.
	 * @param ctx the parse tree
	 */
	void exitUniOp(HplusplusParser.UniOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#binOp}.
	 * @param ctx the parse tree
	 */
	void enterBinOp(HplusplusParser.BinOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#binOp}.
	 * @param ctx the parse tree
	 */
	void exitBinOp(HplusplusParser.BinOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterInstantiation(HplusplusParser.InstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitInstantiation(HplusplusParser.InstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(HplusplusParser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(HplusplusParser.InvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#memberSelection}.
	 * @param ctx the parse tree
	 */
	void enterMemberSelection(HplusplusParser.MemberSelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#memberSelection}.
	 * @param ctx the parse tree
	 */
	void exitMemberSelection(HplusplusParser.MemberSelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#assocExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssocExpr(HplusplusParser.AssocExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#assocExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssocExpr(HplusplusParser.AssocExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#self}.
	 * @param ctx the parse tree
	 */
	void enterSelf(HplusplusParser.SelfContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#self}.
	 * @param ctx the parse tree
	 */
	void exitSelf(HplusplusParser.SelfContext ctx);
	/**
	 * Enter a parse tree produced by {@link HplusplusParser#it}.
	 * @param ctx the parse tree
	 */
	void enterIt(HplusplusParser.ItContext ctx);
	/**
	 * Exit a parse tree produced by {@link HplusplusParser#it}.
	 * @param ctx the parse tree
	 */
	void exitIt(HplusplusParser.ItContext ctx);
}