package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ConfigurationWatchList extends ContextAwareBase {
    List fileWatchList = new ArrayList();
    List lastModifiedList = new ArrayList();
    URL mainURL;

    private void addAsFileToWatch(URL url) {
        File fileConvertToFile = convertToFile(url);
        if (fileConvertToFile != null) {
            this.fileWatchList.add(fileConvertToFile);
            this.lastModifiedList.add(Long.valueOf(fileConvertToFile.lastModified()));
        }
    }

    public void addToWatchList(URL url) {
        addAsFileToWatch(url);
    }

    public ConfigurationWatchList buildClone() {
        ConfigurationWatchList configurationWatchList = new ConfigurationWatchList();
        configurationWatchList.mainURL = this.mainURL;
        configurationWatchList.fileWatchList = new ArrayList(this.fileWatchList);
        configurationWatchList.lastModifiedList = new ArrayList(this.lastModifiedList);
        return configurationWatchList;
    }

    public boolean changeDetected() {
        int size = this.fileWatchList.size();
        for (int i = 0; i < size; i++) {
            if (((Long) this.lastModifiedList.get(i)).longValue() != ((File) this.fileWatchList.get(i)).lastModified()) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.mainURL = null;
        this.lastModifiedList.clear();
        this.fileWatchList.clear();
    }

    File convertToFile(URL url) {
        if ("file".equals(url.getProtocol())) {
            return new File(URLDecoder.decode(url.getFile()));
        }
        addInfo("URL [" + url + "] is not of type file");
        return null;
    }

    public List<File> getCopyOfFileWatchList() {
        return new ArrayList(this.fileWatchList);
    }

    public URL getMainURL() {
        return this.mainURL;
    }

    public void setMainURL(URL url) {
        this.mainURL = url;
        if (url != null) {
            addAsFileToWatch(url);
        }
    }
}
