package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Rect;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;

/* renamed from: com.contentsquare.android.sdk.i5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0706i5 extends Lambda implements Function1<G2, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ C0726k5 b;
    public final /* synthetic */ Bitmap c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0706i5(int i, C0726k5 c0726k5, Bitmap bitmap) {
        super(1);
        this.a = i;
        this.b = c0726k5;
        this.c = bitmap;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(G2 g2) throws JSONException {
        G2 jsonView = g2;
        Intrinsics.checkNotNullParameter(jsonView, "jsonView");
        int i = jsonView.f.getInt("y");
        if (i > this.a) {
            jsonView.f.remove("bmp");
        } else if (jsonView.f.getInt("height") + i > this.a) {
            int i2 = jsonView.f.getInt("x");
            Rect rect = new Rect(i2, i, jsonView.f.getInt("width") + i2, this.a);
            jsonView.f.put("height", rect.height());
            jsonView.f.put("bmp", C0726k5.a(this.b, rect, this.c));
        }
        return Unit.INSTANCE;
    }
}
