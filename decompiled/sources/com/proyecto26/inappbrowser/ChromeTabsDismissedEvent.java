package com.proyecto26.inappbrowser;

/* loaded from: classes4.dex */
public class ChromeTabsDismissedEvent {
    public final Boolean isError;
    public final String message;
    public final String resultType;

    public ChromeTabsDismissedEvent(String str, String str2, Boolean bool) {
        this.message = str;
        this.resultType = str2;
        this.isError = bool;
    }
}
