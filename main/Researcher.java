package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Researcher {
    private String name;
    private int hIndex;
    private List<ResearchPaper> researchPapers;
    private List<ResearchProject> researchProjects;

    public Researcher(String name, int hIndex) {
        this.name = name;
        this.hIndex = hIndex;
        this.researchPapers = new ArrayList<>();
        this.researchProjects = new ArrayList<>();
    }

    public void addResearchPaper(ResearchPaper researchPaper) {
        researchPapers.add(researchPaper);
    }

    public void addResearchProject(ResearchProject researchProject) {
        researchProjects.add(researchProject);
    }

    public int calculateHIndex() {
        researchPapers.sort(Comparator.comparing(ResearchPaper::getCitations).reversed());
        int count = 0;
        for (int i = 0; i < researchPapers.size(); i++) {
            if (researchPapers.get(i).getCitations() >= i + 1) {
                count++;
            }
        }
        return count;
    }

    public void printPapers(Comparator<ResearchPaper> comparator) {
        researchPapers.sort(comparator);
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper);
        }
    }
}
