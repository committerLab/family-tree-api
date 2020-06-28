package fr.committer.familytree.controller;

import fr.committer.familytree.domain.Membre;
import fr.committer.familytree.service.PhotosManagmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
public class PhotosManagmentController {

	private final PhotosManagmentService photosManagmentService;

	/**
	 *
	 * @param pseudo
	 * @param path
	 * @return
	 */
	@ExceptionHandler(NullPointerException.class)
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public Mono<Membre> addProfilePhoto(String pseudo, String path) {
		throw new NullPointerException();
	}

	/**
	 *
	 * @param pseudo
	 * @param path
	 * @return
	 */
	public Mono<Membre> deleteProfilePhoto(String pseudo, String path) {
		return null;
	}

	/**
	 *
	 * @param pseudo
	 * @param newPath
	 * @return
	 */
	public Mono<Membre> updateProfilePhoto(String pseudo, String newPath) {
		return null;
	}

}
