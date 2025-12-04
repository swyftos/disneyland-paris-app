package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.ConverterUtil;
import ch.qos.logback.core.pattern.LiteralConverter;
import ch.qos.logback.core.pattern.parser.Parser;
import ch.qos.logback.core.pattern.util.AlmostAsIsEscapeUtil;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.ScanException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class FileNamePattern extends ContextAwareBase {
    static final Map CONVERTER_MAP;
    Converter headTokenConverter;
    String pattern;

    static {
        HashMap map = new HashMap();
        CONVERTER_MAP = map;
        map.put("i", IntegerTokenConverter.class.getName());
        map.put("d", DateTokenConverter.class.getName());
    }

    public FileNamePattern(String str, Context context) {
        setPattern(FileFilterUtil.slashify(str));
        setContext(context);
        parse();
        ConverterUtil.startConverters(this.headTokenConverter);
    }

    public String convert(Object obj) {
        StringBuilder sb = new StringBuilder();
        for (Converter next = this.headTokenConverter; next != null; next = next.getNext()) {
            sb.append(next.convert(obj));
        }
        return sb.toString();
    }

    public String convertInt(int i) {
        return convert(Integer.valueOf(i));
    }

    public String convertMultipleArguments(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Converter next = this.headTokenConverter; next != null; next = next.getNext()) {
            if (next instanceof MonoTypedConverter) {
                MonoTypedConverter monoTypedConverter = (MonoTypedConverter) next;
                for (Object obj : objArr) {
                    if (monoTypedConverter.isApplicable(obj)) {
                        sb.append(next.convert(obj));
                    }
                }
            } else {
                sb.append(next.convert(objArr));
            }
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FileNamePattern fileNamePattern = (FileNamePattern) obj;
        String str = this.pattern;
        if (str == null) {
            if (fileNamePattern.pattern != null) {
                return false;
            }
        } else if (!str.equals(fileNamePattern.pattern)) {
            return false;
        }
        return true;
    }

    String escapeRightParantesis(String str) {
        return this.pattern.replace(")", "\\)");
    }

    public IntegerTokenConverter getIntegerTokenConverter() {
        for (Converter next = this.headTokenConverter; next != null; next = next.getNext()) {
            if (next instanceof IntegerTokenConverter) {
                return (IntegerTokenConverter) next;
            }
        }
        return null;
    }

    public String getPattern() {
        return this.pattern;
    }

    public DateTokenConverter<Object> getPrimaryDateTokenConverter() {
        for (Converter next = this.headTokenConverter; next != null; next = next.getNext()) {
            if (next instanceof DateTokenConverter) {
                DateTokenConverter<Object> dateTokenConverter = (DateTokenConverter) next;
                if (dateTokenConverter.isPrimary()) {
                    return dateTokenConverter;
                }
            }
        }
        return null;
    }

    public boolean hasIntegerTokenCOnverter() {
        return getIntegerTokenConverter() != null;
    }

    public int hashCode() {
        String str = this.pattern;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    void parse() {
        try {
            Parser parser = new Parser(escapeRightParantesis(this.pattern), new AlmostAsIsEscapeUtil());
            parser.setContext(this.context);
            this.headTokenConverter = parser.compile(parser.parse(), CONVERTER_MAP);
        } catch (ScanException e) {
            addError("Failed to parse pattern \"" + this.pattern + "\".", e);
        }
    }

    public void setPattern(String str) {
        if (str != null) {
            this.pattern = str.trim().replace("//", "/");
        }
    }

    public String toRegex() {
        return toRegex(false, false);
    }

    public String toRegex(boolean z, boolean z2) {
        String regex;
        String strRegexEscapePath;
        StringBuilder sb = new StringBuilder();
        for (Converter next = this.headTokenConverter; next != null; next = next.getNext()) {
            if (next instanceof LiteralConverter) {
                strRegexEscapePath = next.convert(null);
            } else {
                if (next instanceof IntegerTokenConverter) {
                    regex = z2 ? "(\\d+)" : "\\d+";
                } else if (next instanceof DateTokenConverter) {
                    DateTokenConverter dateTokenConverter = (DateTokenConverter) next;
                    regex = (z && dateTokenConverter.isPrimary()) ? "(" + dateTokenConverter.toRegex() + ")" : dateTokenConverter.toRegex();
                }
                strRegexEscapePath = FileFinder.regexEscapePath(regex);
            }
            sb.append(strRegexEscapePath);
        }
        return sb.toString();
    }

    public String toRegexForFixedDate(Date date) {
        String regex;
        String strConvert;
        StringBuilder sb = new StringBuilder();
        for (Converter next = this.headTokenConverter; next != null; next = next.getNext()) {
            if (next instanceof LiteralConverter) {
                strConvert = next.convert(null);
            } else {
                if (next instanceof IntegerTokenConverter) {
                    regex = "(\\d+)";
                } else if (next instanceof DateTokenConverter) {
                    DateTokenConverter dateTokenConverter = (DateTokenConverter) next;
                    if (dateTokenConverter.isPrimary()) {
                        strConvert = next.convert(date);
                    } else {
                        regex = dateTokenConverter.toRegex();
                    }
                }
                strConvert = FileFinder.regexEscapePath(regex);
            }
            sb.append(strConvert);
        }
        return sb.toString();
    }

    public String toString() {
        return this.pattern;
    }
}
