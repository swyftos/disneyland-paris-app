package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.FormatInfo;
import ch.qos.logback.core.pattern.IdentityCompositeConverter;
import ch.qos.logback.core.pattern.ReplacingCompositeConverter;
import ch.qos.logback.core.pattern.util.IEscapeUtil;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.ScanException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class Parser<E> extends ContextAwareBase {
    public static final Map<String, String> DEFAULT_COMPOSITE_CONVERTER_MAP;
    public static final String MISSING_RIGHT_PARENTHESIS = "http://logback.qos.ch/codes.html#missingRightParenthesis";
    public static final String REPLACE_CONVERTER_WORD = "replace";
    int pointer;
    final List tokenList;

    static {
        HashMap map = new HashMap();
        DEFAULT_COMPOSITE_CONVERTER_MAP = map;
        map.put(Token.BARE_COMPOSITE_KEYWORD_TOKEN.getValue().toString(), IdentityCompositeConverter.class.getName());
        map.put(REPLACE_CONVERTER_WORD, ReplacingCompositeConverter.class.getName());
    }

    public Parser(String str) throws ScanException {
        this(str, new RegularEscapeUtil());
    }

    public Parser(String str, IEscapeUtil iEscapeUtil) throws ScanException {
        this.pointer = 0;
        try {
            this.tokenList = new TokenStream(str, iEscapeUtil).tokenize();
        } catch (IllegalArgumentException e) {
            throw new ScanException("Failed to initialize Parser", e);
        }
    }

    FormattingNode C() {
        Token curentToken = getCurentToken();
        expectNotNull(curentToken, "a LEFT_PARENTHESIS or KEYWORD");
        int type = curentToken.getType();
        if (type == 1004) {
            return SINGLE();
        }
        if (type == 1005) {
            advanceTokenPointer();
            return COMPOSITE(curentToken.getValue().toString());
        }
        throw new IllegalStateException("Unexpected token " + curentToken);
    }

    FormattingNode COMPOSITE(String str) throws ScanException {
        CompositeNode compositeNode = new CompositeNode(str);
        compositeNode.setChildNode(E());
        Token nextToken = getNextToken();
        if (nextToken != null && nextToken.getType() == 41) {
            Token curentToken = getCurentToken();
            if (curentToken != null && curentToken.getType() == 1006) {
                compositeNode.setOptions(curentToken.getOptionsList());
                advanceTokenPointer();
            }
            return compositeNode;
        }
        String str2 = "Expecting RIGHT_PARENTHESIS token but got " + nextToken;
        addError(str2);
        addError("See also http://logback.qos.ch/codes.html#missingRightParenthesis");
        throw new ScanException(str2);
    }

    Node E() throws IllegalArgumentException {
        Node nodeT = T();
        if (nodeT == null) {
            return null;
        }
        Node nodeEopt = Eopt();
        if (nodeEopt != null) {
            nodeT.setNext(nodeEopt);
        }
        return nodeT;
    }

    Node Eopt() {
        if (getCurentToken() == null) {
            return null;
        }
        return E();
    }

    FormattingNode SINGLE() {
        SimpleKeywordNode simpleKeywordNode = new SimpleKeywordNode(getNextToken().getValue());
        Token curentToken = getCurentToken();
        if (curentToken != null && curentToken.getType() == 1006) {
            simpleKeywordNode.setOptions(curentToken.getOptionsList());
            advanceTokenPointer();
        }
        return simpleKeywordNode;
    }

    Node T() throws IllegalArgumentException {
        Token curentToken = getCurentToken();
        expectNotNull(curentToken, "a LITERAL or '%'");
        int type = curentToken.getType();
        if (type != 37) {
            if (type != 1000) {
                return null;
            }
            advanceTokenPointer();
            return new Node(0, curentToken.getValue());
        }
        advanceTokenPointer();
        Token curentToken2 = getCurentToken();
        expectNotNull(curentToken2, "a FORMAT_MODIFIER, SIMPLE_KEYWORD or COMPOUND_KEYWORD");
        if (curentToken2.getType() != 1002) {
            return C();
        }
        FormatInfo formatInfoValueOf = FormatInfo.valueOf(curentToken2.getValue());
        advanceTokenPointer();
        FormattingNode formattingNodeC = C();
        formattingNodeC.setFormatInfo(formatInfoValueOf);
        return formattingNodeC;
    }

    void advanceTokenPointer() {
        this.pointer++;
    }

    public Converter<E> compile(Node node, Map<String, String> map) {
        Compiler compiler = new Compiler(node, map);
        compiler.setContext(this.context);
        return compiler.compile();
    }

    void expectNotNull(Token token, String str) {
        if (token != null) {
            return;
        }
        throw new IllegalStateException("All tokens consumed but was expecting " + str);
    }

    Token getCurentToken() {
        if (this.pointer < this.tokenList.size()) {
            return (Token) this.tokenList.get(this.pointer);
        }
        return null;
    }

    Token getNextToken() {
        if (this.pointer >= this.tokenList.size()) {
            return null;
        }
        List list = this.tokenList;
        int i = this.pointer;
        this.pointer = i + 1;
        return (Token) list.get(i);
    }

    public Node parse() throws ScanException {
        return E();
    }
}
