package com.disney.id.android.services;

import androidx.annotation.Keep;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/disney/id/android/services/GCErrorContentLink;", "", "href", "", "label", ViewProps.START, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getHref", "()Ljava/lang/String;", "setHref", "(Ljava/lang/String;)V", "getLabel", "setLabel", "getStart", "()Ljava/lang/Integer;", "setStart", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/disney/id/android/services/GCErrorContentLink;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GCErrorContentLink {

    @Nullable
    private String href;

    @Nullable
    private String label;

    @Nullable
    private Integer start;

    public static /* synthetic */ GCErrorContentLink copy$default(GCErrorContentLink gCErrorContentLink, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gCErrorContentLink.href;
        }
        if ((i & 2) != 0) {
            str2 = gCErrorContentLink.label;
        }
        if ((i & 4) != 0) {
            num = gCErrorContentLink.start;
        }
        return gCErrorContentLink.copy(str, str2, num);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getHref() {
        return this.href;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getStart() {
        return this.start;
    }

    @NotNull
    public final GCErrorContentLink copy(@Nullable String href, @Nullable String label, @Nullable Integer start) {
        return new GCErrorContentLink(href, label, start);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GCErrorContentLink)) {
            return false;
        }
        GCErrorContentLink gCErrorContentLink = (GCErrorContentLink) other;
        return Intrinsics.areEqual(this.href, gCErrorContentLink.href) && Intrinsics.areEqual(this.label, gCErrorContentLink.label) && Intrinsics.areEqual(this.start, gCErrorContentLink.start);
    }

    public int hashCode() {
        String str = this.href;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.label;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.start;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GCErrorContentLink(href=" + this.href + ", label=" + this.label + ", start=" + this.start + ")";
    }

    public GCErrorContentLink(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        this.href = str;
        this.label = str2;
        this.start = num;
    }

    @Nullable
    public final String getHref() {
        return this.href;
    }

    public final void setHref(@Nullable String str) {
        this.href = str;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(@Nullable String str) {
        this.label = str;
    }

    @Nullable
    public final Integer getStart() {
        return this.start;
    }

    public final void setStart(@Nullable Integer num) {
        this.start = num;
    }
}
