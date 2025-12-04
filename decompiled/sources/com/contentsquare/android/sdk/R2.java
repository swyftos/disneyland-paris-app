package com.contentsquare.android.sdk;

import android.app.Activity;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class R2 implements Supplier<String> {

    @NotNull
    public final Activity a;

    @Nullable
    public final Fragment b;

    @Nullable
    public final String c;

    public R2(Activity activity, String str, int i) {
        str = (i & 4) != 0 ? null : str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        this.b = null;
        this.c = str;
    }

    @Override // androidx.core.util.Supplier
    public final String get() {
        StringBuilder sb;
        Object obj;
        if (this.b != null) {
            sb = new StringBuilder("[handleScreenChanged]: Was called for activity: [");
            sb.append(this.a);
            sb.append("] and fragment [");
            obj = this.b;
        } else {
            if (this.c != null) {
                sb = new StringBuilder("[handleScreenChanged]: Was called for activity: [");
                sb.append(this.a);
                sb.append("] and page title [");
                sb.append(this.c);
                sb.append(AbstractJsonLexerKt.END_LIST);
                return sb.toString();
            }
            sb = new StringBuilder("[handleScreenChanged]: Was called for activity: [");
            obj = this.a;
        }
        sb.append(obj);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
