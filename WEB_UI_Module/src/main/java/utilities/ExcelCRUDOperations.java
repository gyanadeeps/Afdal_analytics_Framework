package utilities;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.extern.java.Log;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.testng.SkipException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Log
public class ExcelCRUDOperations {
    public String path;
    public FileInputStream fis;
    public FileOutputStream fileOut;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;


    public ExcelCRUDOperations(String path) {

        this.path = path;
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (FileNotFoundException e) {
            e.getMessage();

        } catch (IOException e) {

        }
    }


    /**
     * returns the row count in a sheet
     **/
    public int getRowCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return 0;
        else {
            sheet = workbook.getSheetAt(index);
            int number = sheet.getLastRowNum() + 1;
            return number;
        }

    }

    // returns the data from a cell
    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1) {
                log.info("Sheet '" + sheetName + "' not found in spreadsheet.");
                throw new SkipException("Sheet '" + sheetName + "' not found in spreadsheet.");
            }


            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                // System.out.println(row.getCell(i).getStringCellValue().trim());
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    colNum = i;
            }
            if (colNum == -1) {
                return "";
            }


            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                throw new SkipException("Test Case row not found.");
            cell = row.getCell(colNum);

            if (cell == null)
                return "";
            // System.out.println(cell.getCellType());
            if (cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue();
            else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

                String cellText = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // format in form of M/D/YY
                    double d = cell.getNumericCellValue();

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

                    // System.out.println(cellText);

                }

                return cellText;
            } else if (cell.getCellType() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        } catch (IllegalArgumentException e) {

            e.getMessage();
            return "row " + rowNum + " or column " + colName + " does not exist in xls";
        }
    }


    // returns the data from a cell
    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";

            int index = workbook.getSheetIndex(sheetName);

            if (index == -1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(colNum);
            if (cell == null)
                return "";

            if (cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue();
            else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

                String cellText = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // format in form of M/D/YY
                    double d = cell.getNumericCellValue();

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

                    // System.out.println(cellText);

                }

                return cellText;
            } else if (cell.getCellType() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        } catch (Exception e) {

            e.getMessage();
            return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
        }
    }


    public boolean setCellData(String sheetName, String colName, int rowNum, String data) {

        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if (rowNum <= 0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1)
                return false;

            sheet = workbook.getSheetAt(index);

            row = sheet.getRow(0);
            // System.out.println("Sheet Row"+row);

            for (int i = 0; i < row.getLastCellNum(); i++) {
                //System.out.println("Xla_reader----"+row.getCell(i).getStringCellValue().trim());
                if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
                    colNum = i;
                    break;
                }
                // System.out.println("Column Number---> "+colNum);

            }

            if (colNum == -1)
                return false;

            //sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum);
            if (row == null)
                row = sheet.createRow(rowNum);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            // cell style
            // CellStyle cs = workbook.createCellStyle();
            // cs.setWrapText(true);
            // cell.setCellStyle(cs);
            cell.setCellValue(data);
            //fis.close();

            fileOut = new FileOutputStream(path);

            workbook.write(fileOut);

            fileOut.close();

        } catch (IOException e) {
            // testSteps.info("Column "+"'"+colName+"'"+" not present in Excel file to set the value");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOut.close();
            } catch (Exception e) {
                // e.printStackTrace();

                //testSteps.info("Column "+"'"+colName+"'"+" not present in Excel file to set the value");
            }
        }
        return true;

    }


    // returns true if sheet is created successfully else false
    public boolean addSheet(String sheetname) {

        FileOutputStream fileOut;
        try {
            workbook.createSheet(sheetname);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
            return false;
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
        return true;
    }

    // returns true if sheet is removed successfully else false if sheet does not
    // exist
    public boolean removeSheet(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return false;

        FileOutputStream fileOut;
        try {
            workbook.removeSheetAt(index);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
            return false;
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
        return true;
    }

    // returns true if column is created successfully
    public boolean addColumn(String sheetName, String colName) {
        // System.out.println("**************addColumn*********************");

        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1)
                return false;

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT.getIndex());
            style.setFillPattern(FillPatternType.NO_FILL);

            sheet = workbook.getSheetAt(index);

            row = sheet.getRow(0);
            if (row == null)
                row = sheet.createRow(0);

            // cell = row.getCell();
            // if (cell == null)
            // System.out.println(row.getLastCellNum());
            if (row.getLastCellNum() == -1)
                cell = row.createCell(0);
            else
                cell = row.createCell(row.getLastCellNum());

            cell.setCellValue(colName);
            cell.setCellStyle(style);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();

        } catch (FileNotFoundException e) {
            e.getMessage();
            return false;
        } catch (IOException e) {
            e.getMessage();
            return false;
        }

        return true;

    }


    public boolean deleteRows(String sheetName, int startRow) {
        try {


            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            int index = workbook.getSheetIndex(sheetName);
            sheet = workbook.getSheetAt(index);
            int totalRows = sheet.getLastRowNum();
            for (int rowNo = 1; rowNo < totalRows; rowNo++) {
                if (rowNo >= 0 && rowNo < totalRows) {
                    sheet.shiftRows(rowNo + 1, totalRows, -1);
                }
                if (rowNo == totalRows) {
                    XSSFRow removingRow = sheet.getRow(rowNo);
                    if (removingRow != null) {
                        sheet.removeRow(removingRow);
                    }
                }
            }
           /* for (int i = 1; i < totalRows; i++) {
                row = sheet.getRow(i);
                sheet.removeRow(row);
                log.info("ROw deleted --> " + i );
            }
*/

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();


        } catch (Exception e) {
            log.info(e.getMessage());

        }
        return true;
    }

    // removes a column and all the contents
    public boolean removeColumn(String sheetName, int colNum) {
        try {
            if (!isSheetExist(sheetName))
                return false;
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT.getIndex());
            // XSSFCreationHelper createHelper = workbook.getCreationHelper();
            style.setFillPattern(FillPatternType.NO_FILL);

            for (int i = 0; i < getRowCount(sheetName); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    cell = row.getCell(colNum);
                    if (cell != null) {
                        cell.setCellStyle(style);
                        row.removeCell(cell);
                    }
                }
            }
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
            return false;
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
        return true;

    }

    // find whether sheets exists
    public boolean isSheetExist(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            index = workbook.getSheetIndex(sheetName.toUpperCase());
            if (index == -1)
                return false;
            else
                return true;
        } else
            return true;
    }

    // returns number of columns in a sheet
    public int getColumnCount(String sheetName) {
        // check if sheet exists
        if (!isSheetExist(sheetName))
            return -1;

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);

        if (row == null)
            return -1;

        return row.getLastCellNum();

    }


    public HashMap<String, String> getCellDataWithColName(String sheetName, String colName, int rowNum) {
        HashMap<String, String> columnData = new HashMap<>();

        int columnNumber;
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);

        try {
            if (rowNum <= 0 || index == -1) {
                //return columnData;
                throw new RuntimeException("Null values are not accepted!");
            }

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                String columnName = row.getCell(i).getStringCellValue().trim();

                if (columnName.startsWith(colName)) {
                    columnNumber = i;

                    // Getting column data to add to the hashmap
                    XSSFRow rowNew = sheet.getRow(rowNum - 1);
                    cell = rowNew.getCell(columnNumber);

                    if (cell == null) {
                        continue;
                    } else if (cell.getCellType() == CellType.STRING) {
                        columnData.put(columnName.substring(columnName.indexOf("_") + 1), cell.getStringCellValue().trim());
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        int integerValue = (int) cell.getNumericCellValue();
                        String cellText = String.valueOf(integerValue).trim();
                        columnData.put(columnName.substring(columnName.indexOf("_") + 1), cellText);
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Null values are not accepted!", e);
        }

        return columnData;
    }


    public Multimap<String, String> storeTwoColumnDataInMap(String sheetName, String colNameForKey, String colNameForValue, int headerRow) {

        Multimap<String, String> DataFormExcel = ArrayListMultimap.create();
        try {
            int keyColumn = 0, valueColumn = 0;
            int index = workbook.getSheetIndex(sheetName);
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(headerRow);
            String keyCell;
            String valueCell;


            /*if (headerRow <= 0 || index == -1) {
                //return columnData;
                throw new RuntimeException("Null values are not accepted!");
            }*/

            for (int i = 0; i < row.getLastCellNum(); i++) {
                String columnName = row.getCell(i).getStringCellValue().trim();

                if (columnName.equalsIgnoreCase(colNameForKey)) {
                    keyColumn = i;
                }

                if (columnName.equalsIgnoreCase(colNameForValue)) {
                    valueColumn = i;
                }


            }

            for (int i = headerRow + 1; i < sheet.getLastRowNum(); i++) {
                System.out.println(" Total number of rows in sheet ---> " + sheet.getLastRowNum());
                row = sheet.getRow(i);
                keyCell = row.getCell(keyColumn).getStringCellValue().trim();
                valueCell = row.getCell(valueColumn).getStringCellValue().trim();

                if (keyCell != null) {
                    if (valueCell == null || valueCell.equals("")) {
                        DataFormExcel.put(keyCell, "Cell is Blank");
                    } else
                        DataFormExcel.put(keyCell, valueCell);
                    // log.info("Key Cell -->" + keyCell + "   Value Cell --> "+ valueCell);

                }


            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        return DataFormExcel;
    }


    public HashMap<Integer, HashMap<String, String>> storeExcelInMap(String sheetName, String colNameForKey, int headerRow) {

        HashMap<Integer, HashMap<String, String>> tableValues = new HashMap<>();


        try {
            int keyColumn = 0, valueColumn = 0;
            int index = workbook.getSheetIndex(sheetName);
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(headerRow);
            int keyCell = 0;
            String valueCell;

            int totalColumn = getColumnCount(sheetName);
            int totalNumberOfRows = sheet.getLastRowNum();

            String[] mapKeysInMapData = new String[row.getLastCellNum()];

            for (int i = 0; i < row.getLastCellNum(); i++) {
                String columnName = row.getCell(i).getStringCellValue().trim();
                mapKeysInMapData[i] = columnName.trim();

                if (columnName.equalsIgnoreCase(colNameForKey)) {
                    keyColumn = i;
                }


            }
            System.out.println(" Total number of rows in sheet ---> " + sheet.getLastRowNum());
            for (int i = headerRow + 1; i <= sheet.getLastRowNum(); i++) {

                row = sheet.getRow(i);
                if (row.getCell(keyColumn,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() == CellType.NUMERIC) {
                    keyCell = (int) row.getCell(keyColumn).getNumericCellValue();

                }

                HashMap<String, String> map = new HashMap<>();

                for (int ii = 0; ii < row.getLastCellNum(); ii++) {
                    String key = mapKeysInMapData[ii].trim();
                    String value = null;
                    if (row.getCell(ii,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() == CellType.BLANK) {
                        value = row.getCell(ii, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                        System.out.print("Missing Values ******************************************************");
                    }

                    if (row.getCell(ii,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() == CellType.NUMERIC) {
                        value = String.valueOf((int) row.getCell(ii,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
                    }
                    if (row.getCell(ii,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() == CellType.STRING) {
                        value = row.getCell(ii,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue().trim();
                    }


                    map.put(key, value);

                }

                tableValues.put(keyCell, map);

            }

        } catch (Exception e) {

            log.info("Exception: "+e.getMessage());
        }
        //log.info(tableValues.toString());

        return tableValues;
    }


    public List<Integer> getColumnDataInArrayList(String sheetName, String colName, int headerRow) {
        List<Integer> columnData = new ArrayList();
        try {
            int keyColumn = 0, valueColumn = 0;
            int index = workbook.getSheetIndex(sheetName);
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(headerRow);
            int keyCell = 0;

            if (sheet.getLastRowNum() <= 0 || index == -1) {
                //return columnData;
                throw new RuntimeException("Sheet is empty");
            }

            for (int i = 0; i < row.getLastCellNum(); i++) {
                String columnName = row.getCell(i,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue().trim();

                if (columnName.equalsIgnoreCase(colName)) {
                    keyColumn = i;
                    break;
                }
            }

            for (int i = headerRow + 1; i <= sheet.getLastRowNum(); i++) {

                row = sheet.getRow(i);
                if (row.getCell(keyColumn,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK) == null) {
                    continue;
                }
                if (row.getCell(keyColumn,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() == CellType.NUMERIC) {
                    int integerValue = (int) row.getCell(keyColumn,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                    columnData.add(integerValue);
                }


            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        return columnData;

    }
}