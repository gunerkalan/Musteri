package com.guner.employee.api;

import com.guner.employee.dto.EmployeeDto;
import com.guner.employee.service.impl.EmployeeServiceImpl;
import com.guner.employee.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(ApiPaths.EmployeeCtrl.CTRL)
@Api(value = ApiPaths.EmployeeCtrl.CTRL, description = "Employee APIS")
@Slf4j
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl){
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping
    @ApiOperation(value = "Get All Operation", response = EmployeeDto.class, responseContainer = "List")
    public ResponseEntity<List<EmployeeDto>> getAll(){
        List<EmployeeDto> data = employeeServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = EmployeeDto.class)
    public ResponseEntity<EmployeeDto> getById(@PathVariable(value = "id", required = true)Long id){
        EmployeeDto employeeDto = employeeServiceImpl.getById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = EmployeeDto.class)
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employee){
        return ResponseEntity.ok(employeeServiceImpl.save(employee));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = EmployeeDto.class)
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(value = "id", required = true)Long id, @Valid @RequestBody EmployeeDto employee){
        return ResponseEntity.ok(employeeServiceImpl.update(id,employee));
   }

   @DeleteMapping("/{id}")
   @ApiOperation(value = "Delete Operation", response = Boolean.class)
   public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(employeeServiceImpl.delete(id));
   }
}
