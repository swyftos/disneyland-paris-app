package com.contentsquare.android.sdk;

import android.app.Activity;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.R2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2608R2 implements Supplier<String> {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Activity f2059a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final Fragment f2060b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final String f2061c;

    public C2608R2(Activity activity, String str, int i) {
        str = (i & 4) != 0 ? null : str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f2059a = activity;
        this.f2060b = null;
        this.f2061c = str;
    }

    @Override // androidx.core.util.Supplier
    public final String get() {
        StringBuilder sb;
        Object obj;
        if (this.f2060b == null) {
            if (this.f2061c != null) {
                sb = new StringBuilder("[handleScreenChanged]: Was called for activity: [");
                sb.append(this.f2059a);
                sb.append("] and page title [");
                sb.append(this.f2061c);
            } else {
                sb = new StringBuilder("[handleScreenChanged]: Was called for activity: [");
                obj = this.f2059a;
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
            return sb.toString();
        }
        sb = new StringBuilder("[handleScreenChanged]: Was called for activity: [");
        sb.append(this.f2059a);
        sb.append("] and fragment [");
        obj = this.f2060b;
        sb.append(obj);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
