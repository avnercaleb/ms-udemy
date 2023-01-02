package hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
