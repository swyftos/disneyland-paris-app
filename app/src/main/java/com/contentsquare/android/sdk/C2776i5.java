package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Rect;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.i5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2776i5 extends Lambda implements Function1<C2499G2, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2746a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2796k5 f2747b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Bitmap f2748c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2776i5(int i, C2796k5 c2796k5, Bitmap bitmap) {
        super(1);
        this.f2746a = i;
        this.f2747b = c2796k5;
        this.f2748c = bitmap;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(C2499G2 c2499g2) throws JSONException {
        C2499G2 jsonView = c2499g2;
        Intrinsics.checkNotNullParameter(jsonView, "jsonView");
        int i = jsonView.f1642f.getInt("y");
        if (i > this.f2746a) {
            jsonView.f1642f.remove("bmp");
        } else if (jsonView.f1642f.getInt("height") + i > this.f2746a) {
            int i2 = jsonView.f1642f.getInt("x");
            Rect rect = new Rect(i2, i, jsonView.f1642f.getInt("width") + i2, this.f2746a);
            jsonView.f1642f.put("height", rect.height());
            jsonView.f1642f.put("bmp", C2796k5.m1171a(this.f2747b, rect, this.f2748c));
        }
        return Unit.INSTANCE;
    }
}
