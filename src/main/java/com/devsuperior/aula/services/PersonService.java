package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
        
        Department department = departmentRepository.getReferenceById(dto.getDepartment().getId());
        //Department department = new Department(dto.getDepartment().getId(), dto.getDepartment().getName());

        Person entity = new Person();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
        entity.setDepartment(department);

        entity = repository.save(entity);

        return new PersonDepartmentDTO(entity);
    }

    public PersonDTO insert(PersonDTO dto) {

        Department department = departmentRepository.getReferenceById(dto.getDepartmentId());

        Person entity = new Person();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
        entity.setDepartment(department);

        entity = repository.save(entity);

        return new PersonDTO(entity);
    }
}
