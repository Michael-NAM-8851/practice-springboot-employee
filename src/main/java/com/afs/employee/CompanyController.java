package com.afs.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    @GetMapping("{id}")
    public Company findCompanyById(@PathVariable Integer id){
        return companyRepository.findById(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> findEmployeesInCompany(@PathVariable Integer id) {
        return companyRepository.findEmployeesInCompany(id);
    }

}
