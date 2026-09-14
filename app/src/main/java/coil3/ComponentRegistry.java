package coil3;

import androidx.exifinterface.media.ExifInterface;
import coil3.content.Collections_jvmCommonKt;
import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.fetch.SourceFetchResult;
import coil3.intercept.Interceptor;
import coil3.key.Keyer;
import coil3.map.Mapper;
import coil3.request.Options;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00010BÃ\u0001\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00120\u0010\u0005\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003\u0012(\u0010\t\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003\u00124\u0010\u000b\u001a0\u0012,\u0012*\u0012&\u0012$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u00030\f0\u0003\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\f0\u0003¢\u0006\u0004\b\u0010\u0010\u0011B\t\b\u0016¢\u0006\u0004\b\u0010\u0010\u0012J\u0016\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!J8\u0010$\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020&H\u0007J8\u0010*\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020&\u0018\u00010\u00062\u0006\u0010,\u001a\u00020-2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020&H\u0007J\u0006\u0010.\u001a\u00020/R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R;\u0010\u0005\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R3\u0010\t\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R<\u0010\u000b\u001a0\u0012,\u0012*\u0012&\u0012$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u00030\f0\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\f0\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R=\u0010\u0017\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u0014R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001c\u0010\u0014¨\u00061"}, m1836d2 = {"Lcoil3/ComponentRegistry;", "", "interceptors", "", "Lcoil3/intercept/Interceptor;", "mappers", "Lkotlin/Pair;", "Lcoil3/map/Mapper;", "Lkotlin/reflect/KClass;", "keyers", "Lcoil3/key/Keyer;", "lazyFetcherFactories", "Lkotlin/Function0;", "Lcoil3/fetch/Fetcher$Factory;", "lazyDecoderFactories", "Lcoil3/decode/Decoder$Factory;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "()V", "getInterceptors", "()Ljava/util/List;", "getMappers", "getKeyers", "fetcherFactories", "getFetcherFactories", "fetcherFactories$delegate", "Lkotlin/Lazy;", "decoderFactories", "getDecoderFactories", "decoderFactories$delegate", "map", "data", "options", "Lcoil3/request/Options;", "key", "", "newFetcher", "Lcoil3/fetch/Fetcher;", "", "imageLoader", "Lcoil3/ImageLoader;", "startIndex", "newDecoder", "Lcoil3/decode/Decoder;", "result", "Lcoil3/fetch/SourceFetchResult;", "newBuilder", "Lcoil3/ComponentRegistry$Builder;", "Builder", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nComponentRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentRegistry.kt\ncoil3/ComponentRegistry\n+ 2 collections.kt\ncoil3/util/CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n43#2,2:200\n46#2:203\n43#2,4:204\n69#2,5:208\n69#2,5:213\n1#3:202\n*S KotlinDebug\n*F\n+ 1 ComponentRegistry.kt\ncoil3/ComponentRegistry\n*L\n48#1:200,2\n48#1:203\n63#1:204,4\n33#1:208,5\n37#1:213,5\n*E\n"})
public final class ComponentRegistry {

    /* JADX INFO: renamed from: decoderFactories$delegate, reason: from kotlin metadata */
    private final Lazy decoderFactories;

    /* JADX INFO: renamed from: fetcherFactories$delegate, reason: from kotlin metadata */
    private final Lazy fetcherFactories;
    private final List interceptors;
    private final List keyers;
    private List lazyDecoderFactories;
    private List lazyFetcherFactories;
    private final List mappers;

    public /* synthetic */ ComponentRegistry(List list, List list2, List list3, List list4, List list5, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4, list5);
    }

    @JvmOverloads
    @Nullable
    public final Pair<Decoder, Integer> newDecoder(@NotNull SourceFetchResult sourceFetchResult, @NotNull Options options, @NotNull ImageLoader imageLoader) {
        return newDecoder$default(this, sourceFetchResult, options, imageLoader, 0, 8, null);
    }

    @JvmOverloads
    @Nullable
    public final Pair<Fetcher, Integer> newFetcher(@NotNull Object obj, @NotNull Options options, @NotNull ImageLoader imageLoader) {
        return newFetcher$default(this, obj, options, imageLoader, 0, 8, null);
    }

    private ComponentRegistry(List list, List list2, List list3, List list4, List list5) {
        this.interceptors = list;
        this.mappers = list2;
        this.keyers = list3;
        this.lazyFetcherFactories = list4;
        this.lazyDecoderFactories = list5;
        this.fetcherFactories = LazyKt.lazy(new Function0() { // from class: coil3.ComponentRegistry$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ComponentRegistry.fetcherFactories_delegate$lambda$2(this.f$0);
            }
        });
        this.decoderFactories = LazyKt.lazy(new Function0() { // from class: coil3.ComponentRegistry$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ComponentRegistry.decoderFactories_delegate$lambda$5(this.f$0);
            }
        });
    }

    @NotNull
    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    @NotNull
    public final List<Pair<Mapper<? extends Object, ? extends Object>, KClass<? extends Object>>> getMappers() {
        return this.mappers;
    }

    @NotNull
    public final List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> getKeyers() {
        return this.keyers;
    }

    public ComponentRegistry() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    @NotNull
    public final List<Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>>> getFetcherFactories() {
        return (List) this.fetcherFactories.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List fetcherFactories_delegate$lambda$2(ComponentRegistry componentRegistry) {
        List list = componentRegistry.lazyFetcherFactories;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            CollectionsKt.addAll(arrayList, (List) ((Function0) list.get(i)).invoke());
        }
        componentRegistry.lazyFetcherFactories = CollectionsKt.emptyList();
        return arrayList;
    }

    @NotNull
    public final List<Decoder.Factory> getDecoderFactories() {
        return (List) this.decoderFactories.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List decoderFactories_delegate$lambda$5(ComponentRegistry componentRegistry) {
        List list = componentRegistry.lazyDecoderFactories;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            CollectionsKt.addAll(arrayList, (List) ((Function0) list.get(i)).invoke());
        }
        componentRegistry.lazyDecoderFactories = CollectionsKt.emptyList();
        return arrayList;
    }

    @NotNull
    public final Object map(@NotNull Object data, @NotNull Options options) {
        List list = this.mappers;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) list.get(i);
            Mapper mapper = (Mapper) pair.component1();
            if (((KClass) pair.component2()).isInstance(data)) {
                Intrinsics.checkNotNull(mapper, "null cannot be cast to non-null type coil3.map.Mapper<kotlin.Any, *>");
                Object map = mapper.map(data, options);
                if (map != null) {
                    data = map;
                }
            }
        }
        return data;
    }

    @Nullable
    public final String key(@NotNull Object data, @NotNull Options options) {
        List list = this.keyers;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) list.get(i);
            Keyer keyer = (Keyer) pair.component1();
            if (((KClass) pair.component2()).isInstance(data)) {
                Intrinsics.checkNotNull(keyer, "null cannot be cast to non-null type coil3.key.Keyer<kotlin.Any>");
                String strKey = keyer.key(data, options);
                if (strKey != null) {
                    return strKey;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ Pair newFetcher$default(ComponentRegistry componentRegistry, Object obj, Options options, ImageLoader imageLoader, int i, int i2, Object obj2) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return componentRegistry.newFetcher(obj, options, imageLoader, i);
    }

    @JvmOverloads
    @Nullable
    public final Pair<Fetcher, Integer> newFetcher(@NotNull Object data, @NotNull Options options, @NotNull ImageLoader imageLoader, int startIndex) {
        int size = getFetcherFactories().size();
        while (startIndex < size) {
            Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>> pair = getFetcherFactories().get(startIndex);
            Fetcher.Factory<? extends Object> factoryComponent1 = pair.component1();
            if (pair.component2().isInstance(data)) {
                Intrinsics.checkNotNull(factoryComponent1, "null cannot be cast to non-null type coil3.fetch.Fetcher.Factory<kotlin.Any>");
                Fetcher fetcherCreate = factoryComponent1.create(data, options, imageLoader);
                if (fetcherCreate != null) {
                    return TuplesKt.m1842to(fetcherCreate, Integer.valueOf(startIndex));
                }
            }
            startIndex++;
        }
        return null;
    }

    public static /* synthetic */ Pair newDecoder$default(ComponentRegistry componentRegistry, SourceFetchResult sourceFetchResult, Options options, ImageLoader imageLoader, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return componentRegistry.newDecoder(sourceFetchResult, options, imageLoader, i);
    }

    @JvmOverloads
    @Nullable
    public final Pair<Decoder, Integer> newDecoder(@NotNull SourceFetchResult result, @NotNull Options options, @NotNull ImageLoader imageLoader, int startIndex) {
        int size = getDecoderFactories().size();
        while (startIndex < size) {
            Decoder decoderCreate = getDecoderFactories().get(startIndex).create(result, options, imageLoader);
            if (decoderCreate != null) {
                return TuplesKt.m1842to(decoderCreate, Integer.valueOf(startIndex));
            }
            startIndex++;
        }
        return null;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Metadata(m1835d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\tJ'\u0010\u001c\u001a\u00020\u0000\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u00012\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u0002H\u001e\u0012\u0002\b\u00030\u000eH\u0086\bJ0\u0010\u001c\u001a\u00020\u0000\"\b\b\u0000\u0010\u001e*\u00020\u00012\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u0002H\u001e\u0012\u0002\b\u00030\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0\u000fJ#\u0010\u001c\u001a\u00020\u0000\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0012H\u0086\bJ,\u0010\u001c\u001a\u00020\u0000\"\b\b\u0000\u0010\u001e*\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0\u000fJ#\u0010\u001c\u001a\u00020\u0000\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0017H\u0086\bJ,\u0010\u001c\u001a\u00020\u0000\"\b\b\u0000\u0010\u001e*\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0\u000fJ6\u0010#\u001a\u00020\u00002.\u0010\"\u001a*\u0012&\u0012$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0017\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\u00160\u0015J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001aJ\u001a\u0010$\u001a\u00020\u00002\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\u0015J\u0006\u0010%\u001a\u00020\u0005R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR:\u0010\f\u001a(\u0012$\u0012\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\u000e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR6\u0010\u0011\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bRB\u0010\u0014\u001a0\u0012,\u0012*\u0012&\u0012$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0017\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\u00160\u00150\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR&\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\u00150\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000b¨\u0006&"}, m1836d2 = {"Lcoil3/ComponentRegistry$Builder;", "", "<init>", "()V", "registry", "Lcoil3/ComponentRegistry;", "(Lcoil3/ComponentRegistry;)V", "interceptors", "", "Lcoil3/intercept/Interceptor;", "getInterceptors$coil_core_release", "()Ljava/util/List;", "mappers", "Lkotlin/Pair;", "Lcoil3/map/Mapper;", "Lkotlin/reflect/KClass;", "getMappers$coil_core_release", "keyers", "Lcoil3/key/Keyer;", "getKeyers$coil_core_release", "lazyFetcherFactories", "Lkotlin/Function0;", "", "Lcoil3/fetch/Fetcher$Factory;", "getLazyFetcherFactories$coil_core_release", "lazyDecoderFactories", "Lcoil3/decode/Decoder$Factory;", "getLazyDecoderFactories$coil_core_release", "add", "interceptor", ExifInterface.GPS_DIRECTION_TRUE, "mapper", "type", "keyer", "factory", "addFetcherFactories", "addDecoderFactories", "build", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nComponentRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentRegistry.kt\ncoil3/ComponentRegistry$Builder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,199:1\n1628#2,3:200\n1628#2,3:203\n*S KotlinDebug\n*F\n+ 1 ComponentRegistry.kt\ncoil3/ComponentRegistry$Builder\n*L\n140#1:200,3\n141#1:203,3\n*E\n"})
    public static final class Builder {
        private final List interceptors;
        private final List keyers;
        private final List lazyDecoderFactories;
        private final List lazyFetcherFactories;
        private final List mappers;

        @NotNull
        public final List<Interceptor> getInterceptors$coil_core_release() {
            return this.interceptors;
        }

        @NotNull
        public final List<Pair<Mapper<? extends Object, ?>, KClass<? extends Object>>> getMappers$coil_core_release() {
            return this.mappers;
        }

        @NotNull
        public final List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> getKeyers$coil_core_release() {
            return this.keyers;
        }

        @NotNull
        public final List<Function0<List<Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>>>>> getLazyFetcherFactories$coil_core_release() {
            return this.lazyFetcherFactories;
        }

        @NotNull
        public final List<Function0<List<Decoder.Factory>>> getLazyDecoderFactories$coil_core_release() {
            return this.lazyDecoderFactories;
        }

        public Builder() {
            this.interceptors = new ArrayList();
            this.mappers = new ArrayList();
            this.keyers = new ArrayList();
            this.lazyFetcherFactories = new ArrayList();
            this.lazyDecoderFactories = new ArrayList();
        }

        public Builder(@NotNull ComponentRegistry componentRegistry) {
            this.interceptors = CollectionsKt.toMutableList((Collection) componentRegistry.getInterceptors());
            this.mappers = CollectionsKt.toMutableList((Collection) componentRegistry.getMappers());
            this.keyers = CollectionsKt.toMutableList((Collection) componentRegistry.getKeyers());
            List<Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>>> fetcherFactories = componentRegistry.getFetcherFactories();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = fetcherFactories.iterator();
            while (it.hasNext()) {
                final Pair pair = (Pair) it.next();
                arrayList.add(new Function0() { // from class: coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CollectionsKt.listOf(pair);
                    }
                });
            }
            this.lazyFetcherFactories = arrayList;
            List<Decoder.Factory> decoderFactories = componentRegistry.getDecoderFactories();
            ArrayList arrayList2 = new ArrayList();
            for (final Decoder.Factory factory : decoderFactories) {
                arrayList2.add(new Function0() { // from class: coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CollectionsKt.listOf(factory);
                    }
                });
            }
            this.lazyDecoderFactories = arrayList2;
        }

        @NotNull
        public final Builder add(@NotNull Interceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        public final /* synthetic */ <T> Builder add(Mapper<T, ?> mapper) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return add(mapper, Reflection.getOrCreateKotlinClass(Object.class));
        }

        @NotNull
        public final <T> Builder add(@NotNull Mapper<T, ?> mapper, @NotNull KClass<T> type) {
            this.mappers.add(TuplesKt.m1842to(mapper, type));
            return this;
        }

        public final /* synthetic */ <T> Builder add(Keyer<T> keyer) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return add(keyer, Reflection.getOrCreateKotlinClass(Object.class));
        }

        @NotNull
        public final <T> Builder add(@NotNull Keyer<T> keyer, @NotNull KClass<T> type) {
            this.keyers.add(TuplesKt.m1842to(keyer, type));
            return this;
        }

        public final /* synthetic */ <T> Builder add(Fetcher.Factory<T> factory) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return add(factory, Reflection.getOrCreateKotlinClass(Object.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List add$lambda$8$lambda$7(Fetcher.Factory factory, KClass kClass) {
            return CollectionsKt.listOf(TuplesKt.m1842to(factory, kClass));
        }

        @NotNull
        public final <T> Builder add(@NotNull final Fetcher.Factory<T> factory, @NotNull final KClass<T> type) {
            this.lazyFetcherFactories.add(new Function0() { // from class: coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ComponentRegistry.Builder.add$lambda$8$lambda$7(factory, type);
                }
            });
            return this;
        }

        @NotNull
        public final Builder addFetcherFactories(@NotNull Function0<? extends List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends KClass<? extends Object>>>> factory) {
            this.lazyFetcherFactories.add(factory);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull final Decoder.Factory factory) {
            this.lazyDecoderFactories.add(new Function0() { // from class: coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CollectionsKt.listOf(factory);
                }
            });
            return this;
        }

        @NotNull
        public final Builder addDecoderFactories(@NotNull Function0<? extends List<? extends Decoder.Factory>> factory) {
            this.lazyDecoderFactories.add(factory);
            return this;
        }

        @NotNull
        public final ComponentRegistry build() {
            return new ComponentRegistry(Collections_jvmCommonKt.toImmutableList(this.interceptors), Collections_jvmCommonKt.toImmutableList(this.mappers), Collections_jvmCommonKt.toImmutableList(this.keyers), Collections_jvmCommonKt.toImmutableList(this.lazyFetcherFactories), Collections_jvmCommonKt.toImmutableList(this.lazyDecoderFactories), null);
        }
    }
}
