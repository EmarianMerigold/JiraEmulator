package Konstantin_Dyachenko.Konstantin_Dyachenko.DTO;

import java.util.Map;

public class IssueUpdateDTO {

    private ProjectDTO project;

    private IssueTypeDTO issuetype;

    private String summary;

    private String description;

    private PriorityDTO priority;

    private Map<String, Object> labels;

    // Геттеры и сеттеры
    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public IssueTypeDTO getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssueTypeDTO issuetype) {
        this.issuetype = issuetype;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriorityDTO getPriority() {
        return priority;
    }

    public void setPriority(PriorityDTO priority) {
        this.priority = priority;
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }
}
