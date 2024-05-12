package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.Objects;


import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
        assertTrue(job.getEmployer().toString().equals("ACME"));
        assertEquals("Desert", job.getLocation().toString());
        assertTrue(job.getPositionType().toString().equals("Quality control"));
        assertEquals("Persistence", job.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String S = System.lineSeparator();
        String jobPrint = job.toString();
        assertEquals(jobPrint.indexOf(S), 0);
        assertEquals(jobPrint.lastIndexOf(S), 125);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String S = System.lineSeparator();
        assertEquals(S + "ID: " + job.getId() + S + "Name: " + job.getName() + S + "Employer: " + job.getEmployer() + S +
                "Location: " + job.getLocation() + S + "Position Type: " + job.getPositionType()
                + S + "Core Competency: " + job.getCoreCompetency() + S, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("Product tester", new Employer(""), new Location("Desert"),
                new PositionType(""), new CoreCompetency("Persistence"));
        String S = System.lineSeparator();
        assertEquals(S + "ID: " + job.getId() + S + "Name: " + job.getName() + S + "Employer: " + "Data not available" + S +
                "Location: " + job.getLocation() + S + "Position Type: " + "Data not available"
                + S + "Core Competency: " + job.getCoreCompetency() + S, job.toString());
    }
}
