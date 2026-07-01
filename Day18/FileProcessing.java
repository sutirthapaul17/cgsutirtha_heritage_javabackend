interface Printable{
    void printInfo();
}
abstract class FileProcessor{
    abstract void processFile();
}
class PDFProcessor extends FileProcessor implements Printable{
    void processFile(){System.out.println("Processing PDF file");}
    public void printInfo(){System.out.println("PDF Handler");}
}
class WordProcessor extends FileProcessor implements Printable{
    void processFile(){System.out.println("Processing Word file");}
    public void printInfo(){System.out.println("Word Handler");}
}
public class FileProcessing{
    public static void main(String[] args){
        FileProcessor f1=new PDFProcessor();
        FileProcessor f2=new WordProcessor();
        f1.processFile();
        ((Printable)f1).printInfo();
        f2.processFile();
        ((Printable)f2).printInfo();
    }
}
