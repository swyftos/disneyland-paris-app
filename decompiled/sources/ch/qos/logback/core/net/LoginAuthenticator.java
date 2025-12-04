package ch.qos.logback.core.net;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/* loaded from: classes2.dex */
public class LoginAuthenticator extends Authenticator {
    String password;
    String username;

    LoginAuthenticator(String str, String str2) {
        this.username = str;
        this.password = str2;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.username, this.password);
    }
}
