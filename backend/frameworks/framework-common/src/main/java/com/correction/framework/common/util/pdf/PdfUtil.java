package com.correction.framework.common.util.pdf;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * pdf操作相关工具
 */
public class PdfUtil {


    public static void initPdfText(Map<String,String> dataMap,String inputFileName,String outputFileName){
        OutputStream os = null;
        PdfStamper ps = null;
        PdfReader reader = null;
        PdfStamper stamper = null;
        try {
            File file = new File(outputFileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            os = new FileOutputStream(file);
            // 2 读入pdf表单
            reader = new PdfReader(inputFileName);
            // 3 根据表单生成一个新的pdf
            ps = new PdfStamper(reader, os);
            // 4 获取pdf表单
            AcroFields form = ps.getAcroFields();
            // 5给表单添加中文字体
            BaseFont bf = BaseFont.createFont("Font/SIMYOU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            form.addSubstitutionFont(bf);
            // 6查询数据================================================
            // 7遍历data 给pdf表单表格赋值
            for (String key : dataMap.keySet()) {
                boolean b = form.setField(key, dataMap.get(key));
                System.out.println(key+":"+b);
            }
            ps.setFormFlattening(true);
            System.out.println("===============PDF生成成功=============");
        } catch (Exception e) {
            System.out.println("===============PDF生成失败=============");
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                reader.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
