package ev.ev_jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ev.ev_jd.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{
    
}
