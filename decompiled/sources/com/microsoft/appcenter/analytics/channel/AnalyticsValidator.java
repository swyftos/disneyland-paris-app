package com.microsoft.appcenter.analytics.channel;

import androidx.annotation.NonNull;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties;
import com.microsoft.appcenter.analytics.ingestion.models.PageLog;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class AnalyticsValidator extends AbstractChannelListener {
    private boolean validateLog(LogWithNameAndProperties logWithNameAndProperties) {
        String strValidateName = validateName(logWithNameAndProperties.getName(), logWithNameAndProperties.getType());
        if (strValidateName == null) {
            return false;
        }
        Map<String, String> mapValidateProperties = validateProperties(logWithNameAndProperties.getProperties(), strValidateName, logWithNameAndProperties.getType());
        logWithNameAndProperties.setName(strValidateName);
        logWithNameAndProperties.setProperties(mapValidateProperties);
        return true;
    }

    private boolean validateLog(EventLog eventLog) {
        String strValidateName = validateName(eventLog.getName(), eventLog.getType());
        if (strValidateName == null) {
            return false;
        }
        validateProperties(eventLog.getTypedProperties());
        eventLog.setName(strValidateName);
        return true;
    }

    private static String validateName(String str, String str2) {
        if (str == null || str.isEmpty()) {
            AppCenterLog.error(Analytics.LOG_TAG, str2 + " name cannot be null or empty.");
            return null;
        }
        if (str.length() <= 256) {
            return str;
        }
        AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : name length cannot be longer than %s characters. Name will be truncated.", str2, str, 256));
        return str.substring(0, 256);
    }

    private static Map validateProperties(Map map, String str, String str2) {
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String strSubstring = (String) entry.getKey();
            String strSubstring2 = (String) entry.getValue();
            if (map2.size() >= 20) {
                AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : properties cannot contain more than %s items. Skipping other properties.", str2, str, 20));
                break;
            }
            if (strSubstring == null || strSubstring.isEmpty()) {
                AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : a property key cannot be null or empty. Property will be skipped.", str2, str));
            } else if (strSubstring2 == null) {
                AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : property '%s' : property value cannot be null. Property '%s' will be skipped.", str2, str, strSubstring, strSubstring));
            } else {
                if (strSubstring.length() > 125) {
                    AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", str2, str, strSubstring, Integer.valueOf(ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH)));
                    strSubstring = strSubstring.substring(0, ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH);
                }
                if (strSubstring2.length() > 125) {
                    AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", str2, str, strSubstring, Integer.valueOf(ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH)));
                    strSubstring2 = strSubstring2.substring(0, ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH);
                }
                map2.put(strSubstring, strSubstring2);
            }
        }
        return map2;
    }

    private static void validateProperties(List list) {
        if (list == null) {
            return;
        }
        ListIterator listIterator = list.listIterator();
        int i = 0;
        boolean z = false;
        while (listIterator.hasNext()) {
            TypedProperty typedPropertyCopyProperty = (TypedProperty) listIterator.next();
            String name = typedPropertyCopyProperty.getName();
            boolean z2 = true;
            if (i >= 20) {
                if (!z) {
                    AppCenterLog.warn(Analytics.LOG_TAG, String.format("Typed properties cannot contain more than %s items. Skipping other properties.", 20));
                    z = true;
                }
                listIterator.remove();
            } else if (name == null || name.isEmpty()) {
                AppCenterLog.warn(Analytics.LOG_TAG, "A typed property key cannot be null or empty. Property will be skipped.");
                listIterator.remove();
            } else {
                if (name.length() > 125) {
                    AppCenterLog.warn(Analytics.LOG_TAG, String.format("Typed property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", name, Integer.valueOf(ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH)));
                    name = name.substring(0, ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH);
                    typedPropertyCopyProperty = copyProperty(typedPropertyCopyProperty, name);
                    listIterator.set(typedPropertyCopyProperty);
                    z2 = false;
                }
                if (typedPropertyCopyProperty instanceof StringTypedProperty) {
                    StringTypedProperty stringTypedProperty = (StringTypedProperty) typedPropertyCopyProperty;
                    String value = stringTypedProperty.getValue();
                    if (value == null) {
                        AppCenterLog.warn(Analytics.LOG_TAG, String.format("Typed property '%s' : property value cannot be null. Property '%s' will be skipped.", name, name));
                        listIterator.remove();
                    } else if (value.length() > 125) {
                        AppCenterLog.warn(Analytics.LOG_TAG, String.format("A String property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", name, Integer.valueOf(ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH)));
                        String strSubstring = value.substring(0, ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH);
                        if (z2) {
                            StringTypedProperty stringTypedProperty2 = new StringTypedProperty();
                            stringTypedProperty2.setName(name);
                            stringTypedProperty2.setValue(strSubstring);
                            listIterator.set(stringTypedProperty2);
                        } else {
                            stringTypedProperty.setValue(strSubstring);
                        }
                    }
                }
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static TypedProperty copyProperty(TypedProperty typedProperty, String str) {
        StringTypedProperty stringTypedProperty;
        String type = typedProperty.getType();
        if ("boolean".equals(type)) {
            BooleanTypedProperty booleanTypedProperty = new BooleanTypedProperty();
            booleanTypedProperty.setValue(((BooleanTypedProperty) typedProperty).getValue());
            stringTypedProperty = booleanTypedProperty;
        } else if (DateTimeTypedProperty.TYPE.equals(type)) {
            DateTimeTypedProperty dateTimeTypedProperty = new DateTimeTypedProperty();
            dateTimeTypedProperty.setValue(((DateTimeTypedProperty) typedProperty).getValue());
            stringTypedProperty = dateTimeTypedProperty;
        } else if (DoubleTypedProperty.TYPE.equals(type)) {
            DoubleTypedProperty doubleTypedProperty = new DoubleTypedProperty();
            doubleTypedProperty.setValue(((DoubleTypedProperty) typedProperty).getValue());
            stringTypedProperty = doubleTypedProperty;
        } else if (LongTypedProperty.TYPE.equals(type)) {
            LongTypedProperty longTypedProperty = new LongTypedProperty();
            longTypedProperty.setValue(((LongTypedProperty) typedProperty).getValue());
            stringTypedProperty = longTypedProperty;
        } else {
            StringTypedProperty stringTypedProperty2 = new StringTypedProperty();
            stringTypedProperty2.setValue(((StringTypedProperty) typedProperty).getValue());
            stringTypedProperty = stringTypedProperty2;
        }
        stringTypedProperty.setName(str);
        return stringTypedProperty;
    }

    @Override // com.microsoft.appcenter.channel.AbstractChannelListener, com.microsoft.appcenter.channel.Channel.Listener
    public boolean shouldFilter(@NonNull Log log) {
        if (log instanceof PageLog) {
            return !validateLog((LogWithNameAndProperties) log);
        }
        if (log instanceof EventLog) {
            return !validateLog((EventLog) log);
        }
        return false;
    }
}
