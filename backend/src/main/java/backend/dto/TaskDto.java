package backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TaskDto will be used to transfer data between client and server
// when restful web service is built, TaskDto is used as a response for the REST APIs
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private String taskName;
    private String description;
    private String deadline;
}
