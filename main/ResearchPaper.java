package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ResearchPaper {
    private String title;
    private Date publicationDate;
    private int citations;
    private int pages;

    public ResearchPaper(String title, Date publicationDate, int citations, int pages) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.citations = citations;
        this.pages = pages;
    }

    public int getCitations() {
        return citations;
    }

    public String getCitation(Format format) {
        switch (format) {
            case PLAIN_TEXT:
                return title + ", " + publicationDate + ", " + citations + " citations";
            case BIBTEX:
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return "@article{" + title + ",\n" +
                       "  title={" + title + "},\n" +
                       "  author={Anonymous},\n" +
                       "  journal={Journal of Research},\n" +
                       "  year={" + dateFormat.format(publicationDate) + "},\n" +
                       "  volume={1},\n" +
                       "  number={1},\n" +
                       "  pages={" + pages + "},\n" +
                       "  citations={" + citations + "}\n" +
                       "}";
            default:
                return "Invalid format";
        }
    }

    public String toString() {
        return "ResearchPaper{" +
               "title='" + title + '\'' +
               ", publicationDate=" + publicationDate +
               ", citations=" + citations +
               ", pages=" + pages +
               '}';
    }
}

