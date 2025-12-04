package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;

/* loaded from: classes4.dex */
public class LibraryVersionComponent {
    public static Component<?> create(String str, String str2) {
        return Component.intoSet(LibraryVersion.create(str, str2), LibraryVersion.class);
    }
}
