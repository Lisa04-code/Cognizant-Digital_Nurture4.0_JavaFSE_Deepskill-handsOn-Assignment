public class DocumentApp {
    public static void main(String[]args){
        System.out.println("Processing Word Document:");
        DocumentFactory.processDocument(DocumentFactory.WORD);
        System.out.println("\nProcessing PDF Document:");
        Document pdfDoc = DocumentFactory.createDocument("pdf");
        pdfDoc.process();
        System.out.println("\nProcessing Excel Document:");
        Document excelDoc = DocumentFactory.createDocument(DocumentFactory.EXCEL);

        excelDoc.open();
        excelDoc.save();
        excelDoc.close();

        try{
            System.out.println("\n Testing invalid document type:");
            DocumentFactory.createDocument("PPT");
        }catch(IllegalArgumentException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}
