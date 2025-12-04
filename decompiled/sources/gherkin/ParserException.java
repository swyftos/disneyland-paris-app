package gherkin;

import gherkin.StringUtils;
import gherkin.ast.Location;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class ParserException extends RuntimeException {
    public final Location location;

    protected ParserException(String str) {
        super(str);
        this.location = null;
    }

    protected ParserException(String str, Location location) {
        super(getMessage(str, location));
        this.location = location;
    }

    private static String getMessage(String str, Location location) {
        return String.format("(%s:%s): %s", Integer.valueOf(location.getLine()), Integer.valueOf(location.getColumn()), str);
    }

    public static class AstBuilderException extends ParserException {
        public AstBuilderException(String str, Location location) {
            super(str, location);
        }
    }

    public static class NoSuchLanguageException extends ParserException {
        public NoSuchLanguageException(String str, Location location) {
            super("Language not supported: " + str, location);
        }
    }

    public static class UnexpectedTokenException extends ParserException {
        public final List<String> expectedTokenTypes;
        public final Token receivedToken;
        public String stateComment;

        public UnexpectedTokenException(Token token, List<String> list, String str) {
            super(getMessage(token, list), getLocation(token));
            this.receivedToken = token;
            this.expectedTokenTypes = list;
            this.stateComment = str;
        }

        private static String getMessage(Token token, List list) {
            return String.format("expected: %s, got '%s'", StringUtils.join(", ", list), token.getTokenValue().trim());
        }

        private static Location getLocation(Token token) {
            return token.location.getColumn() > 1 ? token.location : new Location(token.location.getLine(), token.line.indent().intValue() + 1);
        }
    }

    public static class UnexpectedEOFException extends ParserException {
        public final List<String> expectedTokenTypes;
        public final String stateComment;

        public UnexpectedEOFException(Token token, List<String> list, String str) {
            super(getMessage(list), token.location);
            this.expectedTokenTypes = list;
            this.stateComment = str;
        }

        private static String getMessage(List list) {
            return String.format("unexpected end of file, expected: %s", StringUtils.join(", ", list));
        }
    }

    public static class CompositeParserException extends ParserException {
        public final List<ParserException> errors;

        public CompositeParserException(List<ParserException> list) {
            super(getMessage(list));
            this.errors = Collections.unmodifiableList(list);
        }

        private static String getMessage(List list) {
            if (list == null) {
                throw new NullPointerException("errors");
            }
            return "Parser errors:\n" + StringUtils.join(new StringUtils.ToString() { // from class: gherkin.ParserException.CompositeParserException.1
                @Override // gherkin.StringUtils.ToString
                public String toString(ParserException parserException) {
                    return parserException.getMessage();
                }
            }, "\n", list);
        }
    }
}
