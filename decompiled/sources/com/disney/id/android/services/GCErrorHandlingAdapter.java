package com.disney.id.android.services;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.services.GCErrorHandlingAdapter;
import com.disney.id.android.utils.GsonUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rumax.reactnative.pdfviewer.PDFView;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/services/GCErrorHandlingAdapter;", "", "()V", "GCCall", "GCCallAdapter", "GCCallback", "GCErrorHandlingCallAdapterFactory", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GCErrorHandlingAdapter {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J$\u0010\u0006\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH&¨\u0006\u000b"}, d2 = {"Lcom/disney/id/android/services/GCErrorHandlingAdapter$GCCall;", ExifInterface.GPS_DIRECTION_TRUE, "", "cancel", "", "clone", "enqueue", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "callback", "Lcom/disney/id/android/services/GCErrorHandlingAdapter$GCCallback;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface GCCall<T> {
        void cancel();

        @NotNull
        GCCall<T> clone();

        void enqueue(@NotNull TypeToken<T> typeToken, @NotNull GCCallback<T> callback);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0014\u0010\u0007\u001a\u00020\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH&J$\u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&¨\u0006\f"}, d2 = {"Lcom/disney/id/android/services/GCErrorHandlingAdapter$GCCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", PDFView.EVENT_ON_ERROR, "", "throwable", "", "onResponseFailure", "response", "Lretrofit2/Response;", "onResponseSuccess", "unconvertedResponse", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface GCCallback<T> {
        void onError(@NotNull Throwable throwable);

        void onResponseFailure(@NotNull Response<?> response);

        void onResponseSuccess(@NotNull Response<T> response, @NotNull Response<T> unconvertedResponse);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0002¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/disney/id/android/services/GCErrorHandlingAdapter$GCErrorHandlingCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "logger", "Lcom/disney/id/android/logging/Logger;", "(Lcom/disney/id/android/logging/Logger;)V", "getLogger", "()Lcom/disney/id/android/logging/Logger;", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "GCErrorHandlingCallAdapter", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GCErrorHandlingCallAdapterFactory extends CallAdapter.Factory {
        private final Logger logger;

        public GCErrorHandlingCallAdapterFactory(@NotNull Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "logger");
            this.logger = logger;
        }

        @NotNull
        public final Logger getLogger() {
            return this.logger;
        }

        @Override // retrofit2.CallAdapter.Factory
        @Nullable
        public CallAdapter<?, ?> get(@NotNull Type returnType, @NotNull Annotation[] annotations, @NotNull Retrofit retrofit) {
            Intrinsics.checkNotNullParameter(returnType, "returnType");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            Intrinsics.checkNotNullParameter(retrofit, "retrofit");
            if (!Intrinsics.areEqual(CallAdapter.Factory.getRawType(returnType), GCCall.class)) {
                return null;
            }
            if (!(returnType instanceof ParameterizedType)) {
                throw new IllegalStateException("GCCall must have generic type (e.g., GCCall<ResponseBody>)");
            }
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
            Executor executorCallbackExecutor = retrofit.callbackExecutor();
            Intrinsics.checkNotNull(parameterUpperBound);
            return new GCErrorHandlingCallAdapter(parameterUpperBound, executorCallbackExecutor, this.logger);
        }

        private static final class GCErrorHandlingCallAdapter implements CallAdapter {
            private final Executor callbackExecutor;
            private final Logger logger;
            private final Type responseType;

            public GCErrorHandlingCallAdapter(Type responseType, Executor executor, Logger logger) {
                Intrinsics.checkNotNullParameter(responseType, "responseType");
                Intrinsics.checkNotNullParameter(logger, "logger");
                this.responseType = responseType;
                this.callbackExecutor = executor;
                this.logger = logger;
            }

            @Override // retrofit2.CallAdapter
            public Type responseType() {
                return this.responseType;
            }

            @Override // retrofit2.CallAdapter
            public GCCall adapt(Call call) {
                Intrinsics.checkNotNullParameter(call, "call");
                return new GCCallAdapter(call, this.callbackExecutor, this.logger);
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0012B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J$\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/disney/id/android/services/GCErrorHandlingAdapter$GCCallAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/disney/id/android/services/GCErrorHandlingAdapter$GCCall;", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "callbackExecutor", "Ljava/util/concurrent/Executor;", "logger", "Lcom/disney/id/android/logging/Logger;", "(Lretrofit2/Call;Ljava/util/concurrent/Executor;Lcom/disney/id/android/logging/Logger;)V", "cancel", "", "clone", "enqueue", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "callback", "Lcom/disney/id/android/services/GCErrorHandlingAdapter$GCCallback;", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GCCallAdapter<T> implements GCCall<T> {
        private static final String TAG;
        private final Call call;
        private final Executor callbackExecutor;
        private final Logger logger;

        public GCCallAdapter(@NotNull Call<T> call, @Nullable Executor executor, @NotNull Logger logger) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(logger, "logger");
            this.call = call;
            this.callbackExecutor = executor;
            this.logger = logger;
        }

        static {
            String simpleName = GCCallAdapter.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            TAG = simpleName;
        }

        @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCall
        public void cancel() {
            this.call.cancel();
        }

        @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCall
        public void enqueue(@NotNull final TypeToken<T> typeToken, @NotNull final GCCallback<T> callback) {
            Intrinsics.checkNotNullParameter(typeToken, "typeToken");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.call.enqueue(new Callback<T>() { // from class: com.disney.id.android.services.GCErrorHandlingAdapter$GCCallAdapter$enqueue$1
                @Override // retrofit2.Callback
                public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    int iCode = response.code();
                    if (200 <= iCode && iCode < 300) {
                        callback.onResponseSuccess(response, response);
                        return;
                    }
                    if (400 > iCode || iCode >= 500) {
                        Logger.DefaultImpls.e$default(this.logger, GCErrorHandlingAdapter.GCCallAdapter.TAG, "unknown HTTP response: " + response.code(), null, 4, null);
                        callback.onResponseFailure(response);
                        return;
                    }
                    Gson gsonCreateStandardGson$default = GsonUtils.Companion.createStandardGson$default(GsonUtils.INSTANCE, false, false, false, 7, null);
                    ResponseBody responseBodyErrorBody = response.errorBody();
                    Response<T> responseSuccess = Response.success(gsonCreateStandardGson$default.fromJson(responseBodyErrorBody != null ? responseBodyErrorBody.string() : null, typeToken.getType()));
                    GCErrorHandlingAdapter.GCCallback gCCallback = callback;
                    Intrinsics.checkNotNull(responseSuccess);
                    gCCallback.onResponseSuccess(responseSuccess, response);
                }

                @Override // retrofit2.Callback
                public void onFailure(@NotNull Call<T> call, @NotNull Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    this.logger.e(GCErrorHandlingAdapter.GCCallAdapter.TAG, "Unexpected failure on GC call", t);
                    callback.onError(t);
                }
            });
        }

        @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCall
        @NotNull
        public GCCall<T> clone() {
            Call<T> callClone = this.call.clone();
            Intrinsics.checkNotNullExpressionValue(callClone, "clone(...)");
            return new GCCallAdapter(callClone, this.callbackExecutor, this.logger);
        }
    }
}
