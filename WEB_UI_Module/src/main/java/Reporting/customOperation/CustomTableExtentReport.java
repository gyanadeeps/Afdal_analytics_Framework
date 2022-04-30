package Reporting.customOperation;


import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class CustomTableExtentReport {


    public String getMarkup(String[][] data, String commaSeparatedHeadersName) {

        String headersArray[] = commaSeparatedHeadersName.split(",");
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\" width=\"100%\">");
        sb.append("<col style=width:20%> ");
//sb.append("<col style=width:20%><col style=width:32%><col style=width:33%><col style=width:15%>");
        String ColumnWidth = dynamicColumnWidthExcludingFirstandLastColumn(headersArray.length);

        for (int column = 0; column < headersArray.length - 2; column++) {
            data[0][column] = headersArray[column];
//Markup markUptext = MarkupHelper.createLabel(data[0][column], ExtentColor.RED);
            sb.append("<col style=width:" + ColumnWidth + ">");
        }

        sb.append("<col style=width:14%>");
        sb.append("<thead>");
        sb.append("<tr color=black>");
        for (int column = 0; column < headersArray.length; column++) {
            data[0][column] = headersArray[column];
            Markup markUptext = MarkupHelper.createLabel(data[0][column], ExtentColor.WHITE);
            sb.append("<th bgcolor=\"#F0F8FF\">" + markUptext.getMarkup() + "</th>");
        }
        sb.append("</tr>");
        sb.append("</thead>");
        for (int row = 1; row < data.length; row++) {
            sb.append("<tr>");

            for (int col = 0; col < data[row].length; col++) {
                //System.out.println("Column Length" + data[row].length );
                if (col == data[row].length - 1) {
                    if (data[row][col].equalsIgnoreCase("pass")) {
                        Markup m = MarkupHelper.createLabel(data[row][col], ExtentColor.GREEN);
                        sb.append("<td >" + m.getMarkup() + "</td>");
                    } else {
                        Markup m1 = MarkupHelper.createLabel(data[row][col], ExtentColor.RED);

                        sb.append("<td>" + m1.getMarkup() + "</td>");
                    }
                } else
                    sb.append("<td>" + data[row][col] + "</td>");
            }
            sb.append("</tr>");
        }

        sb.append("</table>");
        return sb.toString();

    }


    public static String dynamicColumnWidthExcludingFirstandLastColumn(int numberofColumns) {
        String widthPercentage = null;
        if (numberofColumns <= 2) {
            return "50%";
        }
        numberofColumns = numberofColumns - 2;
        int width = (int) (66 / numberofColumns);
        widthPercentage = width + "%";
        return widthPercentage;


    }
}


