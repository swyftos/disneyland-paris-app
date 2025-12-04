package ch.qos.logback.core.rolling;

import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.helper.CompressionMode;
import ch.qos.logback.core.rolling.helper.FileNamePattern;
import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes2.dex */
public abstract class RollingPolicyBase extends ContextAwareBase implements RollingPolicy {
    protected CompressionMode compressionMode = CompressionMode.NONE;
    FileNamePattern fileNamePattern;
    protected String fileNamePatternStr;
    private FileAppender parent;
    private boolean started;
    FileNamePattern zipEntryFileNamePattern;

    protected void determineCompressionMode() {
        CompressionMode compressionMode;
        if (this.fileNamePatternStr.endsWith(".gz")) {
            addInfo("Will use gz compression");
            compressionMode = CompressionMode.GZ;
        } else if (this.fileNamePatternStr.endsWith(".zip")) {
            addInfo("Will use zip compression");
            compressionMode = CompressionMode.ZIP;
        } else {
            addInfo("No compression will be used");
            compressionMode = CompressionMode.NONE;
        }
        this.compressionMode = compressionMode;
    }

    @Override // ch.qos.logback.core.rolling.RollingPolicy
    public CompressionMode getCompressionMode() {
        return this.compressionMode;
    }

    public String getFileNamePattern() {
        return this.fileNamePatternStr;
    }

    public String getParentsRawFileProperty() {
        return this.parent.rawFileProperty();
    }

    public boolean isParentPrudent() {
        return this.parent.isPrudent();
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    public void setFileNamePattern(String str) {
        this.fileNamePatternStr = str;
    }

    @Override // ch.qos.logback.core.rolling.RollingPolicy
    public void setParent(FileAppender<?> fileAppender) {
        this.parent = fileAppender;
    }

    public void start() {
        this.started = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.started = false;
    }
}
