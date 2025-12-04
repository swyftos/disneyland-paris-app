package com.dylanvann.fastimage;

import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes3.dex */
public class FastImageUrlUtils {
    private static final String TAG = "FastImageUrlUtils";

    public static String getFileExtensionFromUrl(String str) {
        try {
            String path = new URL(str).getPath();
            int iLastIndexOf = path.lastIndexOf(46);
            if (iLastIndexOf != -1 && iLastIndexOf != path.length() - 1) {
                return path.substring(iLastIndexOf + 1).toLowerCase();
            }
            return null;
        } catch (MalformedURLException e) {
            Log.e(TAG, "Malformed URL: Unable to parse URL '" + str + "'", e);
            return null;
        }
    }
}
