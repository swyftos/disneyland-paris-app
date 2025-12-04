package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JU\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006'"}, d2 = {"Lcom/disney/id/android/MarketingDetail;", "", "code", "", "displayCheckbox", "", "preselected", "subscribed", "text", "textId", "links", "", "Lcom/disney/id/android/PlainTextLink;", "(Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCode", "()Ljava/lang/String;", "getDisplayCheckbox", "()Z", "getLinks", "()Ljava/util/List;", "getPreselected", "getSubscribed", "setSubscribed", "(Z)V", "getText", "getTextId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MarketingDetail {

    @NotNull
    private final String code;
    private final boolean displayCheckbox;

    @NotNull
    private final List<PlainTextLink> links;
    private final boolean preselected;
    private boolean subscribed;

    @NotNull
    private final String text;

    @NotNull
    private final String textId;

    public static /* synthetic */ MarketingDetail copy$default(MarketingDetail marketingDetail, String str, boolean z, boolean z2, boolean z3, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = marketingDetail.code;
        }
        if ((i & 2) != 0) {
            z = marketingDetail.displayCheckbox;
        }
        boolean z4 = z;
        if ((i & 4) != 0) {
            z2 = marketingDetail.preselected;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = marketingDetail.subscribed;
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            str2 = marketingDetail.text;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            str3 = marketingDetail.textId;
        }
        String str5 = str3;
        if ((i & 64) != 0) {
            list = marketingDetail.links;
        }
        return marketingDetail.copy(str, z4, z5, z6, str4, str5, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getDisplayCheckbox() {
        return this.displayCheckbox;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getPreselected() {
        return this.preselected;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSubscribed() {
        return this.subscribed;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getTextId() {
        return this.textId;
    }

    @NotNull
    public final List<PlainTextLink> component7() {
        return this.links;
    }

    @NotNull
    public final MarketingDetail copy(@NotNull String code, boolean displayCheckbox, boolean preselected, boolean subscribed, @NotNull String text, @NotNull String textId, @NotNull List<PlainTextLink> links) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textId, "textId");
        Intrinsics.checkNotNullParameter(links, "links");
        return new MarketingDetail(code, displayCheckbox, preselected, subscribed, text, textId, links);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketingDetail)) {
            return false;
        }
        MarketingDetail marketingDetail = (MarketingDetail) other;
        return Intrinsics.areEqual(this.code, marketingDetail.code) && this.displayCheckbox == marketingDetail.displayCheckbox && this.preselected == marketingDetail.preselected && this.subscribed == marketingDetail.subscribed && Intrinsics.areEqual(this.text, marketingDetail.text) && Intrinsics.areEqual(this.textId, marketingDetail.textId) && Intrinsics.areEqual(this.links, marketingDetail.links);
    }

    public int hashCode() {
        return (((((((((((this.code.hashCode() * 31) + Boolean.hashCode(this.displayCheckbox)) * 31) + Boolean.hashCode(this.preselected)) * 31) + Boolean.hashCode(this.subscribed)) * 31) + this.text.hashCode()) * 31) + this.textId.hashCode()) * 31) + this.links.hashCode();
    }

    @NotNull
    public String toString() {
        return "MarketingDetail(code=" + this.code + ", displayCheckbox=" + this.displayCheckbox + ", preselected=" + this.preselected + ", subscribed=" + this.subscribed + ", text=" + this.text + ", textId=" + this.textId + ", links=" + this.links + ")";
    }

    public MarketingDetail(@NotNull String code, boolean z, boolean z2, boolean z3, @NotNull String text, @NotNull String textId, @NotNull List<PlainTextLink> links) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textId, "textId");
        Intrinsics.checkNotNullParameter(links, "links");
        this.code = code;
        this.displayCheckbox = z;
        this.preselected = z2;
        this.subscribed = z3;
        this.text = text;
        this.textId = textId;
        this.links = links;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final boolean getDisplayCheckbox() {
        return this.displayCheckbox;
    }

    public final boolean getPreselected() {
        return this.preselected;
    }

    public final boolean getSubscribed() {
        return this.subscribed;
    }

    public final void setSubscribed(boolean z) {
        this.subscribed = z;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getTextId() {
        return this.textId;
    }

    @NotNull
    public final List<PlainTextLink> getLinks() {
        return this.links;
    }
}
