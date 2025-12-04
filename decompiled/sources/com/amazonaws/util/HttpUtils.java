package com.amazonaws.util;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import gherkin.GherkinLanguageConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Marker;

/* loaded from: classes2.dex */
public class HttpUtils {
    private static final Pattern DECODED_CHARACTERS_PATTERN;
    private static final Pattern ENCODED_CHARACTERS_PATTERN = Pattern.compile(Pattern.quote(Marker.ANY_NON_NULL_MARKER) + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("*") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%7E") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%2F"));

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Pattern.quote("%2A"));
        sb.append(GherkinLanguageConstants.TABLE_CELL_SEPARATOR);
        sb.append(Pattern.quote("%2B"));
        sb.append(GherkinLanguageConstants.TABLE_CELL_SEPARATOR);
        DECODED_CHARACTERS_PATTERN = Pattern.compile(sb.toString());
    }

    public static String urlEncode(String str, boolean z) throws UnsupportedEncodingException {
        if (str == null) {
            return "";
        }
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            Matcher matcher = ENCODED_CHARACTERS_PATTERN.matcher(strEncode);
            StringBuffer stringBuffer = new StringBuffer(strEncode.length());
            while (matcher.find()) {
                String strGroup = matcher.group(0);
                if (Marker.ANY_NON_NULL_MARKER.equals(strGroup)) {
                    strGroup = "%20";
                } else if ("*".equals(strGroup)) {
                    strGroup = "%2A";
                } else if ("%7E".equals(strGroup)) {
                    strGroup = "~";
                } else if (z && "%2F".equals(strGroup)) {
                    strGroup = "/";
                }
                matcher.appendReplacement(stringBuffer, strGroup);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String urlDecode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isUsingNonDefaultPort(URI uri) {
        String strLowerCase = StringUtils.lowerCase(uri.getScheme());
        int port = uri.getPort();
        if (port <= 0) {
            return false;
        }
        if ("http".equals(strLowerCase) && port == 80) {
            return false;
        }
        return ("https".equals(strLowerCase) && port == 443) ? false : true;
    }

    public static boolean usePayloadForQueryParameters(Request<?> request) {
        return HttpMethodName.POST.equals(request.getHttpMethod()) && (request.getContent() == null);
    }

    public static String encodeParameters(Request<?> request) throws UnsupportedEncodingException {
        String strEncode;
        if (request.getParameters().isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            boolean z = true;
            for (Map.Entry<String, String> entry : request.getParameters().entrySet()) {
                String strEncode2 = URLEncoder.encode(entry.getKey(), "UTF-8");
                String value = entry.getValue();
                if (value != null) {
                    strEncode = URLEncoder.encode(value, "UTF-8");
                } else {
                    strEncode = "";
                }
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(strEncode2);
                sb.append("=");
                sb.append(strEncode);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String appendUri(String str, String str2) {
        return appendUri(str, str2, false);
    }

    public static String appendUri(String str, String str2, boolean z) throws UnsupportedEncodingException {
        if (str2 != null && str2.length() > 0) {
            if (str2.startsWith("/")) {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } else if (!str.endsWith("/")) {
                str = str + "/";
            }
            String strUrlEncode = urlEncode(str2, true);
            if (z) {
                strUrlEncode = strUrlEncode.replace("//", "/%2F");
            }
            return str + strUrlEncode;
        }
        if (str.endsWith("/")) {
            return str;
        }
        return str + "/";
    }

    public static InputStream fetchFile(URI uri, ClientConfiguration clientConfiguration) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
        httpURLConnection.setConnectTimeout(getConnectionTimeout(clientConfiguration));
        httpURLConnection.setReadTimeout(getSocketTimeout(clientConfiguration));
        httpURLConnection.addRequestProperty("User-Agent", getUserAgent(clientConfiguration));
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            int responseCode = httpURLConnection.getResponseCode();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            if (responseCode != 200) {
                InputStream errorStream = InstrumentationCallbacks.getErrorStream(httpURLConnection);
                if (errorStream != null) {
                    errorStream.close();
                }
                httpURLConnection.disconnect();
                StringBuilder sb = new StringBuilder();
                sb.append("Error fetching file from ");
                sb.append(uri);
                sb.append(": ");
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                try {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                    sb.append(responseMessage);
                    throw new IOException(sb.toString());
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(httpURLConnection, e);
                    throw e;
                }
            }
            return InstrumentationCallbacks.getInputStream(httpURLConnection);
        } catch (IOException e2) {
            InstrumentationCallbacks.networkError(httpURLConnection, e2);
            throw e2;
        }
    }

    static String getUserAgent(ClientConfiguration clientConfiguration) {
        String userAgent = clientConfiguration != null ? clientConfiguration.getUserAgent() : null;
        if (userAgent == null) {
            return ClientConfiguration.DEFAULT_USER_AGENT;
        }
        String str = ClientConfiguration.DEFAULT_USER_AGENT;
        if (str.equals(userAgent)) {
            return userAgent;
        }
        return userAgent + ", " + str;
    }

    static int getConnectionTimeout(ClientConfiguration clientConfiguration) {
        if (clientConfiguration != null) {
            return clientConfiguration.getConnectionTimeout();
        }
        return 15000;
    }

    static int getSocketTimeout(ClientConfiguration clientConfiguration) {
        if (clientConfiguration != null) {
            return clientConfiguration.getSocketTimeout();
        }
        return 15000;
    }
}
