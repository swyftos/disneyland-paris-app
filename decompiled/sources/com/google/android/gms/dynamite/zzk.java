package com.google.android.gms.dynamite;

import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes3.dex */
final class zzk implements DynamiteModule.VersionPolicy {
    zzk() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[PHI: r3
  0x001b: PHI (r3v2 int) = (r3v1 int), (r3v3 int) binds: [B:3:0x0014, B:5:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.SelectionResult selectModule(android.content.Context r2, java.lang.String r3, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions r4) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r1 = this;
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r1 = new com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult
            r1.<init>()
            int r0 = r4.zza(r2, r3)
            r1.localVersion = r0
            r0 = 1
            int r2 = r4.zzb(r2, r3, r0)
            r1.remoteVersion = r2
            int r3 = r1.localVersion
            if (r3 != 0) goto L1b
            r3 = 0
            if (r2 != 0) goto L1b
            r0 = r3
            goto L1f
        L1b:
            if (r2 < r3) goto L1e
            goto L1f
        L1e:
            r0 = -1
        L1f:
            r1.selection = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.zzk.selectModule(android.content.Context, java.lang.String, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions):com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult");
    }
}
