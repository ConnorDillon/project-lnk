// Generated from Link.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LinkParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		ID=32, FIELD=33, FLOAT=34, INT=35, RAW_STRING=36, STRING=37, WS=38, COMMENT=39;
	public static final int
		RULE_prog = 0, RULE_expr = 1, RULE_oper = 2, RULE_pipe = 3, RULE_assign = 4, 
		RULE_pair = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "expr", "oper", "pipe", "assign", "pair"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "'{'", "','", "'}'", "'['", "']'", "'if'", 
			"'then'", "'else'", "'let'", "'in'", "'\\'", "'.'", "'*'", "'/'", "'+'", 
			"'-'", "'>'", "'<'", "'>='", "'<='", "'!='", "'=='", "'and'", "'or'", 
			"'&'", "'|'", "'='", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "ID", "FIELD", "FLOAT", 
			"INT", "RAW_STRING", "STRING", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "Link.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LinkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<TerminalNode> EOF() { return getTokens(LinkParser.EOF); }
		public TerminalNode EOF(int i) {
			return getToken(LinkParser.EOF, i);
		}
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public PipeContext pipe() {
			return getRuleContext(PipeContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(12);
					assign();
					setState(13);
					_la = _input.LA(1);
					if ( !(_la==EOF || _la==T__0) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(19);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__8) | (1L << T__11) | (1L << T__13) | (1L << ID) | (1L << FIELD) | (1L << FLOAT) | (1L << INT) | (1L << RAW_STRING) | (1L << STRING))) != 0)) {
				{
				setState(20);
				pipe(0);
				}
			}

			setState(23);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyStreamContext extends ExprContext {
		public EmptyStreamContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitEmptyStream(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RawStringContext extends ExprContext {
		public TerminalNode RAW_STRING() { return getToken(LinkParser.RAW_STRING, 0); }
		public RawStringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitRawString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyArrayContext extends ExprContext {
		public EmptyArrayContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitEmptyArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApplyContext extends ExprContext {
		public TerminalNode ID() { return getToken(LinkParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ApplyContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubExprContext extends ExprContext {
		public PipeContext pipe() {
			return getRuleContext(PipeContext.class,0);
		}
		public SubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(LinkParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(LinkParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApplyExprContext extends ExprContext {
		public PipeContext pipe() {
			return getRuleContext(PipeContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ApplyExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitApplyExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayContext extends ExprContext {
		public List<PipeContext> pipe() {
			return getRuleContexts(PipeContext.class);
		}
		public PipeContext pipe(int i) {
			return getRuleContext(PipeContext.class,i);
		}
		public ArrayContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(LinkParser.FLOAT, 0); }
		public FloatContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldContext extends ExprContext {
		public TerminalNode FIELD() { return getToken(LinkParser.FIELD, 0); }
		public FieldContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyObjectContext extends ExprContext {
		public EmptyObjectContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitEmptyObject(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjectContext extends ExprContext {
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public ObjectContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StreamContext extends ExprContext {
		public List<PipeContext> pipe() {
			return getRuleContexts(PipeContext.class);
		}
		public PipeContext pipe(int i) {
			return getRuleContext(PipeContext.class,i);
		}
		public StreamContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitStream(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetContext extends ExprContext {
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public OperContext oper() {
			return getRuleContext(OperContext.class,0);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(LinkParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends ExprContext {
		public List<OperContext> oper() {
			return getRuleContexts(OperContext.class);
		}
		public OperContext oper(int i) {
			return getRuleContext(OperContext.class,i);
		}
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaContext extends ExprContext {
		public OperContext oper() {
			return getRuleContext(OperContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(LinkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LinkParser.ID, i);
		}
		public LambdaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		int _la;
		try {
			int _alt;
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				match(INT);
				}
				break;
			case 2:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				match(FLOAT);
				}
				break;
			case 3:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(27);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new RawStringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(28);
				match(RAW_STRING);
				}
				break;
			case 5:
				_localctx = new FieldContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(29);
				match(FIELD);
				}
				break;
			case 6:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(30);
				match(ID);
				}
				break;
			case 7:
				_localctx = new ApplyContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(31);
				match(ID);
				setState(33); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(32);
						expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(35); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 8:
				_localctx = new SubExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(37);
				match(T__1);
				setState(38);
				pipe(0);
				setState(39);
				match(T__2);
				}
				break;
			case 9:
				_localctx = new ApplyExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(41);
				match(T__1);
				setState(42);
				pipe(0);
				setState(43);
				match(T__2);
				setState(45); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(44);
						expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(47); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 10:
				_localctx = new ObjectContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(49);
				match(T__3);
				setState(50);
				pair();
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(51);
					match(T__4);
					setState(52);
					pair();
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
				match(T__5);
				}
				break;
			case 11:
				_localctx = new EmptyObjectContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(60);
				match(T__3);
				setState(61);
				match(T__5);
				}
				break;
			case 12:
				_localctx = new ArrayContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(62);
				match(T__6);
				setState(63);
				pipe(0);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(64);
					match(T__4);
					setState(65);
					pipe(0);
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71);
				match(T__7);
				}
				break;
			case 13:
				_localctx = new EmptyArrayContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(73);
				match(T__6);
				setState(74);
				match(T__7);
				}
				break;
			case 14:
				_localctx = new StreamContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(75);
				match(T__1);
				setState(86);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					{
					setState(76);
					pipe(0);
					setState(77);
					match(T__4);
					}
					}
					break;
				case 2:
					{
					{
					setState(79);
					pipe(0);
					setState(82); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(80);
						match(T__4);
						setState(81);
						pipe(0);
						}
						}
						setState(84); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__4 );
					}
					}
					break;
				}
				setState(88);
				match(T__2);
				}
				break;
			case 15:
				_localctx = new EmptyStreamContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(90);
				match(T__1);
				setState(91);
				match(T__2);
				}
				break;
			case 16:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(92);
				match(T__8);
				setState(93);
				oper(0);
				setState(94);
				match(T__9);
				setState(95);
				oper(0);
				setState(96);
				match(T__10);
				setState(97);
				oper(0);
				}
				break;
			case 17:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(99);
				match(T__11);
				setState(100);
				assign();
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(101);
					match(T__0);
					setState(102);
					assign();
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(108);
				match(T__12);
				setState(109);
				oper(0);
				}
				break;
			case 18:
				_localctx = new LambdaContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(111);
				match(T__13);
				setState(113); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(112);
					match(ID);
					}
					}
					setState(115); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(117);
				match(T__14);
				setState(118);
				oper(0);
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

	public static class OperContext extends ParserRuleContext {
		public OperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oper; }
	 
		public OperContext() { }
		public void copyFrom(OperContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConsContext extends OperContext {
		public Token op;
		public List<OperContext> oper() {
			return getRuleContexts(OperContext.class);
		}
		public OperContext oper(int i) {
			return getRuleContext(OperContext.class,i);
		}
		public ConsContext(OperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitCons(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends OperContext {
		public Token op;
		public List<OperContext> oper() {
			return getRuleContexts(OperContext.class);
		}
		public OperContext oper(int i) {
			return getRuleContext(OperContext.class,i);
		}
		public OrContext(OperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprOperContext extends OperContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprOperContext(OperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitExprOper(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends OperContext {
		public Token op;
		public List<OperContext> oper() {
			return getRuleContexts(OperContext.class);
		}
		public OperContext oper(int i) {
			return getRuleContext(OperContext.class,i);
		}
		public MulDivContext(OperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends OperContext {
		public Token op;
		public List<OperContext> oper() {
			return getRuleContexts(OperContext.class);
		}
		public OperContext oper(int i) {
			return getRuleContext(OperContext.class,i);
		}
		public AddSubContext(OperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends OperContext {
		public Token op;
		public List<OperContext> oper() {
			return getRuleContexts(OperContext.class);
		}
		public OperContext oper(int i) {
			return getRuleContext(OperContext.class,i);
		}
		public AndContext(OperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareContext extends OperContext {
		public Token op;
		public List<OperContext> oper() {
			return getRuleContexts(OperContext.class);
		}
		public OperContext oper(int i) {
			return getRuleContext(OperContext.class,i);
		}
		public CompareContext(OperContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperContext oper() throws RecognitionException {
		return oper(0);
	}

	private OperContext oper(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OperContext _localctx = new OperContext(_ctx, _parentState);
		OperContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_oper, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExprOperContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(122);
			expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(142);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new OperContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_oper);
						setState(124);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(125);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(126);
						oper(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new OperContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_oper);
						setState(127);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(128);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(129);
						oper(6);
						}
						break;
					case 3:
						{
						_localctx = new CompareContext(new OperContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_oper);
						setState(130);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(131);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(132);
						oper(5);
						}
						break;
					case 4:
						{
						_localctx = new AndContext(new OperContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_oper);
						setState(133);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(134);
						((AndContext)_localctx).op = match(T__25);
						setState(135);
						oper(4);
						}
						break;
					case 5:
						{
						_localctx = new OrContext(new OperContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_oper);
						setState(136);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(137);
						((OrContext)_localctx).op = match(T__26);
						setState(138);
						oper(3);
						}
						break;
					case 6:
						{
						_localctx = new ConsContext(new OperContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_oper);
						setState(139);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(140);
						((ConsContext)_localctx).op = match(T__27);
						setState(141);
						oper(2);
						}
						break;
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class PipeContext extends ParserRuleContext {
		public PipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipe; }
	 
		public PipeContext() { }
		public void copyFrom(PipeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OperPipeContext extends PipeContext {
		public OperContext oper() {
			return getRuleContext(OperContext.class,0);
		}
		public OperPipeContext(PipeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitOperPipe(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PipeOperContext extends PipeContext {
		public Token op;
		public List<PipeContext> pipe() {
			return getRuleContexts(PipeContext.class);
		}
		public PipeContext pipe(int i) {
			return getRuleContext(PipeContext.class,i);
		}
		public PipeOperContext(PipeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitPipeOper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipeContext pipe() throws RecognitionException {
		return pipe(0);
	}

	private PipeContext pipe(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PipeContext _localctx = new PipeContext(_ctx, _parentState);
		PipeContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_pipe, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new OperPipeContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(148);
			oper(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PipeOperContext(new PipeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_pipe);
					setState(150);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(151);
					((PipeOperContext)_localctx).op = match(T__28);
					setState(152);
					pipe(2);
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class AssignContext extends ParserRuleContext {
		public PipeContext pipe() {
			return getRuleContext(PipeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(LinkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LinkParser.ID, i);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(158);
				match(ID);
				}
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(163);
			match(T__29);
			setState(164);
			pipe(0);
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

	public static class PairContext extends ParserRuleContext {
		public PipeContext pipe() {
			return getRuleContext(PipeContext.class,0);
		}
		public TerminalNode ID() { return getToken(LinkParser.ID, 0); }
		public TerminalNode STRING() { return getToken(LinkParser.STRING, 0); }
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinkVisitor ) return ((LinkVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(167);
			match(T__30);
			setState(168);
			pipe(0);
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
		case 2:
			return oper_sempred((OperContext)_localctx, predIndex);
		case 3:
			return pipe_sempred((PipeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean oper_sempred(OperContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean pipe_sempred(PipeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00ad\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\7\2\22\n\2\f\2\16\2"+
		"\25\13\2\3\2\5\2\30\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3$\n"+
		"\3\r\3\16\3%\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\60\n\3\r\3\16\3\61\3"+
		"\3\3\3\3\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3E\n\3\f\3\16\3H\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6"+
		"\3U\n\3\r\3\16\3V\5\3Y\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\7\3j\n\3\f\3\16\3m\13\3\3\3\3\3\3\3\3\3\3\3\6\3t\n\3"+
		"\r\3\16\3u\3\3\3\3\5\3z\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0091\n\4\f\4\16\4\u0094"+
		"\13\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u009c\n\5\f\5\16\5\u009f\13\5\3\6\6"+
		"\6\u00a2\n\6\r\6\16\6\u00a3\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\2\4\6\b\b"+
		"\2\4\6\b\n\f\2\7\3\3\3\3\3\2\22\23\3\2\24\25\3\2\26\33\4\2\"\"\'\'\2\u00c9"+
		"\2\23\3\2\2\2\4y\3\2\2\2\6{\3\2\2\2\b\u0095\3\2\2\2\n\u00a1\3\2\2\2\f"+
		"\u00a8\3\2\2\2\16\17\5\n\6\2\17\20\t\2\2\2\20\22\3\2\2\2\21\16\3\2\2\2"+
		"\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2"+
		"\26\30\5\b\5\2\27\26\3\2\2\2\27\30\3\2\2\2\30\31\3\2\2\2\31\32\7\2\2\3"+
		"\32\3\3\2\2\2\33z\7%\2\2\34z\7$\2\2\35z\7\'\2\2\36z\7&\2\2\37z\7#\2\2"+
		" z\7\"\2\2!#\7\"\2\2\"$\5\4\3\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2"+
		"\2&z\3\2\2\2\'(\7\4\2\2()\5\b\5\2)*\7\5\2\2*z\3\2\2\2+,\7\4\2\2,-\5\b"+
		"\5\2-/\7\5\2\2.\60\5\4\3\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3"+
		"\2\2\2\62z\3\2\2\2\63\64\7\6\2\2\649\5\f\7\2\65\66\7\7\2\2\668\5\f\7\2"+
		"\67\65\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7"+
		"\b\2\2=z\3\2\2\2>?\7\6\2\2?z\7\b\2\2@A\7\t\2\2AF\5\b\5\2BC\7\7\2\2CE\5"+
		"\b\5\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7"+
		"\n\2\2Jz\3\2\2\2KL\7\t\2\2Lz\7\n\2\2MX\7\4\2\2NO\5\b\5\2OP\7\7\2\2PY\3"+
		"\2\2\2QT\5\b\5\2RS\7\7\2\2SU\5\b\5\2TR\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3"+
		"\2\2\2WY\3\2\2\2XN\3\2\2\2XQ\3\2\2\2YZ\3\2\2\2Z[\7\5\2\2[z\3\2\2\2\\]"+
		"\7\4\2\2]z\7\5\2\2^_\7\13\2\2_`\5\6\4\2`a\7\f\2\2ab\5\6\4\2bc\7\r\2\2"+
		"cd\5\6\4\2dz\3\2\2\2ef\7\16\2\2fk\5\n\6\2gh\7\3\2\2hj\5\n\6\2ig\3\2\2"+
		"\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7\17\2\2op\5\6"+
		"\4\2pz\3\2\2\2qs\7\20\2\2rt\7\"\2\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3"+
		"\2\2\2vw\3\2\2\2wx\7\21\2\2xz\5\6\4\2y\33\3\2\2\2y\34\3\2\2\2y\35\3\2"+
		"\2\2y\36\3\2\2\2y\37\3\2\2\2y \3\2\2\2y!\3\2\2\2y\'\3\2\2\2y+\3\2\2\2"+
		"y\63\3\2\2\2y>\3\2\2\2y@\3\2\2\2yK\3\2\2\2yM\3\2\2\2y\\\3\2\2\2y^\3\2"+
		"\2\2ye\3\2\2\2yq\3\2\2\2z\5\3\2\2\2{|\b\4\1\2|}\5\4\3\2}\u0092\3\2\2\2"+
		"~\177\f\b\2\2\177\u0080\t\3\2\2\u0080\u0091\5\6\4\t\u0081\u0082\f\7\2"+
		"\2\u0082\u0083\t\4\2\2\u0083\u0091\5\6\4\b\u0084\u0085\f\6\2\2\u0085\u0086"+
		"\t\5\2\2\u0086\u0091\5\6\4\7\u0087\u0088\f\5\2\2\u0088\u0089\7\34\2\2"+
		"\u0089\u0091\5\6\4\6\u008a\u008b\f\4\2\2\u008b\u008c\7\35\2\2\u008c\u0091"+
		"\5\6\4\5\u008d\u008e\f\3\2\2\u008e\u008f\7\36\2\2\u008f\u0091\5\6\4\4"+
		"\u0090~\3\2\2\2\u0090\u0081\3\2\2\2\u0090\u0084\3\2\2\2\u0090\u0087\3"+
		"\2\2\2\u0090\u008a\3\2\2\2\u0090\u008d\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\7\3\2\2\2\u0094\u0092\3\2\2\2"+
		"\u0095\u0096\b\5\1\2\u0096\u0097\5\6\4\2\u0097\u009d\3\2\2\2\u0098\u0099"+
		"\f\3\2\2\u0099\u009a\7\37\2\2\u009a\u009c\5\b\5\4\u009b\u0098\3\2\2\2"+
		"\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\t\3"+
		"\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\7\"\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\7 \2\2\u00a6\u00a7\5\b\5\2\u00a7\13\3\2\2\2\u00a8\u00a9"+
		"\t\6\2\2\u00a9\u00aa\7!\2\2\u00aa\u00ab\5\b\5\2\u00ab\r\3\2\2\2\21\23"+
		"\27%\619FVXkuy\u0090\u0092\u009d\u00a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}