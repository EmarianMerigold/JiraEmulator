package Konstantin_Dyachenko.Konstantin_Dyachenko.DTO;
import Konstantin_Dyachenko.Konstantin_Dyachenko.RequestEnums.Priority;
import jakarta.validation.constraints.NotNull;

public class PriorityDTO {
    @NotNull(message = "Priority Обязательное поле")
    private Priority name;

    // Геттеры и сеттеры
    public Priority getName() {
        return name;
    }

    public void setName(Priority name) {
        this.name = name;
    }
}
