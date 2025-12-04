package cucumber.runtime;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

/* loaded from: classes5.dex */
public class Env {
    public static final Env INSTANCE = new Env("cucumber");
    private final Map map;

    public Env() {
        this(null, System.getProperties());
    }

    public Env(String str) {
        this(str, System.getProperties());
    }

    public Env(Properties properties) {
        this(null, properties);
    }

    public Env(String str, Properties properties) {
        this.map = new HashMap();
        if (str != null) {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle(str);
                for (String str2 : bundle.keySet()) {
                    put(str2, bundle.getString(str2));
                }
            } catch (MissingResourceException unused) {
            }
        }
        if (properties != null) {
            for (String str3 : properties.stringPropertyNames()) {
                put(str3, properties.getProperty(str3));
            }
        }
        Map<String, String> map = System.getenv();
        for (String str4 : map.keySet()) {
            put(str4, map.get(str4));
        }
    }

    private void put(String str, String str2) {
        this.map.put(str, str2);
        Map map = this.map;
        String strReplace = str.replace('.', '_');
        Locale locale = Locale.ROOT;
        map.put(strReplace.toUpperCase(locale), str2);
        this.map.put(str.replace('_', '.').toLowerCase(locale), str2);
    }

    public String get(String str) {
        return (String) this.map.get(str);
    }

    public String get(String str, String str2) {
        String str3 = get(str);
        return str3 != null ? str3 : str2;
    }
}
