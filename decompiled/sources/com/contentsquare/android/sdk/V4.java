package com.contentsquare.android.sdk;

/* loaded from: classes2.dex */
public final class V4 {
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List a(@org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.G2 r14, boolean r15) {
        /*
            java.lang.String r0 = "node"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.util.List<com.contentsquare.android.sdk.G2> r0 = r14.c
            if (r0 != 0) goto L13
            com.contentsquare.android.sdk.G2 r15 = new com.contentsquare.android.sdk.G2
            r15.<init>(r14)
            java.util.List r14 = kotlin.collections.CollectionsKt.listOf(r15)
            return r14
        L13:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L1c:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L31
            java.lang.Object r2 = r0.next()
            com.contentsquare.android.sdk.G2 r2 = (com.contentsquare.android.sdk.G2) r2
            java.util.List r2 = a(r2, r3)
            r1.addAll(r2)
            goto L1c
        L31:
            r0 = r3
            r2 = r0
        L33:
            if (r15 != 0) goto La4
            int r4 = r1.size()
            if (r0 >= r4) goto La4
            if (r2 != 0) goto La4
            java.lang.Object r2 = r1.get(r0)
            com.contentsquare.android.sdk.G2 r2 = (com.contentsquare.android.sdk.G2) r2
            org.json.JSONObject r4 = r14.f
            org.json.JSONObject r2 = r2.f
            java.lang.String r5 = "height"
            java.lang.String r6 = "width"
            if (r4 == 0) goto L84
            if (r2 != 0) goto L51
            goto L84
        L51:
            java.lang.String r7 = "x"
            int r8 = r4.optInt(r7)
            java.lang.String r9 = "y"
            int r10 = r4.optInt(r9)
            int r11 = r4.optInt(r6)
            int r12 = r4.optInt(r5)
            int r7 = r2.optInt(r7)
            int r9 = r2.optInt(r9)
            int r13 = r2.optInt(r6)
            int r2 = r2.optInt(r5)
            if (r8 < r7) goto L84
            if (r10 < r9) goto L84
            int r8 = r8 + r11
            int r7 = r7 + r13
            if (r8 > r7) goto L84
            int r10 = r10 + r12
            int r9 = r9 + r2
            if (r10 > r9) goto L84
            goto L9e
        L84:
            if (r4 == 0) goto L93
            int r2 = r4.optInt(r6)
            if (r2 == 0) goto L9e
            int r2 = r4.optInt(r5)
            if (r2 != 0) goto L93
            goto L9e
        L93:
            if (r4 == 0) goto La0
            java.lang.String r2 = "visibility"
            boolean r2 = r4.optBoolean(r2)
            if (r2 != 0) goto La0
        L9e:
            r2 = 1
            goto La1
        La0:
            r2 = r3
        La1:
            int r0 = r0 + 1
            goto L33
        La4:
            if (r2 == 0) goto La7
            goto Lb2
        La7:
            com.contentsquare.android.sdk.G2 r15 = new com.contentsquare.android.sdk.G2
            r15.<init>(r14)
            r15.c = r1
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r15)
        Lb2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.V4.a(com.contentsquare.android.sdk.G2, boolean):java.util.List");
    }
}
