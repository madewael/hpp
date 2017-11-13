// Generated from /Users/madewael/Desktop/currentProgramming projects/hpp/src/main/antlr4/Hplusplus.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HplusplusLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		OBSERVE=10, SELF=11, IT=12, OF=13, PRINT=14, NEW=15, OP=16, BOOL=17, NUMBER=18, 
		ID=19, OPEN_SEQ=20, CLOSE_SEQ=21, OPEN_BLOCK=22, CLOSE_BLOCK=23, RETURN=24, 
		END=25, STRING=26, WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"OBSERVE", "SELF", "IT", "OF", "PRINT", "NEW", "OP", "BOOL", "NUMBER", 
		"ID", "OPEN_SEQ", "CLOSE_SEQ", "OPEN_BLOCK", "CLOSE_BLOCK", "RETURN", 
		"END", "STRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@'", "':'", "','", "'if'", "'else'", "'for'", "'<<'", "'do'", 
		"'with'", "'~>'", null, "'it'", "'of'", "'show'", "'new'", null, null, 
		null, null, "'('", "')'", "'(:'", "':)'", "'>>'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "OBSERVE", 
		"SELF", "IT", "OF", "PRINT", "NEW", "OP", "BOOL", "NUMBER", "ID", "OPEN_SEQ", 
		"CLOSE_SEQ", "OPEN_BLOCK", "CLOSE_BLOCK", "RETURN", "END", "STRING", "WS"
	};
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


	public HplusplusLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Hplusplus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00b4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f^\n\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u0081\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u0088\n\22\3\23\6"+
		"\23\u008b\n\23\r\23\16\23\u008c\3\24\6\24\u0090\n\24\r\24\16\24\u0091"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\7\33\u00a7\n\33\f\33\16\33\u00aa\13\33\3\33"+
		"\3\33\3\34\6\34\u00af\n\34\r\34\16\34\u00b0\3\34\3\34\2\2\35\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\t\4\2>>@@\5"+
		"\2,-//\61\61\3\2\62;\4\2C\\c|\4\2$$^^\6\2\f\f\17\17$$^^\5\2\13\f\17\17"+
		"\"\"\2\u00c2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3"+
		"\2\2\2\5;\3\2\2\2\7=\3\2\2\2\t?\3\2\2\2\13B\3\2\2\2\rG\3\2\2\2\17K\3\2"+
		"\2\2\21N\3\2\2\2\23Q\3\2\2\2\25V\3\2\2\2\27]\3\2\2\2\31_\3\2\2\2\33b\3"+
		"\2\2\2\35e\3\2\2\2\37j\3\2\2\2!\u0080\3\2\2\2#\u0087\3\2\2\2%\u008a\3"+
		"\2\2\2\'\u008f\3\2\2\2)\u0093\3\2\2\2+\u0095\3\2\2\2-\u0097\3\2\2\2/\u009a"+
		"\3\2\2\2\61\u009d\3\2\2\2\63\u00a0\3\2\2\2\65\u00a2\3\2\2\2\67\u00ae\3"+
		"\2\2\29:\7B\2\2:\4\3\2\2\2;<\7<\2\2<\6\3\2\2\2=>\7.\2\2>\b\3\2\2\2?@\7"+
		"k\2\2@A\7h\2\2A\n\3\2\2\2BC\7g\2\2CD\7n\2\2DE\7u\2\2EF\7g\2\2F\f\3\2\2"+
		"\2GH\7h\2\2HI\7q\2\2IJ\7t\2\2J\16\3\2\2\2KL\7>\2\2LM\7>\2\2M\20\3\2\2"+
		"\2NO\7f\2\2OP\7q\2\2P\22\3\2\2\2QR\7y\2\2RS\7k\2\2ST\7v\2\2TU\7j\2\2U"+
		"\24\3\2\2\2VW\7\u0080\2\2WX\7@\2\2X\26\3\2\2\2YZ\7o\2\2Z^\7{\2\2[\\\7"+
		"o\2\2\\^\7g\2\2]Y\3\2\2\2][\3\2\2\2^\30\3\2\2\2_`\7k\2\2`a\7v\2\2a\32"+
		"\3\2\2\2bc\7q\2\2cd\7h\2\2d\34\3\2\2\2ef\7u\2\2fg\7j\2\2gh\7q\2\2hi\7"+
		"y\2\2i\36\3\2\2\2jk\7p\2\2kl\7g\2\2lm\7y\2\2m \3\2\2\2no\7p\2\2op\7q\2"+
		"\2p\u0081\7v\2\2qr\7?\2\2r\u0081\7?\2\2st\7#\2\2t\u0081\7?\2\2uv\7c\2"+
		"\2vw\7p\2\2w\u0081\7f\2\2xy\7q\2\2y\u0081\7t\2\2z\u0081\t\2\2\2{|\7>\2"+
		"\2|\u0081\7?\2\2}~\7@\2\2~\u0081\7?\2\2\177\u0081\t\3\2\2\u0080n\3\2\2"+
		"\2\u0080q\3\2\2\2\u0080s\3\2\2\2\u0080u\3\2\2\2\u0080x\3\2\2\2\u0080z"+
		"\3\2\2\2\u0080{\3\2\2\2\u0080}\3\2\2\2\u0080\177\3\2\2\2\u0081\"\3\2\2"+
		"\2\u0082\u0083\7{\2\2\u0083\u0084\7g\2\2\u0084\u0088\7u\2\2\u0085\u0086"+
		"\7p\2\2\u0086\u0088\7q\2\2\u0087\u0082\3\2\2\2\u0087\u0085\3\2\2\2\u0088"+
		"$\3\2\2\2\u0089\u008b\t\4\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2"+
		"\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d&\3\2\2\2\u008e\u0090\t"+
		"\5\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092(\3\2\2\2\u0093\u0094\7*\2\2\u0094*\3\2\2\2\u0095"+
		"\u0096\7+\2\2\u0096,\3\2\2\2\u0097\u0098\7*\2\2\u0098\u0099\7<\2\2\u0099"+
		".\3\2\2\2\u009a\u009b\7<\2\2\u009b\u009c\7+\2\2\u009c\60\3\2\2\2\u009d"+
		"\u009e\7@\2\2\u009e\u009f\7@\2\2\u009f\62\3\2\2\2\u00a0\u00a1\7\60\2\2"+
		"\u00a1\64\3\2\2\2\u00a2\u00a8\7$\2\2\u00a3\u00a4\7^\2\2\u00a4\u00a7\t"+
		"\6\2\2\u00a5\u00a7\n\7\2\2\u00a6\u00a3\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7$\2\2\u00ac\66\3\2\2\2\u00ad\u00af"+
		"\t\b\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\34\2\2\u00b38\3\2\2\2"+
		"\13\2]\u0080\u0087\u008c\u0091\u00a6\u00a8\u00b0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}