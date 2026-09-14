package com.appdynamics.eumagent.runtime.p192private;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.cg */
/* JADX INFO: loaded from: classes2.dex */
public class C2111cg extends AbstractC2131j {

    /* JADX INFO: renamed from: i */
    public final String f782i;

    /* JADX INFO: renamed from: j */
    private String f783j;

    /* JADX INFO: renamed from: k */
    private int f784k;

    /* JADX INFO: renamed from: l */
    private String f785l;

    /* JADX INFO: renamed from: m */
    private String f786m;

    /* JADX INFO: renamed from: n */
    private String f787n;

    /* JADX INFO: renamed from: o */
    private String f788o;

    /* JADX INFO: renamed from: p */
    private String f789p;

    public C2111cg(String str, String str2) {
        this(str, str2, new C2123cs(), null);
    }

    public C2111cg(String str, String str2, C2123cs c2123cs, C2123cs c2123cs2) {
        this(str, str2, c2123cs, c2123cs2, null, null, null, null, 0);
    }

    public C2111cg(String str, String str2, C2123cs c2123cs, C2123cs c2123cs2, String str3, String str4, String str5, String str6, String str7, int i) {
        super("ui", c2123cs, c2123cs2);
        this.f783j = str;
        this.f782i = str2;
        this.f785l = str3;
        this.f786m = str4;
        this.f787n = str5;
        this.f788o = str6;
        this.f789p = str7;
        this.f784k = i;
    }

    private C2111cg(String str, String str2, C2123cs c2123cs, C2123cs c2123cs2, String str3, String str4, String str5, String str6, int i) {
        this(str, str2, c2123cs, c2123cs2, str3, str4, str5, str6, null, i);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.AbstractC2131j
    /* JADX INFO: renamed from: a */
    public final void mo500a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("activity").value(this.f783j);
        jsonWriter.name("event").value(this.f782i);
        if (this.f785l != null) {
            jsonWriter.name("uiLabel").value(this.f785l);
        }
        if (this.f786m != null) {
            jsonWriter.name("uiAccessibilityLabel").value(this.f786m);
        }
        if (this.f784k > 0) {
            jsonWriter.name("uiTag").value(this.f784k);
        }
        if (this.f787n != null) {
            jsonWriter.name("uiResponder").value(this.f787n);
        }
        if (this.f788o != null) {
            jsonWriter.name("uiClass").value(this.f788o);
        }
        if (this.f789p != null) {
            jsonWriter.name("uiIndex").value(this.f789p);
        }
    }

    /* JADX INFO: renamed from: a */
    public static C2111cg m641a(Button button, String str, C2123cs c2123cs) {
        return new C2111cg(button.getContext().getClass().getName(), "Button Pressed", c2123cs, null, button.getText().toString(), button.getContentDescription() == null ? null : button.getContentDescription().toString(), str, button.getClass().getName(), button.getId());
    }

    /* JADX INFO: renamed from: a */
    public static C2111cg m640a(AdapterView<?> adapterView, View view, int i, String str, C2123cs c2123cs) {
        int numColumns;
        String string = (!(adapterView instanceof GridView) || (numColumns = ((GridView) adapterView).getNumColumns()) == -1 || numColumns <= 0) ? null : String.format("%d, %d", Integer.valueOf(i % numColumns), Integer.valueOf(i / numColumns));
        if (string == null) {
            string = Integer.toString(i);
        }
        return new C2111cg(adapterView.getContext().getClass().getName(), "Table Cell Selected", c2123cs, null, null, view.getContentDescription() != null ? view.getContentDescription().toString() : null, str, view.getClass().getName(), string, view.getId());
    }

    /* JADX INFO: renamed from: a */
    public static C2111cg m642a(EditText editText, C2123cs c2123cs, boolean z) {
        return new C2111cg(editText.getContext().getClass().getName(), z ? "Text View Focused" : "Text View Unfocused", c2123cs, null, null, editText.getContentDescription() == null ? null : editText.getContentDescription().toString(), null, editText.getClass().getName(), editText.getId());
    }
}
