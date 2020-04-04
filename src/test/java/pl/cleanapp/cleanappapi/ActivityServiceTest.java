package pl.cleanapp.cleanappapi;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import pl.cleanapp.cleanappapi.model.Area;
import pl.cleanapp.cleanappapi.model.Frequency;
import pl.cleanapp.cleanappapi.model.User;
import pl.cleanapp.cleanappapi.model.Week;
import pl.cleanapp.cleanappapi.repository.ActivityRepository;
import pl.cleanapp.cleanappapi.service.ActivityService;
import pl.cleanapp.cleanappapi.service.impl.ActivityServiceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ActivityServiceTest {

@Autowired
        ActivityRepository activityRepository;

    ActivityServiceImpl activityService =new ActivityServiceImpl(activityRepository);

    @Test
    void checkIfActivityIsNeededTest() {
        Set<Area> testSet = Collections.emptySet();
        assertNotNull(activityService.checkIfActivityIsNeeded(new Week(1L, "CW13",
                        testSet),
                Frequency.EVEN));
        assertFalse(activityService.checkIfActivityIsNeeded(new Week(1L, "CW12",
                        testSet),
                Frequency.ODD));
        assertTrue(activityService.checkIfActivityIsNeeded(new Week(1L, "CW13",
                testSet), Frequency.ALWAYS));
        assertTrue(activityService.checkIfActivityIsNeeded(new Week(1L, "CW13",
                testSet), Frequency.ODD));
    }

}
