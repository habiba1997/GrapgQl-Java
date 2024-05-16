package com.demo.graphql.query.resolver;

import java.util.ArrayList;
import java.util.List;

import com.demo.graphql.entity.Subject;
import com.demo.graphql.enums.SubjectNameFilter;
import com.demo.graphql.response.StudentResponse;
import com.demo.graphql.response.SubjectResponse;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;


@Controller
public class StudentResponseResolver {

    @SchemaMapping
    public List<SubjectResponse> learningSubjects(StudentResponse studentResponse) {

        List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();

        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
//                if (subjectNameFilter == SubjectNameFilter.ALL || subject.getSubjectName().equalsIgnoreCase(subjectNameFilter.name())) {
                learningSubjects.add(new SubjectResponse(subject));
//                }
            }
        }

        return learningSubjects;

    }

    @SchemaMapping(typeName = "StudentResponse", field = "fullName")
    public String fullName(StudentResponse studentResponse) {
        return studentResponse.getFirstName() + " " + studentResponse.getLastName();
    }
}
