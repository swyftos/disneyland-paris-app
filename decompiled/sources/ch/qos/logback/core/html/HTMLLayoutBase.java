package ch.qos.logback.core.html;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.ConverterUtil;
import ch.qos.logback.core.pattern.parser.Parser;
import ch.qos.logback.core.spi.ScanException;
import com.amazonaws.services.s3.util.Mimetypes;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class HTMLLayoutBase<E> extends LayoutBase<E> {
    protected CssBuilder cssBuilder;
    protected Converter<E> head;
    protected String pattern;
    protected String title = "Logback Log Messages";
    protected long counter = 0;

    private void buildHeaderRowForTable(StringBuilder sb) {
        sb.append("<tr class=\"header\">");
        sb.append(CoreConstants.LINE_SEPARATOR);
        for (Converter<E> next = this.head; next != null; next = next.getNext()) {
            if (computeConverterName(next) != null) {
                sb.append("<td class=\"");
                sb.append(computeConverterName(next));
                sb.append("\">");
                sb.append(computeConverterName(next));
                sb.append("</td>");
                sb.append(CoreConstants.LINE_SEPARATOR);
            }
        }
        sb.append("</tr>");
        sb.append(CoreConstants.LINE_SEPARATOR);
    }

    protected String computeConverterName(Converter<E> converter) {
        String simpleName = converter.getClass().getSimpleName();
        int iIndexOf = simpleName.indexOf("Converter");
        return iIndexOf == -1 ? simpleName : simpleName.substring(0, iIndexOf);
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getContentType() {
        return Mimetypes.MIMETYPE_HTML;
    }

    public CssBuilder getCssBuilder() {
        return this.cssBuilder;
    }

    protected abstract Map<String, String> getDefaultConverterMap();

    public Map<String, String> getEffectiveConverterMap() {
        Map map;
        HashMap map2 = new HashMap();
        Map<String, String> defaultConverterMap = getDefaultConverterMap();
        if (defaultConverterMap != null) {
            map2.putAll(defaultConverterMap);
        }
        Context context = getContext();
        if (context != null && (map = (Map) context.getObject(CoreConstants.PATTERN_RULE_REGISTRY)) != null) {
            map2.putAll(map);
        }
        return map2;
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getFileFooter() {
        return CoreConstants.LINE_SEPARATOR + "</body></html>";
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getFileHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
        sb.append(" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        String str = CoreConstants.LINE_SEPARATOR;
        sb.append(str);
        sb.append("<html>");
        sb.append(str);
        sb.append("  <head>");
        sb.append(str);
        sb.append("    <title>");
        sb.append(this.title);
        sb.append("</title>");
        sb.append(str);
        this.cssBuilder.addCss(sb);
        sb.append(str);
        sb.append("  </head>");
        sb.append(str);
        sb.append("<body>");
        sb.append(str);
        return sb.toString();
    }

    public String getPattern() {
        return this.pattern;
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getPresentationFooter() {
        return "</table>";
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getPresentationHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append("<hr/>");
        String str = CoreConstants.LINE_SEPARATOR;
        sb.append(str);
        sb.append("<p>Log session start time ");
        sb.append(new Date());
        sb.append("</p><p></p>");
        sb.append(str);
        sb.append(str);
        sb.append("<table cellspacing=\"0\">");
        sb.append(str);
        buildHeaderRowForTable(sb);
        return sb.toString();
    }

    public String getTitle() {
        return this.title;
    }

    public void setCssBuilder(CssBuilder cssBuilder) {
        this.cssBuilder = cssBuilder;
    }

    public void setPattern(String str) {
        this.pattern = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        try {
            Parser parser = new Parser(this.pattern);
            parser.setContext(getContext());
            Converter<E> converterCompile = parser.compile(parser.parse(), getEffectiveConverterMap());
            this.head = converterCompile;
            ConverterUtil.startConverters(converterCompile);
            this.started = true;
        } catch (ScanException e) {
            addError("Incorrect pattern found", e);
        }
    }

    protected void startNewTableIfLimitReached(StringBuilder sb) {
        if (this.counter >= 10000) {
            this.counter = 0L;
            sb.append("</table>");
            String str = CoreConstants.LINE_SEPARATOR;
            sb.append(str);
            sb.append("<p></p>");
            sb.append("<table cellspacing=\"0\">");
            sb.append(str);
            buildHeaderRowForTable(sb);
        }
    }
}
