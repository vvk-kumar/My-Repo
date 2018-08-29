package com.excel.write;

import java.util.logging.Logger;


@Service("excelOutputService")
public class ExcelOutputServiceImpl implements ExcelOutputService{
  
   
    @Override
    public WritableWorkbook createExcelOutputExcel(HttpServletResponse response) {
       String fileName = "Excel_Output.xls";
       WritableWorkbook writableWorkbook = null;
       try {
           response.setContentType("application/vnd.ms-excel");

           response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

           writableWorkbook = Workbook.createWorkbook(response.getOutputStream());
          
           WritableSheet excelOutputsheet = writableWorkbook.createSheet("Excel Output", 0);
           addExcelOutputHeader(excelOutputsheet);
           writeExcelOutputData(excelOutputsheet);
           
           writableWorkbook.write();
           writableWorkbook.close();

       } catch (Exception e) {
           LOGGER.error("Error occured while creating Excel file", e);
       }

       return writableWorkbook;
    }