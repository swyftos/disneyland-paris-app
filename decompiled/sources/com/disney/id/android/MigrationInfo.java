package com.disney.id.android;

import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/disney/id/android/MigrationInfo;", "", "()V", "category", "", "codes", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, OneIDTrackerEvent.EVENT_PARAM_PROBLEM, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getCodes", "setCodes", "getInfo", "setInfo", "getProblem", "()Z", "setProblem", "(Z)V", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MigrationInfo {
    private String category;
    private String codes;
    private String info;
    private boolean problem;

    public static /* synthetic */ MigrationInfo copy$default(MigrationInfo migrationInfo, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = migrationInfo.category;
        }
        if ((i & 2) != 0) {
            str2 = migrationInfo.codes;
        }
        if ((i & 4) != 0) {
            str3 = migrationInfo.info;
        }
        if ((i & 8) != 0) {
            z = migrationInfo.problem;
        }
        return migrationInfo.copy(str, str2, str3, z);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCodes() {
        return this.codes;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getProblem() {
        return this.problem;
    }

    @NotNull
    public final MigrationInfo copy(@Nullable String category, @Nullable String codes, @Nullable String info, boolean problem) {
        return new MigrationInfo(category, codes, info, problem);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MigrationInfo)) {
            return false;
        }
        MigrationInfo migrationInfo = (MigrationInfo) other;
        return Intrinsics.areEqual(this.category, migrationInfo.category) && Intrinsics.areEqual(this.codes, migrationInfo.codes) && Intrinsics.areEqual(this.info, migrationInfo.info) && this.problem == migrationInfo.problem;
    }

    public int hashCode() {
        String str = this.category;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.codes;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.info;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Boolean.hashCode(this.problem);
    }

    @NotNull
    public String toString() {
        return "MigrationInfo(category=" + this.category + ", codes=" + this.codes + ", info=" + this.info + ", problem=" + this.problem + ")";
    }

    public MigrationInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z) {
        this.category = str;
        this.codes = str2;
        this.info = str3;
        this.problem = z;
    }

    public /* synthetic */ MigrationInfo(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? false : z);
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getCodes() {
        return this.codes;
    }

    @Nullable
    public final String getInfo() {
        return this.info;
    }

    public final boolean getProblem() {
        return this.problem;
    }

    public final void setCategory(@Nullable String str) {
        this.category = str;
    }

    public final void setCodes(@Nullable String str) {
        this.codes = str;
    }

    public final void setInfo(@Nullable String str) {
        this.info = str;
    }

    public final void setProblem(boolean z) {
        this.problem = z;
    }

    public MigrationInfo() {
        this(null, null, null, false, 8, null);
    }
}
