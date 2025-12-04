package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.util.IEscapeUtil;
import ch.qos.logback.core.pattern.util.RestrictedEscapeUtil;
import ch.qos.logback.core.spi.ScanException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class TokenStream {
    final IEscapeUtil escapeUtil;
    final String pattern;
    final int patternLength;
    final IEscapeUtil optionEscapeUtil = new RestrictedEscapeUtil();
    TokenizerState state = TokenizerState.LITERAL_STATE;
    int pointer = 0;

    /* renamed from: ch.qos.logback.core.pattern.parser.TokenStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState;

        static {
            int[] iArr = new int[TokenizerState.values().length];
            $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState = iArr;
            try {
                iArr[TokenizerState.LITERAL_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[TokenizerState.FORMAT_MODIFIER_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[TokenizerState.OPTION_STATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[TokenizerState.KEYWORD_STATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[TokenizerState.RIGHT_PARENTHESIS_STATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    enum TokenizerState {
        LITERAL_STATE,
        FORMAT_MODIFIER_STATE,
        KEYWORD_STATE,
        OPTION_STATE,
        RIGHT_PARENTHESIS_STATE
    }

    TokenStream(String str, IEscapeUtil iEscapeUtil) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("null or empty pattern string not allowed");
        }
        this.pattern = str;
        this.patternLength = str.length();
        this.escapeUtil = iEscapeUtil;
    }

    private void addValuedToken(int i, StringBuffer stringBuffer, List list) {
        if (stringBuffer.length() > 0) {
            list.add(new Token(i, stringBuffer.toString()));
            stringBuffer.setLength(0);
        }
    }

    private void handleFormatModifierState(char c, List list, StringBuffer stringBuffer) {
        if (c == '(') {
            addValuedToken(1002, stringBuffer, list);
            list.add(Token.BARE_COMPOSITE_KEYWORD_TOKEN);
            this.state = TokenizerState.LITERAL_STATE;
        } else {
            if (Character.isJavaIdentifierStart(c)) {
                addValuedToken(1002, stringBuffer, list);
                this.state = TokenizerState.KEYWORD_STATE;
            }
            stringBuffer.append(c);
        }
    }

    private void handleKeywordState(char c, List list, StringBuffer stringBuffer) {
        TokenizerState tokenizerState;
        if (Character.isJavaIdentifierPart(c)) {
            stringBuffer.append(c);
            return;
        }
        if (c == '{') {
            addValuedToken(1004, stringBuffer, list);
            tokenizerState = TokenizerState.OPTION_STATE;
        } else {
            if (c == '(') {
                addValuedToken(1005, stringBuffer, list);
            } else if (c == '%') {
                addValuedToken(1004, stringBuffer, list);
                list.add(Token.PERCENT_TOKEN);
                tokenizerState = TokenizerState.FORMAT_MODIFIER_STATE;
            } else {
                addValuedToken(1004, stringBuffer, list);
                if (c == ')') {
                    tokenizerState = TokenizerState.RIGHT_PARENTHESIS_STATE;
                } else if (c == '\\') {
                    int i = this.pointer;
                    if (i < this.patternLength) {
                        String str = this.pattern;
                        this.pointer = i + 1;
                        this.escapeUtil.escape("%()", stringBuffer, str.charAt(i), this.pointer);
                    }
                } else {
                    stringBuffer.append(c);
                }
            }
            tokenizerState = TokenizerState.LITERAL_STATE;
        }
        this.state = tokenizerState;
    }

    private void handleLiteralState(char c, List list, StringBuffer stringBuffer) {
        TokenizerState tokenizerState;
        if (c == '%') {
            addValuedToken(1000, stringBuffer, list);
            list.add(Token.PERCENT_TOKEN);
            tokenizerState = TokenizerState.FORMAT_MODIFIER_STATE;
        } else {
            if (c != ')') {
                if (c != '\\') {
                    stringBuffer.append(c);
                    return;
                } else {
                    escape("%()", stringBuffer);
                    return;
                }
            }
            addValuedToken(1000, stringBuffer, list);
            tokenizerState = TokenizerState.RIGHT_PARENTHESIS_STATE;
        }
        this.state = tokenizerState;
    }

    private void handleRightParenthesisState(char c, List list, StringBuffer stringBuffer) {
        TokenizerState tokenizerState;
        list.add(Token.RIGHT_PARENTHESIS_TOKEN);
        if (c != ')') {
            if (c == '\\') {
                escape("%{}", stringBuffer);
            } else {
                if (c == '{') {
                    tokenizerState = TokenizerState.OPTION_STATE;
                    this.state = tokenizerState;
                }
                stringBuffer.append(c);
            }
            tokenizerState = TokenizerState.LITERAL_STATE;
            this.state = tokenizerState;
        }
    }

    private void processOption(char c, List list, StringBuffer stringBuffer) throws ScanException {
        new OptionTokenizer(this).tokenize(c, list);
    }

    void escape(String str, StringBuffer stringBuffer) {
        int i = this.pointer;
        if (i < this.patternLength) {
            String str2 = this.pattern;
            this.pointer = i + 1;
            this.escapeUtil.escape(str, stringBuffer, str2.charAt(i), this.pointer);
        }
    }

    List tokenize() throws ScanException {
        Token token;
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i = this.pointer;
            if (i >= this.patternLength) {
                break;
            }
            char cCharAt = this.pattern.charAt(i);
            this.pointer++;
            int i2 = AnonymousClass1.$SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[this.state.ordinal()];
            if (i2 == 1) {
                handleLiteralState(cCharAt, arrayList, stringBuffer);
            } else if (i2 == 2) {
                handleFormatModifierState(cCharAt, arrayList, stringBuffer);
            } else if (i2 == 3) {
                processOption(cCharAt, arrayList, stringBuffer);
            } else if (i2 == 4) {
                handleKeywordState(cCharAt, arrayList, stringBuffer);
            } else if (i2 == 5) {
                handleRightParenthesisState(cCharAt, arrayList, stringBuffer);
            }
        }
        int i3 = AnonymousClass1.$SwitchMap$ch$qos$logback$core$pattern$parser$TokenStream$TokenizerState[this.state.ordinal()];
        if (i3 == 1) {
            addValuedToken(1000, stringBuffer, arrayList);
        } else {
            if (i3 == 2 || i3 == 3) {
                throw new ScanException("Unexpected end of pattern string");
            }
            if (i3 == 4) {
                token = new Token(1004, stringBuffer.toString());
            } else if (i3 == 5) {
                token = Token.RIGHT_PARENTHESIS_TOKEN;
            }
            arrayList.add(token);
        }
        return arrayList;
    }
}
