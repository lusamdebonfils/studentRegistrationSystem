package edu.mum.cs.cs425.studentregistrationapp.service.impl;

import edu.mum.cs.cs425.studentregistrationapp.model.Transcript;
import edu.mum.cs.cs425.studentregistrationapp.repository.TranscriptRepository;
import edu.mum.cs.cs425.studentregistrationapp.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {

    @Autowired
    private TranscriptRepository transcriptRepository;

    @Override
    public Transcript save(Transcript t) {
        return transcriptRepository.save(t);
    }
}
