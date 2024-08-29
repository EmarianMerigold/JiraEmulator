package Konstantin_Dyachenko.Konstantin_Dyachenko.DTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class IssueRequestDTO {

    @NotNull(message = "Обязательные поля")
    @Valid
    private FieldsDTO fields;

    // Геттеры и сеттеры
    public FieldsDTO getFields() {
        return fields;
    }

    public void setFields(FieldsDTO fields) {
        this.fields = fields;
    }
}
