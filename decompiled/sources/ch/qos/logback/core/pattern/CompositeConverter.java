package ch.qos.logback.core.pattern;

/* loaded from: classes2.dex */
public abstract class CompositeConverter<E> extends DynamicConverter<E> {
    Converter childConverter;

    @Override // ch.qos.logback.core.pattern.Converter
    public String convert(E e) {
        StringBuilder sb = new StringBuilder();
        for (Converter converter = this.childConverter; converter != null; converter = converter.next) {
            converter.write(sb, e);
        }
        return transform(e, sb.toString());
    }

    public Converter<E> getChildConverter() {
        return this.childConverter;
    }

    public void setChildConverter(Converter<E> converter) {
        this.childConverter = converter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompositeConverter<");
        FormatInfo formatInfo = this.formattingInfo;
        if (formatInfo != null) {
            sb.append(formatInfo);
        }
        if (this.childConverter != null) {
            sb.append(", children: ");
            sb.append(this.childConverter);
        }
        sb.append(">");
        return sb.toString();
    }

    protected abstract String transform(E e, String str);
}
