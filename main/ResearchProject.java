package main;

import java.util.Date;

public class ResearchProject {
    private String title;
    private Date startDate;
    private Date endDate;

    public ResearchProject(String title, Date startDate, Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String toString() {
        return "ResearchProject{" +
               "title='" + title + '\'' +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               '}';
    }
}

