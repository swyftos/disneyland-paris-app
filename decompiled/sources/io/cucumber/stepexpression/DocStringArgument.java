package io.cucumber.stepexpression;

/* loaded from: classes5.dex */
public final class DocStringArgument implements Argument {
    private final String argument;
    private final DocStringTransformer docStringType;

    DocStringArgument(DocStringTransformer docStringTransformer, String str) {
        this.docStringType = docStringTransformer;
        this.argument = str;
    }

    @Override // io.cucumber.stepexpression.Argument
    public Object getValue() {
        return this.docStringType.transform(this.argument);
    }

    public String toString() {
        return "DocString: " + this.argument;
    }
}
