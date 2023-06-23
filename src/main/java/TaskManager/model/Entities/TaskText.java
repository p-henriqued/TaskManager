package TaskManager.model.Entities;

public class TaskText {
    private String text;
    private Integer id;

    public TaskText(String text) {
        this.text = text;
    }

    public TaskText(String text, Integer id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
