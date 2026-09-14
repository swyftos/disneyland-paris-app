package expo.modules.kotlin.devtools;

import androidx.media3.common.MimeTypes;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\"\u001a\u0010\u000b\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1836d2 = {"Lokhttp3/Response;", "response", "", "byteCount", "Lokhttp3/ResponseBody;", "peekResponseBody", "(Lokhttp3/Response;J)Lokhttp3/ResponseBody;", "", "shouldParseBody", "(Lokhttp3/Response;)Z", "Lexpo/modules/kotlin/devtools/ExpoNetworkInspectOkHttpInterceptorsDelegate;", "delegate", "Lexpo/modules/kotlin/devtools/ExpoNetworkInspectOkHttpInterceptorsDelegate;", "getDelegate", "()Lexpo/modules/kotlin/devtools/ExpoNetworkInspectOkHttpInterceptorsDelegate;", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nExpoNetworkInspectOkHttpInterceptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExpoNetworkInspectOkHttpInterceptors.kt\nexpo/modules/kotlin/devtools/ExpoNetworkInspectOkHttpInterceptorsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,157:1\n1755#2,3:158\n1755#2,3:161\n*S KotlinDebug\n*F\n+ 1 ExpoNetworkInspectOkHttpInterceptors.kt\nexpo/modules/kotlin/devtools/ExpoNetworkInspectOkHttpInterceptorsKt\n*L\n136#1:158,3\n143#1:161,3\n*E\n"})
public final class ExpoNetworkInspectOkHttpInterceptorsKt {
    private static final ExpoNetworkInspectOkHttpInterceptorsDelegate delegate = ExpoRequestCdpInterceptor.INSTANCE;

    @NotNull
    public static final ExpoNetworkInspectOkHttpInterceptorsDelegate getDelegate() {
        return delegate;
    }

    public static /* synthetic */ ResponseBody peekResponseBody$default(Response response, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 1048576;
        }
        return peekResponseBody(response, j);
    }

    @Nullable
    public static final ResponseBody peekResponseBody(@NotNull Response response, long j) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            return null;
        }
        BufferedSource bufferedSourcePeek = responseBodyBody.getSource().peek();
        try {
            if (bufferedSourcePeek.request(1 + j)) {
                return null;
            }
        } catch (IOException unused) {
        }
        if (StringsKt.equals(Response.header$default(response, "Content-Encoding", null, 2, null), "gzip", true)) {
            bufferedSourcePeek = Okio.buffer(new GzipSource(bufferedSourcePeek));
            bufferedSourcePeek.request(j);
        }
        Buffer buffer = new Buffer();
        buffer.write((Source) bufferedSourcePeek, Math.min(j, bufferedSourcePeek.getBuffer().size()));
        return ResponseBody.INSTANCE.create(buffer, responseBodyBody.get$contentType(), buffer.size());
    }

    public static final boolean shouldParseBody(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"text/event-stream", "text/x-component", MimeTypes.BASE_TYPE_AUDIO, MimeTypes.BASE_TYPE_VIDEO});
        String strHeader$default = Response.header$default(response, "Content-Type", null, 2, null);
        if (strHeader$default == null) {
            strHeader$default = "";
        }
        if (listListOf == null || !listListOf.isEmpty()) {
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                if (StringsKt.startsWith$default(strHeader$default, (String) it.next(), false, 2, (Object) null)) {
                    return false;
                }
            }
        }
        String strHeader = response.request().header("Accept");
        String str = strHeader != null ? strHeader : "";
        if (listListOf == null || !listListOf.isEmpty()) {
            Iterator it2 = listListOf.iterator();
            while (it2.hasNext()) {
                if (StringsKt.startsWith$default(str, (String) it2.next(), false, 2, (Object) null)) {
                    return false;
                }
            }
        }
        if (StringsKt.equals("chunked", Response.header$default(response, HttpHeaders.TRANSFER_ENCODING, null, 2, null), true)) {
            return false;
        }
        String strHeader$default2 = Response.header$default(response, "Content-Length", null, 2, null);
        long j = strHeader$default2 != null ? Long.parseLong(strHeader$default2) : -1L;
        return j < 1 || j <= 1048576;
    }
}
