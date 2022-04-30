package utilities;

import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.java.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Log
public class UtilOperations {

    public boolean fileGenerationFromMap(String filePath, Multimap<String, String> mapToWriteInFile) throws IOException {

        Gson gson2 = new GsonBuilder()
                .setPrettyPrinting().serializeNulls()
                .create();
        FileWriter dataFile =
                new FileWriter(filePath);
        gson2.toJson(mapToWriteInFile.asMap(), dataFile);
        dataFile.flush();
        dataFile.close();
        return true;
    }



    public Multimap<String, String> getDataPathMultiMap(String FilePath, String sheetName, String columnKey, String columnValue, int headerRow) {
        ExcelCRUDOperations crud = new ExcelCRUDOperations(FilePath);
        return crud.storeTwoColumnDataInMap(sheetName, columnKey, columnValue, headerRow);
    }


    public boolean dataComparatorExcelJsonAndExcel(String excelFilePath, Multimap<String, String> parsedXmlMultiMap, Multimap<String, String> parsedJsonMultiMap) {

        ExcelCRUDOperations crudExcel = new ExcelCRUDOperations(excelFilePath);
        crudExcel.deleteRows("Artifact",1);
        int rowNumber = 0;
        try {
            log.info("Total number of XML elements found : [ " + parsedXmlMultiMap.keySet().size() + " ]");
            for (String dataElement : parsedXmlMultiMap.keySet()) {
                rowNumber = rowNumber + 1;
                List<String> xmlValues = (List<String>) parsedXmlMultiMap.get(dataElement);
                List<String> jsonValues = (List<String>) parsedJsonMultiMap.get(dataElement);
                Collections.sort(xmlValues);
                Collections.sort(jsonValues);
                crudExcel.setCellData("Artifact", "Data Element", rowNumber, dataElement);
                if (xmlValues.toString().length() > 32000) {

                } else {

                    crudExcel.setCellData("Artifact", "Xml Values", rowNumber, xmlValues.toString());
                    crudExcel.setCellData("Artifact", "Json Values", rowNumber, jsonValues.toString());

                }
            }
        } catch (Exception e) {
            log.info(e.getMessage());

        }


        return true;
    }



    public static String jsonStringConversionKeyString(Multimap<String, String> mapToWriteInFile)  {

        Gson gson2 = new GsonBuilder()
                .setPrettyPrinting().serializeNulls()
                .create();
        String json= gson2.toJson(mapToWriteInFile.asMap());

        return json;
    }

    public static String jsonStringConversionKeyInteger(HashMap<Integer, HashMap<String, String>>  mapToWriteInFile)  {

        Gson gson2 = new GsonBuilder()
                .setPrettyPrinting().serializeNulls()
                .create();
        String json= gson2.toJson(mapToWriteInFile);

        return json;
    }
}