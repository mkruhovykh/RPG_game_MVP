package maksym.kruhovykh.wekingsmonolith.mvp.controller;

import lombok.RequiredArgsConstructor;
import maksym.kruhovykh.wekingsmonolith.mvp.model.dto.CharacterDto;
import maksym.kruhovykh.wekingsmonolith.mvp.service.CharacterParamsService;
import maksym.kruhovykh.wekingsmonolith.mvp.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/character")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterParamsService characterParamsService;

    @GetMapping
    public ResponseEntity<CharacterDto> getCharacterByName(Principal principal) {
        CharacterDto response = characterService.getCharacterByName(principal.getName());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/increase/strength")
    public ResponseEntity<Void> increaseStrength(Principal principal) {
        characterParamsService.increaseStrength(principal.getName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/increase/mastery")
    public ResponseEntity<Void> increaseMastery(Principal principal) {
        characterParamsService.increaseMastery(principal.getName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/increase/defense")
    public ResponseEntity<Void> increaseDefense(Principal principal) {
        characterParamsService.increaseDefence(principal.getName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/increase/agility")
    public ResponseEntity<Void> increaseAgility(Principal principal) {
        characterParamsService.increaseAgility(principal.getName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/increase/health")
    public ResponseEntity<Void> increaseHealth(Principal principal) {
        characterParamsService.increaseHealth(principal.getName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}