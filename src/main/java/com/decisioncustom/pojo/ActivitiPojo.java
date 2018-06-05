package com.decisioncustom.pojo;

import java.io.File;

public class ActivitiPojo {
    private String name;
    private File processFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getProcessFile() {
        return processFile;
    }

    public void setProcessFile(File processFile) {
        this.processFile = processFile;
    }
}
