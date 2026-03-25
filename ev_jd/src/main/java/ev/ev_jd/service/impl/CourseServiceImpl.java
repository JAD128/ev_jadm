package ev.ev_jd.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ev.ev_jd.dto.CourseRequest;
import ev.ev_jd.dto.CourseResponse;
import ev.ev_jd.entity.Course;
import ev.ev_jd.entity.Instructor;
import ev.ev_jd.repository.CourseRepository;
import ev.ev_jd.repository.InstructorRepository;
import ev.ev_jd.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final InstructorRepository instructorRepository;
    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository, InstructorRepository instructorRepository) {
        this.repository = repository;
        this.instructorRepository = instructorRepository;
    }

    private CourseResponse toResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());           // mapea el id
        response.setName(course.getName());       // mapea el nombre
        response.setDescription(course.getDescription()); // mapea la descripción
        response.setCredits(course.getCredits()); // mapea los créditos

        if (course.getInstructor() != null) {
            response.setInstructorId(course.getInstructor().getId());
            response.setInstructorName(course.getInstructor().getName());
        }
        return response;
    }

    @Override
    public CourseResponse create(CourseRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setCredits(request.getCredits());

        if (request.getInstructorId() != null) {
            Instructor instructor = instructorRepository.findById(request.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Instructor " + request.getInstructorId() + " not found"));

            course.setInstructor(instructor);
        }

        Course saved = repository.save(course);
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }
}
