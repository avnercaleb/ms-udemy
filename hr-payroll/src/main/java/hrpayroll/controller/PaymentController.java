package hrpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import hrpayroll.entities.Payment;
import hrpayroll.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")	
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable int days){
		return ResponseEntity.status(HttpStatus.OK).body(service.getPayment(workerId, days));
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(@PathVariable Long workerId, @PathVariable int days){
		Payment payment = new Payment("Bran", 400.00, days);
		return ResponseEntity.ok(payment);
	}
}
