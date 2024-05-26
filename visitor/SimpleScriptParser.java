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
		CONCAT=1, SUB=2, MUL=3, DIV=4, ASSIGNMENT=5, ASSIGN=6, CONDITION_OP=7, 
		AND=8, OR=9, NOT=10, SINGLE_VAL_OP=11, IS_NULL=12, IN=13, IF=14, ELIF=15, 
		ELSE=16, FOR=17, WHILE=18, SWITCH=19, CASE=20, DEFAULT=21, BREAK=22, TYPE=23, 
		RETURN=24, STRING=25, BOOLEAN=26, SEMICOLON=27, COMMA=28, COLON=29, LPAREN=30, 
		RPAREN=31, LBRACE=32, RBRACE=33, LBRACK=34, RBRACK=35, FUNCTION=36, PRINT=37, 
		FIND=38, REVERSE=39, ADD=40, COMMENT=41, WS=42, NAME=43, NUMBER=44;
	public static final int
		RULE_script = 0, RULE_statement = 1, RULE_variableDeclaration = 2, RULE_variableDefinition = 3, 
		RULE_variableAssignment = 4, RULE_returnStatement = 5, RULE_functionDeclaration = 6, 
		RULE_functionInvocation = 7, RULE_parameter = 8, RULE_parameters = 9, 
		RULE_arguments = 10, RULE_arrayType = 11, RULE_arrayDefinition = 12, RULE_arrayDeclaration = 13, 
		RULE_arrayAssignment = 14, RULE_arrayAccess = 15, RULE_printStatement = 16, 
		RULE_expr = 17, RULE_arithmeticOperation = 18, RULE_term = 19, RULE_factor = 20, 
		RULE_conditionalOperation = 21, RULE_logicalTerm = 22, RULE_logicalFactor = 23, 
		RULE_logicalPrimary = 24, RULE_singleValueOperation = 25, RULE_stringOperation = 26, 
		RULE_concatenationOperation = 27, RULE_findOperation = 28, RULE_arrayOperation = 29, 
		RULE_reverseOperation = 30, RULE_addOperation = 31, RULE_block = 32, RULE_iterationStatement = 33, 
		RULE_whileLoop = 34, RULE_forLoop = 35, RULE_forLoopArray = 36, RULE_conditionalStatement = 37, 
		RULE_ifCondition = 38, RULE_switchCondition = 39, RULE_value = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "statement", "variableDeclaration", "variableDefinition", "variableAssignment", 
			"returnStatement", "functionDeclaration", "functionInvocation", "parameter", 
			"parameters", "arguments", "arrayType", "arrayDefinition", "arrayDeclaration", 
			"arrayAssignment", "arrayAccess", "printStatement", "expr", "arithmeticOperation", 
			"term", "factor", "conditionalOperation", "logicalTerm", "logicalFactor", 
			"logicalPrimary", "singleValueOperation", "stringOperation", "concatenationOperation", 
			"findOperation", "arrayOperation", "reverseOperation", "addOperation", 
			"block", "iterationStatement", "whileLoop", "forLoop", "forLoopArray", 
			"conditionalStatement", "ifCondition", "switchCondition", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", null, "'='", null, "'and'", "'or'", 
			"'not'", null, "'is null'", "'in'", "'if'", "'elif'", "'else'", "'for'", 
			"'while'", "'switch'", "'case'", "'default'", "'break'", null, "'return'", 
			null, null, "';'", "','", "':'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"'function'", "'print'", "'find'", "'reverse'", "'add'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CONCAT", "SUB", "MUL", "DIV", "ASSIGNMENT", "ASSIGN", "CONDITION_OP", 
			"AND", "OR", "NOT", "SINGLE_VAL_OP", "IS_NULL", "IN", "IF", "ELIF", "ELSE", 
			"FOR", "WHILE", "SWITCH", "CASE", "DEFAULT", "BREAK", "TYPE", "RETURN", 
			"STRING", "BOOLEAN", "SEMICOLON", "COMMA", "COLON", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "FUNCTION", "PRINT", "FIND", 
			"REVERSE", "ADD", "COMMENT", "WS", "NAME", "NUMBER"
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
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				statement();
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 26801796432896L) != 0) );
			setState(87);
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
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				variableAssignment();
				setState(91);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				variableDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				conditionalStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				iterationStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(96);
				functionDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(97);
				functionInvocation();
				setState(98);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(100);
				arrayDefinition();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(101);
				arrayDeclaration();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(102);
				arrayAssignment();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(103);
				printStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(104);
				expr();
				setState(105);
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
			setState(109);
			match(TYPE);
			setState(110);
			match(NAME);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(111);
				match(COMMA);
				setState(112);
				match(NAME);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
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
			setState(120);
			match(TYPE);
			setState(121);
			match(NAME);
			setState(122);
			match(ASSIGN);
			setState(123);
			expr();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(124);
				match(COMMA);
				setState(125);
				match(NAME);
				setState(126);
				match(ASSIGN);
				setState(127);
				expr();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
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
			setState(135);
			match(NAME);
			setState(136);
			_la = _input.LA(1);
			if ( !(_la==ASSIGNMENT || _la==ASSIGN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(137);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(SimpleScriptParser.SEMICOLON, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(RETURN);
			setState(140);
			match(LPAREN);
			setState(141);
			expr();
			setState(142);
			match(RPAREN);
			setState(143);
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
		public TerminalNode LBRACE() { return getToken(SimpleScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleScriptParser.RBRACE, 0); }
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(145);
				match(TYPE);
				}
				break;
			case 2:
				{
				setState(146);
				arrayType();
				}
				break;
			}
			setState(149);
			match(NAME);
			setState(150);
			match(LPAREN);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(153);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(151);
					match(TYPE);
					}
					break;
				case 2:
					{
					setState(152);
					arrayType();
					}
					break;
				}
				setState(155);
				match(NAME);
				{
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(156);
					match(COMMA);
					setState(159);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(157);
						match(TYPE);
						}
						break;
					case 2:
						{
						setState(158);
						arrayType();
						}
						break;
					}
					setState(161);
					match(NAME);
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
			}

			setState(169);
			match(RPAREN);
			setState(170);
			match(LBRACE);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(171);
					statement();
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(177);
				returnStatement();
				}
			}

			setState(180);
			match(RBRACE);
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
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26664348156928L) != 0)) {
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26664348156928L) != 0)) {
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
		public ArithmeticOperationContext arithmeticOperation() {
			return getRuleContext(ArithmeticOperationContext.class,0);
		}
		public ConditionalOperationContext conditionalOperation() {
			return getRuleContext(ConditionalOperationContext.class,0);
		}
		public SingleValueOperationContext singleValueOperation() {
			return getRuleContext(SingleValueOperationContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
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
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
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
				arithmeticOperation(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				conditionalOperation(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(260);
				singleValueOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(261);
				functionInvocation();
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_arithmeticOperation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(268);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(276);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticOperationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOperation);
						setState(270);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(271);
						match(CONCAT);
						setState(272);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticOperationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticOperation);
						setState(273);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(274);
						match(SUB);
						setState(275);
						term(0);
						}
						break;
					}
					} 
				}
				setState(280);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(282);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(290);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(284);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(285);
						match(MUL);
						setState(286);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(287);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(288);
						match(DIV);
						setState(289);
						factor();
						}
						break;
					}
					} 
				}
				setState(294);
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
		enterRule(_localctx, 40, RULE_factor);
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				functionInvocation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
				match(LPAREN);
				setState(298);
				expr();
				setState(299);
				match(RPAREN);
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
		public ConditionalOperationContext conditionalOperation() {
			return getRuleContext(ConditionalOperationContext.class,0);
		}
		public TerminalNode CONDITION_OP() { return getToken(SimpleScriptParser.CONDITION_OP, 0); }
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
		return conditionalOperation(0);
	}

	private ConditionalOperationContext conditionalOperation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionalOperationContext _localctx = new ConditionalOperationContext(_ctx, _parentState);
		ConditionalOperationContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_conditionalOperation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(304);
			logicalTerm(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalOperationContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionalOperation);
					setState(306);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(307);
					match(CONDITION_OP);
					setState(308);
					logicalTerm(0);
					}
					} 
				}
				setState(313);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_logicalTerm, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(315);
			logicalFactor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalTermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalTerm);
					setState(317);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(318);
					match(OR);
					setState(319);
					logicalFactor(0);
					}
					} 
				}
				setState(324);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_logicalFactor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(326);
			logicalPrimary();
			}
			_ctx.stop = _input.LT(-1);
			setState(333);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalFactorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalFactor);
					setState(328);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(329);
					match(AND);
					setState(330);
					logicalPrimary();
					}
					} 
				}
				setState(335);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public ConditionalOperationContext conditionalOperation() {
			return getRuleContext(ConditionalOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
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
		enterRule(_localctx, 48, RULE_logicalPrimary);
		try {
			setState(343);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case BOOLEAN:
			case NAME:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				value();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				match(LPAREN);
				setState(338);
				conditionalOperation(0);
				setState(339);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				match(NOT);
				setState(342);
				logicalPrimary();
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
		enterRule(_localctx, 50, RULE_singleValueOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(NAME);
			setState(346);
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
		enterRule(_localctx, 52, RULE_stringOperation);
		try {
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				concatenationOperation();
				}
				break;
			case FIND:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
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
		public TerminalNode CONCAT() { return getToken(SimpleScriptParser.CONCAT, 0); }
		public List<TerminalNode> STRING() { return getTokens(SimpleScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SimpleScriptParser.STRING, i);
		}
		public List<TerminalNode> NAME() { return getTokens(SimpleScriptParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SimpleScriptParser.NAME, i);
		}
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
		enterRule(_localctx, 54, RULE_concatenationOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(353);
			match(CONCAT);
			setState(354);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FindOperationContext extends ParserRuleContext {
		public TerminalNode FIND() { return getToken(SimpleScriptParser.FIND, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleScriptParser.LPAREN, 0); }
		public TerminalNode IN() { return getToken(SimpleScriptParser.IN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleScriptParser.RPAREN, 0); }
		public List<TerminalNode> STRING() { return getTokens(SimpleScriptParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SimpleScriptParser.STRING, i);
		}
		public List<TerminalNode> NAME() { return getTokens(SimpleScriptParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SimpleScriptParser.NAME, i);
		}
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
		enterRule(_localctx, 56, RULE_findOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(FIND);
			setState(357);
			match(LPAREN);
			setState(358);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(359);
			match(IN);
			setState(360);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(361);
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
		enterRule(_localctx, 58, RULE_arrayOperation);
		try {
			setState(365);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REVERSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				reverseOperation();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
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
		enterRule(_localctx, 60, RULE_reverseOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(REVERSE);
			setState(368);
			match(LPAREN);
			setState(369);
			match(NAME);
			setState(370);
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
		enterRule(_localctx, 62, RULE_addOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(ADD);
			setState(373);
			match(LPAREN);
			setState(374);
			match(NAME);
			setState(375);
			match(COMMA);
			setState(376);
			expr();
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(SimpleScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleScriptParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 64, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(LBRACE);
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26801796432896L) != 0)) {
				{
				{
				setState(380);
				statement();
				}
				}
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(386);
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
		enterRule(_localctx, 66, RULE_iterationStatement);
		try {
			setState(391);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				whileLoop();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				forLoop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(390);
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
		enterRule(_localctx, 68, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(WHILE);
			setState(394);
			match(LPAREN);
			setState(395);
			conditionalOperation(0);
			setState(396);
			match(RPAREN);
			setState(397);
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
		enterRule(_localctx, 70, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(FOR);
			setState(400);
			match(LPAREN);
			setState(405);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				{
				setState(401);
				variableDefinition();
				}
				break;
			case NAME:
				{
				setState(402);
				variableAssignment();
				setState(403);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(407);
			conditionalOperation(0);
			setState(408);
			match(SEMICOLON);
			setState(411);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(409);
				singleValueOperation();
				}
				break;
			case 2:
				{
				setState(410);
				variableAssignment();
				}
				break;
			}
			setState(413);
			match(RPAREN);
			setState(414);
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
		enterRule(_localctx, 72, RULE_forLoopArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(FOR);
			setState(417);
			match(LPAREN);
			setState(418);
			parameter();
			setState(419);
			match(IN);
			setState(420);
			match(NAME);
			setState(421);
			match(RPAREN);
			setState(422);
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
		enterRule(_localctx, 74, RULE_conditionalStatement);
		try {
			setState(426);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				ifCondition();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 2);
				{
				setState(425);
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
		enterRule(_localctx, 76, RULE_ifCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(IF);
			setState(429);
			match(LPAREN);
			setState(430);
			conditionalOperation(0);
			setState(431);
			match(RPAREN);
			setState(432);
			block();
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(433);
				match(ELIF);
				setState(434);
				match(LPAREN);
				setState(435);
				conditionalOperation(0);
				setState(436);
				match(RPAREN);
				setState(437);
				block();
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(444);
				match(ELSE);
				setState(445);
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
		public List<TerminalNode> CASE() { return getTokens(SimpleScriptParser.CASE); }
		public TerminalNode CASE(int i) {
			return getToken(SimpleScriptParser.CASE, i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(SimpleScriptParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(SimpleScriptParser.COLON, i);
		}
		public TerminalNode DEFAULT() { return getToken(SimpleScriptParser.DEFAULT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> BREAK() { return getTokens(SimpleScriptParser.BREAK); }
		public TerminalNode BREAK(int i) {
			return getToken(SimpleScriptParser.BREAK, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(SimpleScriptParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(SimpleScriptParser.SEMICOLON, i);
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
		enterRule(_localctx, 78, RULE_switchCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(SWITCH);
			setState(449);
			match(LPAREN);
			setState(450);
			match(NAME);
			setState(451);
			match(RPAREN);
			setState(452);
			match(LBRACE);
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(453);
				match(CASE);
				setState(454);
				value();
				setState(455);
				match(COLON);
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26801796432896L) != 0)) {
					{
					{
					setState(456);
					statement();
					}
					}
					setState(461);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BREAK) {
					{
					setState(462);
					match(BREAK);
					setState(463);
					match(SEMICOLON);
					}
				}

				}
				}
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(471);
				match(DEFAULT);
				setState(472);
				match(COLON);
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26801796432896L) != 0)) {
					{
					{
					setState(473);
					statement();
					}
					}
					setState(478);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BREAK) {
					{
					setState(479);
					match(BREAK);
					setState(480);
					match(SEMICOLON);
					}
				}

				}
			}

			setState(485);
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
		enterRule(_localctx, 80, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 26388379729920L) != 0)) ) {
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
			return arithmeticOperation_sempred((ArithmeticOperationContext)_localctx, predIndex);
		case 19:
			return term_sempred((TermContext)_localctx, predIndex);
		case 21:
			return conditionalOperation_sempred((ConditionalOperationContext)_localctx, predIndex);
		case 22:
			return logicalTerm_sempred((LogicalTermContext)_localctx, predIndex);
		case 23:
			return logicalFactor_sempred((LogicalFactorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmeticOperation_sempred(ArithmeticOperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionalOperation_sempred(ConditionalOperationContext _localctx, int predIndex) {
		switch (predIndex) {
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
		"\u0004\u0001,\u01ea\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0001\u0000\u0004\u0000T\b\u0000\u000b\u0000\f\u0000U\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001l\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002r\b\u0002\n\u0002\f\u0002u\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u0081\b\u0003\n\u0003"+
		"\f\u0003\u0084\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u0094\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u009a\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00a0\b\u0006"+
		"\u0001\u0006\u0005\u0006\u00a3\b\u0006\n\u0006\f\u0006\u00a6\t\u0006\u0003"+
		"\u0006\u00a8\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00ad"+
		"\b\u0006\n\u0006\f\u0006\u00b0\t\u0006\u0001\u0006\u0003\u0006\u00b3\b"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0004\u0007\u00c1\b\u0007\u000b\u0007\f\u0007\u00c2\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00c7\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0005\t\u00cf\b\t\n\t\f\t\u00d2\t\t\u0001\n\u0001\n\u0001"+
		"\n\u0005\n\u00d7\b\n\n\n\f\n\u00da\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00e5\b\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00f2\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u010a\b\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u0115\b\u0012\n\u0012\f\u0012\u0118\t\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0123\b\u0013\n\u0013"+
		"\f\u0013\u0126\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u012e\b\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0136\b\u0015"+
		"\n\u0015\f\u0015\u0139\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0141\b\u0016\n\u0016\f\u0016"+
		"\u0144\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u014c\b\u0017\n\u0017\f\u0017\u014f\t\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u0158\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u015f\b\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u016e"+
		"\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0005 \u017e\b \n \f \u0181\t \u0001 \u0001 \u0001"+
		"!\u0001!\u0001!\u0003!\u0188\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u0196\b#\u0001"+
		"#\u0001#\u0001#\u0001#\u0003#\u019c\b#\u0001#\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0003%\u01ab"+
		"\b%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0005&\u01b8\b&\n&\f&\u01bb\t&\u0001&\u0001&\u0003&\u01bf\b&"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0005\'\u01ca\b\'\n\'\f\'\u01cd\t\'\u0001\'\u0001\'\u0003\'\u01d1\b"+
		"\'\u0005\'\u01d3\b\'\n\'\f\'\u01d6\t\'\u0001\'\u0001\'\u0001\'\u0005\'"+
		"\u01db\b\'\n\'\f\'\u01de\t\'\u0001\'\u0001\'\u0003\'\u01e2\b\'\u0003\'"+
		"\u01e4\b\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0000\u0005$&*,.)\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNP\u0000\u0003\u0001\u0000\u0005\u0006\u0002"+
		"\u0000\u0019\u0019++\u0002\u0000\u0019\u001a+,\u01fe\u0000S\u0001\u0000"+
		"\u0000\u0000\u0002k\u0001\u0000\u0000\u0000\u0004m\u0001\u0000\u0000\u0000"+
		"\u0006x\u0001\u0000\u0000\u0000\b\u0087\u0001\u0000\u0000\u0000\n\u008b"+
		"\u0001\u0000\u0000\u0000\f\u0093\u0001\u0000\u0000\u0000\u000e\u00b7\u0001"+
		"\u0000\u0000\u0000\u0010\u00c8\u0001\u0000\u0000\u0000\u0012\u00cb\u0001"+
		"\u0000\u0000\u0000\u0014\u00d3\u0001\u0000\u0000\u0000\u0016\u00db\u0001"+
		"\u0000\u0000\u0000\u0018\u00df\u0001\u0000\u0000\u0000\u001a\u00e9\u0001"+
		"\u0000\u0000\u0000\u001c\u00ed\u0001\u0000\u0000\u0000\u001e\u00f6\u0001"+
		"\u0000\u0000\u0000 \u00fb\u0001\u0000\u0000\u0000\"\u0109\u0001\u0000"+
		"\u0000\u0000$\u010b\u0001\u0000\u0000\u0000&\u0119\u0001\u0000\u0000\u0000"+
		"(\u012d\u0001\u0000\u0000\u0000*\u012f\u0001\u0000\u0000\u0000,\u013a"+
		"\u0001\u0000\u0000\u0000.\u0145\u0001\u0000\u0000\u00000\u0157\u0001\u0000"+
		"\u0000\u00002\u0159\u0001\u0000\u0000\u00004\u015e\u0001\u0000\u0000\u0000"+
		"6\u0160\u0001\u0000\u0000\u00008\u0164\u0001\u0000\u0000\u0000:\u016d"+
		"\u0001\u0000\u0000\u0000<\u016f\u0001\u0000\u0000\u0000>\u0174\u0001\u0000"+
		"\u0000\u0000@\u017b\u0001\u0000\u0000\u0000B\u0187\u0001\u0000\u0000\u0000"+
		"D\u0189\u0001\u0000\u0000\u0000F\u018f\u0001\u0000\u0000\u0000H\u01a0"+
		"\u0001\u0000\u0000\u0000J\u01aa\u0001\u0000\u0000\u0000L\u01ac\u0001\u0000"+
		"\u0000\u0000N\u01c0\u0001\u0000\u0000\u0000P\u01e7\u0001\u0000\u0000\u0000"+
		"RT\u0003\u0002\u0001\u0000SR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000"+
		"\u0000\u0000WX\u0005\u0000\u0000\u0001X\u0001\u0001\u0000\u0000\u0000"+
		"Yl\u0003\u0004\u0002\u0000Z[\u0003\b\u0004\u0000[\\\u0005\u001b\u0000"+
		"\u0000\\l\u0001\u0000\u0000\u0000]l\u0003\u0006\u0003\u0000^l\u0003J%"+
		"\u0000_l\u0003B!\u0000`l\u0003\f\u0006\u0000ab\u0003\u000e\u0007\u0000"+
		"bc\u0005\u001b\u0000\u0000cl\u0001\u0000\u0000\u0000dl\u0003\u0018\f\u0000"+
		"el\u0003\u001a\r\u0000fl\u0003\u001c\u000e\u0000gl\u0003 \u0010\u0000"+
		"hi\u0003\"\u0011\u0000ij\u0005\u001b\u0000\u0000jl\u0001\u0000\u0000\u0000"+
		"kY\u0001\u0000\u0000\u0000kZ\u0001\u0000\u0000\u0000k]\u0001\u0000\u0000"+
		"\u0000k^\u0001\u0000\u0000\u0000k_\u0001\u0000\u0000\u0000k`\u0001\u0000"+
		"\u0000\u0000ka\u0001\u0000\u0000\u0000kd\u0001\u0000\u0000\u0000ke\u0001"+
		"\u0000\u0000\u0000kf\u0001\u0000\u0000\u0000kg\u0001\u0000\u0000\u0000"+
		"kh\u0001\u0000\u0000\u0000l\u0003\u0001\u0000\u0000\u0000mn\u0005\u0017"+
		"\u0000\u0000ns\u0005+\u0000\u0000op\u0005\u001c\u0000\u0000pr\u0005+\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000"+
		"\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000vw\u0005\u001b\u0000\u0000w\u0005\u0001\u0000\u0000"+
		"\u0000xy\u0005\u0017\u0000\u0000yz\u0005+\u0000\u0000z{\u0005\u0006\u0000"+
		"\u0000{\u0082\u0003\"\u0011\u0000|}\u0005\u001c\u0000\u0000}~\u0005+\u0000"+
		"\u0000~\u007f\u0005\u0006\u0000\u0000\u007f\u0081\u0003\"\u0011\u0000"+
		"\u0080|\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083"+
		"\u0085\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005\u001b\u0000\u0000\u0086\u0007\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005+\u0000\u0000\u0088\u0089\u0007\u0000\u0000\u0000\u0089\u008a"+
		"\u0003\"\u0011\u0000\u008a\t\u0001\u0000\u0000\u0000\u008b\u008c\u0005"+
		"\u0018\u0000\u0000\u008c\u008d\u0005\u001e\u0000\u0000\u008d\u008e\u0003"+
		"\"\u0011\u0000\u008e\u008f\u0005\u001f\u0000\u0000\u008f\u0090\u0005\u001b"+
		"\u0000\u0000\u0090\u000b\u0001\u0000\u0000\u0000\u0091\u0094\u0005\u0017"+
		"\u0000\u0000\u0092\u0094\u0003\u0016\u000b\u0000\u0093\u0091\u0001\u0000"+
		"\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0005+\u0000\u0000\u0096\u00a7\u0005\u001e\u0000"+
		"\u0000\u0097\u009a\u0005\u0017\u0000\u0000\u0098\u009a\u0003\u0016\u000b"+
		"\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u00a4\u0005+\u0000\u0000"+
		"\u009c\u009f\u0005\u001c\u0000\u0000\u009d\u00a0\u0005\u0017\u0000\u0000"+
		"\u009e\u00a0\u0003\u0016\u000b\u0000\u009f\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a3\u0005+\u0000\u0000\u00a2\u009c\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a7\u0099\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0005\u001f\u0000\u0000\u00aa\u00ae\u0005 \u0000\u0000\u00ab\u00ad"+
		"\u0003\u0002\u0001\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00b0"+
		"\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b3\u0003\n\u0005\u0000\u00b2\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0005!\u0000\u0000\u00b5\u00b6\u0005\u001b"+
		"\u0000\u0000\u00b6\r\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005+\u0000"+
		"\u0000\u00b8\u00c6\u0005\u001e\u0000\u0000\u00b9\u00c7\u0005\u001f\u0000"+
		"\u0000\u00ba\u00bb\u0003\"\u0011\u0000\u00bb\u00bc\u0005\u001f\u0000\u0000"+
		"\u00bc\u00c7\u0001\u0000\u0000\u0000\u00bd\u00c0\u0003\"\u0011\u0000\u00be"+
		"\u00bf\u0005\u001c\u0000\u0000\u00bf\u00c1\u0003\"\u0011\u0000\u00c0\u00be"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u001f\u0000\u0000\u00c5\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c6\u00b9\u0001\u0000\u0000\u0000\u00c6\u00ba"+
		"\u0001\u0000\u0000\u0000\u00c6\u00bd\u0001\u0000\u0000\u0000\u00c7\u000f"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u0017\u0000\u0000\u00c9\u00ca"+
		"\u0005+\u0000\u0000\u00ca\u0011\u0001\u0000\u0000\u0000\u00cb\u00d0\u0003"+
		"\u0010\b\u0000\u00cc\u00cd\u0005\u001c\u0000\u0000\u00cd\u00cf\u0003\u0010"+
		"\b\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u0013\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d8\u0003\"\u0011\u0000\u00d4\u00d5\u0005\u001c\u0000\u0000"+
		"\u00d5\u00d7\u0003\"\u0011\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7"+
		"\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0001\u0000\u0000\u0000\u00d9\u0015\u0001\u0000\u0000\u0000\u00da"+
		"\u00d8\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\u0017\u0000\u0000\u00dc"+
		"\u00dd\u0005\"\u0000\u0000\u00dd\u00de\u0005#\u0000\u0000\u00de\u0017"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0003\u0016\u000b\u0000\u00e0\u00e1"+
		"\u0005+\u0000\u0000\u00e1\u00e2\u0005\u0006\u0000\u0000\u00e2\u00e4\u0005"+
		"\"\u0000\u0000\u00e3\u00e5\u0003\u0014\n\u0000\u00e4\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e7\u0005#\u0000\u0000\u00e7\u00e8\u0005\u001b\u0000"+
		"\u0000\u00e8\u0019\u0001\u0000\u0000\u0000\u00e9\u00ea\u0003\u0016\u000b"+
		"\u0000\u00ea\u00eb\u0005+\u0000\u0000\u00eb\u00ec\u0005\u001b\u0000\u0000"+
		"\u00ec\u001b\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005+\u0000\u0000\u00ee"+
		"\u00ef\u0005\u0006\u0000\u0000\u00ef\u00f1\u0005\"\u0000\u0000\u00f0\u00f2"+
		"\u0003\u0014\n\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005"+
		"#\u0000\u0000\u00f4\u00f5\u0005\u001b\u0000\u0000\u00f5\u001d\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f7\u0005+\u0000\u0000\u00f7\u00f8\u0005\"\u0000"+
		"\u0000\u00f8\u00f9\u0003\"\u0011\u0000\u00f9\u00fa\u0005#\u0000\u0000"+
		"\u00fa\u001f\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005%\u0000\u0000\u00fc"+
		"\u00fd\u0005\u001e\u0000\u0000\u00fd\u00fe\u0003\"\u0011\u0000\u00fe\u00ff"+
		"\u0005\u001f\u0000\u0000\u00ff\u0100\u0005\u001b\u0000\u0000\u0100!\u0001"+
		"\u0000\u0000\u0000\u0101\u010a\u0003P(\u0000\u0102\u010a\u0003$\u0012"+
		"\u0000\u0103\u010a\u0003*\u0015\u0000\u0104\u010a\u00032\u0019\u0000\u0105"+
		"\u010a\u0003\u000e\u0007\u0000\u0106\u010a\u00034\u001a\u0000\u0107\u010a"+
		"\u0003\n\u0005\u0000\u0108\u010a\u0003\u001e\u000f\u0000\u0109\u0101\u0001"+
		"\u0000\u0000\u0000\u0109\u0102\u0001\u0000\u0000\u0000\u0109\u0103\u0001"+
		"\u0000\u0000\u0000\u0109\u0104\u0001\u0000\u0000\u0000\u0109\u0105\u0001"+
		"\u0000\u0000\u0000\u0109\u0106\u0001\u0000\u0000\u0000\u0109\u0107\u0001"+
		"\u0000\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a#\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0006\u0012\uffff\uffff\u0000\u010c\u010d\u0003"+
		"&\u0013\u0000\u010d\u0116\u0001\u0000\u0000\u0000\u010e\u010f\n\u0002"+
		"\u0000\u0000\u010f\u0110\u0005\u0001\u0000\u0000\u0110\u0115\u0003&\u0013"+
		"\u0000\u0111\u0112\n\u0001\u0000\u0000\u0112\u0113\u0005\u0002\u0000\u0000"+
		"\u0113\u0115\u0003&\u0013\u0000\u0114\u010e\u0001\u0000\u0000\u0000\u0114"+
		"\u0111\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000\u0000\u0000\u0116"+
		"\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117"+
		"%\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119\u011a"+
		"\u0006\u0013\uffff\uffff\u0000\u011a\u011b\u0003(\u0014\u0000\u011b\u0124"+
		"\u0001\u0000\u0000\u0000\u011c\u011d\n\u0002\u0000\u0000\u011d\u011e\u0005"+
		"\u0003\u0000\u0000\u011e\u0123\u0003(\u0014\u0000\u011f\u0120\n\u0001"+
		"\u0000\u0000\u0120\u0121\u0005\u0004\u0000\u0000\u0121\u0123\u0003(\u0014"+
		"\u0000\u0122\u011c\u0001\u0000\u0000\u0000\u0122\u011f\u0001\u0000\u0000"+
		"\u0000\u0123\u0126\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000"+
		"\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125\'\u0001\u0000\u0000\u0000"+
		"\u0126\u0124\u0001\u0000\u0000\u0000\u0127\u012e\u0003P(\u0000\u0128\u012e"+
		"\u0003\u000e\u0007\u0000\u0129\u012a\u0005\u001e\u0000\u0000\u012a\u012b"+
		"\u0003\"\u0011\u0000\u012b\u012c\u0005\u001f\u0000\u0000\u012c\u012e\u0001"+
		"\u0000\u0000\u0000\u012d\u0127\u0001\u0000\u0000\u0000\u012d\u0128\u0001"+
		"\u0000\u0000\u0000\u012d\u0129\u0001\u0000\u0000\u0000\u012e)\u0001\u0000"+
		"\u0000\u0000\u012f\u0130\u0006\u0015\uffff\uffff\u0000\u0130\u0131\u0003"+
		",\u0016\u0000\u0131\u0137\u0001\u0000\u0000\u0000\u0132\u0133\n\u0001"+
		"\u0000\u0000\u0133\u0134\u0005\u0007\u0000\u0000\u0134\u0136\u0003,\u0016"+
		"\u0000\u0135\u0132\u0001\u0000\u0000\u0000\u0136\u0139\u0001\u0000\u0000"+
		"\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000"+
		"\u0000\u0138+\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000"+
		"\u013a\u013b\u0006\u0016\uffff\uffff\u0000\u013b\u013c\u0003.\u0017\u0000"+
		"\u013c\u0142\u0001\u0000\u0000\u0000\u013d\u013e\n\u0001\u0000\u0000\u013e"+
		"\u013f\u0005\t\u0000\u0000\u013f\u0141\u0003.\u0017\u0000\u0140\u013d"+
		"\u0001\u0000\u0000\u0000\u0141\u0144\u0001\u0000\u0000\u0000\u0142\u0140"+
		"\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143-\u0001"+
		"\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0145\u0146\u0006"+
		"\u0017\uffff\uffff\u0000\u0146\u0147\u00030\u0018\u0000\u0147\u014d\u0001"+
		"\u0000\u0000\u0000\u0148\u0149\n\u0001\u0000\u0000\u0149\u014a\u0005\b"+
		"\u0000\u0000\u014a\u014c\u00030\u0018\u0000\u014b\u0148\u0001\u0000\u0000"+
		"\u0000\u014c\u014f\u0001\u0000\u0000\u0000\u014d\u014b\u0001\u0000\u0000"+
		"\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e/\u0001\u0000\u0000\u0000"+
		"\u014f\u014d\u0001\u0000\u0000\u0000\u0150\u0158\u0003P(\u0000\u0151\u0152"+
		"\u0005\u001e\u0000\u0000\u0152\u0153\u0003*\u0015\u0000\u0153\u0154\u0005"+
		"\u001f\u0000\u0000\u0154\u0158\u0001\u0000\u0000\u0000\u0155\u0156\u0005"+
		"\n\u0000\u0000\u0156\u0158\u00030\u0018\u0000\u0157\u0150\u0001\u0000"+
		"\u0000\u0000\u0157\u0151\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000"+
		"\u0000\u0000\u01581\u0001\u0000\u0000\u0000\u0159\u015a\u0005+\u0000\u0000"+
		"\u015a\u015b\u0005\u000b\u0000\u0000\u015b3\u0001\u0000\u0000\u0000\u015c"+
		"\u015f\u00036\u001b\u0000\u015d\u015f\u00038\u001c\u0000\u015e\u015c\u0001"+
		"\u0000\u0000\u0000\u015e\u015d\u0001\u0000\u0000\u0000\u015f5\u0001\u0000"+
		"\u0000\u0000\u0160\u0161\u0007\u0001\u0000\u0000\u0161\u0162\u0005\u0001"+
		"\u0000\u0000\u0162\u0163\u0007\u0001\u0000\u0000\u01637\u0001\u0000\u0000"+
		"\u0000\u0164\u0165\u0005&\u0000\u0000\u0165\u0166\u0005\u001e\u0000\u0000"+
		"\u0166\u0167\u0007\u0001\u0000\u0000\u0167\u0168\u0005\r\u0000\u0000\u0168"+
		"\u0169\u0007\u0001\u0000\u0000\u0169\u016a\u0005\u001f\u0000\u0000\u016a"+
		"9\u0001\u0000\u0000\u0000\u016b\u016e\u0003<\u001e\u0000\u016c\u016e\u0003"+
		">\u001f\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016d\u016c\u0001\u0000"+
		"\u0000\u0000\u016e;\u0001\u0000\u0000\u0000\u016f\u0170\u0005\'\u0000"+
		"\u0000\u0170\u0171\u0005\u001e\u0000\u0000\u0171\u0172\u0005+\u0000\u0000"+
		"\u0172\u0173\u0005\u001f\u0000\u0000\u0173=\u0001\u0000\u0000\u0000\u0174"+
		"\u0175\u0005(\u0000\u0000\u0175\u0176\u0005\u001e\u0000\u0000\u0176\u0177"+
		"\u0005+\u0000\u0000\u0177\u0178\u0005\u001c\u0000\u0000\u0178\u0179\u0003"+
		"\"\u0011\u0000\u0179\u017a\u0005\u001f\u0000\u0000\u017a?\u0001\u0000"+
		"\u0000\u0000\u017b\u017f\u0005 \u0000\u0000\u017c\u017e\u0003\u0002\u0001"+
		"\u0000\u017d\u017c\u0001\u0000\u0000\u0000\u017e\u0181\u0001\u0000\u0000"+
		"\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000"+
		"\u0000\u0180\u0182\u0001\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000"+
		"\u0000\u0182\u0183\u0005!\u0000\u0000\u0183A\u0001\u0000\u0000\u0000\u0184"+
		"\u0188\u0003D\"\u0000\u0185\u0188\u0003F#\u0000\u0186\u0188\u0003H$\u0000"+
		"\u0187\u0184\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000"+
		"\u0187\u0186\u0001\u0000\u0000\u0000\u0188C\u0001\u0000\u0000\u0000\u0189"+
		"\u018a\u0005\u0012\u0000\u0000\u018a\u018b\u0005\u001e\u0000\u0000\u018b"+
		"\u018c\u0003*\u0015\u0000\u018c\u018d\u0005\u001f\u0000\u0000\u018d\u018e"+
		"\u0003@ \u0000\u018eE\u0001\u0000\u0000\u0000\u018f\u0190\u0005\u0011"+
		"\u0000\u0000\u0190\u0195\u0005\u001e\u0000\u0000\u0191\u0196\u0003\u0006"+
		"\u0003\u0000\u0192\u0193\u0003\b\u0004\u0000\u0193\u0194\u0005\u001b\u0000"+
		"\u0000\u0194\u0196\u0001\u0000\u0000\u0000\u0195\u0191\u0001\u0000\u0000"+
		"\u0000\u0195\u0192\u0001\u0000\u0000\u0000\u0196\u0197\u0001\u0000\u0000"+
		"\u0000\u0197\u0198\u0003*\u0015\u0000\u0198\u019b\u0005\u001b\u0000\u0000"+
		"\u0199\u019c\u00032\u0019\u0000\u019a\u019c\u0003\b\u0004\u0000\u019b"+
		"\u0199\u0001\u0000\u0000\u0000\u019b\u019a\u0001\u0000\u0000\u0000\u019c"+
		"\u019d\u0001\u0000\u0000\u0000\u019d\u019e\u0005\u001f\u0000\u0000\u019e"+
		"\u019f\u0003@ \u0000\u019fG\u0001\u0000\u0000\u0000\u01a0\u01a1\u0005"+
		"\u0011\u0000\u0000\u01a1\u01a2\u0005\u001e\u0000\u0000\u01a2\u01a3\u0003"+
		"\u0010\b\u0000\u01a3\u01a4\u0005\r\u0000\u0000\u01a4\u01a5\u0005+\u0000"+
		"\u0000\u01a5\u01a6\u0005\u001f\u0000\u0000\u01a6\u01a7\u0003@ \u0000\u01a7"+
		"I\u0001\u0000\u0000\u0000\u01a8\u01ab\u0003L&\u0000\u01a9\u01ab\u0003"+
		"N\'\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000\u01aa\u01a9\u0001\u0000"+
		"\u0000\u0000\u01abK\u0001\u0000\u0000\u0000\u01ac\u01ad\u0005\u000e\u0000"+
		"\u0000\u01ad\u01ae\u0005\u001e\u0000\u0000\u01ae\u01af\u0003*\u0015\u0000"+
		"\u01af\u01b0\u0005\u001f\u0000\u0000\u01b0\u01b9\u0003@ \u0000\u01b1\u01b2"+
		"\u0005\u000f\u0000\u0000\u01b2\u01b3\u0005\u001e\u0000\u0000\u01b3\u01b4"+
		"\u0003*\u0015\u0000\u01b4\u01b5\u0005\u001f\u0000\u0000\u01b5\u01b6\u0003"+
		"@ \u0000\u01b6\u01b8\u0001\u0000\u0000\u0000\u01b7\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b8\u01bb\u0001\u0000\u0000\u0000\u01b9\u01b7\u0001\u0000\u0000"+
		"\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba\u01be\u0001\u0000\u0000"+
		"\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bc\u01bd\u0005\u0010\u0000"+
		"\u0000\u01bd\u01bf\u0003@ \u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01be"+
		"\u01bf\u0001\u0000\u0000\u0000\u01bfM\u0001\u0000\u0000\u0000\u01c0\u01c1"+
		"\u0005\u0013\u0000\u0000\u01c1\u01c2\u0005\u001e\u0000\u0000\u01c2\u01c3"+
		"\u0005+\u0000\u0000\u01c3\u01c4\u0005\u001f\u0000\u0000\u01c4\u01d4\u0005"+
		" \u0000\u0000\u01c5\u01c6\u0005\u0014\u0000\u0000\u01c6\u01c7\u0003P("+
		"\u0000\u01c7\u01cb\u0005\u001d\u0000\u0000\u01c8\u01ca\u0003\u0002\u0001"+
		"\u0000\u01c9\u01c8\u0001\u0000\u0000\u0000\u01ca\u01cd\u0001\u0000\u0000"+
		"\u0000\u01cb\u01c9\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000"+
		"\u0000\u01cc\u01d0\u0001\u0000\u0000\u0000\u01cd\u01cb\u0001\u0000\u0000"+
		"\u0000\u01ce\u01cf\u0005\u0016\u0000\u0000\u01cf\u01d1\u0005\u001b\u0000"+
		"\u0000\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d0\u01d1\u0001\u0000\u0000"+
		"\u0000\u01d1\u01d3\u0001\u0000\u0000\u0000\u01d2\u01c5\u0001\u0000\u0000"+
		"\u0000\u01d3\u01d6\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000"+
		"\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000\u01d5\u01e3\u0001\u0000\u0000"+
		"\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d7\u01d8\u0005\u0015\u0000"+
		"\u0000\u01d8\u01dc\u0005\u001d\u0000\u0000\u01d9\u01db\u0003\u0002\u0001"+
		"\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01db\u01de\u0001\u0000\u0000"+
		"\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000\u0000"+
		"\u0000\u01dd\u01e1\u0001\u0000\u0000\u0000\u01de\u01dc\u0001\u0000\u0000"+
		"\u0000\u01df\u01e0\u0005\u0016\u0000\u0000\u01e0\u01e2\u0005\u001b\u0000"+
		"\u0000\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000"+
		"\u0000\u01e2\u01e4\u0001\u0000\u0000\u0000\u01e3\u01d7\u0001\u0000\u0000"+
		"\u0000\u01e3\u01e4\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000"+
		"\u0000\u01e5\u01e6\u0005!\u0000\u0000\u01e6O\u0001\u0000\u0000\u0000\u01e7"+
		"\u01e8\u0007\u0002\u0000\u0000\u01e8Q\u0001\u0000\u0000\u0000*Uks\u0082"+
		"\u0093\u0099\u009f\u00a4\u00a7\u00ae\u00b2\u00c2\u00c6\u00d0\u00d8\u00e4"+
		"\u00f1\u0109\u0114\u0116\u0122\u0124\u012d\u0137\u0142\u014d\u0157\u015e"+
		"\u016d\u017f\u0187\u0195\u019b\u01aa\u01b9\u01be\u01cb\u01d0\u01d4\u01dc"+
		"\u01e1\u01e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}