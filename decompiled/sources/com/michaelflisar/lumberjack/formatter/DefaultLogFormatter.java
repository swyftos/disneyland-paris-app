package com.michaelflisar.lumberjack.formatter;

import ch.qos.logback.core.joran.action.ActionConst;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class DefaultLogFormatter implements ILogFormatter {
    private boolean mEnableBeautifulCollectionPrint;
    private boolean mEnableCollectionPrintNewLines;
    private Integer mMaxListValues;

    public DefaultLogFormatter(Integer num, boolean z, boolean z2) {
        this.mEnableBeautifulCollectionPrint = z;
        this.mEnableCollectionPrintNewLines = z2;
        this.mMaxListValues = num;
    }

    @Override // com.michaelflisar.lumberjack.formatter.ILogFormatter
    public String formatLine(String str, String str2) {
        return "[" + str + "]: " + str2;
    }

    @Override // com.michaelflisar.lumberjack.formatter.ILogFormatter
    public String extractGroupFromTag(String str) {
        if (str.startsWith("<")) {
            return str.substring(str.indexOf("<") + 1, str.indexOf(">"));
        }
        return null;
    }

    @Override // com.michaelflisar.lumberjack.formatter.ILogFormatter
    public String combineTagAndGroup(String str, String str2) {
        return "<" + str2 + "> " + str;
    }

    @Override // com.michaelflisar.lumberjack.formatter.ILogFormatter
    public <T> String format(Collection<T> collection, HashMap<Class, ILogClassFormatter> map) {
        if (collection == null) {
            return "Collection=NULL";
        }
        if (collection.size() == 0) {
            return "Collection=EMPTY";
        }
        return formatArrayOrCollection(collection, map);
    }

    @Override // com.michaelflisar.lumberjack.formatter.ILogFormatter
    public <T> String format(T[] tArr, HashMap<Class, ILogClassFormatter> map) {
        if (tArr == null) {
            return "Array=NULL";
        }
        if (tArr.length == 0) {
            return "Array=EMPTY";
        }
        return formatArrayOrCollection(Arrays.asList(tArr), map);
    }

    @Override // com.michaelflisar.lumberjack.formatter.ILogFormatter
    public <T> Object format(T t, HashMap<Class, ILogClassFormatter> map, boolean z) {
        if (t == null) {
            return ActionConst.NULL;
        }
        ILogClassFormatter iLogClassFormatter = (map == null || map.size() == 0) ? null : map.get(t.getClass());
        return iLogClassFormatter == null ? t : iLogClassFormatter.log(t, z);
    }

    private String formatArrayOrCollection(Collection collection, HashMap map) {
        if (!this.mEnableBeautifulCollectionPrint) {
            return collection.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[Type=");
        sb.append(collection.iterator().next().getClass().getSimpleName());
        sb.append(", Size=");
        sb.append(collection.size());
        sb.append("]");
        Integer num = this.mMaxListValues;
        if (num == null || num.intValue() > 0) {
            if (this.mEnableCollectionPrintNewLines) {
                sb.append("\n[");
            } else {
                sb.append("[");
            }
            int i = 0;
            for (Object obj : collection) {
                if (this.mEnableCollectionPrintNewLines) {
                    sb.append("\n\t");
                } else if (i > 0) {
                    sb.append(", ");
                }
                sb.append(format(obj, map, true));
                i++;
                Integer num2 = this.mMaxListValues;
                if (num2 != null && i == num2.intValue()) {
                    break;
                }
            }
            if (this.mEnableCollectionPrintNewLines) {
                sb.append("\n]");
            } else {
                sb.append("]");
            }
        }
        return sb.toString();
    }
}
