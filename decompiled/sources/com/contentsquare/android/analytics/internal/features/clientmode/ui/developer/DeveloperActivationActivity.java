package com.contentsquare.android.analytics.internal.features.clientmode.ui.developer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.R;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.developer.a;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/android/analytics/internal/features/clientmode/ui/developer/DeveloperActivationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DeveloperActivationActivity extends AppCompatActivity {

    @NotNull
    public final a.C0037a a = new a.C0037a(CoreModule.INSTANCE.safeInstance(this).getPreferencesStore());
    public a b;

    public final void a(String code) {
        boolean zAreEqual;
        a aVar = this.b;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("developerActivationViewModel");
            aVar = null;
        }
        aVar.getClass();
        Intrinsics.checkNotNullParameter(code, "code");
        List listSplit$default = StringsKt.split$default((CharSequence) "28/04/20/08", new String[]{"/"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
        }
        if (StringsKt.toIntOrNull(code) == null || code.length() != arrayList.size()) {
            zAreEqual = false;
        } else {
            int length = code.length();
            String str = "";
            for (int i = 0; i < length; i++) {
                str = str + ((((Number) arrayList.get(i)).intValue() ^ CharsKt.digitToInt(code.charAt(i))) << 1);
            }
            zAreEqual = Intrinsics.areEqual(str, "62144216");
        }
        if (!zAreEqual) {
            Toast.makeText(this, "Invalid password.", 0).show();
            return;
        }
        a aVar3 = this.b;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("developerActivationViewModel");
        } else {
            aVar2 = aVar3;
        }
        aVar2.a.putBoolean(PreferencesKey.DEVELOPER_MODE_ACTIVATION_STATE, true);
        aVar2.a.putBoolean(PreferencesKey.SESSION_REPLAY_DEFAULT_MASKING, true);
        aVar2.a.putBoolean(PreferencesKey.VERBOSE_LOG, true);
        setResult(-1);
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InstrumentationCallbacks.dispatchTouchEventCalled(this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        InstrumentationCallbacks.onConfigurationChangedCalled(this, configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) {
        InstrumentationCallbacks.onCreateCalled(this, bundle);
        super.onCreate(bundle);
        setContentView(R.layout.contentsquare_developer_activation_activity);
        a();
        setFinishOnTouchOutside(false);
        this.b = (a) this.a.create(a.class);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        InstrumentationCallbacks.onDestroyCalled(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        InstrumentationCallbacks.onRestartCalled(this);
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    public final void a() {
        final EditText editText = (EditText) findViewById(R.id.developer_password);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.developer.DeveloperActivationActivity$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return DeveloperActivationActivity.a(this.f$0, textView, i, keyEvent);
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled((Button) findViewById(R.id.developer_password_button), new View.OnClickListener() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.developer.DeveloperActivationActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeveloperActivationActivity.a(this.f$0, editText, view);
            }
        });
    }

    public static final boolean a(DeveloperActivationActivity this$0, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (i != 2) {
            return false;
        }
        this$0.a(textView.getText().toString());
        return true;
    }

    public static final void a(DeveloperActivationActivity this$0, EditText editText, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(editText.getText().toString());
    }
}
