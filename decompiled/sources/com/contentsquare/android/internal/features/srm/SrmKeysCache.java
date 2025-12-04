package com.contentsquare.android.internal.features.srm;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.sdk.D6;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSrmKeysCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SrmKeysCache.kt\ncom/contentsquare/android/internal/features/srm/SrmKeysCache\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n+ 4 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n*L\n1#1,153:1\n766#2:154\n857#2,2:155\n1549#2:159\n1620#2,3:160\n1549#2:163\n1620#2,3:164\n96#3:157\n113#4:158\n*S KotlinDebug\n*F\n+ 1 SrmKeysCache.kt\ncom/contentsquare/android/internal/features/srm/SrmKeysCache\n*L\n65#1:154\n65#1:155,2\n108#1:159\n108#1:160,3\n118#1:163\n118#1:164,3\n77#1:157\n101#1:158\n*E\n"})
/* loaded from: classes2.dex */
public final class SrmKeysCache {

    @NotNull
    public final FileStorageUtil a;

    @NotNull
    public final SystemInstantiable b;
    public final int c;

    @NotNull
    public final LinkedHashSet d;

    @NotNull
    public final String e;

    @NotNull
    public final String f;
    public int g;

    @NotNull
    public final CoroutineScope h;

    @NotNull
    public final Logger i;

