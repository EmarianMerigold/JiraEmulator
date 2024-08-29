package Konstantin_Dyachenko.Konstantin_Dyachenko.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class FieldsDTO {

    @NotNull(message = "Обязательное поле")
    @Valid
    private ProjectDTO project;

    @NotNull(message = "Обязательное поле")
    @Valid
    private String summary;

    private String description;

    @NotNull(message = "Обязательное поле")
    @Valid
    private IssueTypeDTO issuetype;

    private PriorityDTO priority;

    private List<String> labels;

    // Геттеры и сеттеры

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
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

    public IssueTypeDTO getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssueTypeDTO issuetype) {
        this.issuetype = issuetype;
    }

    public PriorityDTO getPriority() {
        return priority;
    }

    public void setPriority(PriorityDTO priority) {
        this.priority = priority;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}