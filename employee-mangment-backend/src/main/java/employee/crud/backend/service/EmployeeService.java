package employee.crud.backend.service;

import employee.crud.backend.payload.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    public EmployeeDto getEmployeeById(long id);

    public List<EmployeeDto> getEmployees();

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, long id);

    public void deleteEmployee(long id);
}
