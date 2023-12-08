import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.Iterator;

public class XML_XLS_Ser_Deser {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        People people = new People("Dmitry", 34,
                new Car("Ferrary", 100, 3_000_000));
        String path = pathSerXML(people);
        deSerXml(path);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("My Worksheet");
        Row row = worksheet.createRow(0);
        Cell cell1 = row.createCell(0);
        cell1.setCellValue("Hello");
        Cell cell2 = row.createCell(1);
        cell2.setCellValue("World!");
        try (FileOutputStream outputStream = new FileOutputStream("data/file.xls")){
            workbook.write(outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        try(FileInputStream fileInputStream = new FileInputStream("data/file.xls")){
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            Iterator<Row> rowIterator = hssfSheet.iterator();
            while (rowIterator.hasNext()){
                Row row1 = rowIterator.next();
                Iterator<Cell> cellIterator = row1.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    String value = cell.getStringCellValue();
                    System.out.println(value + "\t");
                }
                System.out.println();
            }
        } catch (IOException e){
            e.printStackTrace();
        }





    }






    public static String  pathSerXML(Object o) {
        File file = new File("data/simple_People.xml");
        try {
            XmlMapper mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file,
                    o);

        } catch (IOException e){
            e.printStackTrace();
        }
        return file.getPath();
    }

    public static void deSerXml(String path){
        try {
            XmlMapper mapper = new XmlMapper();
            File file = new File(path);
            People people = mapper.readValue(file, People.class);
            System.out.println(people);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
