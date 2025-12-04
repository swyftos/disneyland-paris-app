package ch.qos.logback.core.pattern;

/* loaded from: classes2.dex */
public abstract class FormattingConverter<E> extends Converter<E> {
    FormatInfo formattingInfo;

    public final FormatInfo getFormattingInfo() {
        return this.formattingInfo;
    }

    public final void setFormattingInfo(FormatInfo formatInfo) {
        if (this.formattingInfo != null) {
            throw new IllegalStateException("FormattingInfo has been already set");
        }
        this.formattingInfo = formatInfo;
    }

    @Override // ch.qos.logback.core.pattern.Converter
    public final void write(StringBuilder sb, E e) {
        String strConvert = convert(e);
        FormatInfo formatInfo = this.formattingInfo;
        if (formatInfo == null) {
            sb.append(strConvert);
            return;
        }
        int min = formatInfo.getMin();
        int max = this.formattingInfo.getMax();
        if (strConvert == null) {
            if (min > 0) {
                SpacePadder.spacePad(sb, min);
                return;
            }
            return;
        }
        int length = strConvert.length();
        if (length > max) {
            sb.append(this.formattingInfo.isLeftTruncate() ? strConvert.substring(length - max) : strConvert.substring(0, max));
            return;
        }
        if (length >= min) {
            sb.append(strConvert);
        } else if (this.formattingInfo.isLeftPad()) {
            SpacePadder.leftPad(sb, strConvert, min);
        } else {
            SpacePadder.rightPad(sb, strConvert, min);
        }
    }
}
