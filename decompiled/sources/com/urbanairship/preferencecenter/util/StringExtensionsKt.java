package com.urbanairship.preferencecenter.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007\"\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007\"\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"", "markdownToHtml", "(Ljava/lang/String;)Ljava/lang/String;", "markdown", "basicMarkdownToHtml", "Lkotlin/text/Regex;", "linkRegex", "Lkotlin/text/Regex;", "boldRegex", "italicRegex", "underlineRegex", "urbanairship-preference-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StringExtensionsKt {
    private static final Regex linkRegex = new Regex("\\[(.*?)\\]\\((.*?)\\)");
    private static final Regex boldRegex = new Regex("\\*\\*(.*?)\\*\\*");
    private static final Regex italicRegex = new Regex("\\*(.*?)\\*");
    private static final Regex underlineRegex = new Regex("__(.*?)__");

    @NotNull
    public static final String markdownToHtml(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return basicMarkdownToHtml(str);
    }

    private static final String basicMarkdownToHtml(String str) {
        return underlineRegex.replace(italicRegex.replace(boldRegex.replace(linkRegex.replace(str, "<a href=\"$2\">$1</a>"), "<b>$1</b>"), "<i>$1</i>"), "<u>$1</u>");
    }
}
