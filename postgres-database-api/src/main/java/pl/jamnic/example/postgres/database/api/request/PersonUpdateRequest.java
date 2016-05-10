package pl.jamnic.example.postgres.database.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PersonUpdateRequest {

    private Long id;
    private String name;
    private String surname;

}
