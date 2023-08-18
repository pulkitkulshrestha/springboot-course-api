package com.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepo topicRepo;
 //private List<Topic> topics = new ArrayList<>(Arrays.asList(
       //  new Topic("spring", "spring framework","spring_framework_description"),
     //    new Topic("spring1", "spring framework1","spring_framework_description1"),
   //      new Topic("spring2", "spring framework2","spring_framework_description2")
 //));

 public List<Topic> getAllTopics()
 {
     //return topics;
     List<Topic> topics = new ArrayList<>();
     topicRepo.findAll().forEach(topics::add);
     return topics;
 }

 public Topic getTopic(String id){
     //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
     //return topicRepo.findById(id);
     Optional<Topic> optionalTopic = topicRepo.findById(id);
     return optionalTopic.orElse(null);
 }

 public void addTopic(Topic topic)
 {
    // topics.add(topic);
    topicRepo.save(topic);
 }

    public void updateTopic(String id, Topic topic) {
        //for (int i =0; i < topics.size(); i++) {
          //  Topic t = topics.get(i);
            //if (t.getId().equals(id)) {
              //  topics.set(i, topic);
                //return;
                   topicRepo.save(topic);
 //}
        //}

    }

    public void deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepo.deleteById(id);
    }
}
