// loadshed.java
// This program determines if your house has power after K load-shedding announcements.
// Each test case (line) contains N (number of stations) and K (number of announcements).
// Output for each test case: "Case #x: ON" or "Case #x: OFF"

import java.io.*;
import java.math.BigInteger; // Used for very large numbers

public class loadshed {
    public static void main(String[] args) throws Exception {

        // Define the input and output files.
        // The program reads from ts1_input.txt and writes to output.txt
        File inputFile = new File("ts1_input.txt");
        File outputFile = new File("output.txt");

        //Setup readers and writers for file I/O
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        PrintWriter pw = new PrintWriter(new FileWriter(outputFile));

        String line;      // stores each input line
        int caseNum = 1;  // keeps track of "Case #1", "Case #2", etc.

        //  Read each test case line-by-line until the end of the file
        while ((line = br.readLine()) != null) {
            line = line.trim();            // remove extra spaces
            if (line.isEmpty()) continue;  // skip empty lines

            // Split line into two parts: N and K
            String[] parts = line.split("\\s+");
            if (parts.length < 2) continue;  // if invalid line, skip it

            //Parse the values
            int N = Integer.parseInt(parts[0]);  // number of stations
            BigInteger K = new BigInteger(parts[1]);  // number of announcements (can be large)

            // Determine if the house has power
            // The house has power if all the lowest N bits of K are 1
            // (e.g., for N=3, we check the lowest 3 bits of K)
            boolean hasPower = true;

            // Loop over bits 0 to N-1
            for (int i = 0; i < N; i++) {
                // testBit(i) checks if the i-th bit (starting from 0) is 1.
                // example 6 = 110 and 3 = 11
                // If it's 0, that means one station is OFF -> no power
                if (!K.testBit(i)) {
                    hasPower = false;
                    break; // stop checking further
                }
            }

            // Write the result in the required format
            // Example: Case #1: ON
            pw.println("Case #" + caseNum + ": " + (hasPower ? "ON" : "OFF"));
            caseNum++; // move to next case
        }

        // Close file resources properly
        br.close();
        pw.close();

        // 8 Print confirmation to the console (not required for marking)
        System.out.println("Output written to output.txt (" + (caseNum - 1) + " cases)");
    }
}
