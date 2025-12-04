package com.urbanairship.android.layout;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J%\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/layout/EmbeddedDisplayRequestResult;", "", "next", "Lcom/urbanairship/android/layout/EmbeddedDisplayRequest;", "list", "", "(Lcom/urbanairship/android/layout/EmbeddedDisplayRequest;Ljava/util/List;)V", "getList", "()Ljava/util/List;", "getNext", "()Lcom/urbanairship/android/layout/EmbeddedDisplayRequest;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class EmbeddedDisplayRequestResult {
    private final List list;
    private final EmbeddedDisplayRequest next;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmbeddedDisplayRequestResult copy$default(EmbeddedDisplayRequestResult embeddedDisplayRequestResult, EmbeddedDisplayRequest embeddedDisplayRequest, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            embeddedDisplayRequest = embeddedDisplayRequestResult.next;
        }
        if ((i & 2) != 0) {
            list = embeddedDisplayRequestResult.list;
        }
        return embeddedDisplayRequestResult.copy(embeddedDisplayRequest, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final EmbeddedDisplayRequest getNext() {
        return this.next;
    }

    @NotNull
    public final List<EmbeddedDisplayRequest> component2() {
        return this.list;
    }

    @NotNull
    public final EmbeddedDisplayRequestResult copy(@Nullable EmbeddedDisplayRequest next, @NotNull List<EmbeddedDisplayRequest> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new EmbeddedDisplayRequestResult(next, list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedDisplayRequestResult)) {
            return false;
        }
        EmbeddedDisplayRequestResult embeddedDisplayRequestResult = (EmbeddedDisplayRequestResult) other;
        return Intrinsics.areEqual(this.next, embeddedDisplayRequestResult.next) && Intrinsics.areEqual(this.list, embeddedDisplayRequestResult.list);
    }

    public int hashCode() {
        EmbeddedDisplayRequest embeddedDisplayRequest = this.next;
        return ((embeddedDisplayRequest == null ? 0 : embeddedDisplayRequest.hashCode()) * 31) + this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmbeddedDisplayRequestResult(next=" + this.next + ", list=" + this.list + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public EmbeddedDisplayRequestResult(@Nullable EmbeddedDisplayRequest embeddedDisplayRequest, @NotNull List<EmbeddedDisplayRequest> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.next = embeddedDisplayRequest;
        this.list = list;
    }

    @NotNull
    public final List<EmbeddedDisplayRequest> getList() {
        return this.list;
    }

    @Nullable
    public final EmbeddedDisplayRequest getNext() {
        return this.next;
    }
}
