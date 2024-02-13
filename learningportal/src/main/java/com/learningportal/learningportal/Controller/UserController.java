package com.learningportal.learningportal.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningportal.learningportal.dto.UserRequestDto;
import com.learningportal.learningportal.dto.UserResponseDto;
import com.learningportal.learningportal.entity.CourseEntity;
import com.learningportal.learningportal.entity.FavouriteEntity;
import com.learningportal.learningportal.entity.RegistrationEntity;
import com.learningportal.learningportal.entity.UserEntity;
import com.learningportal.learningportal.repository.CourseService;
import com.learningportal.learningportal.repository.FavouriteService;
import com.learningportal.learningportal.repository.RegistrationService;
import com.learningportal.learningportal.repository.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	private RegistrationService registrationService;
	private FavouriteService favouriteService;
	private CourseService courseService;

	@GetMapping
	public ResponseEntity<Object> showAllUsers() {
		List<UserEntity> users = userService.findAllUsers();
		List<UserResponseDto> userresp = users.stream().map(userService::userEntitytoDtoMapper)
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(userresp);

	}

	@PostMapping
	public ResponseEntity<Object> addUser(@RequestBody UserRequestDto userRequestDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(userRequestDto.getName());
		userEntity.setRole(userRequestDto.getRole());
		UserEntity user = userService.addUser(userEntity);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Failed to add User");
		}

		RegistrationEntity registrationEntity = new RegistrationEntity();
		registrationEntity.setUserEntity(user);
		registrationService.saveRegistration(registrationEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> showUserById(@PathVariable(value = "id") Long id) {
		Optional<UserEntity> userEntity = userService.findUserById(id);
		if (userEntity.isPresent()) {
			UserEntity user = userEntity.get();
			UserResponseDto userresp = new UserResponseDto();
			userresp.setId(user.getId());
			userresp.setName(user.getName());
			userresp.setRole(user.getRole());
			userresp.setEnrolledCourses(registrationService.findEnrolledCoursesByUser(user));
			List<CourseEntity> courses = user.getFavouriteCourses().stream().map(pred -> pred.getCourseFavEntity())
					.collect(Collectors.toList());
			userresp.setFavoriteCourses(
					courses.stream().map(courseService::mapCourseEntitytoCourseDto).collect(Collectors.toList()));
			return ResponseEntity.status(HttpStatus.FOUND).body(userresp);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable(value = "id") Long id) {
		userService.removeUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body("User deleted");
	}

	@PostMapping("/{id}/enroll/{courseid}")
	public ResponseEntity<Object> enrollCourse(@PathVariable(value = "id") Long id,
			@PathVariable(value = "courseid") Long courseId) {
		try {
			Optional<UserEntity> userEntity = userService.findUserById(id);
			Optional<CourseEntity> courseEntity = courseService.findCourseById(courseId);

			if (userEntity.isPresent() && courseEntity.isPresent()) {
				UserEntity user = userEntity.get();
				CourseEntity course = courseEntity.get();

				if (registrationService.checkRegistrationByUserAndCourse(user, course)) {
					return ResponseEntity.badRequest().body("User is already enrolled in the course.");
				} else if (registrationService.checkRegistrationByUser(user)) {
					List<RegistrationEntity> registrations = registrationService.findRegistrationByUserEntity(user);
					Optional<RegistrationEntity> registrationOpt = registrations.stream()
							.filter(reg -> reg.getCourseEntity() == null).findFirst();
					RegistrationEntity registrationEntity;
					if (registrationOpt.isEmpty()) {
						registrationEntity = new RegistrationEntity();
						registrationEntity.setUserEntity(user);
					} else {
						registrationEntity = registrationOpt.get();
					}
					registrationEntity.setCourseEntity(course);
					registrationService.saveRegistration(registrationEntity);

					UserResponseDto userresp = new UserResponseDto();
					userresp.setId(user.getId());
					userresp.setName(user.getName());
					userresp.setRole(user.getRole());
					userresp.setEnrolledCourses(registrationService.findEnrolledCoursesByUser(user));
					List<CourseEntity> courses = user.getFavouriteCourses().stream()
							.map(pred -> pred.getCourseFavEntity()).collect(Collectors.toList());
					userresp.setFavoriteCourses(courses.stream().map(courseService::mapCourseEntitytoCourseDto)
							.collect(Collectors.toList()));
					return ResponseEntity.status(HttpStatus.ACCEPTED).body(userresp);
				} else {
					RegistrationEntity registrationEntity = new RegistrationEntity();
					registrationEntity.setUserEntity(user);
					registrationEntity.setCourseEntity(course);
					registrationService.saveRegistration(registrationEntity);

					UserResponseDto userresp = new UserResponseDto();
					userresp.setId(user.getId());
					userresp.setName(user.getName());
					userresp.setRole(user.getRole());
					userresp.setEnrolledCourses(registrationService.findEnrolledCoursesByUser(user));
					List<CourseEntity> courses = user.getFavouriteCourses().stream()
							.map(pred -> pred.getCourseFavEntity()).collect(Collectors.toList());
					userresp.setFavoriteCourses(courses.stream().map(courseService::mapCourseEntitytoCourseDto)
							.collect(Collectors.toList()));
					return ResponseEntity.status(HttpStatus.ACCEPTED).body(userresp);
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or Course not found!");
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error enrolling user in the course.");
		}
	}

	@PostMapping("/{userId}/favorite/{courseId}")
	public ResponseEntity<Object> favoriteCourse(@PathVariable("userId") Long userId,
			@PathVariable("courseId") Long courseId) {
		try {
			Optional<UserEntity> userEntityOptional = userService.findUserById(userId);
			Optional<CourseEntity> courseEntityOptional = courseService.findCourseById(courseId);

			if (userEntityOptional.isPresent() && courseEntityOptional.isPresent()) {
				UserEntity user = userEntityOptional.get();
				CourseEntity course = courseEntityOptional.get();

				if (registrationService.checkRegistrationByUserAndCourse(user, course)) {
					if (favouriteService.checkFavouriteByUserAndCourse(user, course)) {
						return ResponseEntity.badRequest().body("Course is already a favorite.");
					}
					FavouriteEntity favourite = new FavouriteEntity();
					favourite.setUserFavEntity(user);
					favourite.setCourseFavEntity(course);
					favouriteService.saveFavourite(favourite);
					user.getFavouriteCourses().add(favourite);
					userService.addUser(user);
					UserResponseDto userresp = userService.userEntitytoDtoMapper(user);
					return ResponseEntity.status(HttpStatus.ACCEPTED).body(userresp);
				} else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body("Enroll into the course first before favoriting!");
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or Course not found.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error favoriting the course.");
		}
	}

	@DeleteMapping("/{userId}/favorite/{courseId}")
	public ResponseEntity<Object> removeFavouriteCourse(@PathVariable("userId") Long userId,
			@PathVariable("courseId") Long courseId) {
		try {
			Optional<UserEntity> userEntityOptional = userService.findUserById(userId);
			Optional<CourseEntity> courseEntityOptional = courseService.findCourseById(courseId);

			if (userEntityOptional.isPresent() && courseEntityOptional.isPresent()) {
				UserEntity user = userEntityOptional.get();
				CourseEntity course = courseEntityOptional.get();

				if (registrationService.checkRegistrationByUserAndCourse(user, course)) {
					if (favouriteService.checkFavouriteByUserAndCourse(user, course)) {
						FavouriteEntity favourite = favouriteService.getFavouriteByUserAndCourse(user, course);
						user.getFavouriteCourses().remove(favourite);
						course.getFavouriteUsers().remove(favourite);
						favouriteService.removeFavourite(favourite);
						userService.addUser(user);
						UserResponseDto userresp = userService.userEntitytoDtoMapper(user);
						return ResponseEntity.status(HttpStatus.OK).body(userresp);
					} else {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not favourited by user.");
					}
				} else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body("Enroll into the course first before unfavoriting!");
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or Course not found.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error unfavoriting the course.");
		}
	}

}