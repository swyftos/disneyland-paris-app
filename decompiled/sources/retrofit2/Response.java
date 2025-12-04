package retrofit2;

import com.appdynamics.eumagent.runtime.networkrequests.OkHttp3;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.OkHttpCall;

/* loaded from: classes6.dex */
public final class Response<T> {
    private final Object body;
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    public static <T> Response<T> success(@Nullable T t) {
        Response.Builder builderProtocol = new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1);
        Request.Builder builderUrl = new Request.Builder().url("http://localhost/");
        OkHttp3.Request.Builder.build.Enter(builderUrl);
        return success(t, builderProtocol.request(builderUrl.build()).build());
    }

    public static <T> Response<T> success(int i, @Nullable T t) {
        if (i < 200 || i >= 300) {
            throw new IllegalArgumentException("code < 200 or >= 300: " + i);
        }
        Response.Builder builderProtocol = new Response.Builder().code(i).message("Response.success()").protocol(Protocol.HTTP_1_1);
        Request.Builder builderUrl = new Request.Builder().url("http://localhost/");
        OkHttp3.Request.Builder.build.Enter(builderUrl);
        return success(t, builderProtocol.request(builderUrl.build()).build());
    }

    public static <T> Response<T> success(@Nullable T t, Headers headers) {
        Objects.requireNonNull(headers, "headers == null");
        Response.Builder builderHeaders = new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers);
        Request.Builder builderUrl = new Request.Builder().url("http://localhost/");
        OkHttp3.Request.Builder.build.Enter(builderUrl);
        return success(t, builderHeaders.request(builderUrl.build()).build());
    }

    public static <T> Response<T> success(@Nullable T t, okhttp3.Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        return new Response<>(response, t, null);
    }

    public static <T> Response<T> error(int i, ResponseBody responseBody) {
        Objects.requireNonNull(responseBody, "body == null");
        if (i < 400) {
            throw new IllegalArgumentException("code < 400: " + i);
        }
        Response.Builder builderProtocol = new Response.Builder().body(new OkHttpCall.NoContentResponseBody(responseBody.contentType(), responseBody.contentLength())).code(i).message("Response.error()").protocol(Protocol.HTTP_1_1);
        Request.Builder builderUrl = new Request.Builder().url("http://localhost/");
        OkHttp3.Request.Builder.build.Enter(builderUrl);
        return error(responseBody, builderProtocol.request(builderUrl.build()).build());
    }

    public static <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new Response<>(response, null, responseBody);
    }

    private Response(okhttp3.Response response, Object obj, ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = obj;
        this.errorBody = responseBody;
    }

    public okhttp3.Response raw() {
        return this.rawResponse;
    }

    public int code() {
        return this.rawResponse.code();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    @Nullable
    public T body() {
        return (T) this.body;
    }

    @Nullable
    public ResponseBody errorBody() {
        return this.errorBody;
    }

    public String toString() {
        return this.rawResponse.toString();
    }
}
