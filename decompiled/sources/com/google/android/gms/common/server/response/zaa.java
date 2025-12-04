package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* loaded from: classes3.dex */
final class zaa implements zai {
    zaa() {
    }

    @Override // com.google.android.gms.common.server.response.zai
    public final /* synthetic */ Object zaa(FastParser fastParser, BufferedReader bufferedReader) {
        return Integer.valueOf(fastParser.zal(bufferedReader));
    }
}
