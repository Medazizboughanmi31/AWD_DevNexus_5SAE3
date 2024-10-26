package tn.healthfit.actuality;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/actualities")
public class ActualityController {
    @Autowired
    private ActualityService actualityService;

    @GetMapping("/retrieve-all")
    public List<Actualities> getAllActualities() {
        return actualityService.getAllActualities();
    }

    @PostMapping("/AddActuality")
    public Actualities createActuality(@RequestBody Actualities actuality) {
        return actualityService.createActuality(actuality);
    }

    @GetMapping("/retrieve/{id}")
    public Actualities getActuality(@PathVariable Long id) {
        log.info("Retrieving Actuality with id: {}", id);
        return actualityService.getActuality(id); // This will throw ResourceNotFoundException if not found
    }
    @DeleteMapping("/Delete/{id}")
    public void deleteActuality(@PathVariable Long id) {
        log.info("Deleting Actuality with id: {}", id);
        actualityService.deleteActuality(id);
    }

    @PutMapping("/update/{id}")
    public Actualities updateActuality(@PathVariable Long id, @RequestBody Actualities updatedActuality) {
        log.info("Updating Actuality with id: {}", id);
        return actualityService.updateActuality(id, updatedActuality);
    }
}
