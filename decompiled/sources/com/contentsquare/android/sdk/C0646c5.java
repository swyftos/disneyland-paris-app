package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.sdk.AbstractC0660e;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.c5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0646c5 extends AbstractC0660e {
    public final int m;

    @Nullable
    public final String n;

    @Nullable
    public final CustomVar[] o;
    public final boolean p;

    /* renamed from: com.contentsquare.android.sdk.c5$a */
    public static final class a extends AbstractC0660e.a<C0646c5> {
        public int k;

        @Nullable
        public String l;

        @Nullable
        public CustomVar[] m;
        public boolean n;

        public a() {
            super(4);
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new C0646c5(this);
        }
    }

    public C0646c5(a aVar) {
        super(aVar);
        this.m = aVar.k;
        this.n = aVar.l;
        this.o = aVar.m;
        this.p = aVar.n;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        CustomVar[] customVarArr = this.o;
        if (customVarArr == null || customVarArr.length == 0) {
            AbstractC0660e.l.i("ScreenView - Screen name: " + this.n + " - Screen number: " + this.d);
            return;
        }
        AbstractC0660e.l.i("ScreenView - Screen name: " + this.n + " - Screen number: " + this.d + " - cVars " + CustomVar.INSTANCE.generateCustomVarsLogMessage(this.o));
    }
}
