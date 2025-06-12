package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import java.io.*;

public class UploadAction extends ActionSupport {
    private File file;
    private String fileFileName;
    private String fileContentType;

    public String execute() {
        if (file == null) {
            addFieldError("file", "请选择要上传的文件！");
            return INPUT;
        }
        try {
            String uploadPath = ServletActionContext.getServletContext().getRealPath("/uploads");
            File dir = new File(uploadPath);
            if (!dir.exists()) dir.mkdirs();
            File dest = new File(dir, fileFileName);
            try (InputStream in = new FileInputStream(file);
                 OutputStream out = new FileOutputStream(dest)) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            }
            addActionMessage("文件上传成功！文件名：" + fileFileName);
            return SUCCESS;
        } catch (Exception e) {
            addFieldError("file", "文件上传失败：" + e.getMessage());
            return INPUT;
        }
    }

    public File getFile() { return file; }
    public void setFile(File file) { this.file = file; }
    public String getFileFileName() { return fileFileName; }
    public void setFileFileName(String fileFileName) { this.fileFileName = fileFileName; }
    public String getFileContentType() { return fileContentType; }
    public void setFileContentType(String fileContentType) { this.fileContentType = fileContentType; }
} 