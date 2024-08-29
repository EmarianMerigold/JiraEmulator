package Konstantin_Dyachenko.Konstantin_Dyachenko.DTO;
import Konstantin_Dyachenko.Konstantin_Dyachenko.RequestEnums.IssueType;
import jakarta.validation.constraints.NotNull;

public class IssueTypeDTO {
    @NotNull(message = "IssueType Обязательное поле")
    private IssueType name;

    // Геттеры и сеттеры
    public IssueType getName() {
        return name;
    }

    public void setName(IssueType name) {
        this.name = name;
    }

}
