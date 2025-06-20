package test.example.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.example.jpa.Entity.Customers;
import test.example.jpa.Exception.CustomException;
import test.example.jpa.Exception.CustomExceptionType;

@Service
@RequiredArgsConstructor

public class TestService {

    private final TestRepository testRepository;

    public String findById(Integer customerNumber) {

        Customers customers = testRepository.findById(customerNumber)
                .orElseThrow(() -> new CustomException(CustomExceptionType.CUSTOMER_NOT_FOUND,
                        customerNumber + "는 없는 유저 입니다."));

        return customers.getCustomerName();

    }

}
