package com.ytw.YTWebDesi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ytw.YTWebDesi.model.CoursesVideosList;
import com.ytw.YTWebDesi.repository.CoursesVideosListRepository;

@RestController
@RequestMapping("/muniCodingZone")
public class CoursesVideosListController {
	
	@Autowired
	CoursesVideosListRepository coursesVideosListRepository;
	
	// List All The Courses Available
		@GetMapping("/listSpecificCourseVideos/{courseId}")
		public ResponseEntity<List<CoursesVideosList>> getSpecificCourseVideosList(@PathVariable("courseId") int courseId) {
			try {
				List<CoursesVideosList> specificCourseVideosList= coursesVideosListRepository.findBycourseId(courseId);
				return new ResponseEntity<>(specificCourseVideosList, HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
