import java.util.Scanner;

public class AssetListView {

    private final Appendable log;
    private final Scanner scanner;

    public AssetListView(Appendable log, Readable scanner){
        if (log == null){
            throw new IllegalArgumentException("Appendable cannot be null");
        }
        this.log = log;
        this.scanner = new Scanner(scanner);
    }

    public void append(String s){
        try {
            this.log.append(s);
        } catch (Exception e){
            throw new IllegalStateException("Append failed");
        }
    }

    public String getInput(String prompt){
        append(prompt);
        return scanner.nextLine();
    }
}