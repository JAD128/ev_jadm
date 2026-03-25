package ev.ev_jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ev.ev_jd.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
