package com.example.filehandling.service;

import java.io.OutputStream;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 18:18 2019/5/24
 */
public interface IExportService {
    String exportFile(int planId, OutputStream outputStream);
}
