package coil3.content;

import coil3.annotation.InternalCoilApi;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rR1\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR)\u0010\f\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\r0\r0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\t¨\u0006\u0014"}, m1836d2 = {"Lcoil3/util/ServiceLoaderComponentRegistry;", "", "<init>", "()V", "fetchers", "", "Lcoil3/util/FetcherServiceLoaderTarget;", "kotlin.jvm.PlatformType", "getFetchers", "()Ljava/util/List;", "fetchers$delegate", "Lkotlin/Lazy;", "decoders", "Lcoil3/util/DecoderServiceLoaderTarget;", "getDecoders", "decoders$delegate", "register", "", "fetcher", "decoder", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@InternalCoilApi
public final class ServiceLoaderComponentRegistry {

    @NotNull
    public static final ServiceLoaderComponentRegistry INSTANCE = new ServiceLoaderComponentRegistry();

    /* JADX INFO: renamed from: fetchers$delegate, reason: from kotlin metadata */
    private static final Lazy fetchers = LazyKt.lazy(new Function0() { // from class: coil3.util.ServiceLoaderComponentRegistry$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ServiceLoaderComponentRegistry.fetchers_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: decoders$delegate, reason: from kotlin metadata */
    private static final Lazy decoders = LazyKt.lazy(new Function0() { // from class: coil3.util.ServiceLoaderComponentRegistry$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ServiceLoaderComponentRegistry.decoders_delegate$lambda$1();
        }
    });

    private ServiceLoaderComponentRegistry() {
    }

    @NotNull
    public final List<FetcherServiceLoaderTarget<?>> getFetchers() {
        return (List) fetchers.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List fetchers_delegate$lambda$0() {
        return Collections_jvmCommonKt.toImmutableList(SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(FetcherServiceLoaderTarget.class, FetcherServiceLoaderTarget.class.getClassLoader()).iterator())));
    }

    @NotNull
    public final List<DecoderServiceLoaderTarget> getDecoders() {
        return (List) decoders.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List decoders_delegate$lambda$1() {
        return Collections_jvmCommonKt.toImmutableList(SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(DecoderServiceLoaderTarget.class, DecoderServiceLoaderTarget.class.getClassLoader()).iterator())));
    }

    public final void register(@NotNull FetcherServiceLoaderTarget<?> fetcher) {
        throw new UnsupportedOperationException();
    }

    public final void register(@NotNull DecoderServiceLoaderTarget decoder) {
        throw new UnsupportedOperationException();
    }
}
