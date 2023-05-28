package employee.crud.backend.payload;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {


    private long id;

    @NotEmpty(message = "First name can't be empty")
    @Size(min = 2, message = "Last name must atleast has 2 characters")
    private String firstName;

    @NotEmpty(message = "Last name can't be empty")
    @Size(min = 2, message = "Last name must atleast has 2 characters")
    private String lastName;

    @Email
    private String email;
}

