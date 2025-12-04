package com.contentsquare.android.error.analysis.util;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.apierror.ApiErrorConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\t\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"CONTENT_TYPE_EVENT_STREAM", "", "CONTENT_TYPE_TEXT", "MAX_RESPONSE_BODY_SIZE", "", "REQUEST_BODY_OVERFLOW_SIZE", "bodyToBytes", "", "Lokhttp3/Request;", "Lokhttp3/Response;", "isEventStream", "", "Lokhttp3/ResponseBody;", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OkHttpExtensionsKt {

    @NotNull
    private static final String CONTENT_TYPE_EVENT_STREAM = "event-stream";

    @NotNull
    private static final String CONTENT_TYPE_TEXT = "text";
    private static final long MAX_RESPONSE_BODY_SIZE = 1048576;
    private static final long REQUEST_BODY_OVERFLOW_SIZE = 64001;

    @Nullable
    public static final byte[] bodyToBytes(Request request) {
        byte[] byteArray;
        Intrinsics.checkNotNullParameter(request, "<this>");
        try {
            RequestBody requestBodyBody = request.body();
            if (requestBodyBody == null) {
                return null;
            }
            if (requestBodyBody.contentLength() > 64000) {
                byteArray = ApiErrorConstants.INSTANCE.getSUPPRESSED_MESSAGE_MARKER();
            } else {
                Buffer buffer = new Buffer();
                requestBodyBody.writeTo(buffer);
                byteArray = buffer.size() > 64000 ? buffer.readByteArray(REQUEST_BODY_OVERFLOW_SIZE) : buffer.readByteArray();
            }
            return byteArray;
        } catch (IOException e) {
            new Logger(null, 1, null).i("Cannot read request body : " + e);
            return null;
        }
    }

    private static final boolean isEventStream(ResponseBody responseBody) {
        MediaType mediaType = responseBody.get$contentType();
        return mediaType != null && Intrinsics.areEqual(mediaType.type(), "text") && Intrinsics.areEqual(mediaType.subtype(), CONTENT_TYPE_EVENT_STREAM);
    }

    @Nullable
    public static final byte[] bodyToBytes(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null || isEventStream(responseBodyBody)) {
            return null;
        }
        return responseBodyBody.getContentLength() > 1048576 ? ApiErrorConstants.INSTANCE.getSUPPRESSED_MESSAGE_MARKER() : response.peekBody(1048576L).bytes();
    }
}
