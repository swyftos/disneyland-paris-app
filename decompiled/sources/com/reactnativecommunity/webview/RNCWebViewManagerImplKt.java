package com.reactnativecommunity.webview;

import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"invalidCharRegex", "Lkotlin/text/Regex;", "getInvalidCharRegex", "()Lkotlin/text/Regex;", "react-native-webview_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RNCWebViewManagerImplKt {

    @NotNull
    private static final Regex invalidCharRegex = new Regex("[\\\\/%\"]");

    @NotNull
    public static final Regex getInvalidCharRegex() {
        return invalidCharRegex;
    }
}
