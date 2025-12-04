package com.urbanairship.android.layout.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Insets;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.android.layout.property.Orientation;
import com.urbanairship.android.layout.property.WindowSize;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* loaded from: classes5.dex */
public final class ResourceUtils {
    @Nullable
    public static JsonMap readJsonAsset(@NonNull Context context, @NonNull String str) throws IOException, JsonException {
        return JsonValue.parseString(readAsset(context, str)).getMap();
    }

    @NonNull
    public static List<String> listJsonAssets(@NonNull Context context, @Nullable String str) throws IOException {
        AssetManager assets = context.getResources().getAssets();
        if (str == null) {
            str = "";
        }
        try {
            String[] list = assets.list(str);
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                if (str2.endsWith(".json")) {
                    arrayList.add(str2);
                }
            }
            return arrayList;
        } catch (IOException unused) {
            return Collections.emptyList();
        }
    }

    @NonNull
    public static String readAsset(@NonNull Context context, @NonNull String str) throws IOException {
        return readStream(context.getResources().getAssets().open(str));
    }

    @Dimension
    public static float dpToPx(@NonNull Context context, @Dimension(unit = 0) int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    @Dimension
    public static float spToPx(@NonNull Context context, @Dimension(unit = 2) int i) {
        return TypedValue.applyDimension(2, i, context.getResources().getDisplayMetrics());
    }

    public static boolean isUiModeNight(@NonNull Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    @Nullable
    public static Orientation getOrientation(@NonNull Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1) {
            return Orientation.PORTRAIT;
        }
        if (i != 2) {
            return null;
        }
        return Orientation.LANDSCAPE;
    }

    @Nullable
    public static WindowSize getWindowSize(@NonNull Context context) {
        int i = context.getResources().getConfiguration().screenLayout & 15;
        if (i == 1) {
            return WindowSize.SMALL;
        }
        if (i == 2 || i == 3) {
            return WindowSize.MEDIUM;
        }
        if (i != 4) {
            return null;
        }
        return WindowSize.LARGE;
    }

    public static int getDisplayWidthPixels(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getDisplayHeightPixels(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getWindowWidthPixels(@NonNull Context context, boolean z) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            if (z) {
                return currentWindowMetrics.getBounds().width();
            }
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            return (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.left) - insetsIgnoringVisibility.right;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getWindowHeightPixels(@NonNull Context context, boolean z) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            if (z) {
                return currentWindowMetrics.getBounds().height();
            }
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            return (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static String readStream(InputStream inputStream) {
        Scanner scannerUseDelimiter = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
        try {
            String next = scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
            scannerUseDelimiter.close();
            return next;
        } catch (Throwable th) {
            if (scannerUseDelimiter != null) {
                try {
                    scannerUseDelimiter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
