package com.urbanairship.android.layout.util;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u001a)\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0007\"\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f\"\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f\"\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\f\"\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\f\"\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\f\"\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\f\"\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\f¨\u0006\u0014"}, d2 = {"", "Lkotlin/Function1;", "", "block", "ifNotEmpty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "markdownToHtml", "(Ljava/lang/String;)Ljava/lang/String;", "markdown", "basicMarkdownToHtml", "Lkotlin/text/Regex;", "linkRegex", "Lkotlin/text/Regex;", "boldAndItalicRegexStar", "boldAndItalicRegexBar", "boldRegexStar", "boldRegexBar", "italicRegexStar", "italicRegexBar", "strikethroughRegex", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStringExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringExtensions.kt\ncom/urbanairship/android/layout/util/StringExtensionsKt\n+ 2 String.kt\nandroidx/core/text/StringKt\n*L\n1#1,78:1\n28#2:79\n*S KotlinDebug\n*F\n+ 1 StringExtensions.kt\ncom/urbanairship/android/layout/util/StringExtensionsKt\n*L\n61#1:79\n*E\n"})
/* loaded from: classes5.dex */
public final class StringExtensionsKt {
    private static final Regex linkRegex = new Regex("\\[(.+?)\\]\\((.+?)\\)");
    private static final Regex boldAndItalicRegexStar = new Regex("(?<!\\*)\\*\\*\\*(?!\\*)(.*?)(?<!\\*)\\*\\*\\*(?!\\*)");
    private static final Regex boldAndItalicRegexBar = new Regex("(?<!_)___(?!_)(.*?)(?<!_)___(?!_)");
    private static final Regex boldRegexStar = new Regex("(?<!\\*)\\*\\*(?!\\*)(.*?)(?<!\\*)\\*\\*(?!\\*)");
    private static final Regex boldRegexBar = new Regex("(?<!_)__(?!_)(.*?)(?<!_)__(?!_)");
    private static final Regex italicRegexStar = new Regex("(?<!\\*)\\*(?!\\*)(.*?)(?<!\\*)\\*(?!\\*)");
    private static final Regex italicRegexBar = new Regex("(?<!_)_(?!_)(.*?)(?<!_)_(?!_)");
    private static final Regex strikethroughRegex = new Regex("(?<!~)~~(?!~)(.*?)(?<!~)~~(?!~)");

    public static final void ifNotEmpty(@Nullable String str, @NotNull Function1<? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (str == null || str.length() == 0) {
            return;
        }
        block.invoke(str);
    }

    @NotNull
    public static final String markdownToHtml(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return basicMarkdownToHtml(str);
    }

    private static final String basicMarkdownToHtml(String str) {
        return strikethroughRegex.replace(italicRegexBar.replace(italicRegexStar.replace(boldRegexBar.replace(boldRegexStar.replace(boldAndItalicRegexBar.replace(boldAndItalicRegexStar.replace(linkRegex.replace(StringsKt.replace$default(StringsKt.replace$default(TextUtils.htmlEncode(str), "\n", "<br>", false, 4, (Object) null), "\\n", "<br>", false, 4, (Object) null), "<a href=\"$2\">$1</a>"), "<b><i>$1</i></b>"), "<b><i>$1</i></b>"), "<b>$1</b>"), "<b>$1</b>"), "<i>$1</i>"), "<i>$1</i>"), "<s>$1</s>");
    }
}
