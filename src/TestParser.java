// Generated from Test.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, ID=47, FLOAT=48, INTEGER=49, WS=50, COMMENT=51, COMMENT2=52, 
		ERROR=53;
	public static final int
		RULE_program = 0, RULE_sector = 1, RULE_alphabet = 2, RULE_automaton = 3, 
		RULE_automatonStatement = 4, RULE_transition = 5, RULE_automatonType = 6, 
		RULE_view = 7, RULE_viewStatement = 8, RULE_pointAssignment = 9, RULE_expression = 10, 
		RULE_animation = 11, RULE_animationStatement = 12, RULE_viewport = 13, 
		RULE_on = 14, RULE_onStatement = 15, RULE_play = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "sector", "alphabet", "automaton", "automatonStatement", "transition", 
			"automatonType", "view", "viewStatement", "pointAssignment", "expression", 
			"animation", "animationStatement", "viewport", "on", "onStatement", "play"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'alphabet'", "'{'", "'''", "', '", "'}'", "'<<<'", "'>>>'", "'state'", 
			"';'", "'['", "'initial'", "'accepting'", "'='", "'false'", "'true'", 
			"']'", "'transition'", "'->'", "','", "'NFA'", "'DFA'", "'complete DFA'", 
			"'view'", "'of'", "'place'", "'at'", "'('", "')'", "'point'", "':'", 
			"'<'", "'>'", "'as'", "'--'", "'-'", "'+'", "'/'", "'*'", "'animation'", 
			"'viewport'", "'for'", "'++'", "'on'", "'show'", "'pause'", "'play'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"FLOAT", "INTEGER", "WS", "COMMENT", "COMMENT2", "ERROR"
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
	public String getGrammarFileName() { return "Test.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public AlphabetContext alphabet() {
			return getRuleContext(AlphabetContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TestParser.EOF, 0); }
		public List<SectorContext> sector() {
			return getRuleContexts(SectorContext.class);
		}
		public SectorContext sector(int i) {
			return getRuleContext(SectorContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			alphabet();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 70918515720192L) != 0)) {
				{
				{
				setState(35);
				sector();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
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
	public static class SectorContext extends ParserRuleContext {
		public AutomatonContext automaton() {
			return getRuleContext(AutomatonContext.class,0);
		}
		public ViewContext view() {
			return getRuleContext(ViewContext.class,0);
		}
		public AnimationContext animation() {
			return getRuleContext(AnimationContext.class,0);
		}
		public PlayContext play() {
			return getRuleContext(PlayContext.class,0);
		}
		public SectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterSector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitSector(this);
		}
	}

	public final SectorContext sector() throws RecognitionException {
		SectorContext _localctx = new SectorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sector);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				automaton();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				view();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				animation();
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				play();
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
	public static class AlphabetContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TestParser.ID, i);
		}
		public AlphabetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alphabet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterAlphabet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitAlphabet(this);
		}
	}

	public final AlphabetContext alphabet() throws RecognitionException {
		AlphabetContext _localctx = new AlphabetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_alphabet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__0);
			setState(50);
			match(T__1);
			setState(51);
			match(T__2);
			setState(52);
			match(ID);
			setState(53);
			match(T__2);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(54);
				match(T__3);
				setState(55);
				match(T__2);
				setState(56);
				match(ID);
				setState(57);
				match(T__2);
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			match(T__4);
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
	public static class AutomatonContext extends ParserRuleContext {
		public AutomatonTypeContext automatonType() {
			return getRuleContext(AutomatonTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public List<AutomatonStatementContext> automatonStatement() {
			return getRuleContexts(AutomatonStatementContext.class);
		}
		public AutomatonStatementContext automatonStatement(int i) {
			return getRuleContext(AutomatonStatementContext.class,i);
		}
		public AutomatonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automaton; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterAutomaton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitAutomaton(this);
		}
	}

	public final AutomatonContext automaton() throws RecognitionException {
		AutomatonContext _localctx = new AutomatonContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_automaton);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			automatonType();
			setState(66);
			match(ID);
			setState(67);
			match(T__5);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140737488486656L) != 0)) {
				{
				{
				setState(68);
				automatonStatement();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(T__6);
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
	public static class AutomatonStatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TestParser.ID, i);
		}
		public TransitionContext transition() {
			return getRuleContext(TransitionContext.class,0);
		}
		public AutomatonStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automatonStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterAutomatonStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitAutomatonStatement(this);
		}
	}

	public final AutomatonStatementContext automatonStatement() throws RecognitionException {
		AutomatonStatementContext _localctx = new AutomatonStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_automatonStatement);
		int _la;
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(T__7);
				setState(77);
				match(ID);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(78);
					match(T__3);
					setState(79);
					match(ID);
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(85);
				match(T__8);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(ID);
				setState(87);
				match(T__9);
				setState(88);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(89);
				match(T__12);
				setState(90);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(91);
				match(T__15);
				setState(92);
				match(T__8);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				transition();
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
	public static class TransitionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TestParser.ID, i);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitTransition(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_transition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__16);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(97);
					match(ID);
					setState(98);
					match(T__17);
					setState(99);
					match(T__2);
					setState(100);
					match(ID);
					setState(101);
					match(T__2);
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__18) {
						{
						{
						setState(102);
						match(T__18);
						setState(103);
						match(T__2);
						setState(104);
						match(ID);
						setState(105);
						match(T__2);
						}
						}
						setState(110);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(111);
					match(T__17);
					setState(112);
					match(ID);
					setState(113);
					match(T__18);
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(119);
			match(ID);
			setState(120);
			match(T__17);
			setState(121);
			match(T__2);
			setState(122);
			match(ID);
			setState(123);
			match(T__2);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(124);
				match(T__18);
				setState(125);
				match(T__2);
				setState(126);
				match(ID);
				setState(127);
				match(T__2);
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__17);
			setState(134);
			match(ID);
			setState(135);
			match(T__8);
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
	public static class AutomatonTypeContext extends ParserRuleContext {
		public AutomatonTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automatonType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterAutomatonType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitAutomatonType(this);
		}
	}

	public final AutomatonTypeContext automatonType() throws RecognitionException {
		AutomatonTypeContext _localctx = new AutomatonTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_automatonType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
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
	public static class ViewContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TestParser.ID, i);
		}
		public List<ViewStatementContext> viewStatement() {
			return getRuleContexts(ViewStatementContext.class);
		}
		public ViewStatementContext viewStatement(int i) {
			return getRuleContext(ViewStatementContext.class,i);
		}
		public ViewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterView(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitView(this);
		}
	}

	public final ViewContext view() throws RecognitionException {
		ViewContext _localctx = new ViewContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_view);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__22);
			setState(140);
			match(ID);
			setState(141);
			match(T__23);
			setState(142);
			match(ID);
			setState(143);
			match(T__5);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 985199630352384L) != 0)) {
				{
				{
				setState(144);
				viewStatement();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			match(T__6);
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
	public static class ViewStatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TestParser.ID, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(TestParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(TestParser.INTEGER, i);
		}
		public List<TerminalNode> FLOAT() { return getTokens(TestParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(TestParser.FLOAT, i);
		}
		public PointAssignmentContext pointAssignment() {
			return getRuleContext(PointAssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ViewStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterViewStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitViewStatement(this);
		}
	}

	public final ViewStatementContext viewStatement() throws RecognitionException {
		ViewStatementContext _localctx = new ViewStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_viewStatement);
		int _la;
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(T__24);
				setState(153);
				match(ID);
				setState(154);
				match(T__25);
				setState(155);
				match(T__26);
				setState(156);
				match(INTEGER);
				setState(157);
				match(T__18);
				setState(158);
				match(INTEGER);
				setState(159);
				match(T__27);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__18) {
					{
					{
					setState(160);
					match(T__18);
					setState(161);
					match(ID);
					setState(162);
					match(T__25);
					setState(163);
					match(T__26);
					setState(164);
					match(INTEGER);
					setState(165);
					match(T__18);
					setState(166);
					match(INTEGER);
					setState(167);
					match(T__27);
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(T__28);
				setState(175);
				match(ID);
				setState(176);
				match(T__8);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				match(ID);
				setState(178);
				match(T__12);
				setState(179);
				match(T__26);
				setState(180);
				match(ID);
				setState(181);
				match(T__27);
				setState(182);
				match(T__8);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(T__28);
				setState(184);
				match(ID);
				setState(185);
				match(T__12);
				setState(186);
				match(T__26);
				setState(187);
				_la = _input.LA(1);
				if ( !(_la==FLOAT || _la==INTEGER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(188);
				match(T__29);
				setState(189);
				_la = _input.LA(1);
				if ( !(_la==FLOAT || _la==INTEGER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(190);
				match(T__27);
				setState(191);
				match(T__8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(192);
				pointAssignment();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(193);
				expression(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(194);
				match(T__30);
				setState(195);
				match(ID);
				setState(196);
				match(T__18);
				setState(197);
				match(ID);
				setState(198);
				match(T__31);
				setState(199);
				match(T__32);
				setState(200);
				match(ID);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__33) {
					{
					{
					setState(201);
					match(T__33);
					setState(202);
					match(ID);
					}
					}
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(208);
				match(T__8);
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
	public static class PointAssignmentContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public PointAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterPointAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitPointAssignment(this);
		}
	}

	public final PointAssignmentContext pointAssignment() throws RecognitionException {
		PointAssignmentContext _localctx = new PointAssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pointAssignment);
		try {
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
			case T__34:
			case ID:
			case FLOAT:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				expression(0);
				setState(212);
				match(T__12);
				setState(213);
				match(T__26);
				setState(214);
				match(ID);
				setState(215);
				match(T__27);
				setState(216);
				match(T__8);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(T__28);
				setState(219);
				expression(0);
				setState(220);
				match(T__12);
				setState(221);
				expression(0);
				setState(222);
				match(T__8);
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
	public static class ExpressionContext extends ParserRuleContext {
		public Token op;
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode INTEGER() { return getToken(TestParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(TestParser.FLOAT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(227);
				match(ID);
				}
				break;
			case T__26:
				{
				setState(228);
				match(T__26);
				setState(229);
				expression(0);
				setState(230);
				match(T__29);
				setState(231);
				expression(0);
				setState(232);
				match(T__27);
				}
				break;
			case INTEGER:
				{
				setState(234);
				match(INTEGER);
				}
				break;
			case FLOAT:
				{
				setState(235);
				match(FLOAT);
				}
				break;
			case T__34:
				{
				setState(236);
				match(T__34);
				setState(237);
				expression(2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(240);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(241);
					((ExpressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 515396083712L) != 0)) ) {
						((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(242);
					expression(2);
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class AnimationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public List<AnimationStatementContext> animationStatement() {
			return getRuleContexts(AnimationStatementContext.class);
		}
		public AnimationStatementContext animationStatement(int i) {
			return getRuleContext(AnimationStatementContext.class,i);
		}
		public AnimationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_animation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterAnimation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitAnimation(this);
		}
	}

	public final AnimationContext animation() throws RecognitionException {
		AnimationContext _localctx = new AnimationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_animation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(T__38);
			setState(249);
			match(ID);
			setState(250);
			match(T__5);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39) {
				{
				{
				setState(251);
				animationStatement();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257);
			match(T__6);
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
	public static class AnimationStatementContext extends ParserRuleContext {
		public ViewportContext viewport() {
			return getRuleContext(ViewportContext.class,0);
		}
		public OnContext on() {
			return getRuleContext(OnContext.class,0);
		}
		public AnimationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_animationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterAnimationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitAnimationStatement(this);
		}
	}

	public final AnimationStatementContext animationStatement() throws RecognitionException {
		AnimationStatementContext _localctx = new AnimationStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_animationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			viewport();
			setState(260);
			on();
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
	public static class ViewportContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TestParser.ID, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(TestParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(TestParser.INTEGER, i);
		}
		public ViewportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewport; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterViewport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitViewport(this);
		}
	}

	public final ViewportContext viewport() throws RecognitionException {
		ViewportContext _localctx = new ViewportContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_viewport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(T__39);
			setState(263);
			match(ID);
			setState(264);
			match(T__40);
			setState(265);
			match(ID);
			setState(266);
			match(T__25);
			setState(267);
			match(T__26);
			setState(268);
			match(INTEGER);
			setState(269);
			match(T__18);
			setState(270);
			match(INTEGER);
			setState(271);
			match(T__27);
			setState(272);
			match(T__33);
			setState(273);
			match(T__41);
			setState(274);
			match(T__26);
			setState(275);
			match(INTEGER);
			setState(276);
			match(T__18);
			setState(277);
			match(INTEGER);
			setState(278);
			match(T__27);
			setState(279);
			match(T__8);
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
	public static class OnContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public List<OnStatementContext> onStatement() {
			return getRuleContexts(OnStatementContext.class);
		}
		public OnStatementContext onStatement(int i) {
			return getRuleContext(OnStatementContext.class,i);
		}
		public OnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_on; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterOn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitOn(this);
		}
	}

	public final OnContext on() throws RecognitionException {
		OnContext _localctx = new OnContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_on);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(T__42);
			setState(282);
			match(ID);
			setState(283);
			match(T__5);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__43 || _la==T__44) {
				{
				{
				setState(284);
				onStatement();
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(290);
			match(T__6);
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
	public static class OnStatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TestParser.ID, i);
		}
		public OnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterOnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitOnStatement(this);
		}
	}

	public final OnStatementContext onStatement() throws RecognitionException {
		OnStatementContext _localctx = new OnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_onStatement);
		int _la;
		try {
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(T__43);
				{
				setState(299);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(293);
					match(ID);
					}
					break;
				case 2:
					{
					setState(294);
					match(ID);
					setState(295);
					match(T__9);
					setState(296);
					_la = _input.LA(1);
					if ( !(_la==T__10 || _la==T__11) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(297);
					match(T__12);
					setState(298);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(301);
				match(T__15);
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__18) {
					{
					{
					setState(303);
					match(T__18);
					setState(310);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(304);
						match(ID);
						}
						break;
					case 2:
						{
						setState(305);
						match(ID);
						setState(306);
						match(T__9);
						setState(307);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(308);
						match(T__12);
						setState(309);
						_la = _input.LA(1);
						if ( !(_la==T__13 || _la==T__14) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					setState(312);
					match(T__15);
					}
					}
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				match(T__44);
				setState(319);
				match(T__8);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				match(T__43);
				setState(321);
				match(T__30);
				setState(322);
				match(ID);
				setState(323);
				match(T__18);
				setState(324);
				match(ID);
				setState(325);
				match(T__31);
				setState(326);
				match(T__8);
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
	public static class PlayContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public PlayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_play; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterPlay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitPlay(this);
		}
	}

	public final PlayContext play() throws RecognitionException {
		PlayContext _localctx = new PlayContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_play);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(T__45);
			setState(330);
			match(ID);
			setState(331);
			match(T__8);
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
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00015\u014e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0005\u0000%\b\u0000"+
		"\n\u0000\f\u0000(\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002;\b\u0002\n\u0002\f\u0002>\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"F\b\u0003\n\u0003\f\u0003I\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004Q\b\u0004\n\u0004\f\u0004"+
		"T\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004_\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005k\b\u0005"+
		"\n\u0005\f\u0005n\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"s\b\u0005\n\u0005\f\u0005v\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u0081\b\u0005\n\u0005\f\u0005\u0084\t\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0092"+
		"\b\u0007\n\u0007\f\u0007\u0095\t\u0007\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a9\b\b\n"+
		"\b\f\b\u00ac\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00cc\b\b\n\b\f\b\u00cf"+
		"\t\b\u0001\b\u0003\b\u00d2\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00e1\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00ef\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\n\u00f4\b\n\n\n\f\n\u00f7\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00fd\b\u000b\n\u000b\f\u000b\u0100\t\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u011e\b\u000e\n\u000e\f\u000e\u0121"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u012c\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0137\b\u000f\u0001\u000f\u0005"+
		"\u000f\u013a\b\u000f\n\u000f\f\u000f\u013d\t\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u0148\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0000\u0001\u0014\u0011\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0005"+
		"\u0001\u0000\u000b\f\u0001\u0000\u000e\u000f\u0001\u0000\u0014\u0016\u0001"+
		"\u000001\u0002\u0000\r\r#&\u015e\u0000\"\u0001\u0000\u0000\u0000\u0002"+
		"/\u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000\u0000\u0006A\u0001"+
		"\u0000\u0000\u0000\b^\u0001\u0000\u0000\u0000\n`\u0001\u0000\u0000\u0000"+
		"\f\u0089\u0001\u0000\u0000\u0000\u000e\u008b\u0001\u0000\u0000\u0000\u0010"+
		"\u00d1\u0001\u0000\u0000\u0000\u0012\u00e0\u0001\u0000\u0000\u0000\u0014"+
		"\u00ee\u0001\u0000\u0000\u0000\u0016\u00f8\u0001\u0000\u0000\u0000\u0018"+
		"\u0103\u0001\u0000\u0000\u0000\u001a\u0106\u0001\u0000\u0000\u0000\u001c"+
		"\u0119\u0001\u0000\u0000\u0000\u001e\u0147\u0001\u0000\u0000\u0000 \u0149"+
		"\u0001\u0000\u0000\u0000\"&\u0003\u0004\u0002\u0000#%\u0003\u0002\u0001"+
		"\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000"+
		"\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000(&\u0001"+
		"\u0000\u0000\u0000)*\u0005\u0000\u0000\u0001*\u0001\u0001\u0000\u0000"+
		"\u0000+0\u0003\u0006\u0003\u0000,0\u0003\u000e\u0007\u0000-0\u0003\u0016"+
		"\u000b\u0000.0\u0003 \u0010\u0000/+\u0001\u0000\u0000\u0000/,\u0001\u0000"+
		"\u0000\u0000/-\u0001\u0000\u0000\u0000/.\u0001\u0000\u0000\u00000\u0003"+
		"\u0001\u0000\u0000\u000012\u0005\u0001\u0000\u000023\u0005\u0002\u0000"+
		"\u000034\u0005\u0003\u0000\u000045\u0005/\u0000\u00005<\u0005\u0003\u0000"+
		"\u000067\u0005\u0004\u0000\u000078\u0005\u0003\u0000\u000089\u0005/\u0000"+
		"\u00009;\u0005\u0003\u0000\u0000:6\u0001\u0000\u0000\u0000;>\u0001\u0000"+
		"\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001"+
		"\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?@\u0005\u0005\u0000\u0000"+
		"@\u0005\u0001\u0000\u0000\u0000AB\u0003\f\u0006\u0000BC\u0005/\u0000\u0000"+
		"CG\u0005\u0006\u0000\u0000DF\u0003\b\u0004\u0000ED\u0001\u0000\u0000\u0000"+
		"FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000"+
		"\u0000HJ\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0005\u0007"+
		"\u0000\u0000K\u0007\u0001\u0000\u0000\u0000LM\u0005\b\u0000\u0000MR\u0005"+
		"/\u0000\u0000NO\u0005\u0004\u0000\u0000OQ\u0005/\u0000\u0000PN\u0001\u0000"+
		"\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000"+
		"U_\u0005\t\u0000\u0000VW\u0005/\u0000\u0000WX\u0005\n\u0000\u0000XY\u0007"+
		"\u0000\u0000\u0000YZ\u0005\r\u0000\u0000Z[\u0007\u0001\u0000\u0000[\\"+
		"\u0005\u0010\u0000\u0000\\_\u0005\t\u0000\u0000]_\u0003\n\u0005\u0000"+
		"^L\u0001\u0000\u0000\u0000^V\u0001\u0000\u0000\u0000^]\u0001\u0000\u0000"+
		"\u0000_\t\u0001\u0000\u0000\u0000`t\u0005\u0011\u0000\u0000ab\u0005/\u0000"+
		"\u0000bc\u0005\u0012\u0000\u0000cd\u0005\u0003\u0000\u0000de\u0005/\u0000"+
		"\u0000el\u0005\u0003\u0000\u0000fg\u0005\u0013\u0000\u0000gh\u0005\u0003"+
		"\u0000\u0000hi\u0005/\u0000\u0000ik\u0005\u0003\u0000\u0000jf\u0001\u0000"+
		"\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001"+
		"\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000"+
		"op\u0005\u0012\u0000\u0000pq\u0005/\u0000\u0000qs\u0005\u0013\u0000\u0000"+
		"ra\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000wx\u0005/\u0000\u0000xy\u0005\u0012\u0000\u0000yz\u0005\u0003"+
		"\u0000\u0000z{\u0005/\u0000\u0000{\u0082\u0005\u0003\u0000\u0000|}\u0005"+
		"\u0013\u0000\u0000}~\u0005\u0003\u0000\u0000~\u007f\u0005/\u0000\u0000"+
		"\u007f\u0081\u0005\u0003\u0000\u0000\u0080|\u0001\u0000\u0000\u0000\u0081"+
		"\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0001\u0000\u0000\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084"+
		"\u0082\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0012\u0000\u0000\u0086"+
		"\u0087\u0005/\u0000\u0000\u0087\u0088\u0005\t\u0000\u0000\u0088\u000b"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0007\u0002\u0000\u0000\u008a\r\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0005\u0017\u0000\u0000\u008c\u008d\u0005"+
		"/\u0000\u0000\u008d\u008e\u0005\u0018\u0000\u0000\u008e\u008f\u0005/\u0000"+
		"\u0000\u008f\u0093\u0005\u0006\u0000\u0000\u0090\u0092\u0003\u0010\b\u0000"+
		"\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005\u0007\u0000\u0000\u0097\u000f\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0005\u0019\u0000\u0000\u0099\u009a\u0005/\u0000\u0000\u009a"+
		"\u009b\u0005\u001a\u0000\u0000\u009b\u009c\u0005\u001b\u0000\u0000\u009c"+
		"\u009d\u00051\u0000\u0000\u009d\u009e\u0005\u0013\u0000\u0000\u009e\u009f"+
		"\u00051\u0000\u0000\u009f\u00aa\u0005\u001c\u0000\u0000\u00a0\u00a1\u0005"+
		"\u0013\u0000\u0000\u00a1\u00a2\u0005/\u0000\u0000\u00a2\u00a3\u0005\u001a"+
		"\u0000\u0000\u00a3\u00a4\u0005\u001b\u0000\u0000\u00a4\u00a5\u00051\u0000"+
		"\u0000\u00a5\u00a6\u0005\u0013\u0000\u0000\u00a6\u00a7\u00051\u0000\u0000"+
		"\u00a7\u00a9\u0005\u001c\u0000\u0000\u00a8\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00d2\u0005\t\u0000\u0000\u00ae"+
		"\u00af\u0005\u001d\u0000\u0000\u00af\u00b0\u0005/\u0000\u0000\u00b0\u00d2"+
		"\u0005\t\u0000\u0000\u00b1\u00b2\u0005/\u0000\u0000\u00b2\u00b3\u0005"+
		"\r\u0000\u0000\u00b3\u00b4\u0005\u001b\u0000\u0000\u00b4\u00b5\u0005/"+
		"\u0000\u0000\u00b5\u00b6\u0005\u001c\u0000\u0000\u00b6\u00d2\u0005\t\u0000"+
		"\u0000\u00b7\u00b8\u0005\u001d\u0000\u0000\u00b8\u00b9\u0005/\u0000\u0000"+
		"\u00b9\u00ba\u0005\r\u0000\u0000\u00ba\u00bb\u0005\u001b\u0000\u0000\u00bb"+
		"\u00bc\u0007\u0003\u0000\u0000\u00bc\u00bd\u0005\u001e\u0000\u0000\u00bd"+
		"\u00be\u0007\u0003\u0000\u0000\u00be\u00bf\u0005\u001c\u0000\u0000\u00bf"+
		"\u00d2\u0005\t\u0000\u0000\u00c0\u00d2\u0003\u0012\t\u0000\u00c1\u00d2"+
		"\u0003\u0014\n\u0000\u00c2\u00c3\u0005\u001f\u0000\u0000\u00c3\u00c4\u0005"+
		"/\u0000\u0000\u00c4\u00c5\u0005\u0013\u0000\u0000\u00c5\u00c6\u0005/\u0000"+
		"\u0000\u00c6\u00c7\u0005 \u0000\u0000\u00c7\u00c8\u0005!\u0000\u0000\u00c8"+
		"\u00cd\u0005/\u0000\u0000\u00c9\u00ca\u0005\"\u0000\u0000\u00ca\u00cc"+
		"\u0005/\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001"+
		"\u0000\u0000\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d2\u0005\t\u0000\u0000\u00d1\u0098\u0001\u0000"+
		"\u0000\u0000\u00d1\u00ae\u0001\u0000\u0000\u0000\u00d1\u00b1\u0001\u0000"+
		"\u0000\u0000\u00d1\u00b7\u0001\u0000\u0000\u0000\u00d1\u00c0\u0001\u0000"+
		"\u0000\u0000\u00d1\u00c1\u0001\u0000\u0000\u0000\u00d1\u00c2\u0001\u0000"+
		"\u0000\u0000\u00d2\u0011\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003\u0014"+
		"\n\u0000\u00d4\u00d5\u0005\r\u0000\u0000\u00d5\u00d6\u0005\u001b\u0000"+
		"\u0000\u00d6\u00d7\u0005/\u0000\u0000\u00d7\u00d8\u0005\u001c\u0000\u0000"+
		"\u00d8\u00d9\u0005\t\u0000\u0000\u00d9\u00e1\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0005\u001d\u0000\u0000\u00db\u00dc\u0003\u0014\n\u0000\u00dc\u00dd"+
		"\u0005\r\u0000\u0000\u00dd\u00de\u0003\u0014\n\u0000\u00de\u00df\u0005"+
		"\t\u0000\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00d3\u0001\u0000"+
		"\u0000\u0000\u00e0\u00da\u0001\u0000\u0000\u0000\u00e1\u0013\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e3\u0006\n\uffff\uffff\u0000\u00e3\u00ef\u0005/"+
		"\u0000\u0000\u00e4\u00e5\u0005\u001b\u0000\u0000\u00e5\u00e6\u0003\u0014"+
		"\n\u0000\u00e6\u00e7\u0005\u001e\u0000\u0000\u00e7\u00e8\u0003\u0014\n"+
		"\u0000\u00e8\u00e9\u0005\u001c\u0000\u0000\u00e9\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ea\u00ef\u00051\u0000\u0000\u00eb\u00ef\u00050\u0000\u0000\u00ec"+
		"\u00ed\u0005#\u0000\u0000\u00ed\u00ef\u0003\u0014\n\u0002\u00ee\u00e2"+
		"\u0001\u0000\u0000\u0000\u00ee\u00e4\u0001\u0000\u0000\u0000\u00ee\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ee\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ec"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f5\u0001\u0000\u0000\u0000\u00f0\u00f1"+
		"\n\u0001\u0000\u0000\u00f1\u00f2\u0007\u0004\u0000\u0000\u00f2\u00f4\u0003"+
		"\u0014\n\u0002\u00f3\u00f0\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f6\u0015\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0005\'\u0000\u0000\u00f9\u00fa\u0005/\u0000"+
		"\u0000\u00fa\u00fe\u0005\u0006\u0000\u0000\u00fb\u00fd\u0003\u0018\f\u0000"+
		"\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fd\u0100\u0001\u0000\u0000\u0000"+
		"\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000"+
		"\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000"+
		"\u0101\u0102\u0005\u0007\u0000\u0000\u0102\u0017\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0003\u001a\r\u0000\u0104\u0105\u0003\u001c\u000e\u0000\u0105"+
		"\u0019\u0001\u0000\u0000\u0000\u0106\u0107\u0005(\u0000\u0000\u0107\u0108"+
		"\u0005/\u0000\u0000\u0108\u0109\u0005)\u0000\u0000\u0109\u010a\u0005/"+
		"\u0000\u0000\u010a\u010b\u0005\u001a\u0000\u0000\u010b\u010c\u0005\u001b"+
		"\u0000\u0000\u010c\u010d\u00051\u0000\u0000\u010d\u010e\u0005\u0013\u0000"+
		"\u0000\u010e\u010f\u00051\u0000\u0000\u010f\u0110\u0005\u001c\u0000\u0000"+
		"\u0110\u0111\u0005\"\u0000\u0000\u0111\u0112\u0005*\u0000\u0000\u0112"+
		"\u0113\u0005\u001b\u0000\u0000\u0113\u0114\u00051\u0000\u0000\u0114\u0115"+
		"\u0005\u0013\u0000\u0000\u0115\u0116\u00051\u0000\u0000\u0116\u0117\u0005"+
		"\u001c\u0000\u0000\u0117\u0118\u0005\t\u0000\u0000\u0118\u001b\u0001\u0000"+
		"\u0000\u0000\u0119\u011a\u0005+\u0000\u0000\u011a\u011b\u0005/\u0000\u0000"+
		"\u011b\u011f\u0005\u0006\u0000\u0000\u011c\u011e\u0003\u001e\u000f\u0000"+
		"\u011d\u011c\u0001\u0000\u0000\u0000\u011e\u0121\u0001\u0000\u0000\u0000"+
		"\u011f\u011d\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000"+
		"\u0120\u0122\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000"+
		"\u0122\u0123\u0005\u0007\u0000\u0000\u0123\u001d\u0001\u0000\u0000\u0000"+
		"\u0124\u012b\u0005,\u0000\u0000\u0125\u012c\u0005/\u0000\u0000\u0126\u0127"+
		"\u0005/\u0000\u0000\u0127\u0128\u0005\n\u0000\u0000\u0128\u0129\u0007"+
		"\u0000\u0000\u0000\u0129\u012a\u0005\r\u0000\u0000\u012a\u012c\u0007\u0001"+
		"\u0000\u0000\u012b\u0125\u0001\u0000\u0000\u0000\u012b\u0126\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012e\u0005\u0010"+
		"\u0000\u0000\u012e\u013b\u0001\u0000\u0000\u0000\u012f\u0136\u0005\u0013"+
		"\u0000\u0000\u0130\u0137\u0005/\u0000\u0000\u0131\u0132\u0005/\u0000\u0000"+
		"\u0132\u0133\u0005\n\u0000\u0000\u0133\u0134\u0007\u0000\u0000\u0000\u0134"+
		"\u0135\u0005\r\u0000\u0000\u0135\u0137\u0007\u0001\u0000\u0000\u0136\u0130"+
		"\u0001\u0000\u0000\u0000\u0136\u0131\u0001\u0000\u0000\u0000\u0137\u0138"+
		"\u0001\u0000\u0000\u0000\u0138\u013a\u0005\u0010\u0000\u0000\u0139\u012f"+
		"\u0001\u0000\u0000\u0000\u013a\u013d\u0001\u0000\u0000\u0000\u013b\u0139"+
		"\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c\u0148"+
		"\u0001\u0000\u0000\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u0005-\u0000\u0000\u013f\u0148\u0005\t\u0000\u0000\u0140\u0141\u0005"+
		",\u0000\u0000\u0141\u0142\u0005\u001f\u0000\u0000\u0142\u0143\u0005/\u0000"+
		"\u0000\u0143\u0144\u0005\u0013\u0000\u0000\u0144\u0145\u0005/\u0000\u0000"+
		"\u0145\u0146\u0005 \u0000\u0000\u0146\u0148\u0005\t\u0000\u0000\u0147"+
		"\u0124\u0001\u0000\u0000\u0000\u0147\u013e\u0001\u0000\u0000\u0000\u0147"+
		"\u0140\u0001\u0000\u0000\u0000\u0148\u001f\u0001\u0000\u0000\u0000\u0149"+
		"\u014a\u0005.\u0000\u0000\u014a\u014b\u0005/\u0000\u0000\u014b\u014c\u0005"+
		"\t\u0000\u0000\u014c!\u0001\u0000\u0000\u0000\u0016&/<GR^lt\u0082\u0093"+
		"\u00aa\u00cd\u00d1\u00e0\u00ee\u00f5\u00fe\u011f\u012b\u0136\u013b\u0147";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}