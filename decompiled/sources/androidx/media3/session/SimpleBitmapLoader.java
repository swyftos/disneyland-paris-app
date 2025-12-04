package androidx.media3.session;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@UnstableApi
@Deprecated
/* loaded from: classes.dex */
public final class SimpleBitmapLoader implements androidx.media3.common.util.BitmapLoader {
    private static final Supplier DEFAULT_EXECUTOR_SERVICE = Suppliers.memoize(new Supplier() { // from class: androidx.media3.session.SimpleBitmapLoader$$ExternalSyntheticLambda1
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return SimpleBitmapLoader.lambda$static$0();
        }
    });
    private final ListeningExecutorService executorService;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ListeningExecutorService lambda$static$0() {
        return MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
    }

    public SimpleBitmapLoader() {
        this((ExecutorService) Assertions.checkStateNotNull((ListeningExecutorService) DEFAULT_EXECUTOR_SERVICE.get()));
    }

    public SimpleBitmapLoader(ExecutorService executorService) {
        this.executorService = MoreExecutors.listeningDecorator(executorService);
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public boolean supportsMimeType(String str) {
        return Util.isBitmapFactorySupportedMimeType(str);
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture<Bitmap> decodeBitmap(final byte[] bArr) {
        return this.executorService.submit(new Callable() { // from class: androidx.media3.session.SimpleBitmapLoader$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SimpleBitmapLoader.decode(bArr);
            }
        });
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture<Bitmap> loadBitmap(final Uri uri) {
        return this.executorService.submit(new Callable() { // from class: androidx.media3.session.SimpleBitmapLoader$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SimpleBitmapLoader.load(uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap decode(byte[] bArr) {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        Assertions.checkArgument(bitmapDecodeByteArray != null, "Could not decode image data");
        return bitmapDecodeByteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap load(Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            String path = uri.getPath();
            if (path == null) {
                throw new IllegalArgumentException("Could not read image from file");
            }
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path);
            if (bitmapDecodeFile != null) {
                return bitmapDecodeFile;
            }
            throw new IllegalArgumentException("Could not read image from file");
        }
        URLConnection uRLConnectionOpenConnection = new URL(uri.toString()).openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new UnsupportedOperationException("Unsupported scheme: " + uri.getScheme());
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            httpURLConnection.connect();
            InstrumentationCallbacks.requestSent(httpURLConnection);
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                if (responseCode != 200) {
                    throw new IOException("Invalid response status code: " + responseCode);
                }
                InputStream inputStream = InstrumentationCallbacks.getInputStream(httpURLConnection);
                try {
                    Bitmap bitmapDecode = decode(ByteStreams.toByteArray(inputStream));
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return bitmapDecode;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(httpURLConnection, e);
                throw e;
            }
        } catch (IOException e2) {
            InstrumentationCallbacks.networkError(httpURLConnection, e2);
            throw e2;
        }
    }
}
