package com.appdynamics.eumagent.runtime.p000private;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class cg extends j {
    public final String i;
    private String j;
    private int k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;

    public cg(String str, String str2) {
        this(str, str2, new cs(), null);
    }

    public cg(String str, String str2, cs csVar, cs csVar2) {
        this(str, str2, csVar, csVar2, null, null, null, null, 0);
    }

    public cg(String str, String str2, cs csVar, cs csVar2, String str3, String str4, String str5, String str6, String str7, int i) {
        super("ui", csVar, csVar2);
        this.j = str;
        this.i = str2;
        this.l = str3;
        this.m = str4;
        this.n = str5;
        this.o = str6;
        this.p = str7;
        this.k = i;
    }

    private cg(String str, String str2, cs csVar, cs csVar2, String str3, String str4, String str5, String str6, int i) {
        this(str, str2, csVar, csVar2, str3, str4, str5, str6, null, i);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.j
    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("activity").value(this.j);
        jsonWriter.name("event").value(this.i);
        if (this.l != null) {
            jsonWriter.name("uiLabel").value(this.l);
        }
        if (this.m != null) {
            jsonWriter.name("uiAccessibilityLabel").value(this.m);
        }
        if (this.k > 0) {
            jsonWriter.name("uiTag").value(this.k);
        }
        if (this.n != null) {
            jsonWriter.name("uiResponder").value(this.n);
        }
        if (this.o != null) {
            jsonWriter.name("uiClass").value(this.o);
        }
        if (this.p != null) {
            jsonWriter.name("uiIndex").value(this.p);
        }
    }

    public static cg a(Button button, String str, cs csVar) {
        return new cg(button.getContext().getClass().getName(), "Button Pressed", csVar, null, button.getText().toString(), button.getContentDescription() == null ? null : button.getContentDescription().toString(), str, button.getClass().getName(), button.getId());
    }

    public static cg a(AdapterView<?> adapterView, View view, int i, String str, cs csVar) {
        int numColumns;
        String string = (!(adapterView instanceof GridView) || (numColumns = ((GridView) adapterView).getNumColumns()) == -1 || numColumns <= 0) ? null : String.format("%d, %d", Integer.valueOf(i % numColumns), Integer.valueOf(i / numColumns));
        if (string == null) {
            string = Integer.toString(i);
        }
        return new cg(adapterView.getContext().getClass().getName(), "Table Cell Selected", csVar, null, null, view.getContentDescription() != null ? view.getContentDescription().toString() : null, str, view.getClass().getName(), string, view.getId());
    }

    public static cg a(EditText editText, cs csVar, boolean z) {
        return new cg(editText.getContext().getClass().getName(), z ? "Text View Focused" : "Text View Unfocused", csVar, null, null, editText.getContentDescription() == null ? null : editText.getContentDescription().toString(), null, editText.getClass().getName(), editText.getId());
    }
}
