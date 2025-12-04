package retrofit2.converter.scalars;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes.dex */
final class ScalarResponseBodyConverters$IntegerResponseBodyConverter implements Converter {
    static final ScalarResponseBodyConverters$IntegerResponseBodyConverter INSTANCE = new ScalarResponseBodyConverters$IntegerResponseBodyConverter();

    ScalarResponseBodyConverters$IntegerResponseBodyConverter() {
    }

    @Override // retrofit2.Converter
    public Integer convert(ResponseBody responseBody) {
        return Integer.valueOf(responseBody.string());
    }
}
