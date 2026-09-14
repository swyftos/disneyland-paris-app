package expo.modules.kotlin.modules;

import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.actions.RateAppAction;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterComponent;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0086\bJ]\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u0001\"\n\b\u0001\u0010\u0010\u0018\u0001*\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u0002H\r0\u0012H\u0086\bø\u0001\u0000J\u0006\u0010\u0016\u001a\u00020\u0017R.\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, m1836d2 = {"Lexpo/modules/kotlin/modules/ModuleConvertersBuilder;", "", "<init>", "()V", "convertersComponent", "", "Lexpo/modules/kotlin/types/TypeConverterComponent;", "getConvertersComponent$annotations", "getConvertersComponent", "()Ljava/util/List;", "setConvertersComponent", "(Ljava/util/List;)V", "TypeConverter", ExifInterface.GPS_DIRECTION_TRUE, "classifier", "Lkotlin/reflect/KClass;", "P0", RateAppAction.BODY_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "p0", "buildTypeConverterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nModuleConvertersBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleConvertersBuilder.kt\nexpo/modules/kotlin/modules/ModuleConvertersBuilder\n+ 2 AnyType.kt\nexpo/modules/kotlin/types/AnyTypeKt\n+ 3 TypeConverterCollection.kt\nexpo/modules/kotlin/types/TypeConverterComponent\n+ 4 TypeConverterCollection.kt\nexpo/modules/kotlin/types/TypeConverterCollection\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,51:1\n18#1:60\n19#1,2:69\n148#2,8:52\n148#2,8:61\n16#3:71\n17#3,2:78\n41#4,6:72\n1557#5:80\n1628#5,3:81\n*S KotlinDebug\n*F\n+ 1 ModuleConvertersBuilder.kt\nexpo/modules/kotlin/modules/ModuleConvertersBuilder\n*L\n27#1:60\n27#1:69,2\n18#1:52,8\n27#1:61,8\n28#1:71\n28#1:78,2\n28#1:72,6\n36#1:80\n36#1:81,3\n*E\n"})
public final class ModuleConvertersBuilder {
    private List convertersComponent = new ArrayList();

    @PublishedApi
    public static /* synthetic */ void getConvertersComponent$annotations() {
    }

    @NotNull
    public final List<TypeConverterComponent<?>> getConvertersComponent() {
        return this.convertersComponent;
    }

    public final void setConvertersComponent(@NotNull List<TypeConverterComponent<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.convertersComponent = list;
    }

    public final /* synthetic */ <T> TypeConverterComponent<T> TypeConverter(KClass<T> classifier) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.needClassReification();
        ModuleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1 moduleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1 = new Function0<KType>() { // from class: expo.modules.kotlin.modules.ModuleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        LazyKType lazyKType = new LazyKType(orCreateKotlinClass, false, moduleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1);
        Intrinsics.needClassReification();
        ModuleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$2 moduleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$2 = new Function0<KType>() { // from class: expo.modules.kotlin.modules.ModuleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$2
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "T?");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "T?");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "T?");
        TypeConverterComponent<T> typeConverterComponent = new TypeConverterComponent<>(lazyKType, new LazyKType(orCreateKotlinClass2, false, moduleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$2));
        getConvertersComponent().add(typeConverterComponent);
        return typeConverterComponent;
    }

    public final /* synthetic */ <T, P0> TypeConverterComponent<T> TypeConverter(KClass<T> classifier, final Function1<? super P0, ? extends T> body) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ModuleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1 moduleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1 = new Function0<KType>() { // from class: expo.modules.kotlin.modules.ModuleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        LazyKType lazyKType = new LazyKType(orCreateKotlinClass, false, moduleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1);
        Intrinsics.needClassReification();
        ModuleConvertersBuilder$TypeConverter$$inlined$TypeConverter$2 moduleConvertersBuilder$TypeConverter$$inlined$TypeConverter$2 = new Function0<KType>() { // from class: expo.modules.kotlin.modules.ModuleConvertersBuilder$TypeConverter$$inlined$TypeConverter$2
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, "T?");
                return null;
            }
        };
        Intrinsics.reifiedOperationMarker(4, "T?");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "T?");
        TypeConverterComponent<T> typeConverterComponent = new TypeConverterComponent<>(lazyKType, new LazyKType(orCreateKotlinClass2, false, moduleConvertersBuilder$TypeConverter$$inlined$TypeConverter$2));
        getConvertersComponent().add(typeConverterComponent);
        Map<KType, Function1<Object, T>> converters = typeConverterComponent.getNonNullableConverter().getValue().getConverters();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.needClassReification();
        converters.put(null, new Function1() { // from class: expo.modules.kotlin.modules.ModuleConvertersBuilder$TypeConverter$lambda$1$$inlined$from$1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return body.invoke(obj);
            }
        });
        Map<KType, Function1<Object, T>> converters2 = typeConverterComponent.getNullableConverter().getValue().getConverters();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.needClassReification();
        converters2.put(null, new Function1() { // from class: expo.modules.kotlin.modules.ModuleConvertersBuilder$TypeConverter$lambda$1$$inlined$from$2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return body.invoke(obj);
            }
        });
        return typeConverterComponent;
    }

    @NotNull
    public final TypeConverterProvider buildTypeConverterProvider() {
        List list = this.convertersComponent;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeConverterComponent) it.next()).build());
        }
        final Map map = MapsKt.toMap(CollectionsKt.flatten(arrayList));
        return new TypeConverterProvider() { // from class: expo.modules.kotlin.modules.ModuleConvertersBuilder.buildTypeConverterProvider.1
            @Override // expo.modules.kotlin.types.TypeConverterProvider
            public TypeConverter<?> obtainTypeConverter(KType type) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(type, "type");
                TypeConverter<?> typeConverter = (TypeConverter) map.get(type);
                if (typeConverter != null) {
                    return typeConverter;
                }
                throw new MissingTypeConverter(type);
            }
        };
    }
}
