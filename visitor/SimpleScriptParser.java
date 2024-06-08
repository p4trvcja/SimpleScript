// Generated from visitor/SimpleScript.g4 by ANTLR 4.13.1
package visitor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CONCAT=1, CONCATSTR=2, SUB=3, MUL=4, DIV=5, ASSIGNMENT=6, ASSIGN=7, CONDITION_OP=8, 
		AND=9, OR=10, NOT=11, SINGLE_VAL_OP=12, IS_NULL=13, IN=14, IF=15, ELIF=16, 
		ELSE=17, FOR=18, WHILE=19, SWITCH=20, CASE=21, DEFAULT=22, BREAK=23, TYPE=24, 
		RETURN=25, STRING=26, BOOLEAN=27, SEMICOLON=28, COMMA=29, COLON=30, LPAREN=31, 
		RPAREN=32, LBRACE=33, RBRACE=34, LBRACK=35, RBRACK=36, FUNCTION=37, PRINT=38, 
		FIND=39, REVERSE=40, ADD=41, COMMENT=42, WS=43, NAME=44, NUMBER=45;
	public static final int
		RULE_script = 0, RULE_statement = 1, RULE_variableDeclaration = 2, RULE_variableDefinition = 3, 
		RULE_variableAssignment = 4, RULE_returnStatement = 5, RULE_functionDeclaration = 6, 
		RULE_functionInvocation = 7, RULE_parameter = 8, RULE_parameters = 9, 
		RULE_arguments = 10, RULE_arrayType = 11, RULE_arrayDefinition = 12, RULE_arrayDeclaration = 13, 
		RULE_arrayAssignment = 14, RULE_arrayAccess = 15, RULE_printStatement = 16, 
		RULE_expr = 17, RULE_conditionalArithmeticOperation = 18, RULE_arithmeticOperation = 19, 
		RULE_term = 20, RULE_factor = 21, RULE_conditionalOperation = 22, RULE_logicalTerm = 23, 
		RULE_logicalFactor = 24, RULE_logicalPrimary = 25, RULE_singleValueOperation = 26, 
		RULE_stringOperation = 27, RULE_concatenationOperation = 28, RULE_findOperation = 29, 
		RULE_arrayOperation = 30, RULE_reverseOperation = 31, RULE_addOperation = 32, 
		RULE_block = 33, RULE_iterationStatement = 34, RULE_whileLoop = 35, RULE_forLoop = 36, 
		RULE_forLoopArray = 37, RULE_conditionalStatement = 38, RULE_ifCondition = 39, 
		RULE_switchCondition = 40, RULE_caseClause = 41, RULE_defaultClause = 42, 
		RULE_value = 43, RULE_str = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "statement", "variableDeclaration", "variableDefinition", "variableAssignment", 
			"returnStatement", "functionDeclaration", "functionInvocation", "parameter", 
			"parameters", "arguments", "arrayType", "arrayDefinition", "arrayDeclaration", 
			"arrayAssignment", "arrayAccess", "printStatement", "expr", "conditionalArithmeticOperation", 
			"arithmeticOperation", "term", "factor", "conditionalOperation", "logicalTerm", 
			"logicalFactor", "logicalPrimary", "singleValueOperation", "stringOperation", 
			"concatenationOperation", "findOperation", "arrayOperation", "reverseOperation", 
			"addOperation", "block", "iterationStatement", "whileLoop", "forLoop", 
			"forLoopArray", "conditionalStatement", "ifCondition", "switchCondition", 
			"caseClause", "defaultClause", "value", "str"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'concat'", "'-'", "'*'", "'/'", null, "'='", null, "'and'", 
			"'or'", "'not'", null, "'is null'", "'in'", "'if'", "'elif'", "'else'", 
			"'for'", "'while'", "'switch'", "'case'", "'default'", "'break'", null, 
			"'return'", null, null, "';'", "','", "':'", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "'function'", "'print'", "'find'", "'reverse'", "'add'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CONCAT", "CONCATSTR", "SUB", "MUL", "DIV", "ASSIGNMENT", "ASSIGN", 
			"CONDITION_OP", "AND", "OR", "NOT", "SINGLE_VAL_OP", "IS_NULL", "IN", 
			"IF", "ELIF", "ELSE", "FOR", "WHILE", "SWITCH", "CASE", "DEFAULT", "BREAK", 
			"TYPE", "RETURN", "STRING", "BOOLEAN", "SEMICOLON", "COMMA", "COLON", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "FUNCTION", 
			"PRINT", "FIND", "REVERSE", "ADD", "COMMENT", "WS", "NAME", "NUMBER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimpleScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScriptContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimpleScriptParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitScript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(90);
				statement();
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 56902127749128L) != 0) );
			setState(95);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public ArrayDefinitionContext arrayDefinition() {
			return getRuleContext(ArrayDefinitionContext.class,0);
		}
		public ArrayDeclarationContext arrayDeclaration() {
			return getRuleContext(ArrayDeclarationContext.class,0);
		}
		public ArrayAssignmentContext arrayAssignment() {
			return getRuleContext(ArrayAssignmentContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				variableAssignment();
				setState(99);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				variableDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				conditionalStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				iterationStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(104);
				functionDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(105);
				functionInvocation();
				setState(106);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(108);
				arrayDefinition();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(109);
				arrayDeclaration();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(110);
				arrayAssignment();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(111);
				printStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(112);
				expr();
				setState(113);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(SimpleScriptParser.TYPE, 0); }
		public List<TerminalNode> NAME() { return getTokens(SimpleScriptParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SimpleScriptParser.NAME, i);
		}
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SimpleScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleScriptParser.COMMA, i);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(TYPE);
			setState(118);
			match(NAME);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(119);
				match(COMMA);
				setState(120);
				match(NAME);
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDefinitionContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(SimpleScriptParser.TYPE, 0); }
		public List<TerminalNode> NAME() { return getTokens(SimpleScriptParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SimpleScriptParser.NAME, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(SimpleScriptParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SimpleScriptParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SimpleScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleScriptParser.COMMA, i);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitVariableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(TYPE);
			setState(129);
			match(NAME);
			setState(130);
			match(ASSIGN);
			setState(131);
			expr();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(132);
				match(COMMA);
				setState(133);
				match(NAME);
				setState(134);
				match(ASSIGN);
				setState(135);
				expr();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableAssignmentContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(SimpleScriptParser.ASSIGNMENT, 0); }
		public TerminalNode ASSIGN() { return getToken(SimpleScriptParser.ASSIGN, 0); }
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(NAME);
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==ASSIGNMENT || _la==ASSIGN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(145);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(SimpleScriptParser.RETURN, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(RETURN);
			setState(148);
			match(LPAREN);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56627231197192L) != 0)) {
				{
				setState(149);
				expr();
				}
			}

			setState(152);
			match(RPAREN);
			setState(153);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(SimpleScriptParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SimpleScriptParser.NAME, i);
		}
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public List<TerminalNode> TYPE() { return getTokens(SimpleScriptParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(SimpleScriptParser.TYPE, i);
		}
		public List<ArrayTypeContext> arrayType() {
			return getRuleContexts(ArrayTypeContext.class);
		}
		public ArrayTypeContext arrayType(int i) {
			return getRuleContext(ArrayTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleScriptParser.COMMA, i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(155);
				match(TYPE);
				}
				break;
			case 2:
				{
				setState(156);
				arrayType();
				}
				break;
			}
			setState(159);
			match(NAME);
			setState(160);
			match(LPAREN);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(163);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(161);
					match(TYPE);
					}
					break;
				case 2:
					{
					setState(162);
					arrayType();
					}
					break;
				}
				setState(165);
				match(NAME);
				{
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(166);
					match(COMMA);
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						setState(167);
						match(TYPE);
						}
						break;
					case 2:
						{
						setState(168);
						arrayType();
						}
						break;
					}
					setState(171);
					match(NAME);
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
			}

			setState(179);
			match(RPAREN);
			setState(180);
			block();
			setState(181);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionInvocationContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleScriptParser.COMMA, i);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterFunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitFunctionInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(NAME);
			setState(184);
			match(LPAREN);
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(185);
				match(RPAREN);
				}
				break;
			case 2:
				{
				setState(186);
				expr();
				setState(187);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(189);
				expr();
				setState(192); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(190);
					match(COMMA);
					setState(191);
					expr();
					}
					}
					setState(194); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(196);
				match(RPAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(SimpleScriptParser.TYPE, 0); }
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(TYPE);
			setState(201);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleScriptParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			parameter();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(204);
				match(COMMA);
				setState(205);
				parameter();
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleScriptParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			expr();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(212);
				match(COMMA);
				setState(213);
				expr();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(SimpleScriptParser.TYPE, 0); }
		public TerminalNode LBRACK() { return getToken(SimpleScriptParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(SimpleScriptParser.RBRACK, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(TYPE);
			setState(220);
			match(LBRACK);
			setState(221);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDefinitionContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode ASSIGN() { return getToken(SimpleScriptParser.ASSIGN, 0); }
		public TerminalNode LBRACK() { return getToken(SimpleScriptParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(SimpleScriptParser.RBRACK, 0); }
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArrayDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterArrayDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitArrayDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitArrayDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDefinitionContext arrayDefinition() throws RecognitionException {
		ArrayDefinitionContext _localctx = new ArrayDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			arrayType();
			setState(224);
			match(NAME);
			setState(225);
			match(ASSIGN);
			setState(226);
			match(LBRACK);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56627231197192L) != 0)) {
				{
				setState(227);
				arguments();
				}
			}

			setState(230);
			match(RBRACK);
			setState(231);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDeclarationContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public ArrayDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclarationContext arrayDeclaration() throws RecognitionException {
		ArrayDeclarationContext _localctx = new ArrayDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arrayDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			arrayType();
			setState(234);
			match(NAME);
			setState(235);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAssignmentContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode ASSIGN() { return getToken(SimpleScriptParser.ASSIGN, 0); }
		public TerminalNode LBRACK() { return getToken(SimpleScriptParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(SimpleScriptParser.RBRACK, 0); }
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArrayAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterArrayAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitArrayAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitArrayAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAssignmentContext arrayAssignment() throws RecognitionException {
		ArrayAssignmentContext _localctx = new ArrayAssignmentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arrayAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(NAME);
			setState(238);
			match(ASSIGN);
			setState(239);
			match(LBRACK);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56627231197192L) != 0)) {
				{
				setState(240);
				arguments();
				}
			}

			setState(243);
			match(RBRACK);
			setState(244);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode LBRACK() { return getToken(SimpleScriptParser.LBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(SimpleScriptParser.RBRACK, 0); }
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(NAME);
			setState(247);
			match(LBRACK);
			setState(248);
			expr();
			setState(249);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(SimpleScriptParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(PRINT);
			setState(252);
			match(LPAREN);
			setState(253);
			expr();
			setState(254);
			match(RPAREN);
			setState(255);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public ArithmeticOperationContext arithmeticOperation() {
			return getRuleContext(ArithmeticOperationContext.class,0);
		}
		public ConditionalOperationContext conditionalOperation() {
			return getRuleContext(ConditionalOperationContext.class,0);
		}
		public SingleValueOperationContext singleValueOperation() {
			return getRuleContext(SingleValueOperationContext.class,0);
		}
		public StringOperationContext stringOperation() {
			return getRuleContext(StringOperationContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public ArrayOperationContext arrayOperation() {
			return getRuleContext(ArrayOperationContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr);
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				functionInvocation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				arithmeticOperation(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(260);
				conditionalOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(261);
				singleValueOperation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(262);
				stringOperation();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(263);
				returnStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(264);
				arrayAccess();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(265);
				arrayOperation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalArithmeticOperationContext extends ParserRuleContext {
		public ArithmeticOperationContext arithmeticOperation() {
			return getRuleContext(ArithmeticOperationContext.class,0);
		}
		public ConditionalArithmeticOperationContext conditionalArithmeticOperation() {
			return getRuleContext(ConditionalArithmeticOperationContext.class,0);
		}
		public TerminalNode CONDITION_OP() { return getToken(SimpleScriptParser.CONDITION_OP, 0); }
		public ConditionalArithmeticOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalArithmeticOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterConditionalArithmeticOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitConditionalArithmeticOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitConditionalArithmeticOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalArithmeticOperationContext conditionalArithmeticOperation() throws RecognitionException {
		return conditionalArithmeticOperation(0);
	}

	private ConditionalArithmeticOperationContext conditionalArithmeticOperation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionalArithmeticOperationContext _localctx = new ConditionalArithmeticOperationContext(_ctx, _parentState);
		ConditionalArithmeticOperationContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_conditionalArithmeticOperation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(269);
			arithmeticOperation(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalArithmeticOperationContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionalArithmeticOperation);
					setState(271);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(272);
					match(CONDITION_OP);
					setState(273);
					arithmeticOperation(0);
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticOperationContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ArithmeticOperationContext arithmeticOperation() {
			return getRuleContext(ArithmeticOperationContext.class,0);
		}
		public TerminalNode CONCAT() { return getToken(SimpleScriptParser.CONCAT, 0); }
		public TerminalNode SUB() { return getToken(SimpleScriptParser.SUB, 0); }
		public ArithmeticOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterArithmeticOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitArithmeticOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitArithmeticOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticOperationContext arithmeticOperation() throws RecognitionException {
		return arithmeticOperation(0);
	}

	private ArithmeticOperationContext arithmeticOperation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticOperationContext _localctx = new ArithmeticOperationContext(_ctx, _parentState);
		ArithmeticOperationContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_arithmeticOperation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(280);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(288);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticOperationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOperation);
						setState(282);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(283);
						match(CONCAT);
						setState(284);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticOperationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOperation);
						setState(285);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(286);
						match(SUB);
						setState(287);
						term(0);
						}
						break;
					}
					} 
				}
				setState(292);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MUL() { return getToken(SimpleScriptParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(SimpleScriptParser.DIV, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(294);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(302);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(296);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(297);
						match(MUL);
						setState(298);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(299);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(300);
						match(DIV);
						setState(301);
						factor();
						}
						break;
					}
					} 
				}
				setState(306);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public TerminalNode SUB() { return getToken(SimpleScriptParser.SUB, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		try {
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				functionInvocation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				match(LPAREN);
				setState(310);
				expr();
				setState(311);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(313);
				match(SUB);
				setState(314);
				factor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalOperationContext extends ParserRuleContext {
		public LogicalTermContext logicalTerm() {
			return getRuleContext(LogicalTermContext.class,0);
		}
		public ConditionalOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterConditionalOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitConditionalOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitConditionalOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalOperationContext conditionalOperation() throws RecognitionException {
		ConditionalOperationContext _localctx = new ConditionalOperationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_conditionalOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			logicalTerm(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalTermContext extends ParserRuleContext {
		public LogicalFactorContext logicalFactor() {
			return getRuleContext(LogicalFactorContext.class,0);
		}
		public LogicalTermContext logicalTerm() {
			return getRuleContext(LogicalTermContext.class,0);
		}
		public TerminalNode OR() { return getToken(SimpleScriptParser.OR, 0); }
		public LogicalTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterLogicalTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitLogicalTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitLogicalTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalTermContext logicalTerm() throws RecognitionException {
		return logicalTerm(0);
	}

	private LogicalTermContext logicalTerm(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalTermContext _localctx = new LogicalTermContext(_ctx, _parentState);
		LogicalTermContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_logicalTerm, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(320);
			logicalFactor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(327);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalTermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalTerm);
					setState(322);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(323);
					match(OR);
					setState(324);
					logicalFactor(0);
					}
					} 
				}
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalFactorContext extends ParserRuleContext {
		public LogicalPrimaryContext logicalPrimary() {
			return getRuleContext(LogicalPrimaryContext.class,0);
		}
		public LogicalFactorContext logicalFactor() {
			return getRuleContext(LogicalFactorContext.class,0);
		}
		public TerminalNode AND() { return getToken(SimpleScriptParser.AND, 0); }
		public LogicalFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterLogicalFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitLogicalFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitLogicalFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalFactorContext logicalFactor() throws RecognitionException {
		return logicalFactor(0);
	}

	private LogicalFactorContext logicalFactor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalFactorContext _localctx = new LogicalFactorContext(_ctx, _parentState);
		LogicalFactorContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_logicalFactor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(331);
			logicalPrimary();
			}
			_ctx.stop = _input.LT(-1);
			setState(338);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalFactorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalFactor);
					setState(333);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(334);
					match(AND);
					setState(335);
					logicalPrimary();
					}
					} 
				}
				setState(340);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalPrimaryContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public ConditionalOperationContext conditionalOperation() {
			return getRuleContext(ConditionalOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public ConditionalArithmeticOperationContext conditionalArithmeticOperation() {
			return getRuleContext(ConditionalArithmeticOperationContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SimpleScriptParser.NOT, 0); }
		public LogicalPrimaryContext logicalPrimary() {
			return getRuleContext(LogicalPrimaryContext.class,0);
		}
		public LogicalPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalPrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterLogicalPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitLogicalPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitLogicalPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalPrimaryContext logicalPrimary() throws RecognitionException {
		LogicalPrimaryContext _localctx = new LogicalPrimaryContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_logicalPrimary);
		try {
			setState(350);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				functionInvocation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(343);
				match(LPAREN);
				setState(344);
				conditionalOperation();
				setState(345);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(347);
				conditionalArithmeticOperation(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(348);
				match(NOT);
				setState(349);
				logicalPrimary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SingleValueOperationContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode SINGLE_VAL_OP() { return getToken(SimpleScriptParser.SINGLE_VAL_OP, 0); }
		public SingleValueOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleValueOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterSingleValueOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitSingleValueOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitSingleValueOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleValueOperationContext singleValueOperation() throws RecognitionException {
		SingleValueOperationContext _localctx = new SingleValueOperationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_singleValueOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(NAME);
			setState(353);
			match(SINGLE_VAL_OP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringOperationContext extends ParserRuleContext {
		public ConcatenationOperationContext concatenationOperation() {
			return getRuleContext(ConcatenationOperationContext.class,0);
		}
		public FindOperationContext findOperation() {
			return getRuleContext(FindOperationContext.class,0);
		}
		public StringOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterStringOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitStringOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitStringOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringOperationContext stringOperation() throws RecognitionException {
		StringOperationContext _localctx = new StringOperationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_stringOperation);
		try {
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				concatenationOperation();
				}
				break;
			case FIND:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				findOperation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConcatenationOperationContext extends ParserRuleContext {
		public List<StrContext> str() {
			return getRuleContexts(StrContext.class);
		}
		public StrContext str(int i) {
			return getRuleContext(StrContext.class,i);
		}
		public TerminalNode CONCATSTR() { return getToken(SimpleScriptParser.CONCATSTR, 0); }
		public ConcatenationOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenationOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterConcatenationOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitConcatenationOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitConcatenationOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatenationOperationContext concatenationOperation() throws RecognitionException {
		ConcatenationOperationContext _localctx = new ConcatenationOperationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_concatenationOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			str();
			setState(360);
			match(CONCATSTR);
			setState(361);
			str();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FindOperationContext extends ParserRuleContext {
		public TerminalNode FIND() { return getToken(SimpleScriptParser.FIND, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public List<StrContext> str() {
			return getRuleContexts(StrContext.class);
		}
		public StrContext str(int i) {
			return getRuleContext(StrContext.class,i);
		}
		public TerminalNode IN() { return getToken(SimpleScriptParser.IN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public FindOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_findOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterFindOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitFindOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitFindOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FindOperationContext findOperation() throws RecognitionException {
		FindOperationContext _localctx = new FindOperationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_findOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(FIND);
			setState(364);
			match(LPAREN);
			setState(365);
			str();
			setState(366);
			match(IN);
			setState(367);
			str();
			setState(368);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayOperationContext extends ParserRuleContext {
		public ReverseOperationContext reverseOperation() {
			return getRuleContext(ReverseOperationContext.class,0);
		}
		public AddOperationContext addOperation() {
			return getRuleContext(AddOperationContext.class,0);
		}
		public ArrayOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterArrayOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitArrayOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitArrayOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayOperationContext arrayOperation() throws RecognitionException {
		ArrayOperationContext _localctx = new ArrayOperationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arrayOperation);
		try {
			setState(372);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REVERSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				reverseOperation();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				addOperation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReverseOperationContext extends ParserRuleContext {
		public TerminalNode REVERSE() { return getToken(SimpleScriptParser.REVERSE, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public ReverseOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reverseOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterReverseOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitReverseOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitReverseOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReverseOperationContext reverseOperation() throws RecognitionException {
		ReverseOperationContext _localctx = new ReverseOperationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_reverseOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(REVERSE);
			setState(375);
			match(LPAREN);
			setState(376);
			match(NAME);
			setState(377);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddOperationContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(SimpleScriptParser.ADD, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode COMMA() { return getToken(SimpleScriptParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public AddOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterAddOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitAddOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitAddOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOperationContext addOperation() throws RecognitionException {
		AddOperationContext _localctx = new AddOperationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_addOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(ADD);
			setState(380);
			match(LPAREN);
			setState(381);
			match(NAME);
			setState(382);
			match(COMMA);
			setState(383);
			expr();
			setState(384);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(SimpleScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleScriptParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(LBRACE);
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(387);
					statement();
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(393);
				returnStatement();
				}
			}

			setState(396);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IterationStatementContext extends ParserRuleContext {
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public ForLoopArrayContext forLoopArray() {
			return getRuleContext(ForLoopArrayContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_iterationStatement);
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				whileLoop();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				forLoop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(400);
				forLoopArray();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(SimpleScriptParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public ConditionalOperationContext conditionalOperation() {
			return getRuleContext(ConditionalOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(WHILE);
			setState(404);
			match(LPAREN);
			setState(405);
			conditionalOperation();
			setState(406);
			match(RPAREN);
			setState(407);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SimpleScriptParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public ConditionalOperationContext conditionalOperation() {
			return getRuleContext(ConditionalOperationContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(SimpleScriptParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(SimpleScriptParser.SEMICOLON, i);
		}
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public List<VariableAssignmentContext> variableAssignment() {
			return getRuleContexts(VariableAssignmentContext.class);
		}
		public VariableAssignmentContext variableAssignment(int i) {
			return getRuleContext(VariableAssignmentContext.class,i);
		}
		public SingleValueOperationContext singleValueOperation() {
			return getRuleContext(SingleValueOperationContext.class,0);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			match(FOR);
			setState(410);
			match(LPAREN);
			setState(415);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				{
				setState(411);
				variableDefinition();
				}
				break;
			case NAME:
				{
				setState(412);
				variableAssignment();
				setState(413);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(417);
			conditionalOperation();
			setState(418);
			match(SEMICOLON);
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(419);
				singleValueOperation();
				}
				break;
			case 2:
				{
				setState(420);
				variableAssignment();
				}
				break;
			}
			setState(423);
			match(RPAREN);
			setState(424);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopArrayContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SimpleScriptParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public TerminalNode IN() { return getToken(SimpleScriptParser.IN, 0); }
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForLoopArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoopArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterForLoopArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitForLoopArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitForLoopArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopArrayContext forLoopArray() throws RecognitionException {
		ForLoopArrayContext _localctx = new ForLoopArrayContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_forLoopArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(FOR);
			setState(427);
			match(LPAREN);
			setState(428);
			parameter();
			setState(429);
			match(IN);
			setState(430);
			match(NAME);
			setState(431);
			match(RPAREN);
			setState(432);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalStatementContext extends ParserRuleContext {
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
		}
		public SwitchConditionContext switchCondition() {
			return getRuleContext(SwitchConditionContext.class,0);
		}
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitConditionalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitConditionalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_conditionalStatement);
		try {
			setState(436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(434);
				ifCondition();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				switchCondition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfConditionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SimpleScriptParser.IF, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(SimpleScriptParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(SimpleScriptParser.LPAREN, i);
		}
		public List<ConditionalOperationContext> conditionalOperation() {
			return getRuleContexts(ConditionalOperationContext.class);
		}
		public ConditionalOperationContext conditionalOperation(int i) {
			return getRuleContext(ConditionalOperationContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(SimpleScriptParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(SimpleScriptParser.RPAREN, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(SimpleScriptParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(SimpleScriptParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(SimpleScriptParser.ELSE, 0); }
		public IfConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterIfCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitIfCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitIfCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfConditionContext ifCondition() throws RecognitionException {
		IfConditionContext _localctx = new IfConditionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_ifCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(IF);
			setState(439);
			match(LPAREN);
			setState(440);
			conditionalOperation();
			setState(441);
			match(RPAREN);
			setState(442);
			block();
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(443);
				match(ELIF);
				setState(444);
				match(LPAREN);
				setState(445);
				conditionalOperation();
				setState(446);
				match(RPAREN);
				setState(447);
				block();
				}
				}
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(454);
				match(ELSE);
				setState(455);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchConditionContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(SimpleScriptParser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleScriptParser.RBRACE, 0); }
		public List<CaseClauseContext> caseClause() {
			return getRuleContexts(CaseClauseContext.class);
		}
		public CaseClauseContext caseClause(int i) {
			return getRuleContext(CaseClauseContext.class,i);
		}
		public DefaultClauseContext defaultClause() {
			return getRuleContext(DefaultClauseContext.class,0);
		}
		public SwitchConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterSwitchCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitSwitchCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitSwitchCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchConditionContext switchCondition() throws RecognitionException {
		SwitchConditionContext _localctx = new SwitchConditionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_switchCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(SWITCH);
			setState(459);
			match(LPAREN);
			setState(460);
			match(NAME);
			setState(461);
			match(RPAREN);
			setState(462);
			match(LBRACE);
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(463);
				caseClause();
				}
				}
				setState(468);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(469);
				defaultClause();
				}
			}

			setState(472);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseClauseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(SimpleScriptParser.CASE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode COLON() { return getToken(SimpleScriptParser.COLON, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode BREAK() { return getToken(SimpleScriptParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public CaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterCaseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitCaseClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitCaseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseClauseContext caseClause() throws RecognitionException {
		CaseClauseContext _localctx = new CaseClauseContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_caseClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			match(CASE);
			setState(475);
			value();
			setState(476);
			match(COLON);
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56902127749128L) != 0)) {
				{
				{
				setState(477);
				statement();
				}
				}
				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BREAK) {
				{
				setState(483);
				match(BREAK);
				setState(484);
				match(SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultClauseContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(SimpleScriptParser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(SimpleScriptParser.COLON, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode BREAK() { return getToken(SimpleScriptParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
		public DefaultClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterDefaultClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitDefaultClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitDefaultClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultClauseContext defaultClause() throws RecognitionException {
		DefaultClauseContext _localctx = new DefaultClauseContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_defaultClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			match(DEFAULT);
			setState(488);
			match(COLON);
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56902127749128L) != 0)) {
				{
				{
				setState(489);
				statement();
				}
				}
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BREAK) {
				{
				setState(495);
				match(BREAK);
				setState(496);
				match(SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public TerminalNode NUMBER() { return getToken(SimpleScriptParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(SimpleScriptParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(SimpleScriptParser.STRING, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 52776759459840L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StrContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SimpleScriptParser.STRING, 0); }
		public TerminalNode NAME() { return getToken(SimpleScriptParser.NAME, 0); }
		public StrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleScriptListener ) ((SimpleScriptListener)listener).exitStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleScriptVisitor ) return ((SimpleScriptVisitor<? extends T>)visitor).visitStr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrContext str() throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_str);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return conditionalArithmeticOperation_sempred((ConditionalArithmeticOperationContext)_localctx, predIndex);
		case 19:
			return arithmeticOperation_sempred((ArithmeticOperationContext)_localctx, predIndex);
		case 20:
			return term_sempred((TermContext)_localctx, predIndex);
		case 23:
			return logicalTerm_sempred((LogicalTermContext)_localctx, predIndex);
		case 24:
			return logicalFactor_sempred((LogicalFactorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean conditionalArithmeticOperation_sempred(ConditionalArithmeticOperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arithmeticOperation_sempred(ArithmeticOperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalTerm_sempred(LogicalTermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalFactor_sempred(LogicalFactorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u01f8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0001"+
		"\u0000\u0004\u0000\\\b\u0000\u000b\u0000\f\u0000]\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001t\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002z\b\u0002\n\u0002\f\u0002}\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003\u0089\b\u0003\n\u0003\f\u0003\u008c"+
		"\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0097\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u009e"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00a4"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00aa"+
		"\b\u0006\u0001\u0006\u0005\u0006\u00ad\b\u0006\n\u0006\f\u0006\u00b0\t"+
		"\u0006\u0003\u0006\u00b2\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007\u00c1\b\u0007\u000b"+
		"\u0007\f\u0007\u00c2\u0001\u0007\u0001\u0007\u0003\u0007\u00c7\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\t\u00cf\b\t\n\t"+
		"\f\t\u00d2\t\t\u0001\n\u0001\n\u0001\n\u0005\n\u00d7\b\n\n\n\f\n\u00da"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00e5\b\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00f2\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u010b\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0113\b\u0012\n\u0012\f\u0012"+
		"\u0116\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0121\b\u0013"+
		"\n\u0013\f\u0013\u0124\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005"+
		"\u0014\u012f\b\u0014\n\u0014\f\u0014\u0132\t\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u013c\b\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0146\b\u0017"+
		"\n\u0017\f\u0017\u0149\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0151\b\u0018\n\u0018\f\u0018"+
		"\u0154\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u015f\b\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u0166\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u0175\b\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001!\u0001!\u0005!\u0185\b!\n!\f!\u0188\t!\u0001!\u0003"+
		"!\u018b\b!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0003\"\u0192\b\"\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0003$\u01a0\b$\u0001$\u0001$\u0001$\u0001$\u0003$\u01a6\b$\u0001"+
		"$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001&\u0001&\u0003&\u01b5\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u01c2\b\'\n"+
		"\'\f\'\u01c5\t\'\u0001\'\u0001\'\u0003\'\u01c9\b\'\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0005(\u01d1\b(\n(\f(\u01d4\t(\u0001(\u0003(\u01d7"+
		"\b(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0005)\u01df\b)\n)\f)\u01e2"+
		"\t)\u0001)\u0001)\u0003)\u01e6\b)\u0001*\u0001*\u0001*\u0005*\u01eb\b"+
		"*\n*\f*\u01ee\t*\u0001*\u0001*\u0003*\u01f2\b*\u0001+\u0001+\u0001,\u0001"+
		",\u0001,\u0000\u0005$&(.0-\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVX\u0000"+
		"\u0003\u0001\u0000\u0006\u0007\u0002\u0000\u001a\u001b,-\u0002\u0000\u001a"+
		"\u001a,,\u020c\u0000[\u0001\u0000\u0000\u0000\u0002s\u0001\u0000\u0000"+
		"\u0000\u0004u\u0001\u0000\u0000\u0000\u0006\u0080\u0001\u0000\u0000\u0000"+
		"\b\u008f\u0001\u0000\u0000\u0000\n\u0093\u0001\u0000\u0000\u0000\f\u009d"+
		"\u0001\u0000\u0000\u0000\u000e\u00b7\u0001\u0000\u0000\u0000\u0010\u00c8"+
		"\u0001\u0000\u0000\u0000\u0012\u00cb\u0001\u0000\u0000\u0000\u0014\u00d3"+
		"\u0001\u0000\u0000\u0000\u0016\u00db\u0001\u0000\u0000\u0000\u0018\u00df"+
		"\u0001\u0000\u0000\u0000\u001a\u00e9\u0001\u0000\u0000\u0000\u001c\u00ed"+
		"\u0001\u0000\u0000\u0000\u001e\u00f6\u0001\u0000\u0000\u0000 \u00fb\u0001"+
		"\u0000\u0000\u0000\"\u010a\u0001\u0000\u0000\u0000$\u010c\u0001\u0000"+
		"\u0000\u0000&\u0117\u0001\u0000\u0000\u0000(\u0125\u0001\u0000\u0000\u0000"+
		"*\u013b\u0001\u0000\u0000\u0000,\u013d\u0001\u0000\u0000\u0000.\u013f"+
		"\u0001\u0000\u0000\u00000\u014a\u0001\u0000\u0000\u00002\u015e\u0001\u0000"+
		"\u0000\u00004\u0160\u0001\u0000\u0000\u00006\u0165\u0001\u0000\u0000\u0000"+
		"8\u0167\u0001\u0000\u0000\u0000:\u016b\u0001\u0000\u0000\u0000<\u0174"+
		"\u0001\u0000\u0000\u0000>\u0176\u0001\u0000\u0000\u0000@\u017b\u0001\u0000"+
		"\u0000\u0000B\u0182\u0001\u0000\u0000\u0000D\u0191\u0001\u0000\u0000\u0000"+
		"F\u0193\u0001\u0000\u0000\u0000H\u0199\u0001\u0000\u0000\u0000J\u01aa"+
		"\u0001\u0000\u0000\u0000L\u01b4\u0001\u0000\u0000\u0000N\u01b6\u0001\u0000"+
		"\u0000\u0000P\u01ca\u0001\u0000\u0000\u0000R\u01da\u0001\u0000\u0000\u0000"+
		"T\u01e7\u0001\u0000\u0000\u0000V\u01f3\u0001\u0000\u0000\u0000X\u01f5"+
		"\u0001\u0000\u0000\u0000Z\\\u0003\u0002\u0001\u0000[Z\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u0000\u0000\u0001`\u0001"+
		"\u0001\u0000\u0000\u0000at\u0003\u0004\u0002\u0000bc\u0003\b\u0004\u0000"+
		"cd\u0005\u001c\u0000\u0000dt\u0001\u0000\u0000\u0000et\u0003\u0006\u0003"+
		"\u0000ft\u0003L&\u0000gt\u0003D\"\u0000ht\u0003\f\u0006\u0000ij\u0003"+
		"\u000e\u0007\u0000jk\u0005\u001c\u0000\u0000kt\u0001\u0000\u0000\u0000"+
		"lt\u0003\u0018\f\u0000mt\u0003\u001a\r\u0000nt\u0003\u001c\u000e\u0000"+
		"ot\u0003 \u0010\u0000pq\u0003\"\u0011\u0000qr\u0005\u001c\u0000\u0000"+
		"rt\u0001\u0000\u0000\u0000sa\u0001\u0000\u0000\u0000sb\u0001\u0000\u0000"+
		"\u0000se\u0001\u0000\u0000\u0000sf\u0001\u0000\u0000\u0000sg\u0001\u0000"+
		"\u0000\u0000sh\u0001\u0000\u0000\u0000si\u0001\u0000\u0000\u0000sl\u0001"+
		"\u0000\u0000\u0000sm\u0001\u0000\u0000\u0000sn\u0001\u0000\u0000\u0000"+
		"so\u0001\u0000\u0000\u0000sp\u0001\u0000\u0000\u0000t\u0003\u0001\u0000"+
		"\u0000\u0000uv\u0005\u0018\u0000\u0000v{\u0005,\u0000\u0000wx\u0005\u001d"+
		"\u0000\u0000xz\u0005,\u0000\u0000yw\u0001\u0000\u0000\u0000z}\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0005\u001c\u0000"+
		"\u0000\u007f\u0005\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0018\u0000"+
		"\u0000\u0081\u0082\u0005,\u0000\u0000\u0082\u0083\u0005\u0007\u0000\u0000"+
		"\u0083\u008a\u0003\"\u0011\u0000\u0084\u0085\u0005\u001d\u0000\u0000\u0085"+
		"\u0086\u0005,\u0000\u0000\u0086\u0087\u0005\u0007\u0000\u0000\u0087\u0089"+
		"\u0003\"\u0011\u0000\u0088\u0084\u0001\u0000\u0000\u0000\u0089\u008c\u0001"+
		"\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005\u001c\u0000\u0000\u008e\u0007\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0005,\u0000\u0000\u0090\u0091\u0007\u0000"+
		"\u0000\u0000\u0091\u0092\u0003\"\u0011\u0000\u0092\t\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0005\u0019\u0000\u0000\u0094\u0096\u0005\u001f\u0000"+
		"\u0000\u0095\u0097\u0003\"\u0011\u0000\u0096\u0095\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0005 \u0000\u0000\u0099\u009a\u0005\u001c\u0000\u0000\u009a"+
		"\u000b\u0001\u0000\u0000\u0000\u009b\u009e\u0005\u0018\u0000\u0000\u009c"+
		"\u009e\u0003\u0016\u000b\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d"+
		"\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0005,\u0000\u0000\u00a0\u00b1\u0005\u001f\u0000\u0000\u00a1\u00a4"+
		"\u0005\u0018\u0000\u0000\u00a2\u00a4\u0003\u0016\u000b\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a5\u00ae\u0005,\u0000\u0000\u00a6\u00a9\u0005"+
		"\u001d\u0000\u0000\u00a7\u00aa\u0005\u0018\u0000\u0000\u00a8\u00aa\u0003"+
		"\u0016\u000b\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00a8\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0005"+
		",\u0000\u0000\u00ac\u00a6\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000"+
		"\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b1\u00a3\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005 \u0000"+
		"\u0000\u00b4\u00b5\u0003B!\u0000\u00b5\u00b6\u0005\u001c\u0000\u0000\u00b6"+
		"\r\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005,\u0000\u0000\u00b8\u00c6"+
		"\u0005\u001f\u0000\u0000\u00b9\u00c7\u0005 \u0000\u0000\u00ba\u00bb\u0003"+
		"\"\u0011\u0000\u00bb\u00bc\u0005 \u0000\u0000\u00bc\u00c7\u0001\u0000"+
		"\u0000\u0000\u00bd\u00c0\u0003\"\u0011\u0000\u00be\u00bf\u0005\u001d\u0000"+
		"\u0000\u00bf\u00c1\u0003\"\u0011\u0000\u00c0\u00be\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0005 \u0000\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6"+
		"\u00b9\u0001\u0000\u0000\u0000\u00c6\u00ba\u0001\u0000\u0000\u0000\u00c6"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c7\u000f\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0005\u0018\u0000\u0000\u00c9\u00ca\u0005,\u0000\u0000\u00ca\u0011"+
		"\u0001\u0000\u0000\u0000\u00cb\u00d0\u0003\u0010\b\u0000\u00cc\u00cd\u0005"+
		"\u001d\u0000\u0000\u00cd\u00cf\u0003\u0010\b\u0000\u00ce\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u0013\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d8\u0003\"\u0011"+
		"\u0000\u00d4\u00d5\u0005\u001d\u0000\u0000\u00d5\u00d7\u0003\"\u0011\u0000"+
		"\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d9\u0015\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0005\u0018\u0000\u0000\u00dc\u00dd\u0005#\u0000\u0000\u00dd"+
		"\u00de\u0005$\u0000\u0000\u00de\u0017\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0003\u0016\u000b\u0000\u00e0\u00e1\u0005,\u0000\u0000\u00e1\u00e2\u0005"+
		"\u0007\u0000\u0000\u00e2\u00e4\u0005#\u0000\u0000\u00e3\u00e5\u0003\u0014"+
		"\n\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005$\u0000\u0000"+
		"\u00e7\u00e8\u0005\u001c\u0000\u0000\u00e8\u0019\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0003\u0016\u000b\u0000\u00ea\u00eb\u0005,\u0000\u0000\u00eb"+
		"\u00ec\u0005\u001c\u0000\u0000\u00ec\u001b\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ee\u0005,\u0000\u0000\u00ee\u00ef\u0005\u0007\u0000\u0000\u00ef\u00f1"+
		"\u0005#\u0000\u0000\u00f0\u00f2\u0003\u0014\n\u0000\u00f1\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f4\u0005$\u0000\u0000\u00f4\u00f5\u0005\u001c"+
		"\u0000\u0000\u00f5\u001d\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005,\u0000"+
		"\u0000\u00f7\u00f8\u0005#\u0000\u0000\u00f8\u00f9\u0003\"\u0011\u0000"+
		"\u00f9\u00fa\u0005$\u0000\u0000\u00fa\u001f\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0005&\u0000\u0000\u00fc\u00fd\u0005\u001f\u0000\u0000\u00fd\u00fe"+
		"\u0003\"\u0011\u0000\u00fe\u00ff\u0005 \u0000\u0000\u00ff\u0100\u0005"+
		"\u001c\u0000\u0000\u0100!\u0001\u0000\u0000\u0000\u0101\u010b\u0003V+"+
		"\u0000\u0102\u010b\u0003\u000e\u0007\u0000\u0103\u010b\u0003&\u0013\u0000"+
		"\u0104\u010b\u0003,\u0016\u0000\u0105\u010b\u00034\u001a\u0000\u0106\u010b"+
		"\u00036\u001b\u0000\u0107\u010b\u0003\n\u0005\u0000\u0108\u010b\u0003"+
		"\u001e\u000f\u0000\u0109\u010b\u0003<\u001e\u0000\u010a\u0101\u0001\u0000"+
		"\u0000\u0000\u010a\u0102\u0001\u0000\u0000\u0000\u010a\u0103\u0001\u0000"+
		"\u0000\u0000\u010a\u0104\u0001\u0000\u0000\u0000\u010a\u0105\u0001\u0000"+
		"\u0000\u0000\u010a\u0106\u0001\u0000\u0000\u0000\u010a\u0107\u0001\u0000"+
		"\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u0109\u0001\u0000"+
		"\u0000\u0000\u010b#\u0001\u0000\u0000\u0000\u010c\u010d\u0006\u0012\uffff"+
		"\uffff\u0000\u010d\u010e\u0003&\u0013\u0000\u010e\u0114\u0001\u0000\u0000"+
		"\u0000\u010f\u0110\n\u0002\u0000\u0000\u0110\u0111\u0005\b\u0000\u0000"+
		"\u0111\u0113\u0003&\u0013\u0000\u0112\u010f\u0001\u0000\u0000\u0000\u0113"+
		"\u0116\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114"+
		"\u0115\u0001\u0000\u0000\u0000\u0115%\u0001\u0000\u0000\u0000\u0116\u0114"+
		"\u0001\u0000\u0000\u0000\u0117\u0118\u0006\u0013\uffff\uffff\u0000\u0118"+
		"\u0119\u0003(\u0014\u0000\u0119\u0122\u0001\u0000\u0000\u0000\u011a\u011b"+
		"\n\u0003\u0000\u0000\u011b\u011c\u0005\u0001\u0000\u0000\u011c\u0121\u0003"+
		"(\u0014\u0000\u011d\u011e\n\u0002\u0000\u0000\u011e\u011f\u0005\u0003"+
		"\u0000\u0000\u011f\u0121\u0003(\u0014\u0000\u0120\u011a\u0001\u0000\u0000"+
		"\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0121\u0124\u0001\u0000\u0000"+
		"\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000"+
		"\u0000\u0123\'\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000"+
		"\u0125\u0126\u0006\u0014\uffff\uffff\u0000\u0126\u0127\u0003*\u0015\u0000"+
		"\u0127\u0130\u0001\u0000\u0000\u0000\u0128\u0129\n\u0002\u0000\u0000\u0129"+
		"\u012a\u0005\u0004\u0000\u0000\u012a\u012f\u0003*\u0015\u0000\u012b\u012c"+
		"\n\u0001\u0000\u0000\u012c\u012d\u0005\u0005\u0000\u0000\u012d\u012f\u0003"+
		"*\u0015\u0000\u012e\u0128\u0001\u0000\u0000\u0000\u012e\u012b\u0001\u0000"+
		"\u0000\u0000\u012f\u0132\u0001\u0000\u0000\u0000\u0130\u012e\u0001\u0000"+
		"\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131)\u0001\u0000\u0000"+
		"\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0133\u013c\u0003V+\u0000\u0134"+
		"\u013c\u0003\u000e\u0007\u0000\u0135\u0136\u0005\u001f\u0000\u0000\u0136"+
		"\u0137\u0003\"\u0011\u0000\u0137\u0138\u0005 \u0000\u0000\u0138\u013c"+
		"\u0001\u0000\u0000\u0000\u0139\u013a\u0005\u0003\u0000\u0000\u013a\u013c"+
		"\u0003*\u0015\u0000\u013b\u0133\u0001\u0000\u0000\u0000\u013b\u0134\u0001"+
		"\u0000\u0000\u0000\u013b\u0135\u0001\u0000\u0000\u0000\u013b\u0139\u0001"+
		"\u0000\u0000\u0000\u013c+\u0001\u0000\u0000\u0000\u013d\u013e\u0003.\u0017"+
		"\u0000\u013e-\u0001\u0000\u0000\u0000\u013f\u0140\u0006\u0017\uffff\uffff"+
		"\u0000\u0140\u0141\u00030\u0018\u0000\u0141\u0147\u0001\u0000\u0000\u0000"+
		"\u0142\u0143\n\u0001\u0000\u0000\u0143\u0144\u0005\n\u0000\u0000\u0144"+
		"\u0146\u00030\u0018\u0000\u0145\u0142\u0001\u0000\u0000\u0000\u0146\u0149"+
		"\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0147\u0148"+
		"\u0001\u0000\u0000\u0000\u0148/\u0001\u0000\u0000\u0000\u0149\u0147\u0001"+
		"\u0000\u0000\u0000\u014a\u014b\u0006\u0018\uffff\uffff\u0000\u014b\u014c"+
		"\u00032\u0019\u0000\u014c\u0152\u0001\u0000\u0000\u0000\u014d\u014e\n"+
		"\u0001\u0000\u0000\u014e\u014f\u0005\t\u0000\u0000\u014f\u0151\u00032"+
		"\u0019\u0000\u0150\u014d\u0001\u0000\u0000\u0000\u0151\u0154\u0001\u0000"+
		"\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000"+
		"\u0000\u0000\u01531\u0001\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000"+
		"\u0000\u0155\u015f\u0003V+\u0000\u0156\u015f\u0003\u000e\u0007\u0000\u0157"+
		"\u0158\u0005\u001f\u0000\u0000\u0158\u0159\u0003,\u0016\u0000\u0159\u015a"+
		"\u0005 \u0000\u0000\u015a\u015f\u0001\u0000\u0000\u0000\u015b\u015f\u0003"+
		"$\u0012\u0000\u015c\u015d\u0005\u000b\u0000\u0000\u015d\u015f\u00032\u0019"+
		"\u0000\u015e\u0155\u0001\u0000\u0000\u0000\u015e\u0156\u0001\u0000\u0000"+
		"\u0000\u015e\u0157\u0001\u0000\u0000\u0000\u015e\u015b\u0001\u0000\u0000"+
		"\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015f3\u0001\u0000\u0000\u0000"+
		"\u0160\u0161\u0005,\u0000\u0000\u0161\u0162\u0005\f\u0000\u0000\u0162"+
		"5\u0001\u0000\u0000\u0000\u0163\u0166\u00038\u001c\u0000\u0164\u0166\u0003"+
		":\u001d\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0165\u0164\u0001\u0000"+
		"\u0000\u0000\u01667\u0001\u0000\u0000\u0000\u0167\u0168\u0003X,\u0000"+
		"\u0168\u0169\u0005\u0002\u0000\u0000\u0169\u016a\u0003X,\u0000\u016a9"+
		"\u0001\u0000\u0000\u0000\u016b\u016c\u0005\'\u0000\u0000\u016c\u016d\u0005"+
		"\u001f\u0000\u0000\u016d\u016e\u0003X,\u0000\u016e\u016f\u0005\u000e\u0000"+
		"\u0000\u016f\u0170\u0003X,\u0000\u0170\u0171\u0005 \u0000\u0000\u0171"+
		";\u0001\u0000\u0000\u0000\u0172\u0175\u0003>\u001f\u0000\u0173\u0175\u0003"+
		"@ \u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0174\u0173\u0001\u0000\u0000"+
		"\u0000\u0175=\u0001\u0000\u0000\u0000\u0176\u0177\u0005(\u0000\u0000\u0177"+
		"\u0178\u0005\u001f\u0000\u0000\u0178\u0179\u0005,\u0000\u0000\u0179\u017a"+
		"\u0005 \u0000\u0000\u017a?\u0001\u0000\u0000\u0000\u017b\u017c\u0005)"+
		"\u0000\u0000\u017c\u017d\u0005\u001f\u0000\u0000\u017d\u017e\u0005,\u0000"+
		"\u0000\u017e\u017f\u0005\u001d\u0000\u0000\u017f\u0180\u0003\"\u0011\u0000"+
		"\u0180\u0181\u0005 \u0000\u0000\u0181A\u0001\u0000\u0000\u0000\u0182\u0186"+
		"\u0005!\u0000\u0000\u0183\u0185\u0003\u0002\u0001\u0000\u0184\u0183\u0001"+
		"\u0000\u0000\u0000\u0185\u0188\u0001\u0000\u0000\u0000\u0186\u0184\u0001"+
		"\u0000\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u018a\u0001"+
		"\u0000\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0189\u018b\u0003"+
		"\n\u0005\u0000\u018a\u0189\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000"+
		"\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u018d\u0005\"\u0000"+
		"\u0000\u018dC\u0001\u0000\u0000\u0000\u018e\u0192\u0003F#\u0000\u018f"+
		"\u0192\u0003H$\u0000\u0190\u0192\u0003J%\u0000\u0191\u018e\u0001\u0000"+
		"\u0000\u0000\u0191\u018f\u0001\u0000\u0000\u0000\u0191\u0190\u0001\u0000"+
		"\u0000\u0000\u0192E\u0001\u0000\u0000\u0000\u0193\u0194\u0005\u0013\u0000"+
		"\u0000\u0194\u0195\u0005\u001f\u0000\u0000\u0195\u0196\u0003,\u0016\u0000"+
		"\u0196\u0197\u0005 \u0000\u0000\u0197\u0198\u0003B!\u0000\u0198G\u0001"+
		"\u0000\u0000\u0000\u0199\u019a\u0005\u0012\u0000\u0000\u019a\u019f\u0005"+
		"\u001f\u0000\u0000\u019b\u01a0\u0003\u0006\u0003\u0000\u019c\u019d\u0003"+
		"\b\u0004\u0000\u019d\u019e\u0005\u001c\u0000\u0000\u019e\u01a0\u0001\u0000"+
		"\u0000\u0000\u019f\u019b\u0001\u0000\u0000\u0000\u019f\u019c\u0001\u0000"+
		"\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1\u01a2\u0003,\u0016"+
		"\u0000\u01a2\u01a5\u0005\u001c\u0000\u0000\u01a3\u01a6\u00034\u001a\u0000"+
		"\u01a4\u01a6\u0003\b\u0004\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a4\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7"+
		"\u01a8\u0005 \u0000\u0000\u01a8\u01a9\u0003B!\u0000\u01a9I\u0001\u0000"+
		"\u0000\u0000\u01aa\u01ab\u0005\u0012\u0000\u0000\u01ab\u01ac\u0005\u001f"+
		"\u0000\u0000\u01ac\u01ad\u0003\u0010\b\u0000\u01ad\u01ae\u0005\u000e\u0000"+
		"\u0000\u01ae\u01af\u0005,\u0000\u0000\u01af\u01b0\u0005 \u0000\u0000\u01b0"+
		"\u01b1\u0003B!\u0000\u01b1K\u0001\u0000\u0000\u0000\u01b2\u01b5\u0003"+
		"N\'\u0000\u01b3\u01b5\u0003P(\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000"+
		"\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b5M\u0001\u0000\u0000\u0000\u01b6"+
		"\u01b7\u0005\u000f\u0000\u0000\u01b7\u01b8\u0005\u001f\u0000\u0000\u01b8"+
		"\u01b9\u0003,\u0016\u0000\u01b9\u01ba\u0005 \u0000\u0000\u01ba\u01c3\u0003"+
		"B!\u0000\u01bb\u01bc\u0005\u0010\u0000\u0000\u01bc\u01bd\u0005\u001f\u0000"+
		"\u0000\u01bd\u01be\u0003,\u0016\u0000\u01be\u01bf\u0005 \u0000\u0000\u01bf"+
		"\u01c0\u0003B!\u0000\u01c0\u01c2\u0001\u0000\u0000\u0000\u01c1\u01bb\u0001"+
		"\u0000\u0000\u0000\u01c2\u01c5\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001"+
		"\u0000\u0000\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000\u01c4\u01c8\u0001"+
		"\u0000\u0000\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005"+
		"\u0011\u0000\u0000\u01c7\u01c9\u0003B!\u0000\u01c8\u01c6\u0001\u0000\u0000"+
		"\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9O\u0001\u0000\u0000\u0000"+
		"\u01ca\u01cb\u0005\u0014\u0000\u0000\u01cb\u01cc\u0005\u001f\u0000\u0000"+
		"\u01cc\u01cd\u0005,\u0000\u0000\u01cd\u01ce\u0005 \u0000\u0000\u01ce\u01d2"+
		"\u0005!\u0000\u0000\u01cf\u01d1\u0003R)\u0000\u01d0\u01cf\u0001\u0000"+
		"\u0000\u0000\u01d1\u01d4\u0001\u0000\u0000\u0000\u01d2\u01d0\u0001\u0000"+
		"\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d6\u0001\u0000"+
		"\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5\u01d7\u0003T*\u0000"+
		"\u01d6\u01d5\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000"+
		"\u01d7\u01d8\u0001\u0000\u0000\u0000\u01d8\u01d9\u0005\"\u0000\u0000\u01d9"+
		"Q\u0001\u0000\u0000\u0000\u01da\u01db\u0005\u0015\u0000\u0000\u01db\u01dc"+
		"\u0003V+\u0000\u01dc\u01e0\u0005\u001e\u0000\u0000\u01dd\u01df\u0003\u0002"+
		"\u0001\u0000\u01de\u01dd\u0001\u0000\u0000\u0000\u01df\u01e2\u0001\u0000"+
		"\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000\u01e0\u01e1\u0001\u0000"+
		"\u0000\u0000\u01e1\u01e5\u0001\u0000\u0000\u0000\u01e2\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e3\u01e4\u0005\u0017\u0000\u0000\u01e4\u01e6\u0005\u001c"+
		"\u0000\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000"+
		"\u0000\u0000\u01e6S\u0001\u0000\u0000\u0000\u01e7\u01e8\u0005\u0016\u0000"+
		"\u0000\u01e8\u01ec\u0005\u001e\u0000\u0000\u01e9\u01eb\u0003\u0002\u0001"+
		"\u0000\u01ea\u01e9\u0001\u0000\u0000\u0000\u01eb\u01ee\u0001\u0000\u0000"+
		"\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000"+
		"\u0000\u01ed\u01f1\u0001\u0000\u0000\u0000\u01ee\u01ec\u0001\u0000\u0000"+
		"\u0000\u01ef\u01f0\u0005\u0017\u0000\u0000\u01f0\u01f2\u0005\u001c\u0000"+
		"\u0000\u01f1\u01ef\u0001\u0000\u0000\u0000\u01f1\u01f2\u0001\u0000\u0000"+
		"\u0000\u01f2U\u0001\u0000\u0000\u0000\u01f3\u01f4\u0007\u0001\u0000\u0000"+
		"\u01f4W\u0001\u0000\u0000\u0000\u01f5\u01f6\u0007\u0002\u0000\u0000\u01f6"+
		"Y\u0001\u0000\u0000\u0000*]s{\u008a\u0096\u009d\u00a3\u00a9\u00ae\u00b1"+
		"\u00c2\u00c6\u00d0\u00d8\u00e4\u00f1\u010a\u0114\u0120\u0122\u012e\u0130"+
		"\u013b\u0147\u0152\u015e\u0165\u0174\u0186\u018a\u0191\u019f\u01a5\u01b4"+
		"\u01c3\u01c8\u01d2\u01d6\u01e0\u01e5\u01ec\u01f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}