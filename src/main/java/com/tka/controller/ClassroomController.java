package com.tka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Classroom;
import com.tka.service.ClassroomService;

@RestController
public class ClassroomController {

	@Autowired
	ClassroomService classroomService;

	@GetMapping("fetchallclassrooms")
	List<Classroom> fetchAllClassrooms() {
		List<Classroom> listClassrooms = classroomService.fetchAllClassrooms();
		System.err.println(listClassrooms);
		return listClassrooms;
	}

	@GetMapping("fetchclassroom/{classroomId}")
	Classroom fetchclassroom(@PathVariable int classroomId) {
		return classroomService.fetchclassroom(classroomId);
	}

	@PostMapping("insertlocation")
	void insertlocation(@RequestBody Classroom classroom) {
		classroomService.insertlocation(classroom);
	}

	@PutMapping("updatelocation")
	Classroom updatelocation(@RequestBody Classroom classroom) {
		Classroom classroom2 = classroomService.updatelocation(classroom);
		return classroom2;
	}

	@GetMapping("fetchclassroomabove/{capacity}")
	ArrayList<Classroom> fetchClsAboveCapacity(@PathVariable("capacity") int capacity) {
		ArrayList<Classroom> listClassrooms = classroomService.fetchClsAboveCapacity(capacity);
		return listClassrooms;
	}

	@GetMapping("fetchclassroomasperlocation/{location}")
	ArrayList<Classroom> fetchClsperLocation(@PathVariable("location") String location) {
		ArrayList<Classroom> listClassrooms = classroomService.fetchClsperLocation(location);
		return listClassrooms;
	}

	@PutMapping("updatelocation/{oldname}/{newname}")
	Classroom updateClassroomName(@PathVariable("oldname") String oldname, @PathVariable("newname") String newname) {
		Classroom classroom = classroomService.updateClassroomName(oldname, newname);
		return classroom;
	}
}
