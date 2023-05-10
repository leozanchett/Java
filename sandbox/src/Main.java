import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String uuidRequest = "";
        final String timestampRequest = "1682713730185";
        long timestamp = Long.parseLong(timestampRequest);
        Date dateRequest = new Date(timestamp);

        boolean requestUnique = false;
        final String readedData = "123";

        uuidRequest = null;

        if (uuidRequest == null || !uuidRequest.equals(readedData)) {
            Date datePlus14minutes = new Date(dateRequest.getTime() + 14 * 60 * 1000);
            if (datePlus14minutes.after(new Date())) {
                requestUnique = true;
            }
        }
        System.out.println(requestUnique);
    }
}