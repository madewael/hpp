package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.exceptions.HppAppException;
import be.howest.ti.hplusplus.exceptions.compile.SyntaxException;
import be.howest.ti.hplusplus.grammar.HplusplusLexer;
import be.howest.ti.hplusplus.grammar.HplusplusParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.io.File;
import java.io.IOException;
import java.util.BitSet;

public class HppParser {

    public static HplusplusParser.ProgContext parse(String src){
        return parse(CharStreams.fromString(src));
    }

    public static HplusplusParser.ProgContext parse(File file){
        try {
            return parse(CharStreams.fromFileName(file.getAbsolutePath()));
        } catch (IOException ex) {
            throw new HppAppException("Failed to read input file", ex);
        }
    }

    private static HplusplusParser.ProgContext parse(CharStream stream){
        return preParse(stream).prog();
    }

    public static HplusplusParser.ExprContext parseExpr(String src){
        return parseExpr(CharStreams.fromString(src));
    }
    private static HplusplusParser.ExprContext parseExpr(CharStream stream){
        return preParse(stream).expr();
    }

    public static HplusplusParser.StmtContext parseStmt(String src){
        return parseStmt(CharStreams.fromString(src));
    }
    private static HplusplusParser.StmtContext parseStmt(CharStream stream){
        return preParse(stream).stmt();
    }


    private static HplusplusParser preParse(CharStream stream){
        HplusplusLexer lexer = new HplusplusLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HplusplusParser parser = new HplusplusParser(tokens);

        parser.addErrorListener(SYNTAX_ERROR_THROWER);

        return parser;
    }




    public static final ANTLRErrorListener SYNTAX_ERROR_THROWER = new ANTLRErrorListener() {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
            throw new SyntaxException(s);
        }

        @Override
        public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
            // System.out.println("reportAmbiguity");
        }

        @Override
        public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
            // System.out.println("reportAttemptingFullContext");
        }

        @Override
        public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
            // System.out.println("reportContextSensitivity");
        }
    };

}
