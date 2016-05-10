package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@Getter
@ToString
@NoArgsConstructor
public class PersonUpdateRequest {

    private Long id;
    private Optional<String> newName;
    private Optional<String> newSurname;

}
