package com.employee.empdetails;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeDetailsRepository extends MongoRepository<EmployeeDetails, String> {
}
