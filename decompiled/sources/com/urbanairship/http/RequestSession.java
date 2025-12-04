package com.urbanairship.http;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH&J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/urbanairship/http/RequestSession;", "", "channelAuthTokenProvider", "Lcom/urbanairship/http/AuthTokenProvider;", "getChannelAuthTokenProvider", "()Lcom/urbanairship/http/AuthTokenProvider;", "setChannelAuthTokenProvider", "(Lcom/urbanairship/http/AuthTokenProvider;)V", "contactAuthTokenProvider", "getContactAuthTokenProvider", "setContactAuthTokenProvider", "execute", "Lcom/urbanairship/http/Response;", "", "request", "Lcom/urbanairship/http/Request;", ExifInterface.GPS_DIRECTION_TRUE, "parser", "Lcom/urbanairship/http/ResponseParser;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface RequestSession {
    @NotNull
    Response<Unit> execute(@NotNull Request request) throws RequestException;

    @NotNull
    <T> Response<T> execute(@NotNull Request request, @NotNull ResponseParser<T> parser) throws RequestException;

    @Nullable
    AuthTokenProvider getChannelAuthTokenProvider();

    @Nullable
    AuthTokenProvider getContactAuthTokenProvider();

    void setChannelAuthTokenProvider(@Nullable AuthTokenProvider authTokenProvider);

    void setContactAuthTokenProvider(@Nullable AuthTokenProvider authTokenProvider);
}
