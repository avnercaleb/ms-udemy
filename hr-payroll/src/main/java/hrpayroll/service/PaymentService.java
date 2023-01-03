package hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrpayroll.entities.Payment;
import hrpayroll.entities.Worker;
import hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient feignClient;
	
	public Payment getPayment(Long workerId, int days) {
		
		Worker worker = feignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
