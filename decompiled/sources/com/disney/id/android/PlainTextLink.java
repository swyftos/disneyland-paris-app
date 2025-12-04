package com.disney.id.android;

import androidx.annotation.Keep;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/disney/id/android/PlainTextLink;", "", ViewProps.START, "", "text", "", "href", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getHref", "()Ljava/lang/String;", "getStart", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/disney/id/android/PlainTextLink;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PlainTextLink {

    @Nullable
    private final String href;

    @Nullable
    private final Integer start;

    @Nullable
    private final String text;

    public static /* synthetic */ PlainTextLink copy$default(PlainTextLink plainTextLink, Integer num, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = plainTextLink.start;
        }
        if ((i & 2) != 0) {
            str = plainTextLink.text;
        }
        if ((i & 4) != 0) {
            str2 = plainTextLink.href;
        }
        return plainTextLink.copy(num, str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getStart() {
        return this.start;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getHref() {
        return this.href;
    }

    @NotNull
    public final PlainTextLink copy(@Nullable Integer start, @Nullable String text, @Nullable String href) {
        return new PlainTextLink(start, text, href);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlainTextLink)) {
            return false;
        }
        PlainTextLink plainTextLink = (PlainTextLink) other;
        return Intrinsics.areEqual(this.start, plainTextLink.start) && Intrinsics.areEqual(this.text, plainTextLink.text) && Intrinsics.areEqual(this.href, plainTextLink.href);
    }

    public int hashCode() {
        Integer num = this.start;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.text;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.href;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlainTextLink(start=" + this.start + ", text=" + this.text + ", href=" + this.href + ")";
    }

    public PlainTextLink(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        this.start = num;
        this.text = str;
        this.href = str2;
    }

    @Nullable
    public final Integer getStart() {
        return this.start;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getHref() {
        return this.href;
    }
}
