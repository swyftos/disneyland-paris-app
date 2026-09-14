package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback {
    private File cacheFile;
    private final List cacheKeys;

    /* JADX INFO: renamed from: cb */
    private final DataFetcherGenerator.FetcherReadyCallback f1021cb;
    private final DecodeHelper helper;
    private volatile ModelLoader.LoadData loadData;
    private int modelLoaderIndex;
    private List modelLoaders;
    private int sourceIdIndex;
    private Key sourceKey;

    DataCacheGenerator(DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.getCacheKeys(), decodeHelper, fetcherReadyCallback);
    }

    DataCacheGenerator(List list, DecodeHelper decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.sourceIdIndex = -1;
        this.cacheKeys = list;
        this.helper = decodeHelper;
        this.f1021cb = fetcherReadyCallback;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type com.bumptech.glide.load.data.DataFetcher$DataCallback to com.bumptech.glide.load.engine.DataCacheGenerator for r7v2 'this'  com.bumptech.glide.load.data.DataFetcher$DataCallback
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            com.bumptech.glide.util.pool.GlideTrace.beginSection(r0)
        L5:
            java.util.List r0 = r7.modelLoaders     // Catch: java.lang.Throwable -> L68
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6e
            boolean r0 = r7.hasNextModelLoader()     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L12
            goto L6e
        L12:
            r0 = 0
            r7.loadData = r0     // Catch: java.lang.Throwable -> L68
        L15:
            if (r2 != 0) goto L6a
            boolean r0 = r7.hasNextModelLoader()     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L6a
            java.util.List r0 = r7.modelLoaders     // Catch: java.lang.Throwable -> L68
            int r3 = r7.modelLoaderIndex     // Catch: java.lang.Throwable -> L68
            int r4 = r3 + 1
            r7.modelLoaderIndex = r4     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader r0 = (com.bumptech.glide.load.model.ModelLoader) r0     // Catch: java.lang.Throwable -> L68
            java.io.File r3 = r7.cacheFile     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r4 = r7.helper     // Catch: java.lang.Throwable -> L68
            int r4 = r4.getWidth()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r5 = r7.helper     // Catch: java.lang.Throwable -> L68
            int r5 = r5.getHeight()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r6 = r7.helper     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.Options r6 = r6.getOptions()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r0.buildLoadData(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L68
            r7.loadData = r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r7.loadData     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            com.bumptech.glide.load.engine.DecodeHelper r0 = r7.helper     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.model.ModelLoader$LoadData r3 = r7.loadData     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.DataFetcher<Data> r3 = r3.fetcher     // Catch: java.lang.Throwable -> L68
            java.lang.Class r3 = r3.getDataClass()     // Catch: java.lang.Throwable -> L68
            boolean r0 = r0.hasLoadPath(r3)     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r7.loadData     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.DataFetcher<Data> r0 = r0.fetcher     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r2 = r7.helper     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.Priority r2 = r2.getPriority()     // Catch: java.lang.Throwable -> L68
            r0.loadData(r2, r7)     // Catch: java.lang.Throwable -> L68
            r2 = r1
            goto L15
        L68:
            r7 = move-exception
            goto Lb0
        L6a:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r2
        L6e:
            int r0 = r7.sourceIdIndex     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + r1
            r7.sourceIdIndex = r0     // Catch: java.lang.Throwable -> L68
            java.util.List r1 = r7.cacheKeys     // Catch: java.lang.Throwable -> L68
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L68
            if (r0 < r1) goto L7f
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r2
        L7f:
            java.util.List r0 = r7.cacheKeys     // Catch: java.lang.Throwable -> L68
            int r1 = r7.sourceIdIndex     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.Key r0 = (com.bumptech.glide.load.Key) r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DataCacheKey r1 = new com.bumptech.glide.load.engine.DataCacheKey     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r3 = r7.helper     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.Key r3 = r3.getSignature()     // Catch: java.lang.Throwable -> L68
            r1.<init>(r0, r3)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r3 = r7.helper     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.cache.DiskCache r3 = r3.getDiskCache()     // Catch: java.lang.Throwable -> L68
            java.io.File r1 = r3.get(r1)     // Catch: java.lang.Throwable -> L68
            r7.cacheFile = r1     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L5
            r7.sourceKey = r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.DecodeHelper r0 = r7.helper     // Catch: java.lang.Throwable -> L68
            java.util.List r0 = r0.getModelLoaders(r1)     // Catch: java.lang.Throwable -> L68
            r7.modelLoaders = r0     // Catch: java.lang.Throwable -> L68
            r7.modelLoaderIndex = r2     // Catch: java.lang.Throwable -> L68
            goto L5
        Lb0:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DataCacheGenerator.startNext():boolean");
    }

    private boolean hasNextModelLoader() {
        return this.modelLoaderIndex < this.modelLoaders.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData loadData = this.loadData;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        this.f1021cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(Exception exc) {
        this.f1021cb.onDataFetcherFailed(this.sourceKey, exc, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
    }
}
