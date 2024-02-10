package entities;

public class news {
    private int id;
    private String title;
    private String source;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public news(int id, String title, String source, String content) {
        this.id = id;
        this.title = title;
        this.source = source;
        this.content = content;
    }
    public news(String title, String source, String content) {
        this.title = title;
        this.source = source;
        this.content = content;
    }
    public news(){}

    @Override
    public String toString() {
        return "news{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
