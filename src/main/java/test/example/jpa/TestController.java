package test.example.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor

public class TestController {

    private final TestService testService;

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<String> findCustomerById(@PathVariable Integer customerId) {

        String name = testService.findById(customerId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(name);


    }

}
