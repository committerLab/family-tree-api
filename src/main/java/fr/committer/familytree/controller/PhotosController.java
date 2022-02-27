package fr.committer.familytree.controller;

import fr.committer.familytree.domain.Member;
import fr.committer.familytree.service.PhotosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
public class PhotosController {

	private final PhotosService photosService;

	/**
	 *
	 * @param pseudo pseudo of member
	 * @param path picture path
	 * @return Member information
	 */
	@ExceptionHandler(NullPointerException.class)
	@GetMapping( "/test")
	public Mono<Member> addProfilePhoto(String pseudo, String path) {
		throw new NullPointerException();
	}

	/**
	 *
	 * @param pseudo pseudi
	 * @param path picture path
	 * @return Member information
	 */
	public Mono<Member> deleteProfilePhoto(String pseudo, String path) {
		return null;
	}

	/**
	 *
	 * @param pseudo
	 * @param newPath
	 * @return
	 */
	public Mono<Member> updateProfilePhoto(String pseudo, String newPath) {
		return null;
	}

}
