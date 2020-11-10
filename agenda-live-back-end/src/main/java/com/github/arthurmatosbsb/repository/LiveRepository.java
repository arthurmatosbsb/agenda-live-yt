package com.github.arthurmatosbsb.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.arthurmatosbsb.models.Live;


public interface LiveRepository extends JpaRepository<Live, String>{

	 Page<Live> findByLiveDateAfterOrderByLiveDateAsc(LocalDateTime date, Pageable pageable);
	    Page<Live> findByLiveDateBeforeOrderByLiveDateDesc(LocalDateTime date, Pageable pageable);
}
