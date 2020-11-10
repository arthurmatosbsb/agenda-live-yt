package com.github.arthurmatosbsb.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.arthurmatosbsb.models.Live;
import com.github.arthurmatosbsb.repository.LiveRepository;

@Service
public class LiveService {
	
	@Autowired
	LiveRepository liveRepository;
	
    public Page<Live> findAll(Pageable pageable, String flag){
        if(flag != null && flag.equals("next")){
            return liveRepository.findByLiveDateAfterOrderByLiveDateAsc(LocalDateTime.now(), pageable);
        }else if(flag != null && flag.equals("previous")){
            return liveRepository.findByLiveDateBeforeOrderByLiveDateDesc(LocalDateTime.now(), pageable);
        }else{
            return liveRepository.findAll(pageable);
        }
    }
    public Optional<Live> findById(String id){
        return liveRepository.findById(id);
    }
    @Transactional
    public Live save(Live liveDocument){
        return liveRepository.save(liveDocument);
    }

    public void delete(Live liveDocument){
        liveRepository.delete(liveDocument);
    }
}

