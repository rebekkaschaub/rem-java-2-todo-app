package de.neuefische.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    @NotBlank(message = "Id must be given")
    private String id;
    @NotBlank(message = "Description must be given")
    private String description;
    @NotBlank(message = "Status must be given")
    private String status;

}
