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
		ID=46, FLOAT=47, INTEGER=48, WS=49, COMMENT=50, COMMENT2=51, ERROR=52;
	public static final int
		RULE_program = 0, RULE_sector = 1, RULE_alphabet = 2, RULE_automaton = 3, 
		RULE_automatonStatement = 4, RULE_transition = 5, RULE_automatonType = 6, 
		RULE_view = 7, RULE_viewStatement = 8, RULE_placeAssignment = 9, RULE_pointAssignment = 10, 
		RULE_expression = 11, RULE_animation = 12, RULE_animationStatement = 13, 
		RULE_viewport = 14, RULE_on = 15, RULE_onStatement = 16, RULE_play = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "sector", "alphabet", "automaton", "automatonStatement", "transition", 
			"automatonType", "view", "viewStatement", "placeAssignment", "pointAssignment", 
			"expression", "animation", "animationStatement", "viewport", "on", "onStatement", 
			"play"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'alphabet'", "'{'", "'''", "', '", "'}'", "'<<<'", "'>>>'", "'state'", 
			"';'", "'['", "'initial'", "'accepting'", "'='", "'false'", "'true'", 
			"']'", "'transition'", "'->'", "','", "'NFA'", "'DFA'", "'complete DFA'", 
			"'view'", "'of'", "'place'", "'at'", "'('", "')'", "'point'", "':'", 
			"'-'", "'+'", "'/'", "'*'", "'animation'", "'viewport'", "'for'", "'--'", 
			"'++'", "'on'", "'show'", "'pause'", "'<'", "'>'", "'play'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "ID", "FLOAT", 
			"INTEGER", "WS", "COMMENT", "COMMENT2", "ERROR"
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
			setState(36);
			alphabet();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35218747555840L) != 0)) {
				{
				{
				setState(37);
				sector();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				automaton();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				view();
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				animation();
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
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
			setState(51);
			match(T__0);
			setState(52);
			match(T__1);
			setState(53);
			match(T__2);
			setState(54);
			match(ID);
			setState(55);
			match(T__2);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(56);
				match(T__3);
				setState(57);
				match(T__2);
				setState(58);
				match(ID);
				setState(59);
				match(T__2);
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
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
			setState(67);
			automatonType();
			setState(68);
			match(ID);
			setState(69);
			match(T__5);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 70368744308992L) != 0)) {
				{
				{
				setState(70);
				automatonStatement();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
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
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(T__7);
				setState(79);
				match(ID);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(80);
					match(T__3);
					setState(81);
					match(ID);
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				match(T__8);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(ID);
				setState(89);
				match(T__9);
				setState(90);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(91);
				match(T__12);
				setState(92);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(93);
				match(T__15);
				setState(94);
				match(T__8);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
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
			setState(98);
			match(T__16);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(99);
					match(ID);
					setState(100);
					match(T__17);
					setState(101);
					match(T__2);
					setState(102);
					match(ID);
					setState(103);
					match(T__2);
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__18) {
						{
						{
						setState(104);
						match(T__18);
						setState(105);
						match(T__2);
						setState(106);
						match(ID);
						setState(107);
						match(T__2);
						}
						}
						setState(112);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(113);
					match(T__17);
					setState(114);
					match(ID);
					setState(115);
					match(T__18);
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(121);
			match(ID);
			setState(122);
			match(T__17);
			setState(123);
			match(T__2);
			setState(124);
			match(ID);
			setState(125);
			match(T__2);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(126);
				match(T__18);
				setState(127);
				match(T__2);
				setState(128);
				match(ID);
				setState(129);
				match(T__2);
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(T__17);
			setState(136);
			match(ID);
			setState(137);
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
			setState(139);
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
			setState(141);
			match(T__22);
			setState(142);
			match(ID);
			setState(143);
			match(T__23);
			setState(144);
			match(ID);
			setState(145);
			match(T__5);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(146);
				viewStatement();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
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
		public List<PlaceAssignmentContext> placeAssignment() {
			return getRuleContexts(PlaceAssignmentContext.class);
		}
		public PlaceAssignmentContext placeAssignment(int i) {
			return getRuleContext(PlaceAssignmentContext.class,i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__24);
			setState(155);
			placeAssignment();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(156);
				match(T__3);
				setState(157);
				placeAssignment();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
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
	public static class PlaceAssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TestParser.ID, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(TestParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(TestParser.INTEGER, i);
		}
		public PlaceAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_placeAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).enterPlaceAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestListener ) ((TestListener)listener).exitPlaceAssignment(this);
		}
	}

	public final PlaceAssignmentContext placeAssignment() throws RecognitionException {
		PlaceAssignmentContext _localctx = new PlaceAssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_placeAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(ID);
			setState(166);
			match(T__25);
			setState(167);
			match(T__26);
			setState(168);
			match(INTEGER);
			setState(169);
			match(T__3);
			setState(170);
			match(INTEGER);
			setState(171);
			match(T__27);
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
		enterRule(_localctx, 20, RULE_pointAssignment);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
			case T__30:
			case ID:
			case FLOAT:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				expression(0);
				setState(174);
				match(T__12);
				setState(175);
				match(T__26);
				setState(176);
				match(ID);
				setState(177);
				match(T__27);
				setState(178);
				match(T__8);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(T__28);
				setState(181);
				expression(0);
				setState(182);
				match(T__12);
				setState(183);
				expression(0);
				setState(184);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(189);
				match(ID);
				}
				break;
			case T__26:
				{
				setState(190);
				match(T__26);
				setState(191);
				expression(0);
				setState(192);
				match(T__29);
				setState(193);
				expression(0);
				setState(194);
				match(T__27);
				}
				break;
			case INTEGER:
				{
				setState(196);
				match(INTEGER);
				}
				break;
			case FLOAT:
				{
				setState(197);
				match(FLOAT);
				}
				break;
			case T__30:
				{
				setState(198);
				match(T__30);
				setState(199);
				expression(2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(202);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(203);
					((ExpressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32212262912L) != 0)) ) {
						((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(204);
					expression(2);
					}
					} 
				}
				setState(209);
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
		enterRule(_localctx, 24, RULE_animation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__34);
			setState(211);
			match(ID);
			setState(212);
			match(T__5);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35) {
				{
				{
				setState(213);
				animationStatement();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(219);
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
		enterRule(_localctx, 26, RULE_animationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			viewport();
			setState(222);
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
		enterRule(_localctx, 28, RULE_viewport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__35);
			setState(225);
			match(ID);
			setState(226);
			match(T__36);
			setState(227);
			match(ID);
			setState(228);
			match(T__25);
			setState(229);
			match(T__26);
			setState(230);
			match(INTEGER);
			setState(231);
			match(T__18);
			setState(232);
			match(INTEGER);
			setState(233);
			match(T__27);
			setState(234);
			match(T__37);
			setState(235);
			match(T__38);
			setState(236);
			match(T__26);
			setState(237);
			match(INTEGER);
			setState(238);
			match(T__18);
			setState(239);
			match(INTEGER);
			setState(240);
			match(T__27);
			setState(241);
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
		enterRule(_localctx, 30, RULE_on);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(T__39);
			setState(244);
			match(ID);
			setState(245);
			match(T__5);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__40 || _la==T__41) {
				{
				{
				setState(246);
				onStatement();
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
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
		enterRule(_localctx, 32, RULE_onStatement);
		int _la;
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(T__40);
				{
				setState(263);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					{
					setState(255);
					match(ID);
					}
					}
					break;
				case 2:
					{
					{
					setState(256);
					match(ID);
					setState(257);
					match(T__9);
					setState(258);
					_la = _input.LA(1);
					if ( !(_la==T__10 || _la==T__11) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(259);
					match(T__12);
					setState(260);
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
					setState(262);
					match(T__15);
					}
					break;
				}
				}
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(265);
					match(T__3);
					{
					setState(274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						{
						setState(266);
						match(ID);
						}
						}
						break;
					case 2:
						{
						{
						setState(267);
						match(ID);
						setState(268);
						match(T__9);
						setState(269);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(270);
						match(T__12);
						setState(271);
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
						setState(273);
						match(T__15);
						}
						break;
					}
					}
					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(281);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(T__41);
				setState(283);
				match(T__8);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				match(T__40);
				setState(285);
				match(T__42);
				setState(286);
				match(ID);
				setState(287);
				match(T__18);
				setState(288);
				match(ID);
				setState(289);
				match(T__43);
				setState(290);
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
		enterRule(_localctx, 34, RULE_play);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(T__44);
			setState(294);
			match(ID);
			setState(295);
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
		case 11:
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
		"\u0004\u00014\u012a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\'\b\u0000\n\u0000\f\u0000*\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00012\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002=\b\u0002\n\u0002\f\u0002"+
		"@\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003H\b\u0003\n\u0003\f\u0003K\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"S\b\u0004\n\u0004\f\u0004V\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004a\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005m\b\u0005\n\u0005\f\u0005p\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005u\b\u0005\n\u0005\f\u0005x\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u0083\b\u0005\n\u0005\f\u0005\u0086"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u0094\b\u0007\n\u0007\f\u0007\u0097\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u009f\b\b\n\b\f\b"+
		"\u00a2\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00bb\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00c9\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00ce"+
		"\b\u000b\n\u000b\f\u000b\u00d1\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u00d7\b\f\n\f\f\f\u00da\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00f8\b\u000f\n\u000f\f\u000f\u00fb\t\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0108\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u0113\b\u0010\u0005\u0010\u0115\b\u0010"+
		"\n\u0010\f\u0010\u0118\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u0124\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0000\u0001\u0016\u0012\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0004"+
		"\u0001\u0000\u000b\f\u0001\u0000\u000e\u000f\u0001\u0000\u0014\u0016\u0002"+
		"\u0000\r\r\u001f\"\u0132\u0000$\u0001\u0000\u0000\u0000\u00021\u0001\u0000"+
		"\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000"+
		"\b`\u0001\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000\f\u008b\u0001\u0000"+
		"\u0000\u0000\u000e\u008d\u0001\u0000\u0000\u0000\u0010\u009a\u0001\u0000"+
		"\u0000\u0000\u0012\u00a5\u0001\u0000\u0000\u0000\u0014\u00ba\u0001\u0000"+
		"\u0000\u0000\u0016\u00c8\u0001\u0000\u0000\u0000\u0018\u00d2\u0001\u0000"+
		"\u0000\u0000\u001a\u00dd\u0001\u0000\u0000\u0000\u001c\u00e0\u0001\u0000"+
		"\u0000\u0000\u001e\u00f3\u0001\u0000\u0000\u0000 \u0123\u0001\u0000\u0000"+
		"\u0000\"\u0125\u0001\u0000\u0000\u0000$(\u0003\u0004\u0002\u0000%\'\u0003"+
		"\u0002\u0001\u0000&%\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000"+
		"(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)+\u0001\u0000\u0000"+
		"\u0000*(\u0001\u0000\u0000\u0000+,\u0005\u0000\u0000\u0001,\u0001\u0001"+
		"\u0000\u0000\u0000-2\u0003\u0006\u0003\u0000.2\u0003\u000e\u0007\u0000"+
		"/2\u0003\u0018\f\u000002\u0003\"\u0011\u00001-\u0001\u0000\u0000\u0000"+
		"1.\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000010\u0001\u0000\u0000"+
		"\u00002\u0003\u0001\u0000\u0000\u000034\u0005\u0001\u0000\u000045\u0005"+
		"\u0002\u0000\u000056\u0005\u0003\u0000\u000067\u0005.\u0000\u00007>\u0005"+
		"\u0003\u0000\u000089\u0005\u0004\u0000\u00009:\u0005\u0003\u0000\u0000"+
		":;\u0005.\u0000\u0000;=\u0005\u0003\u0000\u0000<8\u0001\u0000\u0000\u0000"+
		"=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?A\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AB\u0005\u0005"+
		"\u0000\u0000B\u0005\u0001\u0000\u0000\u0000CD\u0003\f\u0006\u0000DE\u0005"+
		".\u0000\u0000EI\u0005\u0006\u0000\u0000FH\u0003\b\u0004\u0000GF\u0001"+
		"\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000"+
		"\u0000LM\u0005\u0007\u0000\u0000M\u0007\u0001\u0000\u0000\u0000NO\u0005"+
		"\b\u0000\u0000OT\u0005.\u0000\u0000PQ\u0005\u0004\u0000\u0000QS\u0005"+
		".\u0000\u0000RP\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000Wa\u0005\t\u0000\u0000XY\u0005.\u0000\u0000"+
		"YZ\u0005\n\u0000\u0000Z[\u0007\u0000\u0000\u0000[\\\u0005\r\u0000\u0000"+
		"\\]\u0007\u0001\u0000\u0000]^\u0005\u0010\u0000\u0000^a\u0005\t\u0000"+
		"\u0000_a\u0003\n\u0005\u0000`N\u0001\u0000\u0000\u0000`X\u0001\u0000\u0000"+
		"\u0000`_\u0001\u0000\u0000\u0000a\t\u0001\u0000\u0000\u0000bv\u0005\u0011"+
		"\u0000\u0000cd\u0005.\u0000\u0000de\u0005\u0012\u0000\u0000ef\u0005\u0003"+
		"\u0000\u0000fg\u0005.\u0000\u0000gn\u0005\u0003\u0000\u0000hi\u0005\u0013"+
		"\u0000\u0000ij\u0005\u0003\u0000\u0000jk\u0005.\u0000\u0000km\u0005\u0003"+
		"\u0000\u0000lh\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000qr\u0005\u0012\u0000\u0000rs\u0005.\u0000\u0000"+
		"su\u0005\u0013\u0000\u0000tc\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000"+
		"\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wy\u0001\u0000"+
		"\u0000\u0000xv\u0001\u0000\u0000\u0000yz\u0005.\u0000\u0000z{\u0005\u0012"+
		"\u0000\u0000{|\u0005\u0003\u0000\u0000|}\u0005.\u0000\u0000}\u0084\u0005"+
		"\u0003\u0000\u0000~\u007f\u0005\u0013\u0000\u0000\u007f\u0080\u0005\u0003"+
		"\u0000\u0000\u0080\u0081\u0005.\u0000\u0000\u0081\u0083\u0005\u0003\u0000"+
		"\u0000\u0082~\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000"+
		"\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000"+
		"\u0085\u0087\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0005\u0012\u0000\u0000\u0088\u0089\u0005.\u0000\u0000\u0089"+
		"\u008a\u0005\t\u0000\u0000\u008a\u000b\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0007\u0002\u0000\u0000\u008c\r\u0001\u0000\u0000\u0000\u008d\u008e\u0005"+
		"\u0017\u0000\u0000\u008e\u008f\u0005.\u0000\u0000\u008f\u0090\u0005\u0018"+
		"\u0000\u0000\u0090\u0091\u0005.\u0000\u0000\u0091\u0095\u0005\u0006\u0000"+
		"\u0000\u0092\u0094\u0003\u0010\b\u0000\u0093\u0092\u0001\u0000\u0000\u0000"+
		"\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0098\u0001\u0000\u0000\u0000"+
		"\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u0099\u0005\u0007\u0000\u0000"+
		"\u0099\u000f\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0019\u0000\u0000"+
		"\u009b\u00a0\u0003\u0012\t\u0000\u009c\u009d\u0005\u0004\u0000\u0000\u009d"+
		"\u009f\u0003\u0012\t\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\t\u0000\u0000\u00a4\u0011\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0005.\u0000\u0000\u00a6\u00a7\u0005\u001a"+
		"\u0000\u0000\u00a7\u00a8\u0005\u001b\u0000\u0000\u00a8\u00a9\u00050\u0000"+
		"\u0000\u00a9\u00aa\u0005\u0004\u0000\u0000\u00aa\u00ab\u00050\u0000\u0000"+
		"\u00ab\u00ac\u0005\u001c\u0000\u0000\u00ac\u0013\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0003\u0016\u000b\u0000\u00ae\u00af\u0005\r\u0000\u0000\u00af"+
		"\u00b0\u0005\u001b\u0000\u0000\u00b0\u00b1\u0005.\u0000\u0000\u00b1\u00b2"+
		"\u0005\u001c\u0000\u0000\u00b2\u00b3\u0005\t\u0000\u0000\u00b3\u00bb\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0005\u001d\u0000\u0000\u00b5\u00b6\u0003"+
		"\u0016\u000b\u0000\u00b6\u00b7\u0005\r\u0000\u0000\u00b7\u00b8\u0003\u0016"+
		"\u000b\u0000\u00b8\u00b9\u0005\t\u0000\u0000\u00b9\u00bb\u0001\u0000\u0000"+
		"\u0000\u00ba\u00ad\u0001\u0000\u0000\u0000\u00ba\u00b4\u0001\u0000\u0000"+
		"\u0000\u00bb\u0015\u0001\u0000\u0000\u0000\u00bc\u00bd\u0006\u000b\uffff"+
		"\uffff\u0000\u00bd\u00c9\u0005.\u0000\u0000\u00be\u00bf\u0005\u001b\u0000"+
		"\u0000\u00bf\u00c0\u0003\u0016\u000b\u0000\u00c0\u00c1\u0005\u001e\u0000"+
		"\u0000\u00c1\u00c2\u0003\u0016\u000b\u0000\u00c2\u00c3\u0005\u001c\u0000"+
		"\u0000\u00c3\u00c9\u0001\u0000\u0000\u0000\u00c4\u00c9\u00050\u0000\u0000"+
		"\u00c5\u00c9\u0005/\u0000\u0000\u00c6\u00c7\u0005\u001f\u0000\u0000\u00c7"+
		"\u00c9\u0003\u0016\u000b\u0002\u00c8\u00bc\u0001\u0000\u0000\u0000\u00c8"+
		"\u00be\u0001\u0000\u0000\u0000\u00c8\u00c4\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9"+
		"\u00cf\u0001\u0000\u0000\u0000\u00ca\u00cb\n\u0001\u0000\u0000\u00cb\u00cc"+
		"\u0007\u0003\u0000\u0000\u00cc\u00ce\u0003\u0016\u000b\u0002\u00cd\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u0017"+
		"\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0005#\u0000\u0000\u00d3\u00d4\u0005.\u0000\u0000\u00d4\u00d8\u0005\u0006"+
		"\u0000\u0000\u00d5\u00d7\u0003\u001a\r\u0000\u00d6\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00db\u0001\u0000\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\u0007\u0000"+
		"\u0000\u00dc\u0019\u0001\u0000\u0000\u0000\u00dd\u00de\u0003\u001c\u000e"+
		"\u0000\u00de\u00df\u0003\u001e\u000f\u0000\u00df\u001b\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e1\u0005$\u0000\u0000\u00e1\u00e2\u0005.\u0000\u0000\u00e2"+
		"\u00e3\u0005%\u0000\u0000\u00e3\u00e4\u0005.\u0000\u0000\u00e4\u00e5\u0005"+
		"\u001a\u0000\u0000\u00e5\u00e6\u0005\u001b\u0000\u0000\u00e6\u00e7\u0005"+
		"0\u0000\u0000\u00e7\u00e8\u0005\u0013\u0000\u0000\u00e8\u00e9\u00050\u0000"+
		"\u0000\u00e9\u00ea\u0005\u001c\u0000\u0000\u00ea\u00eb\u0005&\u0000\u0000"+
		"\u00eb\u00ec\u0005\'\u0000\u0000\u00ec\u00ed\u0005\u001b\u0000\u0000\u00ed"+
		"\u00ee\u00050\u0000\u0000\u00ee\u00ef\u0005\u0013\u0000\u0000\u00ef\u00f0"+
		"\u00050\u0000\u0000\u00f0\u00f1\u0005\u001c\u0000\u0000\u00f1\u00f2\u0005"+
		"\t\u0000\u0000\u00f2\u001d\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005("+
		"\u0000\u0000\u00f4\u00f5\u0005.\u0000\u0000\u00f5\u00f9\u0005\u0006\u0000"+
		"\u0000\u00f6\u00f8\u0003 \u0010\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000"+
		"\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000"+
		"\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005\u0007\u0000\u0000"+
		"\u00fd\u001f\u0001\u0000\u0000\u0000\u00fe\u0107\u0005)\u0000\u0000\u00ff"+
		"\u0108\u0005.\u0000\u0000\u0100\u0101\u0005.\u0000\u0000\u0101\u0102\u0005"+
		"\n\u0000\u0000\u0102\u0103\u0007\u0000\u0000\u0000\u0103\u0104\u0005\r"+
		"\u0000\u0000\u0104\u0105\u0007\u0001\u0000\u0000\u0105\u0106\u0001\u0000"+
		"\u0000\u0000\u0106\u0108\u0005\u0010\u0000\u0000\u0107\u00ff\u0001\u0000"+
		"\u0000\u0000\u0107\u0100\u0001\u0000\u0000\u0000\u0108\u0116\u0001\u0000"+
		"\u0000\u0000\u0109\u0112\u0005\u0004\u0000\u0000\u010a\u0113\u0005.\u0000"+
		"\u0000\u010b\u010c\u0005.\u0000\u0000\u010c\u010d\u0005\n\u0000\u0000"+
		"\u010d\u010e\u0007\u0000\u0000\u0000\u010e\u010f\u0005\r\u0000\u0000\u010f"+
		"\u0110\u0007\u0001\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111"+
		"\u0113\u0005\u0010\u0000\u0000\u0112\u010a\u0001\u0000\u0000\u0000\u0112"+
		"\u010b\u0001\u0000\u0000\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114"+
		"\u0109\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000\u0000\u0000\u0116"+
		"\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117"+
		"\u0119\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119"+
		"\u0124\u0005\t\u0000\u0000\u011a\u011b\u0005*\u0000\u0000\u011b\u0124"+
		"\u0005\t\u0000\u0000\u011c\u011d\u0005)\u0000\u0000\u011d\u011e\u0005"+
		"+\u0000\u0000\u011e\u011f\u0005.\u0000\u0000\u011f\u0120\u0005\u0013\u0000"+
		"\u0000\u0120\u0121\u0005.\u0000\u0000\u0121\u0122\u0005,\u0000\u0000\u0122"+
		"\u0124\u0005\t\u0000\u0000\u0123\u00fe\u0001\u0000\u0000\u0000\u0123\u011a"+
		"\u0001\u0000\u0000\u0000\u0123\u011c\u0001\u0000\u0000\u0000\u0124!\u0001"+
		"\u0000\u0000\u0000\u0125\u0126\u0005-\u0000\u0000\u0126\u0127\u0005.\u0000"+
		"\u0000\u0127\u0128\u0005\t\u0000\u0000\u0128#\u0001\u0000\u0000\u0000"+
		"\u0014(1>IT`nv\u0084\u0095\u00a0\u00ba\u00c8\u00cf\u00d8\u00f9\u0107\u0112"+
		"\u0116\u0123";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}