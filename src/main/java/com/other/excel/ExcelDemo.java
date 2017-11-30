package com.other.excel;

import org.apache.poi.ss.usermodel.*;

import java.io.*;

/**
 * Excel��д
 * �ļ���C:\Users\lenovo\Desktop\ExcelTest.xlsx
 */
public class ExcelDemo {
    public static void main(String[] args) throws Exception {
                 String input="C:\\Users\\lenovo\\Desktop\\ExcelTest.xlsx";
//                 writeExcel(input,2007);           //xlsx��ʽ��2007,xls��ʽ��2003
                 readExcel(input,2007);

    }


        public static  void readExcel(String file,int edition) throws Exception {//��ȡ2003��2007�汾��Excel
            try {
                //�����ļ���
                FileInputStream fis=new FileInputStream(new File(file));
                //ͨ���ӿ�ʵ����Workbook������
                Workbook workbook=PoiUtil.getWorkbook(fis,edition);
                //ͨ���ӿڻ��Ĭ�ϵĵ�һ��sheet��ҳ��
                Sheet sheet = workbook.getSheetAt(0);
                //��ȡsheetҳ�ĵ�һ��
                Row row1 = sheet.getRow(0);

              //�ӵڶ��п�ʼ�������������һ��
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);//�õ�ÿһ��
                    for (int j = 0; j < row.getLastCellNum(); j++) {//�õ�ÿһ�е�ÿһ��
                        Cell cell = row.getCell(j);
                        // ����excel�е�Ԫ������ԣ����ò�ͬ�ĸ�ʽȡ����Чֵ
                        String cellValue = PoiUtil.getCellString(cell);
                        System.out.println("��Ԫ������Ϊ:"+cellValue);
                    }
                }
                fis.close();
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    public static void writeExcel(String file,int edition) throws Exception{

        FileInputStream fis=new FileInputStream(new File(file));
        Workbook workbook=PoiUtil.getWorkbook(fis,edition);
        Sheet sheet=workbook.getSheetAt(0);

        try {
            //��ȡ��һ��
            Row row0=sheet.getRow(0);
            //�ڵ�һ�е�һ��д������,����Ϊstring
            Cell cell0=row0.createCell(0, CellType.STRING);
            cell0.setCellValue("Order");
            //�ڵڶ��п�ʼд������
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                Cell cell=row.createCell(0, CellType.STRING);
                cell.setCellValue( String.valueOf(i+1) );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        fis.close();
        //ˢ�����Ļ�����,������д��excel
        FileOutputStream fos=new FileOutputStream(file);
        fos.flush();
        workbook.write(fos);
        //�ر��ļ���
        fos.close();
        workbook.close();

    }

}