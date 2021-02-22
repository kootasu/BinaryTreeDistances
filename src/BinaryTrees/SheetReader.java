package BinaryTrees;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class SheetReader {

    private HSSFSheet sheet;

    /**
     * Sheetreader constructor creates HSSFSheet from XSL file
     * @param pathname
     * @throws IOException
     */
    public HSSFSheet createHSSFSheet(String pathname) throws IOException {
        File excelFile = new File(pathname);
        FileInputStream fileInputStream = new FileInputStream(excelFile);
        // XSSF Workbook from Apache POI for working with XLS sheets
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        // Let's get the sheet
        HSSFSheet sheet = workbook.getSheetAt(0);
        // Closing down
        workbook.close();
        fileInputStream.close();
        return sheet;
    }

    /**
     *
     * @throws IOException
     */
    public void readSheet() throws IOException {
        // Iterate over rows
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Iterate over cells for the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();

                // Just seeing if this works
                System.out.println(cell + "\n");
            }
        }
    }

    /**
     * Returns ArrayList<CityNode> with values form 1st and 2nd row of XSL sheet
     * @return
     * @throws IOException
     */
    public ArrayList<CityNode> createCityNodes(String pathname) throws IOException {
        ArrayList<CityNode> cityNodes = new ArrayList<>();
        HSSFSheet sheet = createHSSFSheet(pathname);
        // Iterate over first 2 rows
        int i = 0;
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext() && i < 1) {
            Row row = rowIterator.next();
            // Iterate over cells for the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                int columnNumber = cell.getColumnIndex();
                cityNodes.add(new CityNode(cell.getStringCellValue(), (int) sheet.getRow(i + 1).getCell(columnNumber).getNumericCellValue()));
            }
            i++;
        }
        return cityNodes;
    }

    /**
     * Returns ArrayList<DistanceNode> with values form 2nd row of XSL sheet
     * @return
     * @throws IOException
     */
    public ArrayList<DistanceNode> createDistanceNodes(String pathname) throws IOException {
        HSSFSheet sheet = createHSSFSheet(pathname);
        ArrayList<DistanceNode> distanceNodes = new ArrayList<>();
        Iterator<Cell> cellIterator = sheet.getRow(1).iterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            distanceNodes.add(new DistanceNode((int) cell.getNumericCellValue()));
            }
        return distanceNodes;
    }


}

