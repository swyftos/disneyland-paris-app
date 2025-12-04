package com.dylanvann.fastimage;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

@GlideModule
/* loaded from: classes3.dex */
public class FastImageOkHttpProgressGlideModule extends LibraryGlideModule {
    private static final DispatchingProgressListener progressListener = new DispatchingProgressListener();

    private interface ResponseProgressListener {
        void update(String str, long j, long j2);
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(OkHttpClientProvider.getOkHttpClient().newBuilder().addInterceptor(createInterceptor(progressListener)).build()));
    }

    private static Interceptor createInterceptor(final ResponseProgressListener responseProgressListener) {
        return new Interceptor() { // from class: com.dylanvann.fastimage.FastImageOkHttpProgressGlideModule.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                Response responseProceed = chain.proceed(request);
                return responseProceed.newBuilder().body(new OkHttpProgressResponseBody(request.url().getUrl(), responseProceed.body(), responseProgressListener)).build();
            }
        };
    }

    static void forget(String str) {
        progressListener.forget(str);
    }

    static void expect(String str, FastImageProgressListener fastImageProgressListener) {
        progressListener.expect(str, fastImageProgressListener);
    }

    private static class DispatchingProgressListener implements ResponseProgressListener {
        private final Map LISTENERS;
        private final Map PROGRESSES;

        private DispatchingProgressListener() {
            this.LISTENERS = new WeakHashMap();
            this.PROGRESSES = new HashMap();
        }

        void forget(String str) {
            this.LISTENERS.remove(str);
            this.PROGRESSES.remove(str);
        }

        void expect(String str, FastImageProgressListener fastImageProgressListener) {
            this.LISTENERS.put(str, fastImageProgressListener);
        }

        @Override // com.dylanvann.fastimage.FastImageOkHttpProgressGlideModule.ResponseProgressListener
        public void update(String str, long j, long j2) {
            FastImageProgressListener fastImageProgressListener = (FastImageProgressListener) this.LISTENERS.get(str);
            if (fastImageProgressListener == null) {
                return;
            }
            if (j2 <= j) {
                forget(str);
            }
            if (needsDispatch(str, j, j2, fastImageProgressListener.getGranularityPercentage())) {
                fastImageProgressListener.onProgress(str, j, j2);
            }
        }

        private boolean needsDispatch(String str, long j, long j2, float f) {
            if (f != BitmapDescriptorFactory.HUE_RED && j != 0 && j2 != j) {
                long j3 = (long) (((j * 100.0f) / j2) / f);
                Long l = (Long) this.PROGRESSES.get(str);
                if (l != null && j3 == l.longValue()) {
                    return false;
                }
                this.PROGRESSES.put(str, Long.valueOf(j3));
            }
            return true;
        }
    }

    private static class OkHttpProgressResponseBody extends ResponseBody {
        private BufferedSource bufferedSource;
        private final String key;
        private final ResponseProgressListener progressListener;
        private final ResponseBody responseBody;

        OkHttpProgressResponseBody(String str, ResponseBody responseBody, ResponseProgressListener responseProgressListener) {
            this.key = str;
            this.responseBody = responseBody;
            this.progressListener = responseProgressListener;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentType */
        public MediaType get$contentType() {
            return this.responseBody.get$contentType();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentLength */
        public long getContentLength() {
            return this.responseBody.getContentLength();
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: source */
        public BufferedSource getSource() {
            if (this.bufferedSource == null) {
                this.bufferedSource = Okio.buffer(source(this.responseBody.getSource()));
            }
            return this.bufferedSource;
        }

        private Source source(Source source) {
            return new ForwardingSource(source) { // from class: com.dylanvann.fastimage.FastImageOkHttpProgressGlideModule.OkHttpProgressResponseBody.1
                long totalBytesRead = 0;

                @Override // okio.ForwardingSource, okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    long j2 = super.read(buffer, j);
                    long contentLength = OkHttpProgressResponseBody.this.responseBody.getContentLength();
                    if (j2 == -1) {
                        this.totalBytesRead = contentLength;
                    } else {
                        this.totalBytesRead += j2;
                    }
                    OkHttpProgressResponseBody.this.progressListener.update(OkHttpProgressResponseBody.this.key, this.totalBytesRead, contentLength);
                    return j2;
                }
            };
        }
    }
}
