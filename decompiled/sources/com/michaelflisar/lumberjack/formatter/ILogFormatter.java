package com.michaelflisar.lumberjack.formatter;

import java.util.Collection;
import java.util.HashMap;

/* loaded from: classes4.dex */
public interface ILogFormatter {
    String combineTagAndGroup(String str, String str2);

    String extractGroupFromTag(String str);

    <T> Object format(T t, HashMap<Class, ILogClassFormatter> map, boolean z);

    <T> String format(Collection<T> collection, HashMap<Class, ILogClassFormatter> map);

    <T> String format(T[] tArr, HashMap<Class, ILogClassFormatter> map);

    String formatLine(String str, String str2);
}
