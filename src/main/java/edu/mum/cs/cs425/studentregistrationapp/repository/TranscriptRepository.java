package edu.mum.cs.cs425.studentregistrationapp.repository;

import edu.mum.cs.cs425.studentregistrationapp.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
}
