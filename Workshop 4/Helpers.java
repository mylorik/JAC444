
/**
 * Helpers
 */
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helpers {
    private Scanner input = new Scanner(System.in);

    public double getPhoneNumber(String message) {
        System.out.print(message);
        do {
            var i = getNextLine();
            if (!i.contains("1") && !i.contains("0")) {
                if (isDouble(i) && Double.parseDouble(i) >= 0) {
                    return Double.parseDouble(i);
                }
            }
            System.out.println("input is incorrect, try again:");
            System.out.print(message);
        } while (true);

    }

    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void closeInput() {
        // why would you use it????
        // it's unsafe for your app, let this object just disappear together with input
        input.close();
        System.out.println("input closed! Be safe!");
    }

    public String getNextLine() {
        var i = input.nextLine().trim().replaceAll(" ", "");
        return i;
    }

    public File CreateFile(String fileName) throws IOException {
        var file = new File(fileName);
        file.createNewFile();
        return file;
    }

    public void SaveFile(String fileName, String stringData) throws IOException {
        Files.write(Paths.get(fileName), stringData.getBytes());
    }

    public String ReadFile(String fileName) throws IOException {

        String line = null;
        var toReturn = "";
        var fileReader = new FileReader(fileName);
        var bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            toReturn += line;
        }
        bufferedReader.close();
      return toReturn;
    }

}