// Generated from visitor/SimpleScript.g4 by ANTLR 4.13.1
package visitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(SimpleScriptParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SimpleScriptParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(SimpleScriptParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(SimpleScriptParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#variableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(SimpleScriptParser.VariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SimpleScriptParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(SimpleScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#functionInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(SimpleScriptParser.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(SimpleScriptParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(SimpleScriptParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(SimpleScriptParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(SimpleScriptParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#arrayDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDefinition(SimpleScriptParser.ArrayDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaration(SimpleScriptParser.ArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#arrayAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignment(SimpleScriptParser.ArrayAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(SimpleScriptParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleScriptParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#arithmeticOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticOperation(SimpleScriptParser.ArithmeticOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#conditionalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOperation(SimpleScriptParser.ConditionalOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#singleValueOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleValueOperation(SimpleScriptParser.SingleValueOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#stringOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringOperation(SimpleScriptParser.StringOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#concatenationOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenationOperation(SimpleScriptParser.ConcatenationOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#findOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFindOperation(SimpleScriptParser.FindOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#arrayOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayOperation(SimpleScriptParser.ArrayOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#reverseOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReverseOperation(SimpleScriptParser.ReverseOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#addOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOperation(SimpleScriptParser.AddOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleScriptParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(SimpleScriptParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(SimpleScriptParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(SimpleScriptParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#forLoopArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopArray(SimpleScriptParser.ForLoopArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#conditionalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(SimpleScriptParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#ifCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCondition(SimpleScriptParser.IfConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#switchCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCondition(SimpleScriptParser.SwitchConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleScriptParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SimpleScriptParser.ValueContext ctx);
}