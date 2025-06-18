public class DocumentFactory {
    public static final String WORD = "WORD";
    public static final String PDF = "PDF";
    public static final String EXCEL = "EXCEL";

    public static Document createDocument(String type){
        if(type == null || type. isEmpty()){
            throw new IllegalArgumentException("Document type cannot be null or empty");
        }
        switch(type.toUpperCase()){
            case WORD:
                return new WordDocument();
            case PDF:
                return new PdfDocument();
            case EXCEL:
                return new ExcelDocument();
            default:
                throw new IllegalArgumentException("Unknown document type:" +type);

        
        }
    }
    public static void processDocument(String type){
        Document doc = createDocument(type);
        doc.process();
    }
}
