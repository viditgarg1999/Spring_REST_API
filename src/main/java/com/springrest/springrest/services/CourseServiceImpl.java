package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.DAO.courseDAO;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	//List<Course> list;
	
	@Autowired
	private courseDAO courseDao;
	
	public CourseServiceImpl()
	{
//		list = new ArrayList<>();
//		list.add(new Course(1,"Spring Basic","Basic Course on Spring"));
//		list.add(new Course(2,"Spring Intermediate","Intermediate Course on Spring"));
	}
	
	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(int courseId) {
		
//		Course resCourse = null;
//		
//		for(Course course:list)
//		{
//			if(course.getId()==courseId)
//			{
//				resCourse=course;
//				break;
//			}
//		}
		
		return courseDao.getById(courseId);
	}
	
	@Override
	public Course addCourse(Course course)
	{
		//list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public String updateCourse(Course course) {
		// TODO Auto-generated method stub
		
//		int flag=0;
//		
//		for(Course courseIterator:list)
//		{
//			if(courseIterator.getId()==course.getId())
//			{
//				courseIterator.setName(course.getName());
//				courseIterator.setDescription(course.getDescription());
//				flag=1;	
//				break;
//			}
//		}
//		
//		if(flag==1)
//			return "Updated Successfully";
//		else
//			return "Course Not Found!";
		
		courseDao.save(course);
		return "Updated Successfully";
		
	}

	@Override
	public void removeCourse(int courseId) {
		

//		for(int i=0;i<list.size();i++)
//		{
//			Course courseIterator  = list.get(i);
//			if(courseIterator.getId()==courseId)
//			{
//				list.remove(i);
//				break;
//			}
//		}
		
		Course entity = courseDao.getById(courseId);
		courseDao.delete(entity);
		
	}

}
