package com.urbanairship.util;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class AttributeSetConfigParser implements ConfigParser {
    private final AttributeSet attributeSet;
    private final Context context;

    public AttributeSetConfigParser(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this.context = context;
        this.attributeSet = attributeSet;
    }

    @Override // com.urbanairship.util.ConfigParser
    public int getCount() {
        return this.attributeSet.getAttributeCount();
    }

    @Override // com.urbanairship.util.ConfigParser
    @Nullable
    public String getName(int i) {
        if (i >= getCount() || i < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + i + " count: " + getCount());
        }
        return this.attributeSet.getAttributeName(i);
    }

    @Override // com.urbanairship.util.ConfigParser
    @Nullable
    public String getString(@NonNull String str) {
        int attributeResourceValue = this.attributeSet.getAttributeResourceValue(null, str, 0);
        if (attributeResourceValue != 0) {
            return this.context.getString(attributeResourceValue);
        }
        return this.attributeSet.getAttributeValue(null, str);
    }

    @Override // com.urbanairship.util.ConfigParser
    @NonNull
    public String getString(@NonNull String str, @NonNull String str2) {
        String string = getString(str);
        return string == null ? str2 : string;
    }

    @Override // com.urbanairship.util.ConfigParser
    public boolean getBoolean(@NonNull String str, boolean z) {
        int attributeResourceValue = this.attributeSet.getAttributeResourceValue(null, str, 0);
        if (attributeResourceValue != 0) {
            return this.context.getResources().getBoolean(attributeResourceValue);
        }
        return this.attributeSet.getAttributeBooleanValue(null, str, z);
    }

    @Override // com.urbanairship.util.ConfigParser
    @Nullable
    public String[] getStringArray(@NonNull String str) {
        int attributeResourceValue = this.attributeSet.getAttributeResourceValue(null, str, 0);
        if (attributeResourceValue != 0) {
            return this.context.getResources().getStringArray(attributeResourceValue);
        }
        String attributeValue = this.attributeSet.getAttributeValue(null, str);
        if (attributeValue == null) {
            return new String[0];
        }
        return attributeValue.split("[, ]+");
    }

    @Override // com.urbanairship.util.ConfigParser
    public int getDrawableResourceId(@NonNull String str) {
        int attributeResourceValue = this.attributeSet.getAttributeResourceValue(null, str, 0);
        if (attributeResourceValue != 0) {
            return attributeResourceValue;
        }
        String attributeValue = this.attributeSet.getAttributeValue(null, str);
        if (attributeValue != null) {
            return this.context.getResources().getIdentifier(attributeValue, "drawable", this.context.getPackageName());
        }
        return 0;
    }

    @Override // com.urbanairship.util.ConfigParser
    @ColorInt
    public int getColor(@NonNull String str, @ColorInt int i) {
        int attributeResourceValue = this.attributeSet.getAttributeResourceValue(null, str, 0);
        if (attributeResourceValue != 0) {
            return ContextCompat.getColor(this.context, attributeResourceValue);
        }
        String string = getString(str);
        return UAStringUtil.isEmpty(string) ? i : Color.parseColor(string);
    }

    @Override // com.urbanairship.util.ConfigParser
    public int getInt(@NonNull String str, int i) {
        String string = getString(str);
        return UAStringUtil.isEmpty(string) ? i : Integer.parseInt(string);
    }

    @Override // com.urbanairship.util.ConfigParser
    public int getRawResourceId(@NonNull String str) {
        int attributeResourceValue = this.attributeSet.getAttributeResourceValue(null, str, 0);
        if (attributeResourceValue != 0) {
            return attributeResourceValue;
        }
        String attributeValue = this.attributeSet.getAttributeValue(null, str);
        if (attributeValue != null) {
            return this.context.getResources().getIdentifier(attributeValue, "raw", this.context.getPackageName());
        }
        return 0;
    }

    @Override // com.urbanairship.util.ConfigParser
    public long getLong(@NonNull String str, long j) {
        String string = getString(str);
        return UAStringUtil.isEmpty(string) ? j : Long.parseLong(string);
    }
}
