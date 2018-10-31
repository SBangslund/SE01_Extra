/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package extra_05.data;

import java.io.File;

/**
 *
 * @author Samuel Bangslund
 */
public class Data {

    private String path;
    private String input;
    private File file;

    public Data() {
        this("no path");
    }

    public Data(String absolutePath) {
        this.path = absolutePath;

        init();
    }

    private void init() {
        file = new File(path);
    }

    public String fileSummary() {
        return String.format("name:[%s], path:[%s]", file.getName(), file.getAbsolutePath());
    }

    public String getPath() {
        return path;
    }

    public String getInput() {
        return input;
    }

    public File getFile() {
        return this.file;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
