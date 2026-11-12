package be.pxl.festival.controller;

import be.pxl.festival.model.Act;
import be.pxl.festival.model.FestivalDay;
import be.pxl.festival.service.LineupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acts")
public class LineupController {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(LineupService.class);

    private final LineupService lineupService;

    public LineupController(LineupService lineupService) {
        this.lineupService = lineupService;
    }

    @GetMapping
    public List<Act> findAll() {
        return lineupService.findAll();
    }

    @GetMapping("day={day}")
    public List<Act> findAll(@PathVariable FestivalDay day) {return lineupService.getActsByDay(day);}

    @GetMapping("{id}")
    public Act findAll(@PathVariable Long id) {return lineupService.getActById(id);}

    @PostMapping
    public void addAct(@RequestBody Act act) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Adding act [" + act.getName() + "]");
        }
        lineupService.addAct(act);
    }
}
