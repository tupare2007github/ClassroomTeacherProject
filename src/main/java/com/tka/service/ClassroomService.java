package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.ClassroomDao;
import com.tka.entity.Classroom;

@Service
public class ClassroomService {

	@Autowired
	private ClassroomDao classroomDao; // Using ClassroomDao instead of repository

	public List<Classroom> fetchAllClassrooms() {
		return classroomDao.fetchAllClassrooms(); // Fetch all classrooms using DAO
	}

	public Classroom fetchclassroom(int classroomId) {
		return classroomDao.fetchclassroom(classroomId); // Fetch a classroom by its ID
	}

	public void insertlocation(Classroom classroom) {
		classroomDao.insertlocation(classroom); // Insert a new classroom using DAO
	}

	public Classroom updatelocation(Classroom classroom) {
		Classroom existingClassroom = classroomDao.updatelocation(classroom.getClsId());
		if (existingClassroom != null) {
			existingClassroom.setClsLocation(classroom.getClsLocation());
			classroomDao.update(existingClassroom); // Update location using DAO
			return existingClassroom;
		}
		return null;
	}

	public ArrayList<Classroom> fetchClsAboveCapacity(int capacity) {
		return classroomDao.findByCapacityGreaterThan(capacity); // Fetch classrooms above the given capacity
	}

	public ArrayList<Classroom> fetchClsperLocation(String location) {
		return classroomDao.findByLocation(location); // Fetch classrooms by location using DAO
	}

	public Classroom updateClassroomName(String oldname, String newname) {
		Classroom classroom = classroomDao.findByName(oldname);
		if (classroom != null) {
			classroom.setClsName(newname);
			classroomDao.update(classroom); // Update the classroom name using DAO
			return classroom;
		}
		return null;
	}
}