import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Operations apo = new Operations();
        String ch = "no";

        // abc dfafasf
        IO.println("No tasks in list. Please add a task.\nEnter a task:");
        String ftk = sc.nextLine();
        apo.addTask(0, ftk, apo.passDateString());
        IO.println("");

        apo.listOpertaions();
        do {
            IO.println("\nEnter your choice:");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    IO.println("\nEnter the name for the task:");
                    String etk = sc.nextLine();
                    apo.addTask(apo.getSize(), etk, apo.passDateString());
                    IO.println("Task added.");
                    break;

                case "2":
                    IO.println("\nEnter the id of the task:");
                    int upid = sc.nextInt();
                    sc.nextLine();
                    IO.println("\nUpdate the description for the task:");
                    String uptk = sc.nextLine();
                    apo.updateTask(upid, uptk, apo.passDateString());
                    IO.println("Task updated.");
                    break;

                case "3":
                    IO.println("\nEnter the id of the task:");
                    int delid = sc.nextInt();
                    apo.deleteTask(delid);
                    IO.println("Task deleted.");
                    break;

                case "4":
                    IO.println("\nEnter the id of the task:");
                    int mdid = sc.nextInt();
                    apo.markDone(mdid);
                    IO.println("Task marked as \"Done\".");
                    break;

                case "5":
                    IO.println("\nEnter the id of the task:");
                    int mipid = sc.nextInt();
                    apo.markInProgress(mipid);
                    IO.println("Task marked as \"In-Progress\".");
                    break;

                case "6":
                    IO.println("\nAll Tasks:");
                    apo.listAllTasks();
                    break;

                case "7":
                    IO.println("\nTasks marked as \"Done\":");
                    apo.listDoneTasks();
                    break;

                case "8":
                    IO.println("\nTasks marked as \"In-Progress\"");
                    apo.listInProgressTasks();
                    break;

                case "9":
                    IO.println("\nTasks marked as \"Not Done\"");
                    apo.listNotDoneTasks();
                    break;

                case "10":
                    IO.println("\nReprinting operations:");
                    apo.listOpertaions();
                    break;

                case "exit":
                    IO.println("\nDo you wish to abort: (yes/no)");
                    ch = sc.next();
                    break;
            }
        } while (ch.equals("no"));

        sc.close();
    }
}
