package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JsonUtils;
import gherkin.GherkinLanguageConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class JsonErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {
    private final List unmarshallerList;

    @Override // com.amazonaws.http.HttpResponseHandler
    public boolean needsConnectionLeftOpen() {
        return false;
    }

    public JsonErrorResponseHandler(List<? extends JsonErrorUnmarshaller> list) {
        this.unmarshallerList = list;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazonaws.http.HttpResponseHandler
    public AmazonServiceException handle(HttpResponse httpResponse) throws Exception {
        try {
            JsonErrorResponse jsonErrorResponseFromResponse = JsonErrorResponse.fromResponse(httpResponse);
            AmazonServiceException amazonServiceExceptionRunErrorUnmarshallers = runErrorUnmarshallers(jsonErrorResponseFromResponse);
            if (amazonServiceExceptionRunErrorUnmarshallers == null) {
                return null;
            }
            amazonServiceExceptionRunErrorUnmarshallers.setStatusCode(httpResponse.getStatusCode());
            if (httpResponse.getStatusCode() < 500) {
                amazonServiceExceptionRunErrorUnmarshallers.setErrorType(AmazonServiceException.ErrorType.Client);
            } else {
                amazonServiceExceptionRunErrorUnmarshallers.setErrorType(AmazonServiceException.ErrorType.Service);
            }
            amazonServiceExceptionRunErrorUnmarshallers.setErrorCode(jsonErrorResponseFromResponse.getErrorCode());
            for (Map.Entry<String, String> entry : httpResponse.getHeaders().entrySet()) {
                if ("X-Amzn-RequestId".equalsIgnoreCase(entry.getKey())) {
                    amazonServiceExceptionRunErrorUnmarshallers.setRequestId(entry.getValue());
                }
            }
            return amazonServiceExceptionRunErrorUnmarshallers;
        } catch (IOException e) {
            throw new AmazonClientException("Unable to parse error response", e);
        }
    }

    private AmazonServiceException runErrorUnmarshallers(JsonErrorResponse jsonErrorResponse) {
        for (JsonErrorUnmarshaller jsonErrorUnmarshaller : this.unmarshallerList) {
            if (jsonErrorUnmarshaller.match(jsonErrorResponse)) {
                return jsonErrorUnmarshaller.unmarshall(jsonErrorResponse);
            }
        }
        return null;
    }

    public static final class JsonErrorResponse {
        private final String errorCode;
        private final Map map;
        private final String message = get("message");
        private final int statusCode;

        private JsonErrorResponse(int i, String str, Map map) {
            this.statusCode = i;
            this.errorCode = str;
            this.map = map;
        }

        public int getStatusCode() {
            return this.statusCode;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getMessage() {
            return this.message;
        }

        public String get(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            String str2 = StringUtils.lowerCase(str.substring(0, 1)) + str.substring(1);
            String str3 = StringUtils.upperCase(str.substring(0, 1)) + str.substring(1);
            if (this.map.containsKey(str3)) {
                return (String) this.map.get(str3);
            }
            if (!this.map.containsKey(str2)) {
                return "";
            }
            return (String) this.map.get(str2);
        }

        public static JsonErrorResponse fromResponse(HttpResponse httpResponse) throws IOException {
            int statusCode = httpResponse.getStatusCode();
            Map<String, String> mapJsonToStringMapWithList = JsonUtils.jsonToStringMapWithList(new BufferedReader(new InputStreamReader(httpResponse.getContent(), StringUtils.UTF8)));
            String strSubstring = httpResponse.getHeaders().get("x-amzn-ErrorType");
            if (strSubstring != null) {
                int iIndexOf = strSubstring.indexOf(58);
                if (iIndexOf != -1) {
                    strSubstring = strSubstring.substring(0, iIndexOf);
                }
            } else if (mapJsonToStringMapWithList.containsKey("__type")) {
                String str = mapJsonToStringMapWithList.get("__type");
                strSubstring = str.substring(str.lastIndexOf(GherkinLanguageConstants.COMMENT_PREFIX) + 1);
            }
            return new JsonErrorResponse(statusCode, strSubstring, mapJsonToStringMapWithList);
        }
    }
}
