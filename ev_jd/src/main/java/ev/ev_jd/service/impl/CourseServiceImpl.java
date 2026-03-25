package ev.ev_jd.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ev.ev_jd.dto.CourseRequest;
import ev.ev_jd.dto.CourseResponse;
import ev.ev_jd.entity.Course;
import ev.ev_jd.repository.CourseRepository;
import ev.ev_jd.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    private CourseResponse toResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());           // mapea el id
        response.setName(course.getName());       // mapea el nombre
        response.setDescription(course.getDescription()); // mapea la descripción
        response.setCredits(course.getCredits()); // mapea los créditos
        return response;
    }

    @Override
    public CourseResponse create(CourseRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setCredits(request.getCredits());

        Course saved = repository.save(course);
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }
}
