package androidx.test.uiautomator;

import androidx.media3.common.C;

/* loaded from: classes2.dex */
public final class Configurator {
    private static Configurator sConfigurator;
    private long mWaitForIdleTimeout = 10000;
    private long mWaitForSelector = 10000;
    private long mWaitForActionAcknowledgment = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private long mScrollEventWaitTimeout = 200;
    private long mKeyInjectionDelay = 0;
    private int mToolType = 1;
    private int mUiAutomationFlags = 0;

    private Configurator() {
    }

    public static Configurator getInstance() {
        if (sConfigurator == null) {
            sConfigurator = new Configurator();
        }
        return sConfigurator;
    }

    public Configurator setWaitForIdleTimeout(long j) {
        this.mWaitForIdleTimeout = j;
        return this;
    }

    public long getWaitForIdleTimeout() {
        return this.mWaitForIdleTimeout;
    }

    public Configurator setWaitForSelectorTimeout(long j) {
        this.mWaitForSelector = j;
        return this;
    }

    public long getWaitForSelectorTimeout() {
        return this.mWaitForSelector;
    }

    public Configurator setScrollAcknowledgmentTimeout(long j) {
        this.mScrollEventWaitTimeout = j;
        return this;
    }

    public long getScrollAcknowledgmentTimeout() {
        return this.mScrollEventWaitTimeout;
    }

    public Configurator setActionAcknowledgmentTimeout(long j) {
        this.mWaitForActionAcknowledgment = j;
        return this;
    }

    public long getActionAcknowledgmentTimeout() {
        return this.mWaitForActionAcknowledgment;
    }

    public Configurator setKeyInjectionDelay(long j) {
        this.mKeyInjectionDelay = j;
        return this;
    }

    public long getKeyInjectionDelay() {
        return this.mKeyInjectionDelay;
    }

    public Configurator setToolType(int i) {
        this.mToolType = i;
        return this;
    }

    public int getToolType() {
        return this.mToolType;
    }

    public Configurator setUiAutomationFlags(int i) {
        this.mUiAutomationFlags = i;
        return this;
    }

    public int getUiAutomationFlags() {
        return this.mUiAutomationFlags;
    }
}
