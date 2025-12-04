package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* loaded from: classes3.dex */
final class zab implements zai {
    zab() {
    }

    @Override // com.google.android.gms.common.server.response.zai
    public final /* synthetic */ Object zaa(FastParser fastParser, BufferedReader bufferedReader) {
        return Long.valueOf(fastParser.zan(bufferedReader));
    }
}
