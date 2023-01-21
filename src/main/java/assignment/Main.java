package assignment;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException,InterruptedException {
        String fileName = "./Files/extracted_log";
        Scanner keyboard = new Scanner(System.in);

            do {
                System.out.println("\n+--------------------SLUM Controller---------------------+");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("| 1 | Total completed and ended jobs by months           |");
                System.out.println("| 2 | Total jobs by partition                            |");   //Total = 9966(but not printed)
                System.out.println("| 3 | Total errors by user                               |");
                System.out.println("| 4 | Total jobs by partition for each month             |"); //total june-dec : 9216
                System.out.println("| 5 | Total nodes usage per partition                    |");
                System.out.println("| 6 | Execution Time                                     |");
                System.out.println("| 7 | Total Invalid Jobs                                 |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("-1 : Quit");
                System.out.print("Select -> ");
                int select = keyboard.nextInt();
                System.out.println();
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                switch (select) {
                    case 1 -> Job.JobCreatedEnded(fileName);
                    case 2 -> Partition.jobByPartitions(fileName);
                    case 3 -> ErrorByUser.getErrorByUser(fileName);
                    case 4 -> PartitionUsage.getJobsByPartition(fileName); //by month(A)
                    case 5 -> PartitionUsage.getNodeUsagePerPartition(fileName);
                    case 6 -> ExecutionTime.averageExecutionTime(fileName);
                    case 7 -> Invalid.InvalidJob(fileName);
                    case -1 -> {
                        System.out.println("Thank you!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid selection");
                }
            } while (true);

    }

    public static LocalDateTime convertToLDT(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'['yyyy-MM-dd'T'HH:mm:ss.SSS']'");
        return LocalDateTime.parse(date, formatter);
    }
}
