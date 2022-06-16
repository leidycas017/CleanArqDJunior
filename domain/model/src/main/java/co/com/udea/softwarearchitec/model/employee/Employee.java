package co.com.udea.softwarearchitec.model.employee;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Employee {
    private String id;
    private String nombre;
    private String cargo;
}
