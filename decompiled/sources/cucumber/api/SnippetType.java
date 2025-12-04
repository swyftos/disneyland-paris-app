package cucumber.api;

import cucumber.runtime.CucumberException;
import cucumber.runtime.snippets.Concatenator;
import cucumber.runtime.snippets.FunctionNameGenerator;

@Deprecated
/* loaded from: classes5.dex */
public enum SnippetType {
    UNDERSCORE("underscore", new Concatenator() { // from class: cucumber.runtime.snippets.UnderscoreConcatenator
        @Override // cucumber.runtime.snippets.Concatenator
        public String concatenate(String[] strArr) {
            StringBuilder sb = new StringBuilder();
            int length = strArr.length;
            boolean z = true;
            int i = 0;
            while (i < length) {
                String lowerCase = strArr[i];
                if (z) {
                    lowerCase = lowerCase.toLowerCase();
                } else {
                    sb.append('_');
                }
                sb.append(lowerCase);
                i++;
                z = false;
            }
            return sb.toString();
        }
    }),
    CAMELCASE("camelcase", new Concatenator() { // from class: cucumber.runtime.snippets.CamelCaseConcatenator
        @Override // cucumber.runtime.snippets.Concatenator
        public String concatenate(String[] strArr) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : strArr) {
                if (z) {
                    sb.append(str.toLowerCase());
                    z = false;
                } else {
                    sb.append(capitalize(str));
                }
            }
            return sb.toString();
        }

        private String capitalize(String str) {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
    });

    private final Concatenator concatenator;
    private final String name;

    SnippetType(String str, Concatenator concatenator) {
        this.name = str;
        this.concatenator = concatenator;
    }

    public static SnippetType fromString(String str) {
        for (SnippetType snippetType : values()) {
            if (str.equalsIgnoreCase(snippetType.name)) {
                return snippetType;
            }
        }
        throw new CucumberException(String.format("Unrecognized SnippetType %s", str));
    }

    public FunctionNameGenerator getFunctionNameGenerator() {
        return new FunctionNameGenerator(this.concatenator);
    }
}
