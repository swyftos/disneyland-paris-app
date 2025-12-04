package com.urbanairship.javascript;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.urbanairship.R;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class JavaScriptEnvironment {
    private final List getters;

    private JavaScriptEnvironment(Builder builder) {
        this.getters = new ArrayList(builder.getters);
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    @WorkerThread
    public String getJavaScript(@NonNull Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("var _UAirship = {};");
        Iterator it = this.getters.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        try {
            sb.append(readNativeBridge(context));
            return sb.toString();
        } catch (IOException unused) {
            UALog.e("Failed to read native bridge.", new Object[0]);
            return "";
        }
    }

    private static String readNativeBridge(Context context) throws Resources.NotFoundException, IOException {
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(R.raw.ua_native_bridge);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpenRawResource.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            String string = byteArrayOutputStream.toString();
            try {
                inputStreamOpenRawResource.close();
                byteArrayOutputStream.close();
            } catch (Exception e) {
                UALog.d(e, "Failed to close streams", new Object[0]);
            }
            return string;
        } catch (Throwable th) {
            try {
                inputStreamOpenRawResource.close();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                UALog.d(e2, "Failed to close streams", new Object[0]);
            }
            throw th;
        }
    }

    public static class Builder {
        private final List getters;

        private Builder() {
            this.getters = new ArrayList();
        }

        @NonNull
        public Builder addGetter(@NonNull String str, @Nullable String str2) {
            return addGetter(str, JsonValue.wrapOpt(str2));
        }

        @NonNull
        public Builder addGetter(@NonNull String str, long j) {
            return addGetter(str, JsonValue.wrapOpt(Long.valueOf(j)));
        }

        @NonNull
        public Builder addGetter(@NonNull String str, @Nullable JsonSerializable jsonSerializable) {
            this.getters.add(String.format(Locale.ROOT, "_UAirship.%s = function(){return %s;};", str, (jsonSerializable == null ? JsonValue.NULL : jsonSerializable.getJsonValue()).toString()));
            return this;
        }

        @NonNull
        public JavaScriptEnvironment build() {
            return new JavaScriptEnvironment(this);
        }
    }
}
