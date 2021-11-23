package debmalya.jash.odysses.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import debmalya.jash.odysses.model.OdyssesResponse;
import debmalya.jash.odysses.service.PlanSelectorImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class OdyssesRestController {

	private final PlanSelectorImpl planSelectorImpl;

	@PostMapping(value = "/v0/bestPlan", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(description = "QUESTION 2 - Find the best plan", summary = "Find the combination of plans that offers all requested features at the lowest price.")
	public ResponseEntity<OdyssesResponse> featureSelection(
			@RequestPart(name = "planFile", required = true) MultipartFile planFile,
			@RequestParam(name = "feature", defaultValue = "email,voice,admin", required = true) String feature) {
		log.info("requested feature {}", feature);
		return ResponseEntity.ok(planSelectorImpl.processPlans(planFile, feature));
	}

}
