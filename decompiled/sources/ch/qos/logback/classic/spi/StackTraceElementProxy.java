package ch.qos.logback.classic.spi;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class StackTraceElementProxy implements Serializable {
    private static final long serialVersionUID = -2374374378980555982L;
    private ClassPackagingData cpd;
    final StackTraceElement ste;
    private transient String steAsString;

    public StackTraceElementProxy(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            throw new IllegalArgumentException("ste cannot be null");
        }
        this.ste = stackTraceElement;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StackTraceElementProxy stackTraceElementProxy = (StackTraceElementProxy) obj;
        if (!this.ste.equals(stackTraceElementProxy.ste)) {
            return false;
        }
        ClassPackagingData classPackagingData = this.cpd;
        if (classPackagingData == null) {
            if (stackTraceElementProxy.cpd != null) {
                return false;
            }
        } else if (!classPackagingData.equals(stackTraceElementProxy.cpd)) {
            return false;
        }
        return true;
    }

    public ClassPackagingData getClassPackagingData() {
        return this.cpd;
    }

    public String getSTEAsString() {
        if (this.steAsString == null) {
            this.steAsString = "at " + this.ste.toString();
        }
        return this.steAsString;
    }

    public StackTraceElement getStackTraceElement() {
        return this.ste;
    }

    public int hashCode() {
        return this.ste.hashCode();
    }

    public void setClassPackagingData(ClassPackagingData classPackagingData) {
        if (this.cpd != null) {
            throw new IllegalStateException("Packaging data has been already set");
        }
        this.cpd = classPackagingData;
    }

    public String toString() {
        return getSTEAsString();
    }
}
