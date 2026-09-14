package com.contentsquare.android.internal.features.srm;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.sdk.C2473D6;
import com.contentsquare.android.sdk.C2599Q2;
import com.urbanairship.iam.legacy.LegacyInAppMessaging;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSrmKeysCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SrmKeysCache.kt\ncom/contentsquare/android/internal/features/srm/SrmKeysCache\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n+ 4 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n*L\n1#1,153:1\n766#2:154\n857#2,2:155\n1549#2:159\n1620#2,3:160\n1549#2:163\n1620#2,3:164\n96#3:157\n113#4:158\n*S KotlinDebug\n*F\n+ 1 SrmKeysCache.kt\ncom/contentsquare/android/internal/features/srm/SrmKeysCache\n*L\n65#1:154\n65#1:155,2\n108#1:159\n108#1:160,3\n118#1:163\n118#1:164,3\n77#1:157\n101#1:158\n*E\n"})
public final class SrmKeysCache {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final FileStorageUtil f1324a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final SystemInstantiable f1325b;

    /* JADX INFO: renamed from: c */
    public final int f1326c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final LinkedHashSet f1327d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final String f1328e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final String f1329f;

    /* JADX INFO: renamed from: g */
    public int f1330g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final CoroutineScope f1331h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final Logger f1332i;

    @JvmOverloads
    public SrmKeysCache(@NotNull FileStorageUtil fileStorageUtil, @NotNull String filesLocation) {
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(filesLocation, "filesLocation");
        SystemInstantiable systemInstantiable = new SystemInstantiable();
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(filesLocation, "filesLocation");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        this.f1324a = fileStorageUtil;
        this.f1325b = systemInstantiable;
        this.f1326c = 10;
        this.f1327d = new LinkedHashSet();
        StringBuilder sb = new StringBuilder();
        sb.append(filesLocation);
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append("srm");
        String string = sb.toString();
        this.f1328e = string;
        this.f1329f = string + str + "SrmCachedKeys.json";
        this.f1331h = CoroutineScopeKt.CoroutineScope(ThreadPoolDispatcherKt.newSingleThreadContext("SrmKeysCache-BackgroundThread"));
        this.f1332i = new Logger("SrmKeysCache");
    }

    /* JADX INFO: renamed from: a */
    public static final void m842a(SrmKeysCache srmKeysCache) {
        List list;
        Logger logger;
        String str;
        synchronized (srmKeysCache) {
            String str2 = new String(srmKeysCache.f1324a.readFileContentAsBytes(srmKeysCache.f1329f), Charsets.UTF_8);
            list = null;
            if (str2.length() != 0) {
                try {
                    Json.Companion companion = Json.INSTANCE;
                    companion.getSerializersModule();
                    list = (List) companion.decodeFromString(new ArrayListSerializer(Key.Companion.serializer()), str2);
                } catch (SerializationException e) {
                    e = e;
                    logger = srmKeysCache.f1332i;
                    str = "Failed to parse keys from storage";
                    C2599Q2.m1011a(logger, str, e);
                    srmKeysCache.m843a();
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    logger = srmKeysCache.f1332i;
                    str = "Failed to parse keys from storage";
                    C2599Q2.m1011a(logger, str, e);
                    srmKeysCache.m843a();
                }
            }
        }
        if (list != null) {
            long jCurrentTimeMillis = srmKeysCache.f1325b.currentTimeMillis() - LegacyInAppMessaging.DEFAULT_EXPIRY_MS;
            LinkedHashSet linkedHashSet = srmKeysCache.f1327d;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Key) obj).f1334b > jCurrentTimeMillis) {
                    arrayList.add(obj);
                }
            }
            CollectionsKt.addAll(linkedHashSet, arrayList);
            srmKeysCache.f1332i.m827d("Loaded " + srmKeysCache.f1327d.size() + " keys from disk.");
        }
    }

    @Serializable
    public static final class Key {

        @NotNull
        public static final C2426a Companion = new C2426a();

        /* JADX INFO: renamed from: a */
        @NotNull
        public final String f1333a;

        /* JADX INFO: renamed from: b */
        public final long f1334b;

        /* JADX INFO: renamed from: com.contentsquare.android.internal.features.srm.SrmKeysCache$Key$a */
        public static final class C2426a {
            @NotNull
            public final KSerializer<Key> serializer() {
                return SrmKeysCache$Key$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public Key(int i, String str, long j) {
            if (3 != (i & 3)) {
                SrmKeysCache$Key$$serializer.INSTANCE.getClass();
                PluginExceptionsKt.throwMissingFieldException(i, 3, SrmKeysCache$Key$$serializer.f1335a);
            }
            this.f1333a = str;
            this.f1334b = j;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(Key.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.contentsquare.android.internal.features.srm.SrmKeysCache.Key");
            return Intrinsics.areEqual(this.f1333a, ((Key) obj).f1333a);
        }

        public final int hashCode() {
            return this.f1333a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "Key(key=" + this.f1333a + ", additionTime=" + this.f1334b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Key(@NotNull String key, long j) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.f1333a = key;
            this.f1334b = j;
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m843a() {
        Logger logger;
        String str;
        try {
            if (this.f1324a.deleteFileOrFolder(this.f1329f)) {
                logger = this.f1332i;
                str = this.f1329f + " deleted from disk successfully";
            } else {
                logger = this.f1332i;
                str = this.f1329f + " deletion failed";
            }
            logger.m827d(str);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m844a(@NotNull ArrayList keysToAdd) {
        try {
            Intrinsics.checkNotNullParameter(keysToAdd, "keysToAdd");
            int size = this.f1327d.size();
            LinkedHashSet linkedHashSet = this.f1327d;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keysToAdd, 10));
            Iterator it = keysToAdd.iterator();
            while (it.hasNext()) {
                arrayList.add(new Key((String) it.next(), this.f1325b.currentTimeMillis()));
            }
            CollectionsKt.addAll(linkedHashSet, arrayList);
            this.f1332i.m827d("Added " + keysToAdd.size() + " new keys.");
            int size2 = (this.f1327d.size() - size) + this.f1330g;
            this.f1330g = size2;
            if (size2 >= this.f1326c) {
                this.f1330g = 0;
                BuildersKt__Builders_commonKt.launch$default(this.f1331h, null, null, new C2473D6(this, null), 3, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
