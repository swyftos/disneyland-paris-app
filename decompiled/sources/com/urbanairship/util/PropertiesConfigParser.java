package com.urbanairship.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.UALog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class PropertiesConfigParser implements ConfigParser {
    private final Context context;
    private final List propertyNames;
    private final Map propertyValues;

    private PropertiesConfigParser(Context context, List list, Map map) {
        this.context = context;
        this.propertyNames = list;
        this.propertyValues = map;
    }

    @NonNull
    public static PropertiesConfigParser fromAssets(@NonNull Context context, @NonNull String str) throws Throwable {
        InputStream inputStreamOpen;
        AssetManager assets = context.getResources().getAssets();
        String[] list = assets.list("");
        if (list == null || !Arrays.asList(list).contains(str)) {
            throw new FileNotFoundException("Unable to find properties file: " + str);
        }
        Properties properties = new Properties();
        try {
            inputStreamOpen = assets.open(str);
        } catch (Throwable th) {
            th = th;
            inputStreamOpen = null;
        }
        try {
            properties.load(inputStreamOpen);
            PropertiesConfigParser propertiesConfigParserFromProperties = fromProperties(context, properties);
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e) {
                    UALog.d(e, "Failed to close input stream.", new Object[0]);
                }
            }
            return propertiesConfigParserFromProperties;
        } catch (Throwable th2) {
            th = th2;
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e2) {
                    UALog.d(e2, "Failed to close input stream.", new Object[0]);
                }
            }
            throw th;
        }
    }

    @NonNull
    public static PropertiesConfigParser fromProperties(@NonNull Context context, @NonNull Properties properties) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (String str : properties.stringPropertyNames()) {
            String property = properties.getProperty(str);
            if (property != null) {
                property = property.trim();
            }
            if (!UAStringUtil.isEmpty(property)) {
                arrayList.add(str);
                map.put(str, property);
            }
        }
        return new PropertiesConfigParser(context, arrayList, map);
    }

    @Override // com.urbanairship.util.ConfigParser
    public int getCount() {
        return this.propertyNames.size();
    }

    @Override // com.urbanairship.util.ConfigParser
    @Nullable
    public String getName(int i) {
        return (String) this.propertyNames.get(i);
    }

    @Override // com.urbanairship.util.ConfigParser
    @Nullable
    public String getString(@NonNull String str) {
        return (String) this.propertyValues.get(str);
    }

    @Override // com.urbanairship.util.ConfigParser
    @NonNull
    public String getString(@NonNull String str, @NonNull String str2) {
        String string = getString(str);
        return string == null ? str2 : string;
    }

    @Override // com.urbanairship.util.ConfigParser
    public boolean getBoolean(@NonNull String str, boolean z) {
        String string = getString(str);
        return UAStringUtil.isEmpty(string) ? z : Boolean.parseBoolean(string);
    }

    @Override // com.urbanairship.util.ConfigParser
    @Nullable
    public String[] getStringArray(@NonNull String str) {
        String str2 = (String) this.propertyValues.get(str);
        if (str2 == null) {
            return new String[0];
        }
        return str2.split("[, ]+");
    }

    @Override // com.urbanairship.util.ConfigParser
    public int getDrawableResourceId(@NonNull String str) {
        return this.context.getResources().getIdentifier(getString(str), "drawable", this.context.getPackageName());
    }

    @Override // com.urbanairship.util.ConfigParser
    public int getRawResourceId(@NonNull String str) {
        return this.context.getResources().getIdentifier(getString(str), "raw", this.context.getPackageName());
    }

    @Override // com.urbanairship.util.ConfigParser
    public long getLong(@NonNull String str, long j) {
        String string = getString(str);
        return UAStringUtil.isEmpty(string) ? j : Long.parseLong(string);
    }

    @Override // com.urbanairship.util.ConfigParser
    public int getInt(@NonNull String str, int i) {
        String string = getString(str);
        return UAStringUtil.isEmpty(string) ? i : Integer.parseInt(string);
    }

    @Override // com.urbanairship.util.ConfigParser
    @ColorInt
    public int getColor(@NonNull String str, @ColorInt int i) {
        String string = getString(str);
        return UAStringUtil.isEmpty(string) ? i : Color.parseColor(string);
    }
}
