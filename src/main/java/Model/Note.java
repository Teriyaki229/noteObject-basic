package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private UUID visibleId;
    private String title;
    private String content;
    private String createdBy;
    private String date_created;
    private String last_modified;
    private List<String> tags;

    public Note(String content) {
        this.content = content;
    }
}
