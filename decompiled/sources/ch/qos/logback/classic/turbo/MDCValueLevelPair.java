package ch.qos.logback.classic.turbo;

import ch.qos.logback.classic.Level;

/* loaded from: classes2.dex */
public class MDCValueLevelPair {
    private Level level;
    private String value;

    public Level getLevel() {
        return this.level;
    }

    public String getValue() {
        return this.value;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
