package training360.guinessapp.recorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecorderRepository extends JpaRepository<Recorder, Long>{

    @Query(value = "select r from Recorder r where r.name like %:include% or r.name like :start% order by r.dateOfBirth")
    List<Recorder> findAllRequestedRecorders(@Param("include") String include, @Param("start") String start);
}
