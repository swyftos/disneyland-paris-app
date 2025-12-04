package retrofit2.converter.scalars;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes.dex */
final class ScalarResponseBodyConverters$BooleanResponseBodyConverter implements Converter {
    static final ScalarResponseBodyConverters$BooleanResponseBodyConverter INSTANCE = new ScalarResponseBodyConverters$BooleanResponseBodyConverter();

    ScalarResponseBodyConverters$BooleanResponseBodyConverter() {
    }

    @Override // retrofit2.Converter
    public Boolean convert(ResponseBody responseBody) {
        return Boolean.valueOf(responseBody.string());
    }
}
