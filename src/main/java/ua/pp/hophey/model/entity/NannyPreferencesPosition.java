package ua.pp.hophey.model.entity;

import java.util.ArrayList;
import java.util.List;

public class NannyPreferencesPosition {

    //Должность
    private List<String> JobTitle = new ArrayList<>();

    //Тип занятости
    private List<String> employmentTypes = new ArrayList<>();

    private Integer numberOfHoursPerWeek;

    private List<String> contractPeriods = new ArrayList<>();

}
