package ch.qos.logback.core.rolling;

import ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP;
import ch.qos.logback.core.util.FileSize;

/* loaded from: classes2.dex */
public class SizeAndTimeBasedRollingPolicy<E> extends TimeBasedRollingPolicy<E> {
    FileSize maxFileSize;

    public void setMaxFileSize(FileSize fileSize) {
        this.maxFileSize = fileSize;
    }

    @Override // ch.qos.logback.core.rolling.TimeBasedRollingPolicy, ch.qos.logback.core.rolling.RollingPolicyBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        String str;
        SizeAndTimeBasedFNATP sizeAndTimeBasedFNATP = new SizeAndTimeBasedFNATP(SizeAndTimeBasedFNATP.Usage.EMBEDDED);
        if (this.maxFileSize == null) {
            str = "maxFileSize property is mandatory";
        } else {
            addInfo("Archive files will be limited to [" + this.maxFileSize + "] each.");
            sizeAndTimeBasedFNATP.setMaxFileSize(this.maxFileSize);
            this.timeBasedFileNamingAndTriggeringPolicy = sizeAndTimeBasedFNATP;
            if (isUnboundedTotalSizeCap() || this.totalSizeCap.getSize() >= this.maxFileSize.getSize()) {
                super.start();
                return;
            }
            str = "totalSizeCap of [" + this.totalSizeCap + "] is smaller than maxFileSize [" + this.maxFileSize + "] which is non-sensical";
        }
        addError(str);
    }

    @Override // ch.qos.logback.core.rolling.TimeBasedRollingPolicy
    public String toString() {
        return "c.q.l.core.rolling.SizeAndTimeBasedRollingPolicy@" + hashCode();
    }
}
