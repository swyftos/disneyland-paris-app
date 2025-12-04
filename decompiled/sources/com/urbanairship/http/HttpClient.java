package com.urbanairship.http;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.actions.RateAppAction;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001JX\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0010H&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/urbanairship/http/HttpClient;", "", "execute", "Lcom/urbanairship/http/Response;", ExifInterface.GPS_DIRECTION_TRUE, "url", "Landroid/net/Uri;", "method", "", "headers", "", RateAppAction.BODY_KEY, "Lcom/urbanairship/http/RequestBody;", "followRedirects", "", "parser", "Lcom/urbanairship/http/ResponseParser;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface HttpClient {
    @NotNull
    <T> Response<T> execute(@NotNull Uri url, @NotNull String method, @NotNull Map<String, String> headers, @Nullable RequestBody body, boolean followRedirects, @NotNull ResponseParser<T> parser);
}
