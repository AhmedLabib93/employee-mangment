package employee.crud.backend.controller;

import employee.crud.backend.entity.Employee;
import employee.crud.backend.payload.EmployeeDto;
import employee.crud.backend.repository.EmployeeRepository;
import employee.crud.backend.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<EmployeeDto>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{employee-id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "employee-id") long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @PutMapping("/{employee-id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto,
                                                      @PathVariable(name = "employee-id") long id) {
        return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(employeeDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{employee-id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "employee-id") long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully!", HttpStatus.ACCEPTED);
    }
}
