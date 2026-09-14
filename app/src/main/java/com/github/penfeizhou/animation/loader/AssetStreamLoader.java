package com.github.penfeizhou.animation.loader;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class AssetStreamLoader extends StreamLoader {
    private final String mAssetName;
    private final Context mContext;

    public AssetStreamLoader(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.mAssetName = str;
    }

    @Override // com.github.penfeizhou.animation.loader.StreamLoader
    protected InputStream getInputStream() throws IOException {
        return this.mContext.getAssets().open(this.mAssetName);
    }
}
