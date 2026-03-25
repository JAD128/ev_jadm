package ev.ev_jd.service;

import java.util.List;

import ev.ev_jd.dto.CourseRequest;
import ev.ev_jd.dto.CourseResponse;


public interface CourseService {

    CourseResponse create(CourseRequest request);

    List<CourseResponse> list();
}
