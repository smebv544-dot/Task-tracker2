import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Operations {
    private List<task> tasklist = new ArrayList<>();

    public void addTask(int id, String desc, String create) {
        tasklist.add(new task(id, desc, create));
    }

    public void updateTask(int id, String desc, String update) {
        task tc = tasklist.get(id);
        tc.setDesc(desc);
        tc.setupdatedAt(update);
    }

    public void deleteTask(int id) {
        tasklist.remove(id);
    }

    public void markDone(int id) {
        task tc1 = tasklist.get(id);
        tc1.setStatus("Done");
    }

    public void markInProgress(int id) {
        task tc2 = tasklist.get(id);
        tc2.setStatus("In-Progress");
    }

    public void listAllTasks() {
        Iterator<task> it = tasklist.iterator();
        while (it.hasNext()) {
            task itk = it.next();
            IO.println(itk.getId() + "\t|\t" + itk.getDesc() + "\t|\t" + itk.getStatus() + "\t|\t" + itk.getCreatedAt()
                    + "\t|\t" + itk.getupdatedAt() + "\t|");
        }
        IO.println("");
    }

    public void listDoneTasks() {
        Iterator<task> it = tasklist.iterator();
        while (it.hasNext()) {
            task itk = it.next();
            if (itk.getStatus().equals("Done")) {
                IO.println(itk.getId() + "\t|\t" + itk.getDesc() + "\t|\t" + itk.getStatus() +
                        "\t|\t" + itk.getCreatedAt() + "\t|\t" + itk.getupdatedAt() + "\t|\t");
            }
        }
        IO.println("");
    }

    public void listInProgressTasks() {
        Iterator<task> it = tasklist.iterator();
        while (it.hasNext()) {
            task itk = it.next();
            if (itk.getStatus().equals("In-Progress")) {
                IO.println(itk.getId() + "\t|\t" + itk.getDesc() + "\t|\t" + itk.getStatus() +
                        "\t|\t" + itk.getCreatedAt() + "\t|\t" + itk.getupdatedAt() + "\t|\t");
            }
        }
        IO.println("");
    }

    public void listNotDoneTasks() {
        Iterator<task> it = tasklist.iterator();
        while (it.hasNext()) {
            task itk = it.next();
            if (itk.getStatus().equals("To-do") || itk.getStatus().equals("In-Progress")) {
                IO.println(itk.getId() + "\t|\t" + itk.getDesc() + "\t|\t" + itk.getStatus() +
                        "\t|\t" + itk.getCreatedAt() + "\t|\t" + itk.getupdatedAt() + "\t|\t");
            }
        }
        IO.println("");
    }

    public String passDateString() {
        LocalDate dtobj = LocalDate.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        String ct = (dtobj).format(formatter1);
        return ct;
    }

    public void listOpertaions() {
        IO.println("The following operations are available:"
                + "\n1. Add a task to the list."
                + "\n2. Update the description of a task in the list."
                + "\n3. delete a task from the list."
                + "\n4. Mark a task as \"Done\"."
                + "\n5. Mark a task as \"In-Progress\"."
                + "\n6. List all tasks."
                + "\n7. List all tasks that are \"Done\"."
                + "\n8. List all tasks that are \"In-Progress\"."
                + "\n9. List all tasks that are \"Not Done\"."
                + "\n10. Reprint all operations."
                + "\n11. Exit from Program.");
    }

    public int getSize() {
        return tasklist.size();
    }

}