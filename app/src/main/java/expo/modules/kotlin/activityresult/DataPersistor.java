package expo.modules.kotlin.activityresult;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u0014J\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\u0017J\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001b0\u0017J\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001bJ\u0010\u0010 \u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006$"}, m1836d2 = {"Lexpo/modules/kotlin/activityresult/DataPersistor;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "accumulator", "Landroid/os/Bundle;", "retrievedData", "getRetrievedData", "()Landroid/os/Bundle;", "retrievedData$delegate", "Lkotlin/Lazy;", "addStringArrayList", "key", "", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "retrieveStringArrayList", "addStringToIntMap", "", "", "retrieveStringToIntMap", "addStringToSerializableMap", "Ljava/io/Serializable;", "retrieveStringToSerializableMap", "addBundle", "retrieveBundle", "addSerializable", "retrieveSerializable", "persist", "", "retrieveData", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nDataPersistor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataPersistor.kt\nexpo/modules/kotlin/activityresult/DataPersistor\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 AndroidExtensions.kt\nexpo/modules/kotlin/AndroidExtensionsKt\n*L\n1#1,137:1\n37#2,2:138\n37#2,2:146\n1279#3,2:140\n1293#3,4:142\n1279#3,2:148\n1293#3,2:150\n1296#3:157\n28#4,5:152\n28#4,5:158\n*S KotlinDebug\n*F\n+ 1 DataPersistor.kt\nexpo/modules/kotlin/activityresult/DataPersistor\n*L\n41#1:138,2\n57#1:146,2\n47#1:140,2\n47#1:142,4\n67#1:148,2\n67#1:150,2\n67#1:157\n68#1:152,5\n86#1:158,5\n*E\n"})
public final class DataPersistor {
    private final Bundle accumulator;

    /* JADX INFO: renamed from: retrievedData$delegate, reason: from kotlin metadata */
    private final Lazy retrievedData;
    private final SharedPreferences sharedPreferences;

    public DataPersistor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("expo.modules.kotlin.PersistentDataManager", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        this.accumulator = new Bundle();
        this.retrievedData = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.activityresult.DataPersistor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.retrieveData();
            }
        });
    }

    private final Bundle getRetrievedData() {
        return (Bundle) this.retrievedData.getValue();
    }

    @NotNull
    public final DataPersistor addStringArrayList(@NotNull String key, @NotNull ArrayList<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.accumulator.putStringArrayList(key, value);
        return this;
    }

    @Nullable
    public final ArrayList<String> retrieveStringArrayList(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getRetrievedData().getStringArrayList(key);
    }

    @NotNull
    public final DataPersistor addStringToIntMap(@NotNull String key, @NotNull Map<String, Integer> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Bundle bundle = this.accumulator;
        Pair[] pairArr = (Pair[]) MapsKt.toList(value).toArray(new Pair[0]);
        bundle.putBundle(key, BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return this;
    }

    @Nullable
    public final Map<String, Integer> retrieveStringToIntMap(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle = getRetrievedData().getBundle(key);
        if (bundle == null) {
            return null;
        }
        Set<String> setKeySet = bundle.keySet();
        Intrinsics.checkNotNull(setKeySet);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setKeySet, 10)), 16));
        for (Object obj : setKeySet) {
            linkedHashMap.put(obj, Integer.valueOf(bundle.getInt((String) obj)));
        }
        return linkedHashMap;
    }

    @NotNull
    public final DataPersistor addStringToSerializableMap(@NotNull String key, @NotNull Map<String, ? extends Serializable> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Bundle bundle = this.accumulator;
        Pair[] pairArr = (Pair[]) MapsKt.toList(value).toArray(new Pair[0]);
        bundle.putBundle(key, BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return this;
    }

    @Nullable
    public final Map<String, Serializable> retrieveStringToSerializableMap(@NotNull String key) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle = getRetrievedData().getBundle(key);
        if (bundle == null) {
            return null;
        }
        Set<String> setKeySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setKeySet, 10)), 16));
        for (Object obj : setKeySet) {
            String str = (String) obj;
            if (Build.VERSION.SDK_INT >= 33) {
                serializable = bundle.getSerializable(str, Serializable.class);
            } else {
                serializable = bundle.getSerializable(str);
            }
            if (serializable == null) {
                throw new IllegalStateException("For a key '" + str + "' there should be a serializable class available");
            }
            linkedHashMap.put(obj, serializable);
        }
        return linkedHashMap;
    }

    @NotNull
    public final DataPersistor addBundle(@NotNull String key, @NotNull Bundle value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.accumulator.putBundle(key, value);
        return this;
    }

    @Nullable
    public final Bundle retrieveBundle(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getRetrievedData().getBundle(key);
    }

    @NotNull
    public final DataPersistor addSerializable(@NotNull String key, @NotNull Serializable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.accumulator.putSerializable(key, value);
        return this;
    }

    @Nullable
    public final Serializable retrieveSerializable(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle retrievedData = getRetrievedData();
        if (Build.VERSION.SDK_INT >= 33) {
            return retrievedData.getSerializable(key, Serializable.class);
        }
        return retrievedData.getSerializable(key);
    }

    public final void persist() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString("bundle", DataPersistorKt.toBase64(this.accumulator));
        editorEdit.putLong(DataPersistorKt.EXPIRE_KEY, new Date().getTime() + 300000);
        editorEdit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle retrieveData() {
        String string;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        if (this.sharedPreferences.getLong(DataPersistorKt.EXPIRE_KEY, 0L) > new Date().getTime() && (string = this.sharedPreferences.getString("bundle", null)) != null && (bundle = DataPersistorKt.toBundle(string)) != null) {
            bundle2 = bundle;
        }
        this.sharedPreferences.edit().clear().apply();
        return bundle2;
    }
}
