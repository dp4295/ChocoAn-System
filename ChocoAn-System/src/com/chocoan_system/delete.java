package com.chocoan_system;
import java.io.*;

public class delete {

    public void member_delete(String name) {

        try {
            File inputFile = new File("./ChocoAn-System/src/com/chocoan_system/files/member/member_directory.txt");
            if (!inputFile.isFile()) {
                System.out.println("Not an existing file");//check file path
                return;
            }
            //temp file to store info not to be deleted
            File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader("member_directory.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;

            while ((line = br.readLine()) != null) {
                if (!line.equals("john")) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete original file
            if (!inputFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename temp file to the original file name.
            if (!tempFile.renameTo(inputFile))
                System.out.println("Could not rename file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

