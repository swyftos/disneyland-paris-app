package gherkin;

import gherkin.Parser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class AstNode {
    public final Parser.RuleType ruleType;
    private final Map subItems = new HashMap();

    public AstNode(Parser.RuleType ruleType) {
        this.ruleType = ruleType;
    }

    public void add(Parser.RuleType ruleType, Object obj) {
        List arrayList = (List) this.subItems.get(ruleType);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.subItems.put(ruleType, arrayList);
        }
        arrayList.add(obj);
    }

    public <T> T getSingle(Parser.RuleType ruleType, T t) {
        List<T> items = getItems(ruleType);
        return items.isEmpty() ? t : items.get(0);
    }

    public <T> List<T> getItems(Parser.RuleType ruleType) {
        List<T> list = (List) this.subItems.get(ruleType);
        return list == null ? Collections.emptyList() : list;
    }

    public Token getToken(Parser.TokenType tokenType) {
        return (Token) getSingle(Parser.RuleType.cast(tokenType), new Token(null, null));
    }

    public List<Token> getTokens(Parser.TokenType tokenType) {
        return getItems(Parser.RuleType.cast(tokenType));
    }
}
