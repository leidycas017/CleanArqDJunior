package co.com.udea.softwarearchitec.usecase.employee;

import co.com.udea.softwarearchitec.model.employee.gateways.EmployeeRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class EmployeeUseCase {
    private EmployeeRepository repoGateway;
    public String getId(String id){
        return repoGateway.getiD();
    }

    public String getNombre(String nombre){
        return repoGateway.getNombre();
    }
}
