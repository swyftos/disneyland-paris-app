package expo.modules.kotlin.types;

import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.bridge.Dynamic;
import com.urbanairship.actions.RateAppAction;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.jni.ExpectedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ?\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0006\b\u0001\u0010\u0016\u0018\u00012#\b\u0004\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00028\u00000\u000eH\u0086\bø\u0001\u0000J\u001f\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR>\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00028\u00000\u000e0\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, m1836d2 = {"Lexpo/modules/kotlin/types/TypeConverterCollection;", "Type", "", "Lexpo/modules/kotlin/types/NullAwareTypeConverter;", "type", "Lkotlin/reflect/KType;", "isOptional", "", "<init>", "(Lkotlin/reflect/KType;Z)V", "getType", "()Lkotlin/reflect/KType;", "converters", "", "Lkotlin/Function1;", "getConverters$annotations", "()V", "getConverters", "()Ljava/util/Map;", "setConverters", "(Ljava/util/Map;)V", "from", "P0", RateAppAction.BODY_KEY, "Lkotlin/ParameterName;", "name", "p0", "convertNonOptional", "value", "context", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)Ljava/lang/Object;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nTypeConverterCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeConverterCollection.kt\nexpo/modules/kotlin/types/TypeConverterCollection\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,82:1\n126#2:83\n153#2,3:84\n774#3:87\n865#3,2:88\n1557#3:90\n1628#3,3:91\n37#4,2:94\n*S KotlinDebug\n*F\n+ 1 TypeConverterCollection.kt\nexpo/modules/kotlin/types/TypeConverterCollection\n*L\n51#1:83\n51#1:84,3\n52#1:87\n52#1:88,2\n76#1:90\n76#1:91,3\n78#1:94,2\n*E\n"})
public final class TypeConverterCollection<Type> extends NullAwareTypeConverter<Type> {
    private Map converters;
    private final KType type;

    @PublishedApi
    public static /* synthetic */ void getConverters$annotations() {
    }

    @NotNull
    public final KType getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeConverterCollection(@NotNull KType type, boolean z) {
        super(z);
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.converters = new LinkedHashMap();
    }

    @NotNull
    public final Map<KType, Function1<Object, Type>> getConverters() {
        return this.converters;
    }

    public final void setConverters(@NotNull Map<KType, Function1<Object, Type>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.converters = map;
    }

    public final /* synthetic */ <P0> TypeConverterCollection<Type> from(Function1<? super P0, ? extends Type> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Map<KType, Function1<Object, Type>> converters = getConverters();
        Intrinsics.reifiedOperationMarker(6, "P0");
        converters.put(null, new C64291(body));
        return this;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.types.TypeConverterCollection$from$1 */
    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
    @SourceDebugExtension({"SMAP\nTypeConverterCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeConverterCollection.kt\nexpo/modules/kotlin/types/TypeConverterCollection$from$1\n+ 2 EnforceType.kt\nexpo/modules/kotlin/types/EnforceTypeKt\n*L\n1#1,82:1\n11#2:83\n*S KotlinDebug\n*F\n+ 1 TypeConverterCollection.kt\nexpo/modules/kotlin/types/TypeConverterCollection$from$1\n*L\n42#1:83\n*E\n"})
    public static final class C64291 implements Function1<Object, Type> {
        final /* synthetic */ Function1 $body;

        public C64291(Function1<? super P0, ? extends Type> function1) {
            this.$body = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Type invoke(Object obj) {
            return (Type) this.$body.invoke(obj);
        }
    }

    @Override // expo.modules.kotlin.types.NullAwareTypeConverter
    @NotNull
    public Type convertNonOptional(@NotNull Object value, @Nullable AppContext context) throws MissingTypeConverter {
        Intrinsics.checkNotNullParameter(value, "value");
        Map map = this.converters;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(TuplesKt.m1842to((KType) entry.getKey(), (Function1) entry.getValue()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            KClassifier classifier = ((KType) ((Pair) obj).component1()).getClassifier();
            KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
            if (kClass != null && kClass.isInstance(value)) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            if (value instanceof Dynamic) {
                return convertNonOptional(new ExpoDynamic((Dynamic) value), context);
            }
            throw new MissingTypeConverter(this.type);
        }
        if (arrayList2.size() > 1) {
            throw new TypeCastException("Cannot cast '" + value + "' to '" + this.type + "'. Type converters conflict");
        }
        return (Type) ((Function1) ((Pair) CollectionsKt.first((List) arrayList2)).getSecond()).invoke(value);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    @NotNull
    public ExpectedType getCppRequiredTypes() {
        ExpectedType.Companion companion = ExpectedType.INSTANCE;
        Set setKeySet = this.converters.keySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(ExpectedType.INSTANCE.fromKType((KType) it.next()));
        }
        ExpectedType[] expectedTypeArr = (ExpectedType[]) arrayList.toArray(new ExpectedType[0]);
        return companion.merge((ExpectedType[]) Arrays.copyOf(expectedTypeArr, expectedTypeArr.length));
    }
}
