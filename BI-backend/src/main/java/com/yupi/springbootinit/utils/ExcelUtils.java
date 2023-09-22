package com.yupi.springbootinit.utils;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @PROJECT_NAME: springboot-init
 * @DESCRIPTION: Excel相关工具类: excel转Csv
 * @USER:
 * @DATE: 2023/9/21 19:37
 */
@Slf4j
public class ExcelUtils {

    public static String excelTocsv(MultipartFile multipartFile){
        File file = null;

//        try {
//            file = ResourceUtils.getFile("d.xlsx");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        // 读取数据
        List<Map<Integer, String>> list = null;

        try {
            list = EasyExcel.read(multipartFile.getInputStream())
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet()
                    .headRowNumber(0)
                    .doReadSync();
        } catch (IOException e) {
            log.error("表格处理错误", e);
            e.printStackTrace();
        }

        if (CollUtil.isEmpty(list)) {
            return "";
        }

        // 转换为csv
        StringBuilder stringBuilder = new StringBuilder();
        // 读取表头
        LinkedHashMap<Integer, String> headerMap = (LinkedHashMap) list.get(0);
        List<String> headerList = headerMap.values().stream().filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
        stringBuilder.append(StringUtils.join(headerList, ",")).append("\n");
        // 读取数据
        for (int i = 1; i < list.size(); i ++) {
            Map<Integer, String> dataMap = (LinkedHashMap) list.get(i);
            List<String> dataList = dataMap.values().stream().filter(ObjectUtil::isNotEmpty).collect(Collectors.toList());
            stringBuilder.append(StringUtils.join(dataList, ",")).append("\n");
        }
        return stringBuilder.toString();
    }

}
