package ch.qos.logback.core.subst;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.ScanException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Parser {
    int pointer = 0;
    final List tokenList;

    /* JADX INFO: renamed from: ch.qos.logback.core.subst.Parser$1 */
    static /* synthetic */ class C17421 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$subst$Token$Type;

        static {
            int[] iArr = new int[Token.Type.values().length];
            $SwitchMap$ch$qos$logback$core$subst$Token$Type = iArr;
            try {
                iArr[Token.Type.LITERAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$subst$Token$Type[Token.Type.CURLY_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$subst$Token$Type[Token.Type.START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Parser(List<Token> list) {
        this.tokenList = list;
    }

    /* JADX INFO: renamed from: C */
    private Node m416C() throws ScanException {
        Node nodeM417E = m417E();
        if (isDefaultToken(peekAtCurentToken())) {
            advanceTokenPointer();
            nodeM417E.append(makeNewLiteralNode(CoreConstants.DEFAULT_VALUE_SEPARATOR));
            nodeM417E.append(m417E());
        }
        return nodeM417E;
    }

    /* JADX INFO: renamed from: E */
    private Node m417E() throws ScanException {
        Node nodeM418T = m418T();
        if (nodeM418T == null) {
            return null;
        }
        Node nodeEopt = Eopt();
        if (nodeEopt != null) {
            nodeM418T.append(nodeEopt);
        }
        return nodeM418T;
    }

    private Node Eopt() {
        if (peekAtCurentToken() == null) {
            return null;
        }
        return m417E();
    }

    /* JADX INFO: renamed from: T */
    private Node m418T() throws ScanException {
        Token tokenPeekAtCurentToken = peekAtCurentToken();
        int i = C17421.$SwitchMap$ch$qos$logback$core$subst$Token$Type[tokenPeekAtCurentToken.type.ordinal()];
        if (i == 1) {
            advanceTokenPointer();
            return makeNewLiteralNode(tokenPeekAtCurentToken.payload);
        }
        if (i != 2) {
            if (i != 3) {
                return null;
            }
            advanceTokenPointer();
            Node nodeM419V = m419V();
            expectCurlyRight(peekAtCurentToken());
            advanceTokenPointer();
            return nodeM419V;
        }
        advanceTokenPointer();
        Node nodeM416C = m416C();
        expectCurlyRight(peekAtCurentToken());
        advanceTokenPointer();
        Node nodeMakeNewLiteralNode = makeNewLiteralNode(CoreConstants.LEFT_ACCOLADE);
        nodeMakeNewLiteralNode.append(nodeM416C);
        nodeMakeNewLiteralNode.append(makeNewLiteralNode(CoreConstants.RIGHT_ACCOLADE));
        return nodeMakeNewLiteralNode;
    }

    /* JADX INFO: renamed from: V */
    private Node m419V() {
        Node node = new Node(Node.Type.VARIABLE, m417E());
        if (isDefaultToken(peekAtCurentToken())) {
            advanceTokenPointer();
            node.defaultPart = m417E();
        }
        return node;
    }

    private boolean isDefaultToken(Token token) {
        return token != null && token.type == Token.Type.DEFAULT;
    }

    private Node makeNewLiteralNode(String str) {
        return new Node(Node.Type.LITERAL, str);
    }

    void advanceTokenPointer() {
        this.pointer++;
    }

    void expectCurlyRight(Token token) throws ScanException {
        expectNotNull(token, "}");
        if (token.type != Token.Type.CURLY_RIGHT) {
            throw new ScanException("Expecting }");
        }
    }

    void expectNotNull(Token token, String str) {
        if (token != null) {
            return;
        }
        throw new IllegalArgumentException("All tokens consumed but was expecting \"" + str + "\"");
    }

    public Node parse() throws ScanException {
        List list = this.tokenList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return m417E();
    }

    Token peekAtCurentToken() {
        if (this.pointer < this.tokenList.size()) {
            return (Token) this.tokenList.get(this.pointer);
        }
        return null;
    }
}
