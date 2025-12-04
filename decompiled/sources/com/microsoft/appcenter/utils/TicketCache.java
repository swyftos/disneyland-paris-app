package com.microsoft.appcenter.utils;

import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class TicketCache {
    private static final Map sTickets = new HashMap();

    public static String getTicket(String str) {
        return (String) sTickets.get(str);
    }

    public static void putTicket(String str, String str2) {
        sTickets.put(str, str2);
    }

    @VisibleForTesting
    public static void clear() {
        sTickets.clear();
    }
}
