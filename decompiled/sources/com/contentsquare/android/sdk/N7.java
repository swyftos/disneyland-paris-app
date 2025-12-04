package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.AbstractC0660e;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class N7 extends AbstractC0660e {

    @NotNull
    public final String m;

    public static final class a extends AbstractC0660e.a<N7> {

        @NotNull
        public String k;

        public a() {
            super(22);
            this.k = "";
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new N7(this);
        }
    }

    public N7(a aVar) {
        super(aVar);
        this.m = aVar.k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        AbstractC0660e.l.i("User identifier hashed sent " + this.m);
    }
}
