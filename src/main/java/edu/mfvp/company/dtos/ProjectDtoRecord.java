package edu.mfvp.company.dtos;

import edu.mfvp.company.domain.model.Employee;
import edu.mfvp.company.domain.model.Project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record ProjectDtoRecord(String name, String description, LocalDate startDate, LocalDate endDate,
                               Long clientId, Long leaderId, BigDecimal budget, BigDecimal expenses, List<Long> teamIds) {

    public Project toEntity() {
        Project p = new Project();
        p.setName(this.name());
        p.setDescription(this.description());
        p.setStartDate(this.startDate());
        p.setEndDate(this.endDate);
        p.setBudget(this.budget());
        p.setExpenses(this.expenses());
        return p;
    }

    public static ProjectDtoRecord toDto(Project project) {
        return new ProjectDtoRecord(project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate(),
                project.getClient().getId(), project.getLeader().getId(), project.getBudget(), project.getExpenses(),
                project.getTeam().stream().map(Employee::getId).collect(Collectors.toList()));
    }

}
