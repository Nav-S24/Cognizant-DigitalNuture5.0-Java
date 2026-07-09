public class FactoryTest {

    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordFactory();
        DocumentFactory pdfFactory = new PdfFactory();
        DocumentFactory excelFactory = new ExcelFactory();

        Document d1 = wordFactory.createDocument();
        Document d2 = pdfFactory.createDocument();
        Document d3 = excelFactory.createDocument();

        d1.open();
        d2.open();
        d3.open();
    }
}