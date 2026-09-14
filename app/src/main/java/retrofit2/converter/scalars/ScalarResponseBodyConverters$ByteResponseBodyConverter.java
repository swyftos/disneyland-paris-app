package retrofit2.converter.scalars;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes7.dex */
final class ScalarResponseBodyConverters$ByteResponseBodyConverter implements Converter {
    static final ScalarResponseBodyConverters$ByteResponseBodyConverter INSTANCE = new ScalarResponseBodyConverters$ByteResponseBodyConverter();

    ScalarResponseBodyConverters$ByteResponseBodyConverter() {
    }

    @Override // retrofit2.Converter
    public Byte convert(ResponseBody responseBody) {
        return Byte.valueOf(responseBody.string());
    }
}
