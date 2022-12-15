package tdtu.finalproject.todoapp;

public class Model {
    private String id;
    private String task;
    private String desc;
    private String date;

    public Model() {
    }

    public Model(String id, String task, String desc, String date) {
        this.id = id;
        this.task = task;
        this.desc = desc;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
