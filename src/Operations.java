import java.util.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Operations {
    private List<task> tasklist = new ArrayList<>();

    public void bindList() throws IOException {
        tasklist = JsonOperations.loadList();
    }

    public int getSize() {
        return tasklist.size();
    }

    public List<task> retrieveList() {
        return tasklist;
    }

    public void addTask(int id, String desc, String create)
            throws IOException {
        tasklist.add(new task(id, desc, create));
        JsonOperations.saveList(tasklist);
    }

    public void updateTask(int id, String desc, String update)
            throws IOException {
        task tc = tasklist.get(id);
        tc.setDesc(desc);
        tc.setupdatedAt(update);
        JsonOperations.saveList(tasklist);
    }

    public void deleteTask(int id) throws IOException {
        tasklist.remove(id);
        JsonOperations.saveList(tasklist);
    }

    public void markDone(int id) throws IOException {
        task tc1 = tasklist.get(id);
        tc1.setStatus("Done");
        JsonOperations.saveList(tasklist);
    }

    public void markInProgress(int id) throws IOException {
        task tc2 = tasklist.get(id);
        tc2.setStatus("In-Progress");
        JsonOperations.saveList(tasklist);
    }

    public void listAllTasks() throws IOException {
        Iterator<task> it = tasklist.iterator();
        while (it.hasNext()) {
            task itk = it.next();
            itk.printAllFields();
        }
        IO.println("");
    }

    public void listDoneTasks() throws IOException {
        Iterator<task> it = tasklist.iterator();
        while (it.hasNext()) {
            task itk = it.next();
            if (itk.getStatus().equals("Done")) {
                itk.printAllFields();
            }
        }
        IO.println("");
    }

    public void listInProgressTasks() throws IOException {
        Iterator<task> it = tasklist.iterator();
        while (it.hasNext()) {
            task itk = it.next();
            if (itk.getStatus().equals("In-Progress")) {
                itk.printAllFields();
            }
        }
        IO.println("");
    }

    public void listNotDoneTasks() throws IOException {
        Iterator<task> it = tasklist.iterator();
        while (it.hasNext()) {
            task itk = it.next();
            if (itk.getStatus().equals("To-do") || itk.getStatus().equals("In-Progress")) {
                itk.printAllFields();
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
}