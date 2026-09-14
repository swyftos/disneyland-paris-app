package com.appdynamics.eumagent.runtime.p192private;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.af */
/* JADX INFO: loaded from: classes2.dex */
public final class C2056af {

    /* JADX INFO: renamed from: a */
    public final c f505a;

    /* JADX INFO: renamed from: b */
    public final AtomicLong f506b;

    /* JADX INFO: renamed from: c */
    public final AtomicLong f507c;

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.af$c */
    public interface c {
        /* JADX INFO: renamed from: a */
        void mo531a(String str);

        /* JADX INFO: renamed from: a */
        void mo532a(String str, long j);

        /* JADX INFO: renamed from: a */
        void mo533a(String str, String str2);

        /* JADX INFO: renamed from: b */
        long mo534b(String str, long j);

        /* JADX INFO: renamed from: b */
        String mo535b(String str, String str2);

        /* JADX INFO: renamed from: b */
        boolean mo536b(String str);
    }

    public C2056af(Context context) {
        this(new a(context));
        if (!this.f505a.mo536b("is_migrated")) {
            b bVar = new b(context);
            ADLog.logVerbose("Migrating AgentMetaData from SharedPreferences to SQL");
            this.f505a.mo533a("mobileAgentToken", bVar.mo535b("mobileAgentToken", "-1"));
            this.f505a.mo533a("agentIdentifier", bVar.mo535b("agentIdentifier", (String) null));
            this.f505a.mo532a("event_counter", bVar.mo534b("event_counter", 0L));
            this.f505a.mo532a("disable_agent_till", bVar.mo534b("disable_agent_till", -1L));
            this.f505a.mo531a("is_migrated");
        }
        this.f506b.set(this.f505a.mo534b("event_counter", 0L));
        this.f506b.addAndGet(100L);
        this.f506b.incrementAndGet();
        this.f505a.mo532a("event_counter", this.f506b.get());
        this.f507c.set(this.f505a.mo534b("session_counter", -1L));
    }

    private C2056af(c cVar) {
        this.f506b = new AtomicLong();
        this.f507c = new AtomicLong();
        this.f505a = cVar;
    }

    /* JADX INFO: renamed from: a */
    public final String m530a() {
        String strMo535b = this.f505a.mo535b("agentIdentifier", (String) null);
        if (strMo535b != null) {
            return strMo535b;
        }
        String string = UUID.randomUUID().toString();
        this.f505a.mo533a("agentIdentifier", string);
        return string;
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.af$a */
    static class a implements c {

        /* JADX INFO: renamed from: a */
        private final SQLiteDatabase f508a;

        /* JADX INFO: renamed from: b */
        private final C2055ae f509b;

        public a(Context context) {
            C2055ae c2055ae = new C2055ae(context);
            this.f509b = c2055ae;
            this.f508a = c2055ae.getWritableDatabase();
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: a */
        public final void mo531a(String str) {
            C2055ae c2055ae = this.f509b;
            SQLiteDatabase sQLiteDatabase = this.f508a;
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", Boolean.TRUE);
            c2055ae.m529a(sQLiteDatabase, "booleans", contentValues, "key", str);
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: b */
        public final boolean mo536b(String str) {
            Boolean boolM528c = C2055ae.m528c(this.f508a, str);
            if (boolM528c != null) {
                return boolM528c.booleanValue();
            }
            return false;
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: a */
        public final void mo532a(String str, long j) {
            C2055ae c2055ae = this.f509b;
            SQLiteDatabase sQLiteDatabase = this.f508a;
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", Long.valueOf(j));
            c2055ae.m529a(sQLiteDatabase, "longs", contentValues, "key", str);
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: b */
        public final long mo534b(String str, long j) {
            Long lM527b = C2055ae.m527b(this.f508a, str);
            return lM527b != null ? lM527b.longValue() : j;
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: a */
        public final void mo533a(String str, String str2) {
            C2055ae c2055ae = this.f509b;
            SQLiteDatabase sQLiteDatabase = this.f508a;
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", str2);
            c2055ae.m529a(sQLiteDatabase, "strings", contentValues, "key", str);
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: b */
        public final String mo535b(String str, String str2) {
            String strM526a = C2055ae.m526a(this.f508a, str);
            return strM526a != null ? strM526a : str2;
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.af$b */
    @Deprecated
    static class b implements c {

        /* JADX INFO: renamed from: a */
        private final SharedPreferences f510a;

        b(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null!");
            }
            this.f510a = context.getApplicationContext().getSharedPreferences("com.appdynamics.eumagent.runtime.agentState", 0);
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: a */
        public final void mo531a(String str) {
            this.f510a.edit().putBoolean(str, true).commit();
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: b */
        public final boolean mo536b(String str) {
            return this.f510a.getBoolean(str, false);
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: a */
        public final void mo532a(String str, long j) {
            this.f510a.edit().putLong(str, j).commit();
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: b */
        public final long mo534b(String str, long j) {
            return this.f510a.getLong(str, j);
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: a */
        public final void mo533a(String str, String str2) {
            this.f510a.edit().putString(str, str2).commit();
        }

        @Override // com.appdynamics.eumagent.runtime.p192private.C2056af.c
        /* JADX INFO: renamed from: b */
        public final String mo535b(String str, String str2) {
            return this.f510a.getString(str, str2);
        }
    }
}
