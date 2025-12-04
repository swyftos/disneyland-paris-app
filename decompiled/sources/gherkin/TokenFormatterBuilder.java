package gherkin;

import gherkin.Parser;

/* loaded from: classes5.dex */
public class TokenFormatterBuilder implements Parser.Builder<String> {
    private final TokenFormatter formatter = new TokenFormatter();
    private final StringBuilder tokensTextBuilder = new StringBuilder();

    @Override // gherkin.Parser.Builder
    public void endRule(Parser.RuleType ruleType) {
    }

    @Override // gherkin.Parser.Builder
    public void reset() {
    }

    @Override // gherkin.Parser.Builder
    public void startRule(Parser.RuleType ruleType) {
    }

    @Override // gherkin.Parser.Builder
    public void build(Token token) {
        StringBuilder sb = this.tokensTextBuilder;
        sb.append(this.formatter.formatToken(token));
        sb.append("\n");
    }

    @Override // gherkin.Parser.Builder
    public String getResult() {
        return this.tokensTextBuilder.toString();
    }
}
