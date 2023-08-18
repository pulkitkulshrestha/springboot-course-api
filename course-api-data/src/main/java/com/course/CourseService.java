package com.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;
 //private List<Topic> topics = new ArrayList<>(Arrays.asList(
       //  new Topic("spring", "spring framework","spring_framework_description"),
     //    new Topic("spring1", "spring framework1","spring_framework_description1"),
   //      new Topic("spring2", "spring framework2","spring_framework_description2")
 //));

 public List<Course> getAllCourses(String topicId)
 {
     //return topics;
     List<Course> Course = new ArrayList<>();
     //courseRepo.findAll().forEach(Course::add);
     courseRepo.findByTopicId(topicId).forEach(Course::add);
     return Course;
 }

 public Course getCourse(String id){
     //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
     //return topicRepo.findById(id);
     Optional<Course> optionalTopic = courseRepo.findById(id);
     return optionalTopic.orElse(null);
 }

 public void addCourse(Course course)
 {
    // topics.add(topic);
    courseRepo.save(course);
 }

    public void updateCourse(Course course) {
        //for (int i =0; i < topics.size(); i++) {
          //  Topic t = topics.get(i);
            //if (t.getId().equals(id)) {
              //  topics.set(i, topic);
                //return;
                   courseRepo.save(course);
 //}
        //}

    }

    public void deleteCourse(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        courseRepo.deleteById(id);
    }
}
