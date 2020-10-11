package io.springBoot.demo.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> list= new ArrayList<>(Arrays.asList(new Topic("Spring", "SpringBoot", "Topic is Spring boot framework"),
			new Topic("Java", "Java EE", "Topic is Java Enterprise")));
	
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	
	public Topic getTopic(String id)
	{
		Optional<Topic> opList = topicRepository.findById(id);
		return opList.get();
	}
	
	public void addTopic(Topic topic)
	{
		topicRepository.save(topic);
	}


	public void updateTopic(String id, Topic topic) {
		Optional<Topic> opList = topicRepository.findById(id);
		
		Topic t= opList.get();
		t.setName(topic.getName());
		t.setDesc(topic.getDesc());
		topicRepository.save(t);
	}


	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
		
	}
}
