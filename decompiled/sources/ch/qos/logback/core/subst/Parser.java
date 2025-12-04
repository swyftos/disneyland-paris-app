package ch.qos.logback.core.subst;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.ScanException;
import ch.qos.logback.core.subst.Node;
import ch.qos.logback.core.subst.Token;
import java.util.List;

/* loaded from: classes2.dex */
public class Parser {
    int pointer = 0;
    final List tokenList;

    /* renamed from: ch.qos.logback.core.subst.Parser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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

    private Node C() throws ScanException {
        Node nodeE = E();
        if (isDefaultToken(peekAtCurentToken())) {
            advanceTokenPointer();
            nodeE.append(makeNewLiteralNode(CoreConstants.DEFAULT_VALUE_SEPARATOR));
            nodeE.append(E());
        }
        return nodeE;
    }

    private Node E() throws ScanException {
        Node nodeT = T();
        if (nodeT == null) {
            return null;
        }
        Node nodeEopt = Eopt();
        if (nodeEopt != null) {
            nodeT.append(nodeEopt);
        }
        return nodeT;
    }

    private Node Eopt() {
        if (peekAtCurentToken() == null) {
            return null;
        }
        return E();
    }

    private Node T() throws ScanException {
        Token tokenPeekAtCurentToken = peekAtCurentToken();
        int i = AnonymousClass1.$SwitchMap$ch$qos$logback$core$subst$Token$Type[tokenPeekAtCurentToken.type.ordinal()];
        if (i == 1) {
            advanceTokenPointer();
            return makeNewLiteralNode(tokenPeekAtCurentToken.payload);
        }
        if (i != 2) {
            if (i != 3) {
                return null;
            }
            advanceTokenPointer();
            Node nodeV = V();
            expectCurlyRight(peekAtCurentToken());
            advanceTokenPointer();
            return nodeV;
        }
        advanceTokenPointer();
        Node nodeC = C();
        expectCurlyRight(peekAtCurentToken());
        advanceTokenPointer();
        Node nodeMakeNewLiteralNode = makeNewLiteralNode(CoreConstants.LEFT_ACCOLADE);
        nodeMakeNewLiteralNode.append(nodeC);
        nodeMakeNewLiteralNode.append(makeNewLiteralNode(CoreConstants.RIGHT_ACCOLADE));
        return nodeMakeNewLiteralNode;
    }

    private Node V() {
        Node node = new Node(Node.Type.VARIABLE, E());
        if (isDefaultToken(peekAtCurentToken())) {
            advanceTokenPointer();
            node.defaultPart = E();
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
        return E();
    }

    Token peekAtCurentToken() {
        if (this.pointer < this.tokenList.size()) {
            return (Token) this.tokenList.get(this.pointer);
        }
        return null;
    }
}
