public class Article {
    private int seq;
    private String subject;
    private String content;
    private String writer;
    private String regDate; 

    public Article ( int seq, String subject, String content, String writer, String regDate ) {
        this.seq = seq;
        this.subject = subject;
        this.content = content;
        this.writer = writer;
        this.regDate = regDate;
    }

    public int getSeq() {
        return this.seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getSubject() {
        return this.subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return this.writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getRegDate() {
        return this.regDate;
    }
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}

