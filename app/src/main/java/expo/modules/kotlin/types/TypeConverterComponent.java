package expo.modules.kotlin.types;

import com.urbanairship.actions.RateAppAction;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JC\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\n\b\u0001\u0010\u0013\u0018\u0001*\u00020\u00022#\b\u0004\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\bø\u0001\u0000J\u001c\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001b0\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m1836d2 = {"Lexpo/modules/kotlin/types/TypeConverterComponent;", "Type", "", "notNullableType", "Lkotlin/reflect/KType;", "nullableType", "<init>", "(Lkotlin/reflect/KType;Lkotlin/reflect/KType;)V", "getNotNullableType", "()Lkotlin/reflect/KType;", "getNullableType", "nonNullableConverter", "Lkotlin/Lazy;", "Lexpo/modules/kotlin/types/TypeConverterCollection;", "getNonNullableConverter", "()Lkotlin/Lazy;", "nullableConverter", "getNullableConverter", "from", "P0", RateAppAction.BODY_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "p0", "build", "", "Lkotlin/Pair;", "Lexpo/modules/kotlin/types/TypeConverter;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nTypeConverterCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeConverterCollection.kt\nexpo/modules/kotlin/types/TypeConverterComponent\n+ 2 TypeConverterCollection.kt\nexpo/modules/kotlin/types/TypeConverterCollection\n*L\n1#1,82:1\n41#2,6:83\n41#2,6:89\n*S KotlinDebug\n*F\n+ 1 TypeConverterCollection.kt\nexpo/modules/kotlin/types/TypeConverterComponent\n*L\n16#1:83,6\n17#1:89,6\n*E\n"})
public final class TypeConverterComponent<Type> {
    private final Lazy nonNullableConverter;
    private final KType notNullableType;
    private final Lazy nullableConverter;
    private final KType nullableType;

    public TypeConverterComponent(@NotNull KType notNullableType, @NotNull KType nullableType) {
        Intrinsics.checkNotNullParameter(notNullableType, "notNullableType");
        Intrinsics.checkNotNullParameter(nullableType, "nullableType");
        this.notNullableType = notNullableType;
        this.nullableType = nullableType;
        this.nonNullableConverter = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.types.TypeConverterComponent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TypeConverterComponent.nonNullableConverter$lambda$0(this.f$0);
            }
        });
        this.nullableConverter = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.types.TypeConverterComponent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TypeConverterComponent.nullableConverter$lambda$1(this.f$0);
            }
        });
    }

    @NotNull
    public final KType getNotNullableType() {
        return this.notNullableType;
    }

    @NotNull
    public final KType getNullableType() {
        return this.nullableType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeConverterCollection nonNullableConverter$lambda$0(TypeConverterComponent typeConverterComponent) {
        return new TypeConverterCollection(typeConverterComponent.notNullableType, false);
    }

    @NotNull
    public final Lazy<TypeConverterCollection<Type>> getNonNullableConverter() {
        return this.nonNullableConverter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeConverterCollection nullableConverter$lambda$1(TypeConverterComponent typeConverterComponent) {
        return new TypeConverterCollection(typeConverterComponent.nullableType, true);
    }

    @NotNull
    public final Lazy<TypeConverterCollection<Type>> getNullableConverter() {
        return this.nullableConverter;
    }

    public final /* synthetic */ <P0> TypeConverterComponent<Type> from(Function1<? super P0, ? extends Type> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Map<KType, Function1<Object, Type>> converters = getNonNullableConverter().getValue().getConverters();
        Intrinsics.reifiedOperationMarker(6, "P0");
        converters.put(null, new TypeConverterCollection.C64291(body));
        Map<KType, Function1<Object, Type>> converters2 = getNullableConverter().getValue().getConverters();
        Intrinsics.reifiedOperationMarker(6, "P0");
        converters2.put(null, new TypeConverterCollection.C64291(body));
        return this;
    }

    @NotNull
    public final List<Pair<KType, TypeConverter<?>>> build() {
        if (this.nonNullableConverter.isInitialized() && this.nullableConverter.isInitialized()) {
            return CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.m1842to(this.notNullableType, this.nonNullableConverter.getValue()), TuplesKt.m1842to(this.nullableType, this.nullableConverter.getValue())});
        }
        return CollectionsKt.emptyList();
    }
}
