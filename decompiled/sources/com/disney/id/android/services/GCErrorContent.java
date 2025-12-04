package com.disney.id.android.services;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/disney/id/android/services/GCErrorContent;", "", "text", "", "links", "", "Lcom/disney/id/android/services/GCErrorContentLink;", "(Ljava/lang/String;Ljava/util/List;)V", "getLinks", "()Ljava/util/List;", "setLinks", "(Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GCErrorContent {

    @Nullable
    private List<GCErrorContentLink> links;

    @Nullable
    private String text;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GCErrorContent copy$default(GCErrorContent gCErrorContent, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gCErrorContent.text;
        }
        if ((i & 2) != 0) {
            list = gCErrorContent.links;
        }
        return gCErrorContent.copy(str, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final List<GCErrorContentLink> component2() {
        return this.links;
    }

    @NotNull
    public final GCErrorContent copy(@Nullable String text, @Nullable List<GCErrorContentLink> links) {
        return new GCErrorContent(text, links);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GCErrorContent)) {
            return false;
        }
        GCErrorContent gCErrorContent = (GCErrorContent) other;
        return Intrinsics.areEqual(this.text, gCErrorContent.text) && Intrinsics.areEqual(this.links, gCErrorContent.links);
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<GCErrorContentLink> list = this.links;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GCErrorContent(text=" + this.text + ", links=" + this.links + ")";
    }

    public GCErrorContent(@Nullable String str, @Nullable List<GCErrorContentLink> list) {
        this.text = str;
        this.links = list;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    @Nullable
    public final List<GCErrorContentLink> getLinks() {
        return this.links;
    }

    public final void setLinks(@Nullable List<GCErrorContentLink> list) {
        this.links = list;
    }
}
