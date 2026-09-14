package coil3.decode;

import android.graphics.Canvas;
import coil3.Image;
import coil3.ImageLoader;
import coil3.annotation.ExperimentalCoilApi;
import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1836d2 = {"Lcoil3/decode/BlackholeDecoder;", "Lcoil3/decode/Decoder;", "imageFactory", "Lkotlin/Function0;", "Lcoil3/Image;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "decode", "Lcoil3/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@ExperimentalCoilApi
public final class BlackholeDecoder implements Decoder {
    private final Function0 imageFactory;

    public BlackholeDecoder(@NotNull Function0<? extends Image> function0) {
        this.imageFactory = function0;
    }

    @Override // coil3.decode.Decoder
    @Nullable
    public Object decode(@NotNull Continuation<? super DecodeResult> continuation) {
        return new DecodeResult((Image) this.imageFactory.invoke(), false);
    }

    @Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1836d2 = {"Lcoil3/decode/BlackholeDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "imageFactory", "Lkotlin/Function0;", "Lcoil3/Image;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "create", "Lcoil3/decode/BlackholeDecoder;", "result", "Lcoil3/fetch/SourceFetchResult;", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "Companion", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Factory implements Decoder.Factory {

        @JvmField
        @NotNull
        public static final Image EMPTY_IMAGE = new Image() { // from class: coil3.decode.BlackholeDecoder$Factory$Companion$EMPTY_IMAGE$1
            @Override // coil3.Image
            public void draw(Canvas canvas) {
            }

            @Override // coil3.Image
            public int getHeight() {
                return -1;
            }

            @Override // coil3.Image
            public boolean getShareable() {
                return true;
            }

            @Override // coil3.Image
            public long getSize() {
                return 0L;
            }

            @Override // coil3.Image
            public int getWidth() {
                return -1;
            }
        };
        private final Function0 imageFactory;

        public Factory() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public Factory(@NotNull Function0<? extends Image> function0) {
            this.imageFactory = function0;
        }

        public /* synthetic */ Factory(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Function0() { // from class: coil3.decode.BlackholeDecoder$Factory$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BlackholeDecoder.Factory.EMPTY_IMAGE;
                }
            } : function0);
        }

        @Override // coil3.decode.Decoder.Factory
        @NotNull
        public BlackholeDecoder create(@NotNull SourceFetchResult result, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            return new BlackholeDecoder(this.imageFactory);
        }
    }
}
