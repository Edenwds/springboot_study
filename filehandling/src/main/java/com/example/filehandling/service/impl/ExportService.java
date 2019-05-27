package com.example.filehandling.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.filehandling.service.IExportService;
import com.example.filehandling.utils.ExcelUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 18:19 2019/5/24
 */
@Service
public class ExportService implements IExportService {

    @Override
    public String exportFile(int planId, OutputStream outputStream) {
        String title = "Export Test";
        System.out.println(planId);
        String[] rowNames = {"uid", "uname", "uage"};
        List<JSONObject> dataList = new ArrayList<>();
        JSONObject j1 = new JSONObject();
        j1.put("uid", 1000);
        j1.put("uname", "zhangsanfasdfaklsjdflk;jalksjdklfjklajskldjflkajshjkgvhzxcjkvnz,mxncvmznx.mc,vnasldkhjgwieyhtiuyhudighajshfdjklahskjdhflkjhasjkhdfjkhajshdfjkhajkshdjfkh");
        j1.put("uage", 21);

        JSONObject j2 = new JSONObject();
        j2.put("uid", 1002);
        j2.put("uname", "list");
        j2.put("uage", 23);

        dataList.add(j1);
        dataList.add(j2);

        try {
            ExcelUtil.export(title, rowNames, dataList, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "user";
    }
}
