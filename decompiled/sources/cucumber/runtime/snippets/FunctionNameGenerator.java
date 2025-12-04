package cucumber.runtime.snippets;

/* loaded from: classes5.dex */
public class FunctionNameGenerator {
    private static final Character SUBST = ' ';
    private final Concatenator concatenator;

    public FunctionNameGenerator(Concatenator concatenator) {
        this.concatenator = concatenator;
    }

    public String generateFunctionName(String str) {
        return this.concatenator.concatenate(removeIllegalCharacters(str).trim().split("\\s"));
    }

    private String removeIllegalCharacters(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Cannot create function name from empty sentence");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.isJavaIdentifierStart(str.charAt(0)) ? str.charAt(0) : SUBST.charValue());
        for (int i = 1; i < str.length(); i++) {
            if (Character.isJavaIdentifierPart(str.charAt(i))) {
                sb.append(str.charAt(i));
            } else {
                char cCharAt = sb.charAt(sb.length() - 1);
                Character ch2 = SUBST;
                if (cCharAt != ch2.charValue() && i != str.length() - 1) {
                    sb.append(ch2);
                }
            }
        }
        return sb.toString();
    }
}
