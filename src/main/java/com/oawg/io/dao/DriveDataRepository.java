package com.oawg.io.dao;

import com.oawg.io.domain.DrivePlaceMarkerVO;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
@Repository
public interface DriveDataRepository extends CrudRepository<DrivePlaceMarkerVO, Long> {
//    public List<DrivePlaceMarkerVO> findByStateAndZipIgnoreCase(String state, String zip);
    public List<DrivePlaceMarkerVO> findByLocStIgnoreCase(String state);
    public List<DrivePlaceMarkerVO> findByLocCntyIgnoreCase(String cnty);
    public List<DrivePlaceMarkerVO> findByLocStAndLocCntyIgnoreCase(String state, String cnty);
    public Iterable<DrivePlaceMarkerVO> findAllById(Iterable<Long> iterable);
    @Query("SELECT DISTINCT locSt FROM DrivePlaceMarkerVO")
    List<String> findDistinctStates();
    @Query("SELECT DISTINCT locCnty FROM DrivePlaceMarkerVO where locSt = :state")
    List<String> findDistinctCounties(@Param("state") String state);
}
