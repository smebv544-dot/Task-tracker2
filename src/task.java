public class task {
    int id;
    String description;
    String status;
    String createdAt;
    String updatedAt;

    task(int id, String description, String createdAt) {
        this.id = id;
        this.description = description;
        status = "To-do";
        this.createdAt = createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public String getDesc() {
        return description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setupdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getupdatedAt() {
        return updatedAt;
    }
}