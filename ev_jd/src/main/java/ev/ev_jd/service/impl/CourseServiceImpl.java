package ev.ev_jd.service.impl;

import ev.ev_jd.dto.CourseRequest;
import ev.ev_jd.dto.CourseResponse;
import ev.ev_jd.repository.CourseRepository;
import ev.ev_jd.service.CourseService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import ev.ev_jd.entity.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseResponse create(CourseRequest request) {
        // Instancia Course y mapea DTO
        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setCredits(request.getCredits());

        // Guarda en la base de datos
        Course saved = repository.save(course);

        // Retorna DTO de respuesta
        return  toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        // Lista todos los cursos y los mapea a DTO
        return repository.findAll().stream().map(this::toResponse).toList();
    }
}
