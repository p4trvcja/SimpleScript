// Generated from visitor/SimpleScript.g4 by ANTLR 4.13.1
package visitor;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleScriptParser}.
 */
public interface SimpleScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(SimpleScriptParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(SimpleScriptParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimpleScriptParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimpleScriptParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(SimpleScriptParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(SimpleScriptParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(SimpleScriptParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(SimpleScriptParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignment(SimpleScriptParser.VariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignment(SimpleScriptParser.VariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SimpleScriptParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SimpleScriptParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(SimpleScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(SimpleScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#functionInvocation}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvocation(SimpleScriptParser.FunctionInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#functionInvocation}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvocation(SimpleScriptParser.FunctionInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(SimpleScriptParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(SimpleScriptParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(SimpleScriptParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(SimpleScriptParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(SimpleScriptParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(SimpleScriptParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(SimpleScriptParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(SimpleScriptParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#arrayDefinition}.
	 * @param ctx the parse tree
	 */
	void enterArrayDefinition(SimpleScriptParser.ArrayDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#arrayDefinition}.
	 * @param ctx the parse tree
	 */
	void exitArrayDefinition(SimpleScriptParser.ArrayDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(SimpleScriptParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(SimpleScriptParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignment(SimpleScriptParser.ArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignment(SimpleScriptParser.ArrayAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(SimpleScriptParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(SimpleScriptParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(SimpleScriptParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(SimpleScriptParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimpleScriptParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimpleScriptParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#arithmeticOperation}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperation(SimpleScriptParser.ArithmeticOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#arithmeticOperation}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperation(SimpleScriptParser.ArithmeticOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(SimpleScriptParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(SimpleScriptParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(SimpleScriptParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(SimpleScriptParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#conditionalOperation}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOperation(SimpleScriptParser.ConditionalOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#conditionalOperation}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOperation(SimpleScriptParser.ConditionalOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#logicalTerm}.
	 * @param ctx the parse tree
	 */
	void enterLogicalTerm(SimpleScriptParser.LogicalTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#logicalTerm}.
	 * @param ctx the parse tree
	 */
	void exitLogicalTerm(SimpleScriptParser.LogicalTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#logicalFactor}.
	 * @param ctx the parse tree
	 */
	void enterLogicalFactor(SimpleScriptParser.LogicalFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#logicalFactor}.
	 * @param ctx the parse tree
	 */
	void exitLogicalFactor(SimpleScriptParser.LogicalFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#logicalPrimary}.
	 * @param ctx the parse tree
	 */
	void enterLogicalPrimary(SimpleScriptParser.LogicalPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#logicalPrimary}.
	 * @param ctx the parse tree
	 */
	void exitLogicalPrimary(SimpleScriptParser.LogicalPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#singleValueOperation}.
	 * @param ctx the parse tree
	 */
	void enterSingleValueOperation(SimpleScriptParser.SingleValueOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#singleValueOperation}.
	 * @param ctx the parse tree
	 */
	void exitSingleValueOperation(SimpleScriptParser.SingleValueOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#stringOperation}.
	 * @param ctx the parse tree
	 */
	void enterStringOperation(SimpleScriptParser.StringOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#stringOperation}.
	 * @param ctx the parse tree
	 */
	void exitStringOperation(SimpleScriptParser.StringOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#concatenationOperation}.
	 * @param ctx the parse tree
	 */
	void enterConcatenationOperation(SimpleScriptParser.ConcatenationOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#concatenationOperation}.
	 * @param ctx the parse tree
	 */
	void exitConcatenationOperation(SimpleScriptParser.ConcatenationOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#findOperation}.
	 * @param ctx the parse tree
	 */
	void enterFindOperation(SimpleScriptParser.FindOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#findOperation}.
	 * @param ctx the parse tree
	 */
	void exitFindOperation(SimpleScriptParser.FindOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#arrayOperation}.
	 * @param ctx the parse tree
	 */
	void enterArrayOperation(SimpleScriptParser.ArrayOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#arrayOperation}.
	 * @param ctx the parse tree
	 */
	void exitArrayOperation(SimpleScriptParser.ArrayOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#reverseOperation}.
	 * @param ctx the parse tree
	 */
	void enterReverseOperation(SimpleScriptParser.ReverseOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#reverseOperation}.
	 * @param ctx the parse tree
	 */
	void exitReverseOperation(SimpleScriptParser.ReverseOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#addOperation}.
	 * @param ctx the parse tree
	 */
	void enterAddOperation(SimpleScriptParser.AddOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#addOperation}.
	 * @param ctx the parse tree
	 */
	void exitAddOperation(SimpleScriptParser.AddOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleScriptParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleScriptParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(SimpleScriptParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(SimpleScriptParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(SimpleScriptParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(SimpleScriptParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(SimpleScriptParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(SimpleScriptParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#forLoopArray}.
	 * @param ctx the parse tree
	 */
	void enterForLoopArray(SimpleScriptParser.ForLoopArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#forLoopArray}.
	 * @param ctx the parse tree
	 */
	void exitForLoopArray(SimpleScriptParser.ForLoopArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(SimpleScriptParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(SimpleScriptParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfCondition(SimpleScriptParser.IfConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfCondition(SimpleScriptParser.IfConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#switchCondition}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCondition(SimpleScriptParser.SwitchConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#switchCondition}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCondition(SimpleScriptParser.SwitchConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleScriptParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SimpleScriptParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleScriptParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SimpleScriptParser.ValueContext ctx);
}