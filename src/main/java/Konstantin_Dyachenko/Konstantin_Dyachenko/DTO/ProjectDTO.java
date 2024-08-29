package Konstantin_Dyachenko.Konstantin_Dyachenko.DTO;
import Konstantin_Dyachenko.Konstantin_Dyachenko.RequestEnums.Project;
import jakarta.validation.constraints.NotNull;

public class ProjectDTO {

    @NotNull(message = "Project обязательное поле")
    private Project key;

    // Геттеры и сеттеры
    public Project getKey() {
        return key;
    }

    public void setKey(Project key) {
        this.key = key;
    }

}