    @JvmOverloads
    public SrmKeysCache(@NotNull FileStorageUtil fileStorageUtil, @NotNull String filesLocation) {
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(filesLocation, "filesLocation");
        SystemInstantiable systemInstantiable = new SystemInstantiable();
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(filesLocation, "filesLocation");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        this.a = fileStorageUtil;
        this.b = systemInstantiable;
        this.c = 10;
        this.d = new LinkedHashSet();
        StringBuilder sb = new StringBuilder();
        sb.append(filesLocation);
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append("srm");
        String string = sb.toString();
        this.e = string;
        this.f = string + str + "SrmCachedKeys.json";
        this.h = CoroutineScopeKt.CoroutineScope(ThreadPoolDispatcherKt.newSingleThreadContext("SrmKeysCache-BackgroundThread"));
        this.i = new Logger("SrmKeysCache");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.contentsquare.android.internal.features.srm.SrmKeysCache r8) {
        /*
            monitor-enter(r8)
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L31
            com.contentsquare.android.core.utils.FileStorageUtil r1 = r8.a     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r8.f     // Catch: java.lang.Throwable -> L31
            byte[] r1 = r1.readFileContentAsBytes(r2)     // Catch: java.lang.Throwable -> L31
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Throwable -> L31
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> L31
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L31
            r2 = 0
            if (r1 != 0) goto L19
        L17:
            monitor-exit(r8)
            goto L48
        L19:
            kotlinx.serialization.json.Json$Default r1 = kotlinx.serialization.json.Json.INSTANCE     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33 kotlinx.serialization.SerializationException -> L35
            r1.getSerializersModule()     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33 kotlinx.serialization.SerializationException -> L35
            kotlinx.serialization.internal.ArrayListSerializer r3 = new kotlinx.serialization.internal.ArrayListSerializer     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33 kotlinx.serialization.SerializationException -> L35
            com.contentsquare.android.internal.features.srm.SrmKeysCache$Key$a r4 = com.contentsquare.android.internal.features.srm.SrmKeysCache.Key.Companion     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33 kotlinx.serialization.SerializationException -> L35
            kotlinx.serialization.KSerializer r4 = r4.serializer()     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33 kotlinx.serialization.SerializationException -> L35
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33 kotlinx.serialization.SerializationException -> L35
            java.lang.Object r0 = r1.decodeFromString(r3, r0)     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33 kotlinx.serialization.SerializationException -> L35
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33 kotlinx.serialization.SerializationException -> L35
            r2 = r0
            goto L17
        L31:
            r0 = move-exception
            goto L9a
        L33:
            r0 = move-exception
            goto L37
        L35:
            r0 = move-exception
            goto L3f
        L37:
            com.contentsquare.android.core.features.logging.Logger r1 = r8.i     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = "Failed to parse keys from storage"
        L3b:
            com.contentsquare.android.sdk.Q2.a(r1, r3, r0)     // Catch: java.lang.Throwable -> L31
            goto L44
        L3f:
            com.contentsquare.android.core.features.logging.Logger r1 = r8.i     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = "Failed to parse keys from storage"
            goto L3b
        L44:
            r8.a()     // Catch: java.lang.Throwable -> L31
            goto L17
        L48:
            if (r2 == 0) goto L99
            com.contentsquare.android.core.utils.SystemInstantiable r0 = r8.b
            long r0 = r0.currentTimeMillis()
            r3 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            long r0 = r0 - r3
            java.util.LinkedHashSet r3 = r8.d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r2 = r2.iterator()
        L61:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L78
            java.lang.Object r5 = r2.next()
            r6 = r5
            com.contentsquare.android.internal.features.srm.SrmKeysCache$Key r6 = (com.contentsquare.android.internal.features.srm.SrmKeysCache.Key) r6
            long r6 = r6.b
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 <= 0) goto L61
            r4.add(r5)
            goto L61
        L78:
            kotlin.collections.CollectionsKt.addAll(r3, r4)
            com.contentsquare.android.core.features.logging.Logger r0 = r8.i
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Loaded "
            r1.<init>(r2)
            java.util.LinkedHashSet r8 = r8.d
            int r8 = r8.size()
            r1.append(r8)
            java.lang.String r8 = " keys from disk."
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.d(r8)
        L99:
            return
        L9a:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.internal.features.srm.SrmKeysCache.a(com.contentsquare.android.internal.features.srm.SrmKeysCache):void");
    }

    @Serializable
    public static final class Key {

        @NotNull
        public static final a Companion = new a();

        @NotNull
        public final String a;
        public final long b;

        public static final class a {
            @NotNull
            public final KSerializer<Key> serializer() {
                return SrmKeysCache$Key$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public Key(int i, String str, long j) {
            if (3 != (i & 3)) {
                SrmKeysCache$Key$$serializer.INSTANCE.getClass();
                PluginExceptionsKt.throwMissingFieldException(i, 3, SrmKeysCache$Key$$serializer.a);
            }
            this.a = str;
            this.b = j;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(Key.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.contentsquare.android.internal.features.srm.SrmKeysCache.Key");
            return Intrinsics.areEqual(this.a, ((Key) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        @NotNull
        public final String toString() {
            return "Key(key=" + this.a + ", additionTime=" + this.b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Key(@NotNull String key, long j) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.a = key;
            this.b = j;
        }
    }

    public final synchronized void a() {
        Logger logger;
        String str;
        try {
            if (this.a.deleteFileOrFolder(this.f)) {
                logger = this.i;
                str = this.f + " deleted from disk successfully";
            } else {
                logger = this.i;
                str = this.f + " deletion failed";
            }
            logger.d(str);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(@NotNull ArrayList keysToAdd) {
        try {
            Intrinsics.checkNotNullParameter(keysToAdd, "keysToAdd");
            int size = this.d.size();
            LinkedHashSet linkedHashSet = this.d;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keysToAdd, 10));
            Iterator it = keysToAdd.iterator();
            while (it.hasNext()) {
                arrayList.add(new Key((String) it.next(), this.b.currentTimeMillis()));
            }
            CollectionsKt.addAll(linkedHashSet, arrayList);
            this.i.d("Added " + keysToAdd.size() + " new keys.");
            int size2 = (this.d.size() - size) + this.g;
            this.g = size2;
            if (size2 >= this.c) {
                this.g = 0;
                BuildersKt__Builders_commonKt.launch$default(this.h, null, null, new D6(this, null), 3, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
