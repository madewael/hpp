// Generated from C:/Users/tim/Workspace/HOW/hpp/src/main/antlr4\Hplusplus.g4 by ANTLR 4.7
package be.howest.ti.hplusplus.grammar;
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
		T__9=10, OBSERVE=11, SELF=12, IT=13, OF=14, PRINT=15, NEW=16, OP=17, BOOL=18, 
		NUMBER=19, ID=20, OPEN_SEQ=21, CLOSE_SEQ=22, OPEN_BLOCK=23, CLOSE_BLOCK=24, 
		RETURN=25, END=26, STRING=27, WS=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "OBSERVE", "SELF", "IT", "OF", "PRINT", "NEW", "OP", "BOOL", "NUMBER", 
		"ID", "OPEN_SEQ", "CLOSE_SEQ", "OPEN_BLOCK", "CLOSE_BLOCK", "RETURN", 
		"END", "STRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "' to '", "'@'", "':'", "','", "'if'", "'else'", "'for'", "'<<'", 
		"'do'", "'with'", "'~>'", null, "'it'", "'of'", "'show'", "'new'", null, 
		null, null, null, "'('", "')'", "'(:'", "':)'", "'>>'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "OBSERVE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00bb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\5\re\n\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0088\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u008f\n\23\3\24\6\24\u0092\n\24\r\24\16\24\u0093\3\25"+
		"\6\25\u0097\n\25\r\25\16\25\u0098\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\7\34\u00ae"+
		"\n\34\f\34\16\34\u00b1\13\34\3\34\3\34\3\35\6\35\u00b6\n\35\r\35\16\35"+
		"\u00b7\3\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36\3\2\t\4\2>>@@\5\2,-//\61\61\3\2\62;\4\2C\\c|\4\2$"+
		"$^^\6\2\f\f\17\17$$^^\5\2\13\f\17\17\"\"\2\u00c9\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5@\3\2\2\2\7B\3"+
		"\2\2\2\tD\3\2\2\2\13F\3\2\2\2\rI\3\2\2\2\17N\3\2\2\2\21R\3\2\2\2\23U\3"+
		"\2\2\2\25X\3\2\2\2\27]\3\2\2\2\31d\3\2\2\2\33f\3\2\2\2\35i\3\2\2\2\37"+
		"l\3\2\2\2!q\3\2\2\2#\u0087\3\2\2\2%\u008e\3\2\2\2\'\u0091\3\2\2\2)\u0096"+
		"\3\2\2\2+\u009a\3\2\2\2-\u009c\3\2\2\2/\u009e\3\2\2\2\61\u00a1\3\2\2\2"+
		"\63\u00a4\3\2\2\2\65\u00a7\3\2\2\2\67\u00a9\3\2\2\29\u00b5\3\2\2\2;<\7"+
		"\"\2\2<=\7v\2\2=>\7q\2\2>?\7\"\2\2?\4\3\2\2\2@A\7B\2\2A\6\3\2\2\2BC\7"+
		"<\2\2C\b\3\2\2\2DE\7.\2\2E\n\3\2\2\2FG\7k\2\2GH\7h\2\2H\f\3\2\2\2IJ\7"+
		"g\2\2JK\7n\2\2KL\7u\2\2LM\7g\2\2M\16\3\2\2\2NO\7h\2\2OP\7q\2\2PQ\7t\2"+
		"\2Q\20\3\2\2\2RS\7>\2\2ST\7>\2\2T\22\3\2\2\2UV\7f\2\2VW\7q\2\2W\24\3\2"+
		"\2\2XY\7y\2\2YZ\7k\2\2Z[\7v\2\2[\\\7j\2\2\\\26\3\2\2\2]^\7\u0080\2\2^"+
		"_\7@\2\2_\30\3\2\2\2`a\7o\2\2ae\7{\2\2bc\7o\2\2ce\7g\2\2d`\3\2\2\2db\3"+
		"\2\2\2e\32\3\2\2\2fg\7k\2\2gh\7v\2\2h\34\3\2\2\2ij\7q\2\2jk\7h\2\2k\36"+
		"\3\2\2\2lm\7u\2\2mn\7j\2\2no\7q\2\2op\7y\2\2p \3\2\2\2qr\7p\2\2rs\7g\2"+
		"\2st\7y\2\2t\"\3\2\2\2uv\7p\2\2vw\7q\2\2w\u0088\7v\2\2xy\7?\2\2y\u0088"+
		"\7?\2\2z{\7#\2\2{\u0088\7?\2\2|}\7c\2\2}~\7p\2\2~\u0088\7f\2\2\177\u0080"+
		"\7q\2\2\u0080\u0088\7t\2\2\u0081\u0088\t\2\2\2\u0082\u0083\7>\2\2\u0083"+
		"\u0088\7?\2\2\u0084\u0085\7@\2\2\u0085\u0088\7?\2\2\u0086\u0088\t\3\2"+
		"\2\u0087u\3\2\2\2\u0087x\3\2\2\2\u0087z\3\2\2\2\u0087|\3\2\2\2\u0087\177"+
		"\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0082\3\2\2\2\u0087\u0084\3\2\2\2\u0087"+
		"\u0086\3\2\2\2\u0088$\3\2\2\2\u0089\u008a\7{\2\2\u008a\u008b\7g\2\2\u008b"+
		"\u008f\7u\2\2\u008c\u008d\7p\2\2\u008d\u008f\7q\2\2\u008e\u0089\3\2\2"+
		"\2\u008e\u008c\3\2\2\2\u008f&\3\2\2\2\u0090\u0092\t\4\2\2\u0091\u0090"+
		"\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"(\3\2\2\2\u0095\u0097\t\5\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2"+
		"\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099*\3\2\2\2\u009a\u009b\7"+
		"*\2\2\u009b,\3\2\2\2\u009c\u009d\7+\2\2\u009d.\3\2\2\2\u009e\u009f\7*"+
		"\2\2\u009f\u00a0\7<\2\2\u00a0\60\3\2\2\2\u00a1\u00a2\7<\2\2\u00a2\u00a3"+
		"\7+\2\2\u00a3\62\3\2\2\2\u00a4\u00a5\7@\2\2\u00a5\u00a6\7@\2\2\u00a6\64"+
		"\3\2\2\2\u00a7\u00a8\7\60\2\2\u00a8\66\3\2\2\2\u00a9\u00af\7$\2\2\u00aa"+
		"\u00ab\7^\2\2\u00ab\u00ae\t\6\2\2\u00ac\u00ae\n\7\2\2\u00ad\u00aa\3\2"+
		"\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7$"+
		"\2\2\u00b38\3\2\2\2\u00b4\u00b6\t\b\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\b\35\2\2\u00ba:\3\2\2\2\13\2d\u0087\u008e\u0093\u0098\u00ad\u00af"+
		"\u00b7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}